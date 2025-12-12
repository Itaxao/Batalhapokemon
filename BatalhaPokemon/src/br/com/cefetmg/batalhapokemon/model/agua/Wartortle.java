package br.com.cefetmg.batalhapokemon.model.agua;
import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Wartortle extends Squirtle{
	public Wartortle(String apelido) {
		super(apelido);
		
		// Como wartortle herda de squirtle seu super pega apenas o apelido do treinador que o tem, então temos que fazer o construtor normal da classe.
		this.especie = "Wartortle";
		this.nivelEvolucao = 2;
		this.vidaMaxima = 59; this.ataque = 63; this.defesa = 80; this.ataqueEsp = 65; this.defesaEsp = 80; this.velocidade = 58;
		
		adicionarAtaque(new Ataque("Water Gun", 40, Tipo.AGUA));
		adicionarAtaque(new Ataque("Withdraw", 0, Tipo.AGUA));
	}
	
	 @Override
	    public Pokemon evoluir() { return new Blastoise(this.getApelido()); }

	    @Override
	    public void realizarSom() { System.out.println("Wartortle Wartortle!"); }
}
