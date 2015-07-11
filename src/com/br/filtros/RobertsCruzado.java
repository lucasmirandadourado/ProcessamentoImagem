package com.br.filtros;
public class RobertsCruzado implements Aplicavel {

	private ImagemPGM imagem;

	public RobertsCruzado(ImagemPGM image) {
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
		int fatA = 0;
		int fatB = 0;

		if (((y + 1) < imagem.getAltura()) && ((x + 1) < imagem.getAltura())) {
			fatB = imagem.getPixel(x,y) - imagem.getPixel(x + 1,y + 1);
		} else {
			fatB = imagem.getPixel(x,y);
		}
		
		if ((x + 1) < imagem.getLargura()){
			fatA += imagem.getPixel(x + 1,y);
		}
		if ((y + 1) < imagem.getAltura()){
			fatA += -imagem.getPixel(x,y + 1);
		}
		
		
		int mag = Math.abs(fatB) + Math.abs(fatA);

		imagem.setPixel(x,y,mag);

	}
	
	public ImagemPGM getImage(){
		return imagem;
	}

}
