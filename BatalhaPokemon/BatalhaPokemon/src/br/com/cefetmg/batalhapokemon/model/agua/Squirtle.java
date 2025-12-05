package br.com.cefetmg.batalhapokemon.model.agua;
import br.com.cefetmg.batalhapokemon.model.Pokemon;
import br.com.cefetmg.batalhapokemon.model.enums.Tipo;
import br.com.cefetmg.batalhapokemon.model.dtos.Ataque;

public class Squirtle extends Pokemon{
	
	// Construtor da classe Squirtle que tem como base a classe pokemon e basicamente é a mesma coisa para todos os próximos pokemons.
	public Squirtle(String apelido) {
		// Construtor baseado na classe Pokemon, 1 = Nivel, 44 = VidaMaxima, 52 = Ataque, 50 = AtaqueEsp, 65 = Defesa, 64 = DefesaEsp 43 = Velocidade.
		super(apelido, "Squirtle", Tipo.AGUA, 1, 44, 52, 50, 65, 64, 43);
		adicionarAtaque(new Ataque("Investida", 40, Tipo.NORMAL));
		adicionarAtaque(new Ataque("Tail Whip", 0,	Tipo.NORMAL));
	}
	
	@Override
	public Pokemon evoluir() {
		return new Wartortle(this.getApelido());
	}
	@Override
	public void realizarSom() {
		System.out.println("Squirtle");
	}
}
