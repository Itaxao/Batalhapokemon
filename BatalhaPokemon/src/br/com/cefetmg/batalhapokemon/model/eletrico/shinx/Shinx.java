package br.com.cefetmg.batalhapokemon.model.eletrico.shinx;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Shinx extends Pokemon {
    public Shinx(String apelido) {
        super(apelido, "Shinx", Tipo.ELETRICO, 1, 45, 65, 40, 34, 34, 45);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Spark", 65, Tipo.ELETRICO));
    }

    @Override
    public Pokemon evoluir() {
        return new Luxio(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Shinx! Shinx!");
    }
}
