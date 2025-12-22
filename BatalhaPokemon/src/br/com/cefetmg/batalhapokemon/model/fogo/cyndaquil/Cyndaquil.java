package br.com.cefetmg.batalhapokemon.model.fogo.cyndaquil;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Cyndaquil extends Pokemon {
    public Cyndaquil(String apelido) {
        super(apelido, "Cyndaquil", Tipo.FOGO, 1, 39, 52, 60, 43, 50, 65);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Ember", 40, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        return new Quilava(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Cyndaquil! Quil!");
    }
}