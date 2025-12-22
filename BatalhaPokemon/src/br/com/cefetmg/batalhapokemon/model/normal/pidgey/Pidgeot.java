package br.com.cefetmg.batalhapokemon.model.normal.pidgey;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Pidgeot extends Pidgeotto {
    public Pidgeot(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Pidgeot";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 83;
        this.vida = 83;
        this.ataque = 80;
        this.ataqueEsp = 70;
        this.defesa = 75;
        this.defesaEsp = 70;
        this.velocidade = 101;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Hurricane", 110, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Brave Bird", 120, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Air Slash", 75, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Heat Wave", 95, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("PIDGEOT! PIIIDGE!");
    }
}