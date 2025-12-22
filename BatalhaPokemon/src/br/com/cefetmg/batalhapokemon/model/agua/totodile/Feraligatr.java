package br.com.cefetmg.batalhapokemon.model.agua.totodile;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Feraligatr extends Croconaw {
    public Feraligatr(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Feraligatr";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 85;
        this.vida = 85;
        this.ataque = 105;
        this.ataqueEsp = 79;
        this.defesa = 100;
        this.defesaEsp = 83;
        this.velocidade = 78;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Hydro Pump", 110, Tipo.AGUA));
        adicionarAtaque(new Ataque("Ice Fang", 65, Tipo.AGUA));
        adicionarAtaque(new Ataque("Aqua Tail", 90, Tipo.AGUA));
        adicionarAtaque(new Ataque("Superpower", 120, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("FERALIGATR! GAAATR!");
    }
}