package dados;

public abstract class Jogo {

	private String nome;

	private int ano;

	private double precoBase;

	public Jogo(String nome, int ano, double precoBase) {
		this.ano=ano;
		this.nome=nome;
		this.precoBase=precoBase;

	}

	public double getPrecoBase() {
		return precoBase;
	}

	public int getAno() {
		return ano;
	}

	public String getNome() {
		return nome;
	}

	public abstract double calculaPrecoFinal();

}
