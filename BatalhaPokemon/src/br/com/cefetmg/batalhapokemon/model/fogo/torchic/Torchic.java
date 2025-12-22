package br.com.cefetmg.batalhapokemon.model.fogo.torchic;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Torchic extends Pokemon {
    public Torchic(String apelido) {
        super(apelido, "Torchic", Tipo.FOGO, 1, 45, 60, 70, 40, 50, 45);
        adicionarAtaque(new Ataque("Scratch", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Ember", 40, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        return new Combusken(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Tor! Torchic!");
    }
}