package application;

import java.util.Scanner;

public class ProgramGame {

	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		System.out.println("Bem vindo ao jogo da Velha!");

		char [][] game = new char [3][3];

		boolean validadorPersonagem = false;
		char jogador1 = 0;
		char jogador2 = 0;
		
		
		// Verifica se o jogador seleciona uma opção entre X ou O
		while (!validadorPersonagem) {

			System.out.print("O primeiro jogador deseja ser X ou O? ");
			jogador1 = sc.next().charAt(0);
			
			if (jogador1 != 'x' && jogador1 != 'X' && jogador1 != 'o' && jogador1 != 'O') {
				
				System.out.println("Opcao invalida");
				
			} else {
				validadorPersonagem = true;
			}
		}
		
		// Caso o jogador tenha entrado com o valor de char em letra minúscula, mudar para maiúscula. 
			if (jogador1 == 'x' || jogador1 == 'X') {

				System.out.println("O segundo jogador sera O");
				jogador2 = 'O';
				jogador1='X';
			}

			if (jogador1 == 'o' || jogador1 == 'O' ) {

				System.out.println("O segundo jogador sera X");
				jogador2 = 'X';
				jogador1='O';
			}
			

		boolean ganhou = false;

		int linha = 0, coluna = 0;
		int jogada = 1;
		char sinal = 0;
		
		//Jogo inicia
		while (!ganhou) {

			//jogada com valor primo indica que é o primeiro jogador.
			if (jogada % 2 == 1) {
				System.out.println("Primeiro jogador, escolha uma linha e coluna:");
				sinal = jogador1;


			}else {
				System.out.println("Segundo jogador, escolha uma linha e coluna:");
				sinal = jogador2;
			}

			boolean linhaValida = false;
			
			//Valida se a linha é válida.
			while (!linhaValida) {

				System.out.print("Linha (1-3): ");
				linha = sc.nextInt();

				if(linha < 1 || linha > 3) {
					System.out.println("Linha invalida, tente novamente");
				}else {
					linhaValida = true;
				}
			}

			boolean colunaValida = false;
			
			//Valida se a coluna é valida.
			while (!colunaValida) {

				System.out.print("Coluna (1-3): ");
				coluna = sc.nextInt();

				if (coluna < 1 || coluna > 3) {
					System.out.println("Coluna invalida, tente novamente");
				}else {
					colunaValida = true;
				}

			}
			
			//Decrescimo de valor pois em array a matriz se inicia com 0,0.
			linha--;
			coluna--;
			
			// Valida se o espaço já não está ocupado na matriz.
			if (game[linha][coluna] == 'X' || game[linha][coluna] == 'O') {
				System.out.println("Espaco ja ocupado, tente outro.");
			}else {
				// Caso não esteja ocupado, a jogada é valida e acrescenta um valor na jogada, fazendo ir para o proximo jogador e atribuindo o valor do sinal (X ou O) no espaço da matriz.
				jogada++;
				game[linha][coluna] = sinal;

			}
			
			// Imprime a matriz
			System.out.println();
			for (int i = 0; i < game.length; i++) {
				System.out.print(i+1 + " ");
				for (int j = 0; j < game[i].length; j++) {
					System.out.print(game[i][j]+"|");
				}
				System.out.println();
			}
			System.out.println("  1 2 3");
			
			
			// Regras para validar se o jogador ganhou a partida.
			if (game[0][0] == jogador1 && game[0][1] == jogador1 && game[0][2] == jogador1 ||
					game[1][0] == jogador1 && game[1][1] == jogador1 && game[1][2] == jogador1 ||
					game[2][0] == jogador1 && game[2][1] == jogador1 && game[2][2] == jogador1 ||
					game[0][0] == jogador1 && game[1][1] == jogador1 && game[2][2] == jogador1 ||
					game[0][2] == jogador1 && game[1][1] == jogador1 && game[2][0] == jogador1) {
				System.out.println("O jogador " + jogador1 + " venceu!");
				ganhou = true;
			} else if (game[0][0] == jogador2 && game[0][1] == jogador2 && game[0][2] == jogador2 ||
					game[1][0] == jogador2 && game[1][1] == jogador2 && game[1][2] == jogador2 ||
					game[2][0] == jogador2 && game[2][1] == jogador2 && game[2][2] == jogador2 ||
					game[0][0] == jogador2 && game[1][1] == jogador2 && game[2][2] == jogador2 ||
					game[0][2] == jogador2 && game[1][1] == jogador2 && game[2][0] == jogador2) {
				System.out.println("O jogador " + jogador2 + " venceu!");
				ganhou = true;
			} else if (jogada >9) {
				System.out.println("O jogo deu velha!");


			}
		}

		sc.close();	
	}

}
