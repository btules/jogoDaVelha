import java.io.IOException;
import java.util.Scanner;
import java.util.Random;

public class jogo {

	public static void main(String[] args) throws IOException{
		Scanner line = new Scanner(System.in);
		Scanner column = new Scanner(System.in);
		Scanner iniciar = new Scanner(System.in);

		//Usuario
		char playerUser;
		char linha[] = new char[10];
		char coluna[] = new char[6];
		char verificaJogadasEfetuadas[] = new char [10];

		//Maquina
		char playerPc;
		int memoriaPcLinha[] = new int[20];
		char memoriaPcColuna[] = new char[20];
		Random sortLinha = new Random();
		Random sortColuna = new Random();

		//Jogo
		int escolha = 0;
		int escolhaLinha, escolhaColuna, partidas = 0, posicao = 0;
		int jogadas = 0, jogadas2 = 0;
		
		
		System.out.println("-------------------------------------");
		System.out.println("-----------------JOGO----------------");
		System.out.println("------------DA-----------------------");
		System.out.println("--------------------VELHA------------");
		System.out.println("-------------------------------------");


		System.out.println("Se você deseja começar digite 1, ou se preferir a maquina começa digite 2");
		escolha = iniciar.nextInt();

		if (escolha == 1) {
			playerPc = 'X';
			playerUser = 'O'; 
			System.out.println("A máquina será o primeiro e  ficará com ! " + playerPc);
			System.out.println("Boa Sorte !! Jogador será o segundo e ficará com " + playerUser);
		}else {
			playerUser = 'X';
			playerPc = 'O';
			System.out.println("Você será iniciará o jogo, e ficará com " + playerUser);
			System.out.println("A máquina será o Segundo e ficará com " + playerPc);
		}

		System.out.println();
		System.out.println();

		for(int i = 1; i < linha.length; i++ ) {
			if(i > 6) {
				linha[i] = ' ';
			}else {
				linha[i] = '_';
			}
			System.out.print(linha[i]);
			if((i % 3 == 0)) {
				System.out.println();
			}else {
				for(int j = 0; j < 1; j++) {
					coluna[j] = '|';
					System.out.print(coluna[j]);
				}
			}
		}

		System.out.println();
		System.out.println();

		switch (escolha) {
		case 1:

			while(partidas <= 9 ){

				if(escolha == 1){				
					//verifica se tem ja uma jogada na posição escolhida.

					System.out.println("Escolha a Linha que deseja jogar");
					escolhaLinha = sortLinha.nextInt(2)+1;
					System.out.println("Escolha a Coluna que deseja jogar");
					escolhaColuna = sortColuna.nextInt(2)+1;

					//trata as linhas e colunas escolhidas.
					if((escolhaLinha == 2) && (escolhaColuna == 2)) {
						posicao = 5;
						memoriaPcLinha[posicao] = posicao;
					}else if((escolhaLinha == 2) && (escolhaColuna == 1)) {
						posicao = 4;
						memoriaPcLinha[posicao] = posicao;
					}else if((escolhaLinha == 3) && (escolhaColuna == 1)) {
						posicao = 7;
						memoriaPcLinha[posicao] = posicao;
					}else if((escolhaLinha == 3) && (escolhaColuna == 2)) {
						posicao = 8;
						memoriaPcLinha[posicao] = posicao;
					}else {
						posicao = escolhaLinha * escolhaColuna;
						memoriaPcLinha[posicao] = posicao;
					}

					while((verificaJogadasEfetuadas[posicao] == 'X')||(verificaJogadasEfetuadas[posicao] == 'O')) {
						escolhaLinha = sortLinha.nextInt(3)+1;
						escolhaColuna = sortColuna.nextInt(3)+1;

						//trata as linhas e colunas escolhidas.
						if((escolhaLinha == 2) && (escolhaColuna == 2)) {
							posicao = 5;
							memoriaPcLinha[posicao] = posicao;
						}else if((escolhaLinha == 2) && (escolhaColuna == 1)) {
							posicao = 4;
							memoriaPcLinha[posicao] = posicao;
						}else if((escolhaLinha == 3) && (escolhaColuna == 1)) {
							posicao = 7;
							memoriaPcLinha[posicao] = posicao;
						}else if((escolhaLinha == 3) && (escolhaColuna == 2)) {
							posicao = 8;
							memoriaPcLinha[posicao] = posicao;
						}else {
							posicao = escolhaLinha * escolhaColuna;
							memoriaPcLinha[posicao] = posicao;
						}
					}

					linha[posicao] = playerPc;
					memoriaPcColuna[posicao] = playerPc;
				}

				//atualiza a tabela
				for(int i = 1; i < linha.length; i++ ) {
					System.out.print(linha[i]);
					if((i % 3 == 0)) {
						System.out.println();
					}else {
						for(int j = 0; j < 1; j++) {
							System.out.print(coluna[j]);
						}
					}
					verificaJogadasEfetuadas[i] = linha[i];
				}

				//contabiliza as jogadas
				partidas++;

				//verifica as linhas se estão validas
				if((linha[1] == playerPc) && (linha[2] == playerPc) && (linha[3] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[1] ==playerPc) && (linha[4] == playerPc) && (linha[7] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[1] == playerPc) && (linha[5] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[4] == playerPc) && (linha[5] == playerPc) && (linha[6] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[7] == playerPc) && (linha[8] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[2] == playerPc) && (linha[5] == playerPc) && (linha[8] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[3] == playerPc) && (linha[6] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[3] == playerPc) && (linha[5] == playerPc) && (linha[7] == playerPc)) {
					jogadas = 3;
					break;
				}

				//verifica as linhas se estão validas
				if((linha[1] == playerUser) && (linha[2] == playerUser) && (linha[3] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[1] == playerUser) && (linha[4] == playerUser) && (linha[7] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[1] == playerUser) && (linha[5] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[4] == playerUser) && (linha[5] == playerUser) && (linha[6] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[7] == playerUser) && (linha[8] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[2] == playerUser) && (linha[5] == playerUser) && (linha[8] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[3] == playerUser) && (linha[6] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[3] == playerUser) && (linha[5] == playerUser) && (linha[7] == playerUser)) {
					jogadas2 = 3;
					break;
				}

				if(partidas == 9 ) {break;}

				System.out.println("Sua vez Usuario");

				System.out.println();
				System.out.println();


				System.out.println("Escolha a Linha que deseja jogar");
				escolhaLinha = line.nextInt();
				System.out.println("Escolha a Coluna que deseja jogar");
				escolhaColuna = column.nextInt();

				if((escolhaLinha == 2) && (escolhaColuna == 2)) {
					posicao = 5;
				}else if((escolhaLinha == 2) && (escolhaColuna == 1)) {
					posicao = 4;
				}else if((escolhaLinha == 3) && (escolhaColuna == 1)) {
					posicao = 7;
				}else if((escolhaLinha == 3) && (escolhaColuna == 2)) {
					posicao = 8;
				}else {
					posicao = escolhaLinha * escolhaColuna;
				}

				while((verificaJogadasEfetuadas[posicao] == 'X')||(verificaJogadasEfetuadas[posicao] == 'O')) {
					System.out.println("Está linha já está marcada, escolha outra");
					escolhaLinha = line.nextInt();
					System.out.println("Escolha a Coluna que deseja jogar");
					escolhaColuna = column.nextInt();

					if((escolhaLinha == 2) && (escolhaColuna == 2)) {
						posicao = 5;
					}else if((escolhaLinha == 2) && (escolhaColuna == 1)) {
						posicao = 4;
					}else if((escolhaLinha == 3) && (escolhaColuna == 2)) {
						posicao = 8;
					}else {
						posicao = escolhaLinha * escolhaColuna;
					}

				}

				linha[posicao] = playerUser;


				for(int i = 1; i < linha.length; i++ ) {
					System.out.print(linha[i]);
					if((i % 3 == 0)) {
						System.out.println();
					}else {
						for(int j = 0; j < 1; j++) {
							System.out.print(coluna[j]);
						}
					}
					verificaJogadasEfetuadas[i] = linha[i];
				}



				//verifica as linhas se estão validas
				if((linha[1] == playerPc) && (linha[2] == playerPc) && (linha[3] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[1] ==playerPc) && (linha[4] == playerPc) && (linha[7] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[1] == playerPc) && (linha[5] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[4] == playerPc) && (linha[5] == playerPc) && (linha[6] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[7] == playerPc) && (linha[8] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[2] == playerPc) && (linha[5] == playerPc) && (linha[8] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[3] == playerPc) && (linha[6] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[3] == playerPc) && (linha[5] == playerPc) && (linha[7] == playerPc)) {
					jogadas = 3;
					break;
				}

				//verifica as linhas se estão validas
				if((linha[1] == playerUser) && (linha[2] == playerUser) && (linha[3] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[1] == playerUser) && (linha[4] == playerUser) && (linha[7] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[1] == playerUser) && (linha[5] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[4] == playerUser) && (linha[5] == playerUser) && (linha[6] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[7] == playerUser) && (linha[8] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[2] == playerUser) && (linha[5] == playerUser) && (linha[8] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[3] == playerUser) && (linha[6] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[3] == playerUser) && (linha[5] == playerUser) && (linha[7] == playerUser)) {
					jogadas2 = 3;
					break;
				}

				partidas++;
			}
			
			System.out.println();		
			System.out.println();

		case 2:

			while(partidas <= 9 ){

				if(escolha == 2){	
					//Usuario
					System.out.println("Escolha a Linha que deseja jogar");
					escolhaLinha = line.nextInt();
					System.out.println("Escolha a Coluna que deseja jogar");
					escolhaColuna = column.nextInt();

					if((escolhaLinha == 2) && (escolhaColuna == 2)) {
						posicao = 5;
					}else if((escolhaLinha == 2) && (escolhaColuna == 1)) {
						posicao = 4;
					}else if((escolhaLinha == 3) && (escolhaColuna == 1)) {
						posicao = 7;
					}else if((escolhaLinha == 3) && (escolhaColuna == 2)) {
						posicao = 8;
					}else {
						posicao = escolhaLinha * escolhaColuna;
					}

					while((verificaJogadasEfetuadas[posicao] == 'X')||(verificaJogadasEfetuadas[posicao] == 'O')) {
						System.out.println("Está linha já está marcada, escolha outra");
						escolhaLinha = line.nextInt();
						System.out.println("Escolha a Coluna que deseja jogar");
						escolhaColuna = column.nextInt();

						if((escolhaLinha == 2) && (escolhaColuna == 2)) {
							posicao = 5;
						}else if((escolhaLinha == 2) && (escolhaColuna == 1)) {
							posicao = 4;
						}else if((escolhaLinha == 3) && (escolhaColuna == 2)) {
							posicao = 8;
						}else {
							posicao = escolhaLinha * escolhaColuna;
						}

					}

					linha[posicao] = playerUser;

				}

				//atualiza a tabela
				for(int i = 1; i < linha.length; i++ ) {
					System.out.print(linha[i]);
					if((i % 3 == 0)) {
						System.out.println();
					}else {
						for(int j = 0; j < 1; j++) {
							System.out.print(coluna[j]);
						}
					}
					verificaJogadasEfetuadas[i] = linha[i];
				}

				//contabiliza as jogadas
				partidas++;

				//verifica as linhas se estão validas
				if((linha[1] == playerPc) && (linha[2] == playerPc) && (linha[3] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[1] ==playerPc) && (linha[4] == playerPc) && (linha[7] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[1] == playerPc) && (linha[5] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[4] == playerPc) && (linha[5] == playerPc) && (linha[6] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[7] == playerPc) && (linha[8] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[2] == playerPc) && (linha[5] == playerPc) && (linha[8] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[3] == playerPc) && (linha[6] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[3] == playerPc) && (linha[5] == playerPc) && (linha[7] == playerPc)) {
					jogadas = 3;
					break;
				}

				//verifica as linhas se estão validas
				if((linha[1] == playerUser) && (linha[2] == playerUser) && (linha[3] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[1] == playerUser) && (linha[4] == playerUser) && (linha[7] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[1] == playerUser) && (linha[5] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[4] == playerUser) && (linha[5] == playerUser) && (linha[6] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[7] == playerUser) && (linha[8] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[2] == playerUser) && (linha[5] == playerUser) && (linha[8] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[3] == playerUser) && (linha[6] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[3] == playerUser) && (linha[5] == playerUser) && (linha[7] == playerUser)) {
					jogadas2 = 3;
					break;
				}

				if(partidas == 9 ) {break;}

				System.out.println("Vez da Maquina");

				System.out.println();
				System.out.println();

				//MAQUINA

				//verifica se tem ja uma jogada na posição escolhida.

				System.out.println("Escolha a Linha que deseja jogar");
				escolhaLinha = sortLinha.nextInt(2)+1;
				System.out.println("Escolha a Coluna que deseja jogar");
				escolhaColuna = sortColuna.nextInt(2)+1;

				//trata as linhas e colunas escolhidas.
				if((escolhaLinha == 2) && (escolhaColuna == 2)) {
					posicao = 5;
					memoriaPcLinha[posicao] = posicao;
				}else if((escolhaLinha == 2) && (escolhaColuna == 1)) {
					posicao = 4;
					memoriaPcLinha[posicao] = posicao;
				}else if((escolhaLinha == 3) && (escolhaColuna == 1)) {
					posicao = 7;
					memoriaPcLinha[posicao] = posicao;
				}else if((escolhaLinha == 3) && (escolhaColuna == 2)) {
					posicao = 8;
					memoriaPcLinha[posicao] = posicao;
				}else {
					posicao = escolhaLinha * escolhaColuna;
					memoriaPcLinha[posicao] = posicao;
				}

				while((verificaJogadasEfetuadas[posicao] == 'X')||(verificaJogadasEfetuadas[posicao] == 'O')) {
					escolhaLinha = sortLinha.nextInt(3)+1;
					escolhaColuna = sortColuna.nextInt(3)+1;

					//trata as linhas e colunas escolhidas.
					if((escolhaLinha == 2) && (escolhaColuna == 2)) {
						posicao = 5;
						memoriaPcLinha[posicao] = posicao;
					}else if((escolhaLinha == 2) && (escolhaColuna == 1)) {
						posicao = 4;
						memoriaPcLinha[posicao] = posicao;
					}else if((escolhaLinha == 3) && (escolhaColuna == 1)) {
						posicao = 7;
						memoriaPcLinha[posicao] = posicao;
					}else if((escolhaLinha == 3) && (escolhaColuna == 2)) {
						posicao = 8;
						memoriaPcLinha[posicao] = posicao;
					}else {
						posicao = escolhaLinha * escolhaColuna;
						memoriaPcLinha[posicao] = posicao;
					}
				}

				linha[posicao] = playerPc;
				memoriaPcColuna[posicao] = playerPc;




				//MAQUINA



				for(int i = 1; i < linha.length; i++ ) {
					System.out.print(linha[i]);
					if((i % 3 == 0)) {
						System.out.println();
					}else {
						for(int j = 0; j < 1; j++) {
							System.out.print(coluna[j]);
						}
					}
					verificaJogadasEfetuadas[i] = linha[i];
				}



				//verifica as linhas se estão validas
				if((linha[1] == playerPc) && (linha[2] == playerPc) && (linha[3] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[1] ==playerPc) && (linha[4] == playerPc) && (linha[7] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[1] == playerPc) && (linha[5] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[4] == playerPc) && (linha[5] == playerPc) && (linha[6] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[7] == playerPc) && (linha[8] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[2] == playerPc) && (linha[5] == playerPc) && (linha[8] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[3] == playerPc) && (linha[6] == playerPc) && (linha[9] == playerPc)) {
					jogadas = 3;
					break;
				}else if((linha[3] == playerPc) && (linha[5] == playerPc) && (linha[7] == playerPc)) {
					jogadas = 3;
					break;
				}

				//verifica as linhas se estão validas
				if((linha[1] == playerUser) && (linha[2] == playerUser) && (linha[3] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[1] == playerUser) && (linha[4] == playerUser) && (linha[7] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[1] == playerUser) && (linha[5] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[4] == playerUser) && (linha[5] == playerUser) && (linha[6] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[7] == playerUser) && (linha[8] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[2] == playerUser) && (linha[5] == playerUser) && (linha[8] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[3] == playerUser) && (linha[6] == playerUser) && (linha[9] == playerUser)) {
					jogadas2 = 3;
					break;
				}else if((linha[3] == playerUser) && (linha[5] == playerUser) && (linha[7] == playerUser)) {
					jogadas2 = 3;
					break;
				}

				partidas++;
			}
			
			default:
				System.out.println();
				break;
		}

		System.out.println();
		System.out.println();


		//Verifica quem foi o vencedor.
		if(jogadas == 3) {
			System.out.println("Parabéns jogador "+ playerPc);
		}else if(jogadas2 == 3){
			System.out.println("Parabéns jogador "+playerUser);
		}else if((jogadas == 0) && (jogadas2 == 0)){
			System.out.println("Empate !!");
		}else {
			System.out.println("Obrigada!!");
		}
		line.close();
		column.close();
		iniciar.close();

	}

}
