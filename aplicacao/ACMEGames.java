
package aplicacao;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.*;
import java.util.Scanner;

import dados.*;



public class ACMEGames {

	private Scanner entrada;
	private final PrintStream saidaPadrao = System.out;
	private BufferedReader streamEntrada;

	private Ludoteca ludoteca = new Ludoteca();

	public ACMEGames() {


		try {
			streamEntrada = new BufferedReader(new FileReader("dadosin.txt"));
			entrada = new Scanner(streamEntrada);
			PrintStream streamSaida = new PrintStream(new File("dadosout.txt"), StandardCharsets.UTF_8);
			System.setOut(streamSaida);
			Locale.setDefault(Locale.ENGLISH);
			entrada.useLocale(Locale.ENGLISH);
			if (entrada != null) {
				entrada.useLocale(Locale.ENGLISH);
				// Restante do processamento com o Scanner 'entrada'
			} else {
				System.out.println("O objeto 'entrada' não foi inicializado corretamente.");
			}
		} catch (FileNotFoundException e) {
			System.out.println("Arquivo não encontrado: " + e.getMessage());
		} catch (Exception e) {
			System.out.println("Ocorreu um erro: " + e);
		}


	}


	public void executa() {
		Cadastra_jogo_eletronico();
		Cadastratra_jogo_tabuleiro();
		mostradertminadojogo();
		mostradeterminadojogodeano();
		mostradadosjogodseletrocin();
		Mostradadosjogotabuleiro();
		mostrasomatorio();
		Mostrapcbasejogo();
		tabuleiromaisantigo();


	}

	public void Cadastra_jogo_eletronico() {

		String linha;

		try {

			while ((linha = streamEntrada.readLine()) != null) {

				if (linha.equals("-1")) {
					break;
				}

				Scanner sc = new Scanner(linha).useDelimiter(";");

				String nome = sc.next();

				int ano = sc.nextInt();


				double precoBase = sc.nextDouble();

				String plataforma = sc.next();

				Categoria categoria = Categoria.testaCategoria(sc.next());

				Jogo jogo = new JogoEletronico(nome, ano, precoBase, plataforma, categoria);

				if (ludoteca.addJogo(jogo)) {
					System.out.println("1:" + jogo.getPrecoBase());

				} else {
					System.out.println("1:Erro-jogo com nome repetido: " + jogo.getNome() + ";");

				}
			}
		}catch(Exception e){
			e.printStackTrace();
		}
	}



	public void Cadastratra_jogo_tabuleiro() {
		try {

			String linha;
			String nome = null;
			while ((linha = streamEntrada.readLine()).equals("-1")) {
				if (linha.equals("-1")) {
					break;
				}

				Scanner sc = new Scanner(linha).useDelimiter(";");

				System.out.println("===CADASTRA JOGO TABULEIRO===");
				nome = sc.nextLine().trim();
				int ano = sc.nextInt();
				double precoBase = sc.nextDouble();
				int numeroPecas = sc.nextInt();
				JogoTabuleiro LO = new JogoTabuleiro(nome, ano, precoBase, numeroPecas);
				ludoteca.addJogo(LO);
				System.out.println("2:NOME DO JOGO" + LO.getNome() + "PRECO FINAL:" + LO.calculaPrecoFinal());

			}

			Jogo l = (ludoteca.consultaPorNome(nome));
			System.out.println("2:Erro-jogo com nome repetido:" + l.getNome());

		}
		catch (Exception e) {

		}

	}

	public void mostradertminadojogo() {
		try {


			String nome = "";
			nome = entrada.nextLine();
			if (ludoteca.consultaPorNome(nome) == null) {
				System.out.println("3:Nome inexistente");
			}
			Jogo t = ludoteca.consultaPorNome(nome);

			System.out.println(String.format("3:%s,%d,%R$2.f,%s,%s,R$%2.f",
					t.getNome(),
					t.getAno(),
					t.getPrecoBase()
					));

		} catch (Exception e) {

		}

	}

	public void mostradeterminadojogodeano() {

		try {

			int ano = entrada.nextInt();
			ArrayList<Jogo> kop = ludoteca.getJogos();
			for (Jogo M : kop) {
				if (M.getAno() == ano) {
					System.out.println("4:NOME:" + M.getNome() + ",ANO:" + M.getAno() + ",PREÇO BASE:" + M.getPrecoBase() + ",PREÇO FINAL" + M.calculaPrecoFinal());


				} else {
					System.out.println("4:NENHUM JOGO ENCONRADO");
				}

			}

		} catch (Exception e) {

		}
	}


	public void mostradadosjogodseletrocin() {
		try {

			String categoria = entrada.nextLine();
			ArrayList<Jogo> KOP = ludoteca.getJogos();
			List<JogoEletronico> jogoEletronicos = KOP
					.stream()
					.filter(jogo -> jogo instanceof JogoEletronico)
					.map(Jogo -> (JogoEletronico) Jogo)
					.toList();

			if (Categoria.valueOf(categoria).equals(Categoria.SIM)) {
				for (JogoEletronico jogo : jogoEletronicos) {
					if (jogo.equals(categoria)) ;
					System.out.println(jogo.ftydvxc());
				}
			}
			if (Categoria.valueOf(categoria).equals(Categoria.ACT)) {
				for (JogoEletronico jogo : jogoEletronicos) {
					if (jogo.equals(categoria)) ;
					System.out.println(jogo.ftydvxc());
				}

				if (Categoria.valueOf(categoria).equals(Categoria.STR)) {
					for (JogoEletronico jogo : jogoEletronicos) {
						if (jogo.equals(categoria)) ;
						System.out.println(jogo.ftydvxc());

					}

				}

			} else {
				System.out.println("5:NENHUM JOGO ENCONTADO");


			}
		} catch (Exception e) {

		}
	}

	public void mostrasomatorio() {
		try {


			double somatorio = 0;
			ArrayList<Jogo> jogos = ludoteca.getJogos();
			for (Jogo J : jogos) {
				somatorio += J.calculaPrecoFinal();

			}
			if (somatorio == 0) {
				System.out.println("6:NENHUM JOGO ENCONTRADO");
			} else {
				String inddh = String.format("%.Of", somatorio);
				System.out.println("6: VALOR DO SOMATORIO:" + somatorio);
			}

		} catch (Exception e) {

		}
	}


	public void Mostradadosjogotabuleiro() {
		try {


			JogoTabuleiro maior = null;
			ArrayList<Jogo> jogos = ludoteca.getJogos();
			Iterador IERATOR = (Iterador) jogos.iterator();

			while (IERATOR.hasNext()) {
				Jogo K = (Jogo) IERATOR.next();
				if (K instanceof JogoTabuleiro) {
					JogoTabuleiro KO = (JogoTabuleiro) K;
					if (KO.calculaPrecoFinal() > maior.calculaPrecoFinal()) {
						maior = KO;
					}
				}
			}
			if (maior.calculaPrecoFinal() == 0) {
				System.out.println("7:NENHUM JOGO ENCONTRADO");
			} else {
				System.out.println("7: NOME:" + maior.getNome() + ",PREÇO FINAL:" + maior.calculaPrecoFinal());
			}

		} catch (Exception e) {
		}


	}

	public void Mostrapcbasejogo() {

		try {


			ArrayList<Jogo> jogos = ludoteca.getJogos();
			if (jogos.isEmpty()) {
				System.out.println("8:NENHUM JOGO ENCONTRADO");
			} else {

				double cal = 0;
				for (Jogo J : jogos)
					cal += J.getPrecoBase();
				double media = cal / jogos.size();

				Jogo proxjogo = Collections.min(jogos, Comparator.comparingDouble(value -> Math.abs(value.getPrecoBase() - media)));
				System.out.println("8:media dos preços" + proxjogo.getNome() + ",ano:" + proxjogo.getAno() + ",preço" + proxjogo.getPrecoBase() + ",preço final" + proxjogo.calculaPrecoFinal());
			}

		} catch (Exception e) {

		}

	}

	public void tabuleiromaisantigo() {
		try {

			ArrayList<Jogo> jogos = ludoteca.getJogos();
			JogoTabuleiro antigo = null;
			List<JogoTabuleiro> jogoTabuleiros = jogos
					.stream()
					.filter(jogo -> jogo instanceof JogoTabuleiro)
					.map(Jogo -> (JogoTabuleiro) Jogo)
					.toList();

			if (jogoTabuleiros.isEmpty()) {
				System.out.println("9:NOME JOGO ENCONTRADO");
			} else {
				for (JogoTabuleiro JI : jogoTabuleiros) {
					if (JI.getAno() < antigo.getAno()) {
						antigo = JI;
					}
					System.out.println("9:NOME DO JOGO:" + antigo.getNome() + ",ANO:" + antigo.getAno());

				}

			}
		} catch (Exception e) {

		}

	}

}