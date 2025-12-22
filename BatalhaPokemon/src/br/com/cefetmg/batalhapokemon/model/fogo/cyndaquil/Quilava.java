package br.com.cefetmg.batalhapokemon.model.fogo.cyndaquil;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Quilava extends Cyndaquil {
    public Quilava(String apelido, Sexo sexo) {
        super(apelido);
        this.especie = "Quilava";
        this.nivelEvolucao = 2;
        this.vidaMaxima = 58;
        this.vida = 58;
        this.ataque = 64;
        this.ataqueEsp = 80;
        this.defesa = 58;
        this.defesaEsp = 65;
        this.velocidade = 80;
        this.sexo = sexo;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Flame Wheel", 60, Tipo.FOGO));
        adicionarAtaque(new Ataque("Quick Attack", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Flamethrower", 90, Tipo.FOGO));
    }

    @Override
    public Pokemon evoluir() {
        return new Typhlosion(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Quilava! Quilava!");
    }
}