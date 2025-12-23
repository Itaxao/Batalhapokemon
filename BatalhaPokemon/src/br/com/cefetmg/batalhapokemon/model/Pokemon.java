package br.com.cefetmg.batalhapokemon.model;

import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public abstract class Pokemon {
    private String apelido;
    protected String especie;
    protected Tipo tipo;
    protected Sexo sexo;
    protected int nivelEvolucao;

    protected double vida;
    protected double vidaMaxima;
    protected double ataque;
    protected double ataqueEsp;
    protected double defesa;
    protected double defesaEsp;
    protected double velocidade;

    protected int experiencia = 0;
    protected int pocoes = 0;
    protected int contadorAtaquesBemSucedidos = 0;
    protected boolean defendendo = false;

    private List<Ataque> ataques = new ArrayList<>();

    public Pokemon(String apelido, String especie, Tipo tipo, int nivelEvolucao,
                   double vidaMaxima, double ataque, double ataqueEspecial,
                   double defesa, double defesaEspecial, double velocidade) {
        this.apelido = apelido;
        this.especie = especie;
        this.tipo = tipo;
        this.sexo = Sexo.gerarAleatorio();
        this.nivelEvolucao = nivelEvolucao;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataque = ataque;
        this.ataqueEsp = ataqueEspecial;
        this.defesa = defesa;
        this.defesaEsp = defesaEspecial;
        this.velocidade = velocidade;
    }

    protected Pokemon(String apelido, String especie, Tipo tipo, Sexo sexo,
                      int nivelEvolucao, double vidaMaxima, double ataque,
                      double ataqueEspecial, double defesa, double defesaEspecial,
                      double velocidade) {
        this.apelido = apelido;
        this.especie = especie;
        this.tipo = tipo;
        this.sexo = sexo;
        this.nivelEvolucao = nivelEvolucao;
        this.vidaMaxima = vidaMaxima;
        this.vida = vidaMaxima;
        this.ataque = ataque;
        this.ataqueEsp = ataqueEspecial;
        this.defesa = defesa;
        this.defesaEsp = defesaEspecial;
        this.velocidade = velocidade;
    }

    public void defender() {
        this.defendendo = true;
        System.out.println("🛡️ " + this.apelido + " assumiu postura defensiva!");
    }

    public void atacar(Pokemon oponente, Ataque golpe) {
        System.out.printf("⚔️ %s usou %s!%n", this.apelido, golpe.nome());

        double multiplicador = Tipo.obterMultiplicador(golpe.tipo(), oponente.getTipo());

        int xpGanho = 15;
        if (multiplicador > 1.0) {
            System.out.println("🔥 Foi super efetivo!");
            xpGanho = 20;
        } else if (multiplicador < 1.0 && multiplicador > 0) {
            System.out.println("🛡️ Não foi muito efetivo...");
            xpGanho = 10;
        } else if (multiplicador == 0.0) {
            System.out.println("❌ Não teve efeito nenhum!");
            return;
        } else {
            System.out.println("😐 Dano normal.");
        }

        // ============================================================
        // NOVA FÓRMULA DE DANO BALANCEADA
        // ============================================================

        // 1. Poder base do ataque (normalizado)
        // Ataques fracos (20-40) = ~10-15 de dano
        // Ataques médios (60-90) = ~20-30 de dano
        // Ataques fortes (100-150) = ~35-50 de dano
        double poderNormalizado = golpe.poder() * 0.35;

        // 2. Bônus de ataque do Pokémon (15% do stat de ataque)
        double bonusAtaque = this.ataque * 0.15;

        // 3. Dano base = poder + bônus
        double danoBase = poderNormalizado + bonusAtaque;

        // 4. Redução por defesa (quanto maior a defesa, menor o dano)
        // Defesa baixa (30-50) = ~85% do dano passa
        // Defesa média (60-80) = ~75% do dano passa
        // Defesa alta (90-110) = ~65% do dano passa
        double defesaOponente = oponente.getDefesa();

        // Se estiver defendendo, defesa é aumentada em 50%
        if (oponente.defendendo) {
            defesaOponente *= 1.5;
            System.out.println("🛡️ " + oponente.getApelido() + " bloqueou parte do ataque!");
        }

        // Fórmula de redução: quanto maior a defesa, maior a redução
        // Fórmula: dano * (100 / (100 + defesa * 0.4))
        double fatorDefesa = 100.0 / (100.0 + (defesaOponente * 0.4));
        double danoAposDefesa = danoBase * fatorDefesa;

        // 5. Variação aleatória (90% a 110% do dano)
        Random random = new Random();
        double variacao = 0.90 + (random.nextDouble() * 0.20);
        double danoComVariacao = danoAposDefesa * variacao;

        // 6. Aplica multiplicador de tipo
        double danoFinal = danoComVariacao * multiplicador;

        // 7. Bônus de nível evolutivo (Pokémons evoluídos causam mais dano)
        double bonusNivel = 1.0 + ((this.nivelEvolucao - 1) * 0.15);
        danoFinal *= bonusNivel;

        // 8. Arredonda e garante dano mínimo de 1
        danoFinal = Math.max(1, Math.round(danoFinal));

        oponente.receberDano(danoFinal);

        // Remove status de defesa após receber ataque
        oponente.defendendo = false;

        this.contadorAtaquesBemSucedidos++;
        if (this.contadorAtaquesBemSucedidos % 2 == 0) {
            this.pocoes++;
            System.out.println("💊 " + this.apelido + " ganhou uma Poção!");
        }

        ganharExperiencia(xpGanho);
    }

    public void receberDano(double dano) {
        this.vida -= dano;
        System.out.printf("💥 %s recebeu %.1f de dano. (VIDA: %.1f/%.1f)%n",
                this.apelido, dano, Math.max(0, this.vida), this.vidaMaxima);
    }

    public boolean usarPocao() {
        if (this.pocoes > 0) {
            this.pocoes--;
            double cura = 20.0;
            this.vida += cura;
            if (this.vida > this.vidaMaxima) this.vida = this.vidaMaxima;
            System.out.printf("✨ %s usou uma poção! Recuperou %.1f VIDA. (Restam %d poções)%n",
                    this.apelido, cura, this.pocoes);
            this.defendendo = false;
            return true;
        } else {
            System.out.println("❌ Você não tem poções!");
            return false;
        }
    }

    private void ganharExperiencia(int xp) {
        this.experiencia += xp;
        System.out.printf("🎓 %s ganhou %d XP. (Total: %d/100)%n", this.apelido, xp, this.experiencia);
    }

    public Pokemon tentarEvoluir() {
        if (this.experiencia >= 100 && this.nivelEvolucao < 3) {
            System.out.println("\n✨✨ O QUE? " + this.apelido + " ESTÁ EVOLUINDO! ✨✨");
            Pokemon evoluido = evoluir();
            evoluido.pocoes = this.pocoes;
            evoluido.experiencia = 0;
            System.out.println("🎉 " + this.apelido + " se tornou um " + evoluido.especie + "!\n");
            return evoluido;
        }
        return this;
    }

    public abstract Pokemon evoluir();
    public abstract void realizarSom();

    public void adicionarAtaque(Ataque a) { ataques.add(a); }

    public boolean estaVivo() { return vida > 0; }
    public double getVelocidade() { return velocidade; }
    public String getApelido() { return apelido; }
    public String getEspecie() { return especie; }
    public List<Ataque> getAtaques() { return ataques; }
    public double getDefesa() { return defesa; }
    public Tipo getTipo() { return tipo; }
    public int getNivelEvolucao() { return nivelEvolucao; }
    public int getPocoes() { return pocoes; }
    public double getVida() { return vida; }
    public double getVidaMaxima() { return vidaMaxima; }
    public Sexo getSexo() { return sexo; }
    public boolean estaDefendendo() { return defendendo; }
}