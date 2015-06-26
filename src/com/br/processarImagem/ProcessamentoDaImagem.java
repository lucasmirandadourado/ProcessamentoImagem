package com.br.processarImagem;

import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Scanner;

public class ProcessamentoDaImagem {
	
	public static int [][] processarImagem(File file){
		
		//instanciar fileInputStream para carregar a imagem na memoria
		FileInputStream fileInputStream = null;
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		//instanciar um scanner para leitura dos dados da imagem
		Scanner scanner = new Scanner(fileInputStream);
		
		//discartar o tipo P2
		scanner.nextLine();
		
		int larguraDaImagem = scanner.nextInt();
		int alturaDaImagem = scanner.nextInt();
		int valorMaximo = scanner.nextInt();
		
		try {
			fileInputStream.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			fileInputStream = new FileInputStream(file);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		DataInputStream dataInputStream = new DataInputStream(fileInputStream);
		
		int numnewlines = 4;
		 while (numnewlines > 0) {
		     char c = 0;
		     do {
		         try {
					c = (char)(dataInputStream.readUnsignedByte());
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		     } while (c != '\n');
		     numnewlines--;
		 }
		
		// read the image data
		 int[][] data2D = new int[alturaDaImagem][larguraDaImagem];
		 for (int row = 0; row < alturaDaImagem; row++) {
		     for (int col = 0; col < larguraDaImagem; col++) {
		         try {
					data2D[row][col] = dataInputStream.readUnsignedByte();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		         System.out.print(data2D[row][col] + " ");
		     }
		     System.out.println();
		 }
		
		return data2D;
	}

}
