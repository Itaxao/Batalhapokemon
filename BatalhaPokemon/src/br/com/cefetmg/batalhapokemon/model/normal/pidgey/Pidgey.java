package br.com.cefetmg.batalhapokemon.model.normal.pidgey;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Pidgey extends Pokemon {
    public Pidgey(String apelido) {
        super(apelido, "Pidgey", Tipo.NORMAL, 1, 40, 45, 35, 40, 35, 56);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Gust", 40, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Pidgeotto(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Pidgey! Pidge!");
    }
}