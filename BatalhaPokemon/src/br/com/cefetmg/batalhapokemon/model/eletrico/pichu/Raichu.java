
package br.com.cefetmg.batalhapokemon.model.eletrico.pichu;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Raichu extends Pikachu {
    public Raichu(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Raichu";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 60;
        this.vida = 60;
        this.ataque = 90;
        this.ataqueEsp = 90;
        this.defesa = 55;
        this.defesaEsp = 80;
        this.velocidade = 110;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Thunder", 110, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Thunder Punch", 75, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Volt Tackle", 120, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Focus Blast", 120, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("RAICHU! RAI RAI!");
    }
}