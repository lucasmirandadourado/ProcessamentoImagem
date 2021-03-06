package com.br.filtros;

public class PassaAlta implements Aplicavel{

	private ImagemPGM imagem;
		
	public PassaAlta(ImagemPGM image){
		this.imagem = image;
		
	}
	
	public void aplica() {
		for (int i = 0; i < imagem.getLargura(); i++) {
			for (int j = 0; j < imagem.getAltura(); j++) {
				Calcular(i, j);
			}
		}
	}

	public void Calcular(int x, int y) {
		int soma = 0;

		soma += 8*imagem.getPixel(x,y);
		if ((x - 1) >= 0) {
			soma += -1*imagem.getPixel(x - 1,y);
		}
		if ((x + 1) < imagem.getLargura()) {
			soma += -1*imagem.getPixel(x + 1,y);
		}
		if ((y - 1) >= 0) {
			soma += -1*imagem.getPixel(x,y - 1);
		}
		if ((y + 1) < imagem.getAltura()) {
			soma += -1*imagem.getPixel(x,y + 1);
		}
		if (((x - 1) >= 0) && ((y - 1) >= 0)) {
			soma += -1*imagem.getPixel(x - 1,y - 1);
		}
		if (((x + 1) < imagem.getLargura()) && ((y - 1) >= 0)) {
			soma += -1*imagem.getPixel(x + 1,y - 1);
		}
		if (((x - 1) >= 0) && ((y + 1) < imagem.getAltura())) {
			soma += -1*imagem.getPixel(x - 1,y + 1);
		}
		if (((x + 1) < imagem.getLargura()) && ((y + 1) < imagem.getAltura())) {
			soma += -1*imagem.getPixel(x + 1,y + 1);
		}

		imagem.setPixel(x,y, soma/9);
	}
	
	public ImagemPGM getImage(){
		return imagem;
	}

}
