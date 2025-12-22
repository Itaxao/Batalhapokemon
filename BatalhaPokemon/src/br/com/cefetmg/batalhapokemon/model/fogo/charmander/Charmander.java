package br.com.cefetmg.batalhapokemon.model.fogo.charmander;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Charmander extends Pokemon {
    public Charmander(String apelido) {
        super(apelido, "Charmander", Tipo.FOGO, 1, 39, 52, 60, 43, 50, 65);
        adicionarAtaque(new Ataque("Scratch", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Ember", 40, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        return new Charmeleon(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Char! Char!");
    }
}