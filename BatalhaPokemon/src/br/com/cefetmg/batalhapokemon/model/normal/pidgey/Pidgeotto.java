package br.com.cefetmg.batalhapokemon.model.normal.pidgey;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Pidgeotto extends Pidgey {
    public Pidgeotto(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Pidgeotto";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 63;
        this.vida = 63;
        this.ataque = 60;
        this.ataqueEsp = 55;
        this.defesa = 55;
        this.defesaEsp = 50;
        this.velocidade = 71;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Wing Attack", 60, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Aerial Ace", 60, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Twister", 40, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return new Pidgeot(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Pidgeotto! Otto!");
    }
}