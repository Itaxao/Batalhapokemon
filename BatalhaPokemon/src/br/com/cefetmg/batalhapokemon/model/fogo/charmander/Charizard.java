package br.com.cefetmg.batalhapokemon.model.fogo.charmander;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Charizard extends Charmeleon {
    public Charizard(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Charizard";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 78;
        this.vida = 78;
        this.ataque = 84;
        this.ataqueEsp = 109;
        this.defesa = 78;
        this.defesaEsp = 85;
        this.velocidade = 100;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Fire Blast", 110, Tipo.FOGO));
        adicionarAtaque(new Ataque("Air Slash", 75, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Flare Blitz", 120, Tipo.FOGO));
        adicionarAtaque(new Ataque("Dragon Claw", 80, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("CHARIZARD! ROOAAAR!");
    }
}