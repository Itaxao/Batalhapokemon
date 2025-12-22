package br.com.cefetmg.batalhapokemon.model.terra.diglett;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Diglett extends Pokemon {
    public Diglett(String apelido) {
        super(apelido, "Diglett", Tipo.TERRA, 1, 10, 55, 35, 25, 45, 95);
        adicionarAtaque(new Ataque("Scratch", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Mud Slap", 20, Tipo.TERRA));
    }

    @Override
    public Pokemon evoluir() {
        return new Dugtrio(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Diglett! Dig!");
    }
}
