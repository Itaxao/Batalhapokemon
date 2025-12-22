package br.com.cefetmg.batalhapokemon.model.planta.bulbasaur;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Venusaur extends Ivysaur {
    public Venusaur(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Venusaur";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 80;
        this.vida = 80;
        this.ataque = 82;
        this.ataqueEsp = 100;
        this.defesa = 83;
        this.defesaEsp = 100;
        this.velocidade = 80;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Solar Beam", 120, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Petal Dance", 120, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Earthquake", 100, Tipo.TERRA));
        adicionarAtaque(new Ataque("Sludge Bomb", 90, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("VENUSAUR! SAAAUR!");
    }
}