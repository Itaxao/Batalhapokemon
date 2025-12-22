package br.com.cefetmg.batalhapokemon.model.eletrico.pichu;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Pichu extends Pokemon {
    public Pichu(String apelido) {
        super(apelido, "Pichu", Tipo.ELETRICO, 1, 20, 40, 35, 15, 35, 60);
        adicionarAtaque(new Ataque("Thunder Shock", 40, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Charm", 0, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Pikachu(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Pichu! Pichu!");
    }
}
