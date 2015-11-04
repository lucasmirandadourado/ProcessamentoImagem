package com.br.view.equalizarImagem;


public class EqualizarImagem {
	
	
	public static int[][] equalizarImagem(int matrizDaImagem [][]){
		
		/*
		 * Posicao [i][0] - K 	- Nivel de Cinza
		 * Posicao [i][1] - nK 	- Frequência em que o nível de cinza se repete
		 * Posicao [i][2] - rK 	- Valor do pixel dividido pelo valor maximo do pixel (255)
		 * Posicao [i][3] - Pr(rK) - Probabilidade de rK (nK dividido pela quantidade de pixels da imagem)
		 * Posicao [i][4] - SK 	- Soma acumulada de Pr(rK)
		 * Posicao [i][5] - Round (255 * SK) - Arredondamento da multiplicacao do valor maximo do pixel pelo valor de SK
		 */
		
		float [][] matrizDeEqualizacao = new float[255][6];
		
		
		//inicializando a matriz de equalizacao
		for (int i = 0; i < matrizDaImagem.length - 1; i++) {
			
			matrizDeEqualizacao[i][0] = 1000;
			matrizDeEqualizacao[i][1] = 0;
			
		}
		
		//calculando K, nK, rk, Pr(rK)
		for (int i = 0; i < matrizDaImagem.length; i++) {
			for (int j = 0; j < matrizDaImagem[0].length; j++) {
				
				matrizDeEqualizacao[matrizDaImagem[i][j]][0] = matrizDaImagem[i][j];
				matrizDeEqualizacao[matrizDaImagem[i][j]][1] += 1;

			}
		}
		
		//calculando K, nK, rk, Pr(rK)
				for (int i = 0; i < matrizDaImagem.length; i++) {
					for (int j = 0; j < matrizDaImagem[0].length; j++) {
						
						matrizDeEqualizacao[matrizDaImagem[i][j]][2] = matrizDaImagem[i][j] / 255;
						matrizDeEqualizacao[matrizDaImagem[i][j]][3] = matrizDeEqualizacao[matrizDaImagem[i][j]][1] / 255;
					}
				}


		//ordenando a matrizDeEqualizacao pelos niveis de cinza
		matrizDeEqualizacao = ordenarMatriz(matrizDeEqualizacao);
		
		//calcular Sk e Round(255 * Sk)
		for (int i = 0; i < matrizDeEqualizacao[0].length; i++) {
			
			//se for a primeira posicao Sk = Pr(rk)
			if(i == 0){
				
				matrizDeEqualizacao[i][4] = matrizDeEqualizacao[i][3];
				matrizDeEqualizacao[i][5] = Math.round(matrizDeEqualizacao[i][4] * 255.0);
				
			} else {
				matrizDeEqualizacao[i][4] = matrizDeEqualizacao[i][3] + matrizDeEqualizacao[i - 1][4];
				matrizDeEqualizacao[i][5] = Math.round(matrizDeEqualizacao[i][4] * 255.0);
			}
			
		}

		for (int i = 0; i < matrizDaImagem.length; i++) {
			System.out.println("Nivel de Cinza: "+matrizDeEqualizacao[i][0]);
			System.out.println("Frequência do Nível de cinza : "+matrizDeEqualizacao[i][1]);
			System.out.println("rk : "+matrizDeEqualizacao[i][2]);
			System.out.println("Probabilidade de rk : "+matrizDeEqualizacao[i][3]);
			System.out.println("Sk : "+matrizDeEqualizacao[i][4]);
			System.out.println("Round(255 * Sk) : "+matrizDeEqualizacao[i][1]);
			System.out.println("\n");
			
		}
		
		//gerando a matriz bidimensional de niveis de cinza equalizados
		int [][] matrizResultado = new int [matrizDaImagem.length][matrizDaImagem[0].length];
		
		for (int i = 0; i < matrizDaImagem.length; i++) {
			for (int j = 0; j < matrizResultado.length; j++) {
				
				int posicao = 0;
				boolean flag = false;
				while(matrizDaImagem[i][j] != matrizDeEqualizacao[posicao][0]){
					posicao += 1;
				}
				
				matrizResultado[i][j] = (int)matrizDeEqualizacao[posicao][5];
				
			}
			
		}

		return matrizResultado;
	}
	
	public static float [][] ordenarMatriz(float matrizDeEqualizacao [][]){
		
		boolean houveTroca = true;
		while(houveTroca == true){
			houveTroca = false;
			
			for (int i = 0; i < matrizDeEqualizacao.length - 1; i++) {
				if(matrizDeEqualizacao[i][0] > matrizDeEqualizacao[i+1][0]){
					float variavelAuxiliar0, variavelAuxiliar1, variavelAuxiliar2, variavelAuxiliar3;
					
					variavelAuxiliar0 = matrizDeEqualizacao[i][0];
					variavelAuxiliar1 = matrizDeEqualizacao[i][1];
					variavelAuxiliar2 = matrizDeEqualizacao[i][2];
					variavelAuxiliar3 = matrizDeEqualizacao[i][3];
					
					matrizDeEqualizacao[i][0] = matrizDeEqualizacao[i+1][0];
					matrizDeEqualizacao[i][1] = matrizDeEqualizacao[i+1][1];
					matrizDeEqualizacao[i][2] = matrizDeEqualizacao[i+1][2];
					matrizDeEqualizacao[i][3] = matrizDeEqualizacao[i+1][3];
					
					matrizDeEqualizacao[i+1][0] = variavelAuxiliar0;
					matrizDeEqualizacao[i+1][1] = variavelAuxiliar1;
					matrizDeEqualizacao[i+1][2] = variavelAuxiliar2;
					matrizDeEqualizacao[i+1][3] = variavelAuxiliar3;
					
					houveTroca = true;
					
				}
			}
			
		}
		
		return matrizDeEqualizacao;
	}
	

}
