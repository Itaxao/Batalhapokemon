package br.com.cefetmg.batalhapokemon.model.eletrico.pichu;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Pikachu extends Pichu {
    public Pikachu(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Pikachu";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 35;
        this.vida = 35;
        this.ataque = 55;
        this.ataqueEsp = 50;
        this.defesa = 40;
        this.defesaEsp = 50;
        this.velocidade = 90;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Thunderbolt", 90, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Quick Attack", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Iron Tail", 100, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Raichu(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Pika! Pikachu!");
    }
}