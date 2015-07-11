package com.br.filtros;

public class Roberts implements Aplicavel {

	private ImagemPGM imagem;
	
	public Roberts(ImagemPGM image){
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
		
		if ((y + 1) < imagem.getAltura()){
			fatB = imagem.getPixel(x,y) - imagem.getPixel(x,y + 1);
		}else{
			fatB = imagem.getPixel(x,y);
		}
		if ((x + 1) < imagem.getAltura()){
			fatA = imagem.getPixel(x,y) - imagem.getPixel(x + 1,y);
		}else {
			fatA = imagem.getPixel(x,y);
		}
		int mag = Math.abs(fatB) + Math.abs(fatA);
		
		imagem.setPixel(x,y,mag);
	}
	
	public ImagemPGM getImage(){
		return imagem;
	}

}
