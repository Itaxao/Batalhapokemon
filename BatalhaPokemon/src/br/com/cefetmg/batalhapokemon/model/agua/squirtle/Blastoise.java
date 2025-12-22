package br.com.cefetmg.batalhapokemon.model.agua.squirtle;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Blastoise extends Wartortle {
    public Blastoise(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Blastoise";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 79;
        this.vida = 79;
        this.ataque = 83;
        this.ataqueEsp = 85;
        this.defesa = 100;
        this.defesaEsp = 105;
        this.velocidade = 78;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Hydro Pump", 110, Tipo.AGUA));
        adicionarAtaque(new Ataque("Skull Bash", 130, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Hydro Cannon", 150, Tipo.AGUA));
        adicionarAtaque(new Ataque("Flash Cannon", 80, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("BLASTOISE! BLAST!");
    }
}