package br.com.cefetmg.batalhapokemon.model.eletrico.shinx;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Luxio extends Shinx {
    public Luxio(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Luxio";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 60;
        this.vida = 60;
        this.ataque = 85;
        this.ataqueEsp = 60;
        this.defesa = 49;
        this.defesaEsp = 49;
        this.velocidade = 60;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Crunch", 80, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Volt Switch", 70, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Wild Charge", 90, Tipo.ELETRICO));
    }

    @Override
    public Pokemon evoluir() {
        return new Luxray(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Luxio! Luuux!");
    }
}