package br.com.cefetmg.batalhapokemon.model.agua.squirtle;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Blastoise extends Pokemon {

    public Blastoise(String apelido) {
        super(apelido, "Blastoise", Tipo.AGUA, 3, 79, 83, 85, 100, 105, 78);
        adicionarAtaque(new Ataque("Water Pulse", 60, Tipo.AGUA));
        adicionarAtaque(new Ataque("Protect", 0, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Hydro Pump", 110, Tipo.AGUA));
        adicionarAtaque(new Ataque("Shell Smash", 0, Tipo.AGUA));
    }

    protected Blastoise(String apelido, Sexo sexo) {
        super(apelido, "Blastoise", Tipo.AGUA, sexo, 3, 79, 83, 85, 100, 105, 78);
        adicionarAtaque(new Ataque("Water Pulse", 60, Tipo.AGUA));
        adicionarAtaque(new Ataque("Protect", 0, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Hydro Pump", 110, Tipo.AGUA));
        adicionarAtaque(new Ataque("Shell Smash", 0, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        return this; // Blastoise é a evolução final, não evolui mais
    }

    @Override
    public void realizarSom() {
        System.out.println("Blastoise! Blastoise!");
    }
}