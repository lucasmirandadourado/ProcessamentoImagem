package com.br.view;

import java.awt.Color;
import java.awt.image.BufferedImage;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.StreamTokenizer;

public class Digital {

	private static BufferedImage imagem;
	File file;

	public static BufferedImage transformarImagem(File file)
			throws NullPointerException, IOException {
		int[][] data2D;
		FileInputStream fileInputStream = new FileInputStream(
				"src/imagens/lena.pgm");
		DataInputStream dis = new DataInputStream(fileInputStream);

		// read header text using StreamTokenizer.nextToken()
		
		data2D = new int[256][256];
		for (int row = 0; row < 255; row++) {
			for (int col = 0; col < 255; col++) {
				data2D[row][col] = dis.readUnsignedByte();
				System.out.print(data2D[row][col] + " ");
			}
			System.out.println();
		}
		
		imagem = new BufferedImage(256, 256, BufferedImage.TYPE_INT_RGB);
		
		for (int i = 0; i < 255; i++) {
			for (int j = 0; j < 255; j++) {
				imagem.setRGB(i, j, new Color(data2D[i][j]).getRGB());
			}
		}	
		
//		for (int i = 0; i < 256; i++) {
//			for (int j = 0; j < 256; j++) {
//				imagem.setRGB(i, j, (int) data2D[i][j]);
//			}
//
//		}
		return imagem;
	}

	public static BufferedImage getImagem() {
		return imagem;
	}

	public static void setImagem(BufferedImage imagem) {
		Digital.imagem = imagem;
	}

}
