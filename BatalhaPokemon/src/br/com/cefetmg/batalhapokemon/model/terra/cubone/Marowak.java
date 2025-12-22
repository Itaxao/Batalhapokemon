package br.com.cefetmg.batalhapokemon.model.terra.cubone;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Marowak extends Cubone {
    public Marowak(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Marowak";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 60;
        this.vida = 60;
        this.ataque = 80;
        this.ataqueEsp = 50;
        this.defesa = 110;
        this.defesaEsp = 80;
        this.velocidade = 45;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Bonemerang", 100, Tipo.TERRA));
        adicionarAtaque(new Ataque("Earthquake", 100, Tipo.TERRA));
        adicionarAtaque(new Ataque("Stone Edge", 100, Tipo.TERRA));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("Marowak! Wak!");
    }
}