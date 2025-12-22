package br.com.cefetmg.batalhapokemon.model.agua.totodile;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Totodile extends Pokemon {
    public Totodile(String apelido) {
        super(apelido, "Totodile", Tipo.AGUA, 1, 50, 65, 44, 64, 48, 43);
        adicionarAtaque(new Ataque("Scratch", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Water Gun", 40, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        return new Croconaw(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Totodile! Dile!");
    }
}