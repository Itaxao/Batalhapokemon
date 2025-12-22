package br.com.cefetmg.batalhapokemon.model.normal.eevee;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Flareon extends Eevee {
    public Flareon(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Flareon";
        this.tipo = Tipo.FOGO;
        this.nivelEvolucao = 2;
        this.vidaMaxima = 65;
        this.vida = 65;
        this.ataque = 130;
        this.ataqueEsp = 95;
        this.defesa = 60;
        this.defesaEsp = 110;
        this.velocidade = 65;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Fire Fang", 65, Tipo.FOGO));
        adicionarAtaque(new Ataque("Flamethrower", 90, Tipo.FOGO));
        adicionarAtaque(new Ataque("Superpower", 120, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("Flareon! Flare!");
    }
}
