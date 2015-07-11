package com.br.filtros;
public class Mediana implements Aplicavel{

	ImagemPGM imagem;
	
	public Mediana(ImagemPGM imagem){
		this.imagem = imagem;
	}

	private static int separaVetor(int[] vetor, int ini, int fim) {
		int aux, c = vetor[ini], i = ini + 1, j = fim;
		while (i <= j) {
			if (vetor[i] <= c)
				++i;
			else if (c < vetor[j])
				--j;
			else {
				aux = vetor[i];
				vetor[i] = vetor[j];
				vetor[j] = aux;
				++i;
				--j;
			}// if
		}// while

		aux = vetor[ini];
		vetor[ini] = vetor[j];
		vetor[j] = aux;
		return j;
	}


	private static void quicksort(int[] vetor, int ini, int fim) {
		int j;
		if (ini < fim) {
			j = separaVetor(vetor, ini, fim);
			quicksort(vetor, ini, j - 1);
			quicksort(vetor, j + 1, fim);
		}// if
	}
	
	public void aplica() {
		for (int i = 0; i < imagem.getLargura(); i++) {
			for (int j = 0; j < imagem.getAltura(); j++) {
				Calcular(i, j);
			}
		}
	}

	public void Calcular(int x, int y) {
		int[] array = new int[9];
		    
		array[0] += imagem.getPixel(x, y);
		if ((x - 1) >= 0) {
			array[1] += imagem.getPixel(x - 1,y);
		}
		if ((x + 1) < imagem.getLargura()) {
			array[2] += imagem.getPixel(x + 1,y);
		}
		if ((y - 1) >= 0) {
			array[3] += imagem.getPixel(x,y - 1);
		}
		if ((y + 1) < imagem.getAltura()) {
			array[4] += imagem.getPixel(x,y + 1);
		}
		if (((x - 1) >= 0) && ((y - 1) >= 0)) {
			array[5] += imagem.getPixel(x - 1,y - 1);
		}
		if (((x + 1) < imagem.getAltura()) && ((y - 1) >= 0)) {
			array[6] += imagem.getPixel(x + 1,y - 1);
		}
		if (((x - 1) >= 0) && ((y + 1) < imagem.getAltura())) {
			array[7] += imagem.getPixel(x - 1,y + 1);
		}
		if (((x + 1) < imagem.getAltura()) && ((y + 1) < imagem.getAltura())) {
			array[8] += imagem.getPixel(x + 1,y + 1);
		}
		
		quicksort(array, 0, 8);
		imagem.setPixel(x, y, array[4]);
		
	}
	
	public ImagemPGM getImage(){
		return imagem;
	}

}