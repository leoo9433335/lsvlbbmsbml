package dados;

public enum Categoria {

	ACT("Acao"),

	STR("Estrategia"),

	SIM("Simulacao");

	private String nome;

	private Categoria(String nome) {
     this.nome=nome;
	}

	public String getNome() {
		return nome;
	}


}
