package br.com.cefetmg.batalhapokemon.model.agua.squirtle;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Wartortle extends Squirtle {
    public Wartortle(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Wartortle";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 59;
        this.vida = 59;
        this.ataque = 63;
        this.ataqueEsp = 65;
        this.defesa = 80;
        this.defesaEsp = 80;
        this.velocidade = 58;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Water Pulse", 60, Tipo.AGUA));
        adicionarAtaque(new Ataque("Bite", 60, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Aqua Tail", 90, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        return new Blastoise(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Wartortle! Wartortle!");
    }
}