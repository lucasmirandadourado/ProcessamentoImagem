package com.br.filtros;
public class Prewitt implements Aplicavel {

	private ImagemPGM imagem;

	public Prewitt(ImagemPGM image) {
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

		if (((x - 1) >= 0) && ((y + 1) < imagem.getAltura())) {
			fatA += imagem.getPixel(x - 1,y + 1);
			fatB -= imagem.getPixel(x - 1,y + 1);
		}
		if ((y + 1) < imagem.getAltura()) {
			fatA += imagem.getPixel(x,y + 1);
		}
		if (((x + 1) < imagem.getLargura()) && ((y + 1) < imagem.getAltura())) {
			fatA += imagem.getPixel(x + 1,y + 1);
			fatB += imagem.getPixel(x + 1,y + 1);
		}
		if (((x - 1) >= 0) && ((y - 1) >= 0)) {
			fatA -= imagem.getPixel(x - 1,y - 1);
			fatB -= imagem.getPixel(x - 1,y - 1);
		}
		if ((y - 1) >= 0) {
			fatA -= imagem.getPixel(x,y - 1);
		}
		if (((x + 1) < imagem.getLargura()) && ((y - 1) >= 0)){
			fatA -= imagem.getPixel(x + 1,y - 1);
			fatB += imagem.getPixel(x + 1,y - 1);
		}
		if ((x + 1) < imagem.getLargura()){
			fatB += imagem.getPixel(x + 1,y);
		}
		if ((x - 1) >= 0){
			fatB -= imagem.getPixel(x - 1,y);
		}

		int mag = Math.abs(fatA) + Math.abs(fatB);
		imagem.setPixel(x,y,mag);
	}
	
	public ImagemPGM getImage(){
		return imagem;
	}

}
