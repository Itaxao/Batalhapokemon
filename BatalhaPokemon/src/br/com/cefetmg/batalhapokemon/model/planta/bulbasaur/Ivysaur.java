package br.com.cefetmg.batalhapokemon.model.planta.bulbasaur;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Ivysaur extends Bulbasaur {
    public Ivysaur(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Ivysaur";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 60;
        this.vida = 60;
        this.ataque = 62;
        this.ataqueEsp = 80;
        this.defesa = 63;
        this.defesaEsp = 80;
        this.velocidade = 60;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Razor Leaf", 55, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Seed Bomb", 80, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Take Down", 90, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Venusaur(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Ivysaur! Ivysaur!");
    }
}