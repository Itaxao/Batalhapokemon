package br.com.cefetmg.batalhapokemon.model.normal.rattata;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Rattata extends Pokemon {
    public Rattata(String apelido) {
        super(apelido, "Rattata", Tipo.NORMAL, 1, 30, 56, 25, 35, 35, 72);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Quick Attack", 40, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Raticate(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Rattata! Rat!");
    }
}