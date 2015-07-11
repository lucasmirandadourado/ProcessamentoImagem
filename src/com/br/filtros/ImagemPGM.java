package com.br.filtros;
import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class ImagemPGM {
	private String nome = null;
    private String codificacao = null;    
    private int largura = 0;
    private int altura = 0;
    private int nivel = 0;
    private int[][] imagem = null;
    public static int x;
    public static int y;
    
    public ImagemPGM(int tam){
    	this.nome = "";
    	this.codificacao = "";
    	this.nivel = -1;
    	this.imagem = new int[tam][tam];
    	this.altura = tam;
    	this.largura = tam;
    	
    }
    
    public ImagemPGM(String pCaminhoArquivo) throws IOException {
        super();
        this.lerArquivoPGM(pCaminhoArquivo);
    }
    
    public ImagemPGM(String nome, String pCodificacao, int pLargura, int pAltura, int pNivel) {
        this.nome = nome;
        this.codificacao = pCodificacao;
        this.nivel = pNivel;
        this.altura = pAltura;
        this.largura = pLargura;
        
        this.imagem = new int[this.altura][this.largura];
        
        for (int i = 0; i < this.altura; i++)
            for (int j = 0; j < this.largura; j++)
                this.imagem[i][j] = 0;
    }
    
    public ImagemPGM(String nome, int pLargura, int pAltura, int pNivel, int[][] img) {
        this.nome = nome;
        this.nivel = pNivel;
        this.altura = pAltura;
        this.largura = pLargura;
        this.imagem = img;
    }
    
  
    private void lerArquivoPGM(String pCaminhoArquivo) throws IOException {
    	//System.out.println(":: Lendo aqruivo PGM...");
    	BufferedReader bufferedReader = null;
    	String linha = null;
    	String[] colunas = null;    	

    	try {
    		bufferedReader = new BufferedReader(new InputStreamReader(new FileInputStream(pCaminhoArquivo)));
    		int ultimaBarra = pCaminhoArquivo.lastIndexOf("\\");
    		this.nome = pCaminhoArquivo.substring(ultimaBarra+1);
    		// le a codificacao
    		
    		do {
    			linha = bufferedReader.readLine();
    		} while (linha.startsWith("#"));
    		
    		this.codificacao = linha.trim();
    		//System.out.println(".codificao: "+this.codificacao);

    		// le a largura e a altura
    		do {
    			linha = bufferedReader.readLine();
    		} while (linha.startsWith("#"));
    		
    		colunas = linha.trim().split(" ");
    		this.largura = Integer.parseInt(colunas[0]);
    		this.altura = Integer.parseInt(colunas[1]);

    		//System.out.println(".largura: "+this.largura + " | altura: " + this.altura);

    		// le os niveis de cinza
    		do {
    			linha = bufferedReader.readLine();
    		} while (linha.startsWith("#"));
    		this.nivel = Integer.parseInt(linha.trim());

    		this.imagem = new int[this.altura][this.largura];

    		linha = bufferedReader.readLine();
    		linha = linha.trim();
    		colunas = linha.split(" ");

    		int linecounter = 0;
    		int columncounter = 0;

    		while (linha!= null) {
    			
    			colunas = linha.split("\\s");

    			for (int i = 0; i < colunas.length; i++ ) {

    				if (columncounter >= altura){
    					linecounter++;
    					columncounter = 0;
    				}					
    				if (!colunas[i].equals("")) {
    					this.imagem[linecounter][columncounter] = Integer.parseInt(colunas[i]);
    					columncounter++;
    				}
    			}
    			linha = bufferedReader.readLine();
    			while ((linha != null) && (linha.startsWith("#"))) {
        			linha = bufferedReader.readLine();
        		}
    		}
    	} catch (Exception e) {

    		e.printStackTrace();
    	}
    }
    

    public int[][] getVizinhanca(int pCoordenadaX, int pCoordenadaY, int pTamanhoMascara) {
        int[][] vizinhaca = null;
        int coordenadaX = 0;
        int coordenadaY = 0;
        int mascara = 0;
        int linha = 0;
        int coluna = 0; 
        
        if ( pTamanhoMascara == 1 )
            mascara = 0;
        else if ( pTamanhoMascara == 3 )
            mascara = 1;
        else if ( pTamanhoMascara == 5 )
            mascara = 2;
        else if ( pTamanhoMascara == 7 )
            mascara = 3;
        this.x = coordenadaX;
        this.y = coordenadaY;
        coordenadaX = pCoordenadaX - 1;
        coordenadaY = pCoordenadaY - 1;
        
        vizinhaca = new int[pTamanhoMascara][pTamanhoMascara];
        
        for ( int i = -mascara; i <= mascara; i++ ) {
            
            coluna = 0;
            
            for ( int j = -mascara; j <= mascara; j++ ) {
                
                vizinhaca[linha][coluna] = this.getValorPixel(coordenadaX + j, coordenadaY + i);
                
                coluna = coluna + 1;                
            }
            
            linha = linha + 1;
        }
        
        return vizinhaca;
    }
 
    private int getValorPixel(int pCoordenadaX, int pCoordenadaY) {
        int valorPixel = 0;
        
        if ( pCoordenadaX < 0 || pCoordenadaY < 0 || pCoordenadaX > this.largura - 1 || pCoordenadaY > this.altura - 1 )
            valorPixel = 0;
        else
            valorPixel = this.imagem[pCoordenadaY][pCoordenadaX];
        
        return valorPixel;      
    }

    public void setPixel(int pCoordenadaX, int pCoordenadaY, int pValor) {
        
        if ( pCoordenadaX < 1 || pCoordenadaY < 1 || pCoordenadaX > this.largura || pCoordenadaY > this.altura ) {
            
        } else
            this.imagem[pCoordenadaY - 1][pCoordenadaX - 1] = pValor;
    }
 
    public int getPixel(int pCoordenadaX, int pCoordenadaY) {
        int pixel = 0;
        
        if ( pCoordenadaX < 1 || pCoordenadaY < 1 || pCoordenadaX > this.largura || pCoordenadaY > this.altura )
            pixel = 0;
        else
            pixel = this.imagem[pCoordenadaY - 1][pCoordenadaX - 1];
        
        return pixel;
    }
    

    
    public Integer[][] getMatrizValores(){
    	Integer[][] retorno = new Integer[this.imagem.length][this.imagem[0].length];
    	for (int i=0;i<imagem.length;i++){
    		for (int j=0; j<imagem[i].length;j++){
    			retorno[i][j]=this.imagem[i][j];
    		}
    	}
    	return retorno;	
    }
    
    public void setBloco(Coordenada c,int[][] bloco){
    	for (int i=0;i<bloco.length;i++){
    		for (int j=0;j<bloco.length;j++){
        		if (i+c.getLinha()>=0 && i+c.getLinha()<this.imagem.length && j+c.getColuna()>=0 && j+c.getColuna()<this.imagem.length){
        			this.imagem[i+c.getLinha()][j+c.getColuna()]=bloco[i][j];
        		}
        	}
    	}
    }
    
    public Bloco getBloco(Coordenada coord, int tamanho){
    	int[][] bloco = new int[tamanho][tamanho];
    	int x = coord.getLinha();
    	int y = coord.getColuna();

    	for (int i=0;i<tamanho;i++,x++){
    		y=coord.getColuna();
    		for (int j=0;j<tamanho;j++,y++){
    			if (x<coord.getLinha()+tamanho && x<imagem.length && x>=0
    					&&(y<coord.getColuna()+tamanho && y<imagem.length && y>=0)){
    				bloco[i][j]=imagem[x][y];
    			}
    		}
    	}
    	
    	Bloco retorno = new Bloco(coord,bloco);

    	return retorno;
    }
    
    public ArrayList<Bloco> getBlocos(int tamanho){ //TODO tratar se o tamanho do bloco não for compatível.
    	ArrayList<Bloco> retorno = new ArrayList<Bloco>();
    	int[][] bloco;
    	
    	for (int linhaImg=0;linhaImg<this.altura;linhaImg+=tamanho){
    		for (int colunaImg=0;colunaImg<this.altura;colunaImg+=tamanho){
    			
    			bloco = new int[tamanho][tamanho];
    			int x=0; //x do bloco
    			for(int linha=linhaImg; linha<linhaImg+tamanho; linha++, x++){
    				int y=0; //y do bloco
    				for(int coluna=colunaImg; coluna<colunaImg+tamanho; coluna++, y++){
    					bloco[x][y]=this.imagem[linha][coluna];
    				}
    			}
    			retorno.add(new Bloco(linhaImg,colunaImg,bloco));
    		}
    	}

    	return retorno;
    }
            
    public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public int getAltura() {
        return altura;
    }
    public String getCodificacao() {
        return codificacao;
    }
    public int[][] getImagem() {
        return imagem;
    }
    public int getLargura() {
        return largura;
    }
    public int getNivel() {
        return nivel;
    }
    public static final String ai = "C:\\Documents and Settings\\Kadhafi\\workspace\\PrjMultimidia\\outros arquivos\\imagens\\SequenciasImagens\\";
    
    public static void main(String args[]) throws IOException {
    	for (int i = 11; i < 70; i++) {
    		ImagemPGM a = new ImagemPGM(ai + "claire0" + i + "-240.pgm");
    		System.out.println("i: " + i);
		}

    }

    public void setAltura(int altura) {
		this.altura = altura;
	}

	public void setCodificacao(String codificacao) {
		this.codificacao = codificacao;
	}

	public void setImagem(int[][] imagem) {
		this.imagem = imagem;
	}

	public void setLargura(int largura) {
		this.largura = largura;
	}

	public void setNivel(int nivel) {
		this.nivel = nivel;
	}

}
