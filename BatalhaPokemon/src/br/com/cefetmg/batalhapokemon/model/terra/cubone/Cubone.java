package br.com.cefetmg.batalhapokemon.model.terra.cubone;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Cubone extends Pokemon {
    public Cubone(String apelido) {
        super(apelido, "Cubone", Tipo.TERRA, 1, 50, 50, 40, 95, 50, 35);
        adicionarAtaque(new Ataque("Bone Club", 65, Tipo.TERRA));
        adicionarAtaque(new Ataque("Headbutt", 70, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Marowak(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Cubone... Bone...");
    }
}