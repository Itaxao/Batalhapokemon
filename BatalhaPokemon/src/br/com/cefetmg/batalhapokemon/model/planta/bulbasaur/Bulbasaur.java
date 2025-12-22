package br.com.cefetmg.batalhapokemon.model.planta.bulbasaur;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Bulbasaur extends Pokemon {
    public Bulbasaur(String apelido) {
        super(apelido, "Bulbasaur", Tipo.PLANTA, 1, 45, 49, 65, 49, 65, 45);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Vine Whip", 45, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        return new Ivysaur(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Bulbasaur! Saur!");
    }
}