package br.com.cefetmg.batalhapokemon.model.planta.chikorita;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Chikorita extends Pokemon {
    public Chikorita(String apelido) {
        super(apelido, "Chikorita", Tipo.PLANTA, 1, 45, 49, 49, 65, 65, 45);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Razor Leaf", 55, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        return new Bayleef(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Chikorita! Chiko!");
    }
}