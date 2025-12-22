package br.com.cefetmg.batalhapokemon.model.agua.mudkip;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Mudkip extends Pokemon {
    public Mudkip(String apelido) {
        super(apelido, "Mudkip", Tipo.AGUA, 1, 50, 70, 50, 50, 50, 40);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Water Gun", 40, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        return new Marshtomp(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Mudkip! Kip kip!");
    }
}