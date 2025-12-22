package br.com.cefetmg.batalhapokemon.model.fogo.cyndaquil;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Typhlosion extends Quilava {
    public Typhlosion(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Typhlosion";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 78;
        this.vida = 78;
        this.ataque = 84;
        this.ataqueEsp = 109;
        this.defesa = 78;
        this.defesaEsp = 85;
        this.velocidade = 100;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Eruption", 150, Tipo.FOGO));
        adicionarAtaque(new Ataque("Fire Blast", 110, Tipo.FOGO));
        adicionarAtaque(new Ataque("Lava Plume", 80, Tipo.FOGO));
        adicionarAtaque(new Ataque("Extrasensory", 80, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("TYPHLOSION! PHLOOOOSH!");
    }
}