package com.br.filtros;
public class Sobel implements Aplicavel{

	private ImagemPGM imagem;

	private ImagemPGM imagemFixa;

	public Sobel(ImagemPGM image){
		this.imagem = image;
		this.imagemFixa = new ImagemPGM(image.getNome(),image.getLargura(), image.getAltura(), image.getNivel(), image.getImagem());
	}

	public void aplica() {
		for (int i = 0; i < imagemFixa.getLargura(); i++) {
			for (int j = 0; j < imagemFixa.getAltura(); j++) {
				Calcular(i, j);
			}
		}
	}

	public void Calcular(int x, int y) {
		int fatA = 0;
		int fatB = 0;
		int fatC = 0;
		int fatD = 0;
		if ((x - 1) >= 0) {
			fatD += 2*imagemFixa.getPixel(x - 1,y);
		}
		if ((x + 1) < imagemFixa.getLargura()) {
			fatC += 2*imagemFixa.getPixel(x + 1,y);
		}
		if ((y - 1) >= 0) {
			fatB += 2*imagemFixa.getPixel(x,y - 1);
		}
		if ((y + 1) < imagemFixa.getAltura()) {
			fatA += 2*imagemFixa.getPixel(x,y + 1);
		}
		if (((x - 1) >= 0) && ((y - 1) >= 0)) {
			fatB += imagemFixa.getPixel(x - 1,y - 1);
			fatD += imagemFixa.getPixel(x - 1,y - 1);
		}
		if (((x + 1) < imagemFixa.getLargura()) && ((y - 1) >= 0)) {
			fatB += imagemFixa.getPixel(x + 1,y - 1);
			fatC += imagemFixa.getPixel(x + 1,y - 1);
		}
		if (((x - 1) >= 0) && ((y + 1) < imagemFixa.getAltura())) {
			fatA += imagemFixa.getPixel(x - 1,y + 1);
			fatD += imagemFixa.getPixel(x - 1,y + 1);
		}
		if (((x + 1) < imagemFixa.getLargura()) && ((y + 1) < imagemFixa.getAltura())) {
			fatA += imagemFixa.getPixel(x + 1,y + 1);
			fatC += imagemFixa.getPixel(x + 1,y + 1);
		}

		int aux1 = fatA - fatB;
		int aux2 = fatC - fatD;
		int mag = Math.abs(aux1) + Math.abs(aux2);
		imagem.setPixel(x, y, mag);
	}

	private int[][] preencheArray(int[][] entrada) {
		int larg = entrada.length;
		int alt = entrada[0].length;
		int[][] saida = new int[larg][alt];
		for (int i = 0; i < entrada.length; i++) {
			for (int j = 0; j < entrada[i].length; j++) {
				saida[i][j] = entrada[i][j];
			}
		}
		return saida;
	}

	public ImagemPGM getImage() {
		return this.imagemFixa;
	}

	public ImagemPGM getModifiedImage() {
		return this.imagem;
	}

}



