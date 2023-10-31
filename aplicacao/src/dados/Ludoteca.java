package dados;

import java.util.ArrayList;
import java.util.NoSuchElementException;

public class Ludoteca implements Iterador {

	private int contador;

	private ArrayList<Jogo>jogos;

	public Ludoteca(int contador, ArrayList<Jogo> jogos) {
		this.contador = contador;
		this.jogos = jogos;
	}

	public boolean addJogo(Jogo jogo) {
		String L= jogo.getNome();
		if(consultaPorNome(L) == null){
			jogos.add(jogo);
			return true;
		}
      return false;
	}

	public Jogo consultaPorNome(String nome) {
		for (Jogo JK:jogos) {
			if(JK.getNome().equalsIgnoreCase(nome)){
				return JK;
			}
		}
        return null;
    }

	public ArrayList<Jogo> getJogos() {
		return jogos;
	}

	public ArrayList<Jogo> consultaPorAno(int ano) {
		for (Jogo M:jogos) {
			if (ano== M.getAno()){
				return jogos;
			}

		}


        return null;
    }


	/**
	 * @see dados.Iterador#reset()
	 */
	public void reset() {
		contador=0;

		}





	/**
	 * @see dados.Iterador#hasNext()
	 */
	public boolean hasNext() {
		if (contador < jogos.size()) {
			return true;
		} else {
			return false;
		}
	}

	/**
	 * @see dados.Iterador#next()
	 */
	public Object next() {

		if(hasNext()){
			Object game=jogos.get(contador);
			contador++;
			return game;
		}
		else {
              throw new NoSuchElementException("não há elemnto");
		}
	}

}
