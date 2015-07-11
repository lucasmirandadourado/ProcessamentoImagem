package com.br.filtros;


public class Coordenada {
	private int linha;
	private int coluna;
	
	public Coordenada(int linha, int coluna
			){
		this.linha = linha;
		this.coluna = coluna;
	}
	
	public Coordenada(int valor){
		this.linha = valor;
		this.coluna = valor;
	}
	
	
	public int getColuna() {
		return coluna;
	}

	public void setColuna(int coluna) {
		this.coluna = coluna;
	}

	public int getLinha() {
		return linha;
	}

	public void setLinha(int linha) {
		this.linha = linha;
	}

	@Override
	public String toString() {
		String retorno = "("+linha+","+coluna+")";
		return retorno;
	}
	
}
