package br.com.cefetmg.batalhapokemon.model.planta.treecko;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Treecko extends Pokemon {
    public Treecko(String apelido) {
        super(apelido, "Treecko", Tipo.PLANTA, 1, 40, 45, 65, 35, 55, 70);
        adicionarAtaque(new Ataque("Pound", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Absorb", 20, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        return new Grovyle(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Treecko! Tree!");
    }
}