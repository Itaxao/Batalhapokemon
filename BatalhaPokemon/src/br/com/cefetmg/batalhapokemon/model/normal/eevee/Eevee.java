package br.com.cefetmg.batalhapokemon.model.normal.eevee;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Eevee extends Pokemon {
    public Eevee(String apelido) {
        super(apelido, "Eevee", Tipo.NORMAL, 1, 55, 55, 45, 50, 65, 55);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Quick Attack", 40, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Flareon(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Eevee! Vee!");
    }
}