package br.com.cefetmg.batalhapokemon.model.fogo.charmander;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Charmeleon extends Charmander {
    public Charmeleon(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Charmeleon";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 58;
        this.vida = 58;
        this.ataque = 64;
        this.ataqueEsp = 80;
        this.defesa = 58;
        this.defesaEsp = 65;
        this.velocidade = 80;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Slash", 70, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Flamethrower", 90, Tipo.FOGO));
        adicionarAtaque(new Ataque("Dragon Rage", 60, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        return new Charizard(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Charmeleon! Charmeleon!");
    }
}