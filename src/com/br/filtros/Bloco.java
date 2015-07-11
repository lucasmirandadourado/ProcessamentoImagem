package com.br.filtros;


public class Bloco {
	private int[][] matrizValores;
	private Coordenada coordenada;

	public Bloco(int[][] matriz){
		this.matrizValores = matriz;
	}
	
	public Bloco(int linha,int coluna,int[][] matriz){
		this.matrizValores = matriz;
		this.coordenada = new Coordenada(linha,coluna);
	}
	
	public Bloco(Coordenada c,int[][] matriz){
		this.matrizValores = matriz;
		this.coordenada = c;
	}
	
	public double calculaMAD(Bloco blocoB){
		double somatorio = 0;
		
		for (int i=0;i<matrizValores.length;i++){
			for (int j=0;j<matrizValores.length;j++){
				somatorio+=Math.abs(this.matrizValores[i][j]-blocoB.getMatrizValores()[i][j]);
			}
		}
		somatorio/=(blocoB.getMatrizValores().length*blocoB.getMatrizValores().length);
		return somatorio;
	}

	public int[][] getMatrizValores() {
		return matrizValores;
	}

	public void setMatrizValores(int[][] matrizValores) {
		this.matrizValores = matrizValores;
	}
	
	public int getTamanho(){
		return this.matrizValores.length;
	}
	
	public int getColuna(){
		return this.coordenada.getColuna();
	}

	public int getLinha(){
		return this.coordenada.getLinha();
	}

	public Coordenada getCoordenada() {
		return coordenada;
	}
	public void setCoordenada(Coordenada coordenada) {
		this.coordenada = coordenada;
	}
	
	public String toString() {
		String retorno = "Bloco("+coordenada.getLinha()+","+coordenada.getColuna()+"):\n";
		for (int i=0;i<matrizValores.length;i++){
			for (int j=0;j<matrizValores.length;j++){
				retorno+=matrizValores[i][j]+"\t";
			}
			retorno+="\n";
		}
		return retorno;
	}
}
