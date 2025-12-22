package br.com.cefetmg.batalhapokemon.model.planta.treecko;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Sceptile extends Grovyle {
    public Sceptile(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Sceptile";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 70;
        this.vida = 70;
        this.ataque = 85;
        this.ataqueEsp = 105;
        this.defesa = 65;
        this.defesaEsp = 85;
        this.velocidade = 120;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Leaf Storm", 130, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Dragon Pulse", 85, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Frenzy Plant", 150, Tipo.PLANTA));
        adicionarAtaque(new Ataque("Acrobatics", 110, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("SCEPTILE! SCEEEPT!");
    }
}