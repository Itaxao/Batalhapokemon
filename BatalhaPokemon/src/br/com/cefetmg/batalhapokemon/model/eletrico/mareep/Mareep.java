package br.com.cefetmg.batalhapokemon.model.eletrico.mareep;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Mareep extends Pokemon {
    public Mareep(String apelido) {
        super(apelido, "Mareep", Tipo.ELETRICO, 1, 55, 40, 65, 40, 45, 35);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Thunder Shock", 40, Tipo.ELETRICO));
    }

    @Override
    public Pokemon evoluir() {
        return new Flaafy(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Mareep! Meep!");
    }
}

