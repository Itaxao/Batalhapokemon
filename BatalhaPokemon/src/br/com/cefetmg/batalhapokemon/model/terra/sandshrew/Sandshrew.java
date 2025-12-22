package br.com.cefetmg.batalhapokemon.model.terra.sandshrew;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Sandshrew extends Pokemon {
    public Sandshrew(String apelido) {
        super(apelido, "Sandshrew", Tipo.TERRA, 1, 50, 75, 20, 85, 30, 40);
        adicionarAtaque(new Ataque("Scratch", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Sand Attack", 0, Tipo.TERRA));
    }

    @Override
    public Pokemon evoluir() {
        return new Sandslash(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Sandshrew! Shrew!");
    }
}