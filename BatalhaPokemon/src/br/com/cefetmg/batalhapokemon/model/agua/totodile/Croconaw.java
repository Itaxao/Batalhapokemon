package br.com.cefetmg.batalhapokemon.model.agua.totodile;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Croconaw extends Totodile {
    public Croconaw(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Croconaw";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 65;
        this.vida = 65;
        this.ataque = 80;
        this.ataqueEsp = 59;
        this.defesa = 80;
        this.defesaEsp = 63;
        this.velocidade = 58;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Bite", 60, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Water Pulse", 60, Tipo.AGUA));
        adicionarAtaque(new Ataque("Crunch", 80, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Feraligatr(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Croconaw! Conaw!");
    }
}