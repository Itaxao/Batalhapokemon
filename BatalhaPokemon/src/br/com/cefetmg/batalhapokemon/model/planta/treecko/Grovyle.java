package br.com.cefetmg.batalhapokemon.model.planta.treecko;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Grovyle extends Treecko {
    public Grovyle(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Grovyle";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 50;
        this.vida = 50;
        this.ataque = 65;
        this.ataqueEsp = 85;
        this.defesa = 45;
        this.defesaEsp = 65;
        this.velocidade = 95;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Leaf Blade", 90, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Quick Attack", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("X-Scissor", 80, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Sceptile(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Grovyle! Vyle!");
    }
}