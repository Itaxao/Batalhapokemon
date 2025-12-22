package br.com.cefetmg.batalhapokemon.model.fogo.torchic;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Blaziken extends Combusken {
    public Blaziken(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Blaziken";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 80;
        this.vida = 80;
        this.ataque = 120;
        this.ataqueEsp = 110;
        this.defesa = 70;
        this.defesaEsp = 70;
        this.velocidade = 80;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Blaze Kick", 85, Tipo.FOGO));
        adicionarAtaque(new Ataque("High Jump Kick", 130, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Flare Blitz", 120, Tipo.FOGO));
        adicionarAtaque(new Ataque("Brave Bird", 120, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("BLAZIKEN! KEEEEN!");
    }
}