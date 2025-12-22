package br.com.cefetmg.batalhapokemon.model.agua.mudkip;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Swampert extends Marshtomp {
    public Swampert(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Swampert";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 100;
        this.vida = 100;
        this.ataque = 110;
        this.ataqueEsp = 85;
        this.defesa = 90;
        this.defesaEsp = 90;
        this.velocidade = 60;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Earthquake", 100, Tipo.TERRA));
        adicionarAtaque(new Ataque("Hydro Cannon", 150, Tipo.AGUA));
        adicionarAtaque(new Ataque("Hammer Arm", 100, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Stone Edge", 100, Tipo.TERRA));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("SWAMPERT! SWOOOM!");
    }
}