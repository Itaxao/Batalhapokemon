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
    protected boolean defendendo = false; // NOVO: Sistema de defesa

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

    // NOVO: Sistema de Defesa
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

        // 1. Dano base: considera ataque do atacante e poder do golpe
        double nivel = (this.nivelEvolucao * 10) + 30; // Nível 1=50, Nível 2=60, Nível 3=70
        double danoBase = ((2 * nivel / 5 + 2) * this.ataque * golpe.poder()) / 80;

        // 2. Aplica defesa do oponente
        double defesaOponente = oponente.getDefesa();

        // Se estiver defendendo, defesa é dobrada
        if (oponente.defendendo) {
            defesaOponente *= 2;
            System.out.println("🛡️ " + oponente.getApelido() + " bloqueou parte do ataque!");
        }

        // 3. Calcula dano após defesa
        double danoAposDefesa = danoBase / (defesaOponente / 50 + 1);

        // 4. Adiciona variação aleatória (85% a 100% do dano)
        double variacao = 0.85 + (Math.random() * 0.15);
        double danoComVariacao = danoAposDefesa * variacao;

        // 5. Aplica multiplicador de tipo
        double danoFinal = danoComVariacao * multiplicador;

        // 6. Garante dano mínimo de 1
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
            // Remove status de defesa ao usar poção
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