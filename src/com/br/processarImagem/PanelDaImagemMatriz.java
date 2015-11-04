package com.br.processarImagem;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.image.BufferedImage;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import java.awt.Rectangle;
import javax.swing.border.LineBorder;

/**
 * @author Bruno Clementino
 */

public class PanelDaImagemMatriz extends JPanel {

	public int[][] matrizImagem;
	public int altura;
	public int largura;
	
	public BufferedImage imagemOriginal;
	
	public PanelDaImagemMatriz() {
		
		setBorder(new LineBorder(new Color(0, 0, 0)));
		setBounds(new Rectangle(0, 0, 250, 250));
				
	}
	
	public void colocaImagemNoPainel(int [][] matrizEqualizada){
		try {
			
			geraImagem(matrizEqualizada);
			
		} catch (IOException e) {
			JOptionPane.showMessageDialog(null, "Ocorreu um erro ao tentar abrir a imagem.");
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
	
	public void geraImagem(int [][] matrizEqualizada) throws Exception{
		
		
        
        imagemOriginal = new BufferedImage(255, 255, BufferedImage.TYPE_INT_RGB);
        for(int i = 0; i<255; i++){
        	for(int j=0;j<255;j++){
        		imagemOriginal.setRGB(j, i, corPixel((int)matrizEqualizada[i][j]));
        		repaint();
        	}
        	
        }
             
    }
	
	
	
	public int[][] getMatrizImagem() {
		return matrizImagem;
	}

	public void setMatrizImagem(int[][] matrizImagem) {
		this.matrizImagem = matrizImagem;
	}

	static int corPixel(int corRGB){
		Color cor = new Color(corRGB, corRGB, corRGB);
		return cor.getRGB();
	}
	
	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage((Image) imagemOriginal, 0, 0, null);
	}
	
}
