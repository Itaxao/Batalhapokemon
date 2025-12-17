package br.com.cefetmg.batalhapokemon.model.agua.squirtle;

import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Wartortle extends Pokemon {

    // Construtor público - cria Wartortle novo (gera sexo aleatório)
    public Wartortle(String apelido) {
        super(apelido, "Wartortle", Tipo.AGUA, 2, 59, 63, 65, 80, 80, 58);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Water Gun", 40, Tipo.AGUA));
        adicionarAtaque(new Ataque("Withdraw", 0, Tipo.AGUA));
    }

    // Construtor protegido - usado na evolução (mantém o sexo)
    protected Wartortle(String apelido, Sexo sexo) {
        super(apelido, "Wartortle", Tipo.AGUA, sexo, 2, 59, 63, 65, 80, 80, 58);
        adicionarAtaque(new Ataque("Tackle", 40, Tipo.NORMAL));
        adicionarAtaque(new Ataque("Water Gun", 40, Tipo.AGUA));
        adicionarAtaque(new Ataque("Withdraw", 0, Tipo.AGUA));
    }

    @Override
    public Pokemon evoluir() {
        return new Blastoise(this.getApelido(), this.getSexo());
    }

    @Override
    public void realizarSom() {
        System.out.println("Wartortle Wartortle!");
    }
}