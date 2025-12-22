package br.com.cefetmg.batalhapokemon.model.eletrico.mareep;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Flaafy extends Mareep {
    public Flaafy(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Flaafy";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 70;
        this.vida = 70;
        this.ataque = 55;
        this.ataqueEsp = 80;
        this.defesa = 55;
        this.defesaEsp = 60;
        this.velocidade = 45;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Thunder Punch", 75, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Power Gem", 80, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Discharge", 80, Tipo.ELETRICO));
    }

    @Override
    public Pokemon evoluir() {
        return new Ampharos(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Flaaffy! Flaaf!");
    }
}