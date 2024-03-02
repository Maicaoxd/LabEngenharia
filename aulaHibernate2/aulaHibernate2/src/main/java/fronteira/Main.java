package fronteira;


import java.util.List;
import java.util.Scanner;

import controller.FilmeController;
import model.Filme;

public class Main {

	public static void main(String[] args) {

		Scanner scanner = new Scanner(System.in);
		String nomeFilme;
		Filme f1 = new Filme ( );
		FilmeController fControl = new FilmeController();
		int escolha;

		do {
			System.out.println("Menu:");
			System.out.println("1. Inserir Filme");
			System.out.println("2. Pequisar um Filme");
			System.out.println("3. Pesquisar Todos");
			System.out.println("4. Apagar um Filme");
			System.out.println("5. Sair");

			System.out.print("Escolha uma opção: ");
			escolha = scanner.nextInt();

			switch (escolha) {
			case 1:
				System.out.println("Inserir Filme");
				f1.setId(0);
				f1.setTitulo("Cidade de Deus");
				f1.setNomeDiretor("Ze Trindade");
				fControl.inserirFilme(f1);		
				break;
				
			case 2:
				
				System.out.println("Pesquisar um filme = ");
				nomeFilme = scanner.next();
				List<Filme> filmes = fControl.pesquisarUmFilme(nomeFilme);	
				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes ) {
						System.out.println("Nome: " + filme.getTitulo() + " Id= " + filme.getId()+ " Diretor: " + filme.getNomeDiretor());
					}
				}
				else System.out.println("Não encontrou o Filme");
				scanner.nextLine();
				break;
				
			case 3:
				
				System.out.println("Listando Todos os Filmes");
				filmes = fControl.pesquisarTodos();	
				if (!(filmes.isEmpty())) {
					for (Filme filme : filmes ) {
						System.out.println("Nome: " + filme.getTitulo() + ", Diretor: " + filme.getNomeDiretor());
					}
				}
				else System.out.println("Não encontrou o Filme");
				break;
				
			case 4:
				System.out.println("Escolha um filme para apagar ");
				long id = scanner.nextLong();
				fControl.apagar(id);
				break;
				
			case 5:
				System.out.println("Saindo do menu.");
				break;
			default:
				System.out.println("Opção inválida. Tente novamente.");
			}
		} while (escolha != 5);

		scanner.close();
	}
}


