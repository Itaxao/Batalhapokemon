package br.com.cefetmg.batalhapokemon.model.agua.squirtle;
import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Sexo;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Blastoise extends Wartortle {

    public Blastoise(String apelido){
        super(apelido);
        this.especie = "Blastoise";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 79; this.ataque = 83; this.defesa = 100; this.ataqueEsp = 85; this.defesaEsp = 105; this.velocidade = 78;

        adicionarAtaque( new Ataque("Water Pulse",60, Tipo.AGUA));
        adicionarAtaque( new Ataque("Protect",0, Tipo.NORMAL));
        adicionarAtaque( new Ataque("Hydro Pump",110, Tipo.AGUA));
        adicionarAtaque( new Ataque("Shell Smash", 0, Tipo.AGUA));
    }

    protected Blastoise(String apelido, Sexo sexo) {
        super(apelido);
        this.sexo = sexo;
        this.especie = "Blastoise";
        this.nivelEvolucao = 3;
        this.vidaMaxima = 79; this.ataque = 83; this.defesa = 100; this.ataqueEsp = 85; this.defesaEsp = 105; this.velocidade = 78;

        adicionarAtaque( new Ataque("Water Pulse",60, Tipo.AGUA));
        adicionarAtaque( new Ataque("Protect",0, Tipo.NORMAL));
        adicionarAtaque( new Ataque("Hydro Pump",110, Tipo.AGUA));
        adicionarAtaque( new Ataque("Shell Smash", 0, Tipo.AGUA));
    }

    @Override
    public Pokemon tentarEvoluir(){ return this; }

    public void realizarSom(){
        System.out.println("Blastoise! Blastoise!");
    }
}
