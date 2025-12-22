package br.com.cefetmg.batalhapokemon.model.fogo.torchic;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Combusken extends Torchic {
    public Combusken(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Combusken";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 60;
        this.vida = 60;
        this.ataque = 85;
        this.ataqueEsp = 85;
        this.defesa = 60;
        this.defesaEsp = 60;
        this.velocidade = 55;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Double Kick", 60, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Flame Charge", 50, Tipo.FOGO));
        adicionarAtaque(new Ataque("Sky Uppercut", 85, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Blaziken(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Combusken! Ken!");
    }
}