package com.br.view.gatoDeArnold;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.Rectangle;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.LineBorder;
import javax.swing.plaf.SliderUI;

public class PanelGatoDeArnold extends JPanel {

	public BufferedImage imagemGatoDeArnold;

	/**
	 * Create the panel.
	 */
	public PanelGatoDeArnold() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));

	}
	
	public void colocaImagemNoPainel(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][]){
		try {
			geraImagem(alturaDaImagem1, larguraDaImagem1, matrizDaImagem1);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void geraImagem(int alturaDaImagem1, int larguraDaImagem1, int matrizDaImagem1[][]) throws Exception{
		
        int altura = alturaDaImagem1;
        int largura = larguraDaImagem1;
        
        imagemGatoDeArnold = new BufferedImage(altura, largura, BufferedImage.TYPE_INT_RGB);
               
        int matrizInput [][] = matrizDaImagem1;
        int matrizResultado [][] = new int [altura][largura];
        
        for (int i = 0; i < matrizDaImagem1.length; i++) {
			for (int j = 0; j < matrizDaImagem1.length; j++) {
				//matrizResultado[i][j] = matrizDaImagem1[]
			}
		}
    }

	private boolean equals(int[][] matrizA, int[][] matrizB) {
        for (int i = 0; i < matrizA.length; i++) {
        	for (int j = 0; j < matrizA[i].length; j++) {
        		if (matrizA[i][j] != matrizB[i][j]){
        			return false;
                }
            }
        }
        return true;
	}
	
	static int corPixel(int corRGB){
		Color cor = new Color(corRGB, corRGB, corRGB);
		return cor.getRGB();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage(imagemGatoDeArnold, 0, 0, null);
	}

}
