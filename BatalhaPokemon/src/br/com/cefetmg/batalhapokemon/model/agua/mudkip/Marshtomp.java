package br.com.cefetmg.batalhapokemon.model.agua.mudkip;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Marshtomp extends Mudkip {
    public Marshtomp(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Marshtomp";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 70;
        this.vida = 70;
        this.ataque = 85;
        this.ataqueEsp = 60;
        this.defesa = 70;
        this.defesaEsp = 70;
        this.velocidade = 50;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Mud Shot", 55, Tipo.TERRA));
        adicionarAtaque(new Ataque("Rock Slide", 75, Tipo.TERRA));
        adicionarAtaque(new Ataque("Water Pulse", 60, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        return new Swampert(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Marshtomp! Tomp!");
    }
}