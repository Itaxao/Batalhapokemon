package br.com.cefetmg.batalhapokemon.model.terra.sandshrew;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Sandslash extends Sandshrew {
    public Sandslash(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Sandslash";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 75;
        this.vida = 75;
        this.ataque = 100;
        this.ataqueEsp = 45;
        this.defesa = 110;
        this.defesaEsp = 55;
        this.velocidade = 65;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Slash", 70, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Dig", 80, Tipo.TERRA));
        adicionarAtaque(new Ataque("Earthquake", 100, Tipo.TERRA));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("Sandslash! Slash!");
    }
}