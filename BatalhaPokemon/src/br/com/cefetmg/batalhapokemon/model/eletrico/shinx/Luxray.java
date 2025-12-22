package br.com.cefetmg.batalhapokemon.model.eletrico.shinx;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Luxray extends Luxio {
    public Luxray(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Luxray";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 80;
        this.vida = 80;
        this.ataque = 120;
        this.ataqueEsp = 95;
        this.defesa = 79;
        this.defesaEsp = 79;
        this.velocidade = 70;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Thunder Fang", 65, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Wild Charge", 90, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Superpower", 120, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Ice Fang", 65, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("LUXRAY! LUUUXRAAAY!");
    }
}