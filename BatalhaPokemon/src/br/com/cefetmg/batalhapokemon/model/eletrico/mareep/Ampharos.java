
package br.com.cefetmg.batalhapokemon.model.eletrico.mareep;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;

public class Ampharos extends Flaafy {
    public Ampharos(String apelido, Sexo sexo) {
        super(apelido, sexo);
        this.especie = "Ampharos";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 90;
        this.vida = 90;
        this.ataque = 75;
        this.ataqueEsp = 115;
        this.defesa = 85;
        this.defesaEsp = 90;
        this.velocidade = 55;

        this.getAtaques().clear();
        adicionarAtaque(new Ataque("Thunder", 110, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Dragon Pulse", 85, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Zap Cannon", 120, Tipo.ELETRICO));
        adicionarAtaque(new Ataque("Focus Blast", 120, Tipo.NORMAL));
    }

    @Override
    public Pokemon evoluir() {
        return this;
    }

    @Override
    public void realizarSom() {
        System.out.println("AMPHAROS! AMPHAA!");
    }
}