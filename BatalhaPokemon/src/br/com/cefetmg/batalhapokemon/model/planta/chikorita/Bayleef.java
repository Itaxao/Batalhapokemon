package br.com.cefetmg.batalhapokemon.model.planta.chikorita;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Bayleef extends Chikorita {
    public Bayleef(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Bayleef";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 60;
        this.vida = 60;
        this.ataque = 62;
        this.ataqueEsp = 63;
        this.defesa = 80;
        this.defesaEsp = 80;
        this.velocidade = 60;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Magical Leaf", 60, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Body Slam", 85, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Synthesis", 0, Tipo.PLANTA));
    }

    @Override
    public Pokemon evoluir() {
        return new Meganium(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Bayleef! Bay!");
    }
}