package br.com.cefetmg.batalhapokemon.model.normal.rattata;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Raticate extends Rattata {
    public Raticate(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Raticate";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 55;
        this.vida = 55;
        this.ataque = 81;
        this.ataqueEsp = 50;
        this.defesa = 60;
        this.defesaEsp = 70;
        this.velocidade = 97;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Hyper Fang", 80, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Sucker Punch", 70, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Super Fang", 90, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("Raticate! Rati!");
    }
}