package dados;

public class JogoEletronico extends Jogo  {

	private String plataforma;

	private Categoria categoria;

	public JogoEletronico(String nome, int ano, double precoBase, String plataforma, Categoria categoria) {
		super(nome,ano,precoBase);
		this.plataforma=plataforma;
		this.categoria=categoria;


	}





	@Override
	public double calculaPrecoFinal() {
		double result=0.0;
			double calcui=getPrecoBase();
				if(categoria.equals(Categoria.ACT)){
					result=(calcui*10)/100;
		}
		if(categoria.equals(Categoria.SIM)){
			result=(calcui*30)/100;
		}
		if (categoria.equals(Categoria.STR)){
			 result=(calcui*70)/100;
		}
		return result;
	}
	public String ftydvxc(){
		return super.toString()+"Preço final:"+calculaPrecoFinal();
	}
}
