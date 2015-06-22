package com.br.view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;
import java.io.BufferedReader;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.io.Reader;
import java.util.ArrayList;

import javax.imageio.ImageIO;

public class Digital {

	private static BufferedImage imagem;
	static Color pixelColour;
	
	
	
	public static BufferedImage transformarImagem(File file) throws NullPointerException, IOException {
		int[][] matriz = new int[256][256];
		ArrayList<String> str = new ArrayList<String>();
		InputStream is = new FileInputStream(file);
	     InputStreamReader isr = new InputStreamReader(is);
	     BufferedReader br = new BufferedReader(isr);
	 
	     while (br.ready()) {
	       str.add(br.readLine());	       
	     }
	     int j = 0;
	     for (int i = 0; i < str.size(); i++) {
			matriz[i][j] = Integer.valueOf(str.get(j).charAt(i));
			System.out.print(matriz[i][j]);
		}
	     
	     br.close();
	   
		return imagem;
	}

	private static void setPixel(int col, int row, Color pixelColour) {
		imagem.setRGB(col, row, pixelColour.getRGB());

	}

	public static BufferedImage getImagem() {
		return imagem;
	}

	public static void setImagem(BufferedImage imagem) {
		Digital.imagem = imagem;
	}
}
