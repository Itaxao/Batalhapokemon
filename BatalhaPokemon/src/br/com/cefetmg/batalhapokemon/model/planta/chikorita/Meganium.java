package br.com.cefetmg.batalhapokemon.model.planta.chikorita;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Meganium extends Bayleef {
    public Meganium(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Meganium";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 80;
        this.vida = 80;
        this.ataque = 82;
        this.ataqueEsp = 83;
        this.defesa = 100;
        this.defesaEsp = 100;
        this.velocidade = 80;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Petal Blizzard", 90, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Frenzy Plant", 150, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Earthquake", 100, Tipo.TERRA));
        adicionarAtaque(new Ataque("Body Slam", 85, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("MEGANIUM! GANIUUUM!");
    }
}