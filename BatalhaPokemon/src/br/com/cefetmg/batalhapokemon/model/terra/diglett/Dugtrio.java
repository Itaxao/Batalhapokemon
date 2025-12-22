package br.com.cefetmg.batalhapokemon.model.terra.diglett;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Dugtrio extends Diglett {
    public Dugtrio(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Dugtrio";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 35;
        this.vida = 35;
        this.ataque = 100;
        this.ataqueEsp = 50;
        this.defesa = 50;
        this.defesaEsp = 70;
        this.velocidade = 120;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Dig", 80, Tipo.TERRA));
        adicionarAtaque(new Ataque("Earthquake", 100, Tipo.TERRA));
        adicionarAtaque(new Ataque("Sucker Punch", 70, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("Dugtrio! Trio trio!");
    }
}