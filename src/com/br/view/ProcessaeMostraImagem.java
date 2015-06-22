package com.br.view;

//
//
//   Uso de ImageIO com BufferedImage
//	 Vantagens: ve varios tipos de imagens,
//   da acesso aos elementos de uma imagem e visualiza dado processado

import java.io.File;

// pacotes do AWT
import java.awt.image.BufferedImage;
import java.awt.image.Raster;
import java.awt.image.WritableRaster;


// pacote Swing para definir interface gráfica
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JScrollPane;
import javax.swing.ImageIcon;

// leitura em modo imediato - para J2SE 1.4+
import javax.imageio.ImageIO;

public class ProcessaeMostraImagem extends JFrame {

  public static void main(String args[]) {

	// Mostra JFrame decorado pelo Swing
		JFrame.setDefaultLookAndFeelDecorated(true);

    // Carrega e Visualiza imagem original

	    String ima_name_in = "imagens/lena.pgm";
	    String ima_name_out = "imagens/Lenag.pgm";
		BufferedImage ima_in, ima_out;

		ima_in = CarregaImagem(ima_name_in);

    	ProcessaeMostraImagem frame1 = new ProcessaeMostraImagem();

    	frame1.MostraImagem(ima_in, ima_name_in);


	// Carrega e processa imagem original e mostra imagem processada

 		ima_out = ProcessaImagem(ima_in);

 		ProcessaeMostraImagem frame2 = new ProcessaeMostraImagem();

		frame2.MostraImagem(ima_out, ima_name_out);

 		SalvaImagem(ima_out, ima_name_out);
  	}

//  public ProcessaeMostraImagem (){  };

  public static BufferedImage CarregaImagem(String image_name)   {
    // Associa objeto BufferedImage com <arquivo_imagem>
    	BufferedImage ima_in = null;

    // Carrega imagem

		File file = new File(image_name);
    	try {
    	  ima_in= ImageIO.read(file);
    	} catch(Exception e) {
     	 	System.out.println("Imagem '" + image_name + "' nao existe.");
     	 	System.exit(0);
    	}

		System.out.println("Nome da Imagem: "+image_name+" Tipo da Imagem: "+ima_in.getType());
		System.out.println("Tamanho da Imagem: Colunas "+ima_in.getWidth()+" Linhas "+ima_in.getHeight());


		return ima_in;

	}

	public static void SalvaImagem(BufferedImage dest, String image_name) {

		try {

			ImageIO.write(dest, "jpg", new File(image_name));

		} catch (Exception e) {

			System.out.println("Problema gravando arquivo. ");
        	System.exit(0);
		}
	}

    public static BufferedImage ProcessaImagem (BufferedImage ima_in) {

    // Associa objeto BufferedImage com <arquivo_imagem> níveis de cinza (10)

    	BufferedImage ima_out  = new BufferedImage(ima_in.getWidth(),ima_in.getHeight(),BufferedImage.TYPE_BYTE_GRAY); // 10 - TYPE_BYTE_GRAY

     // Recupera matriz das imagens de entrada e saida

		Raster raster = ima_in.getRaster(); // declara e instancia objeto raster soh para leitura
		WritableRaster wraster = ima_out.getRaster(); // declara e instancia objeto raster para escrita

	// Processa valores da imagem de entrada e armazena na imagem de saida

		int r, g, b, valorn;

		for(int y=0; y<ima_in.getHeight(); y++)
			for(int x=0; x<ima_in.getWidth(); x++){

				r = raster.getSample(x,y,0);  // le dado da banda 0 da imagem de entrada
				g = raster.getSample(x,y,1);  // le dado da banda 1 da imagem de entrada
				b = raster.getSample(x,y,2);  // le dado da banda 2 da imagem de entrada

//				valorn = r;  // Transfere Banda 0 (r) da imagem
//				valorn = g;  // Transfere Banda 1 (g) da imagem
//				valorn = b;  // Transfere Banda 2 (b) da imagem

//				Criacao de Imagens níveis de Cinza a partir das bandas r, g e b
//				valorn = (r+g+b)/3;	// Pela média das 3 bandas
//				valorn = (Maximo(r,g,b)+Minimo(r,g,b))/2; // Pela Média entre Maximo e Minimo
				valorn = (int)(.299*(double)r + .587*(double)g + .114*(double)b); // Pela Média Ponderada das 3 bandas

//				valorn = 255-valorn; // Inverte Imagem

//				if(valorn<127)valorn = 0; else valorn=255; // Binariza imagem pelo nivel 127

				wraster.setSample(x,y,0,valorn);

				if(y<=3 && x<=3)
					System.out.println(y+" "+x+"  Valores "+r+"  "+g+"  "+b+" "+valorn);

			}

		return ima_out;
	};

	public void MostraImagem(BufferedImage ima, String image_name) {

    // Define GUI com objetos do Swing
  	 	JLabel lsrc2 = new JLabel(new ImageIcon(ima));
    	getContentPane().add(new JScrollPane(lsrc2));

    // Atribui nome e tamanho ao frame
   		setTitle("Java2DImageDisplay: =>" + image_name);
  		setSize(ima.getWidth()+40, ima.getHeight()+40);

    	setVisible(true);

    // Encerra a aplicação clicando no "close"
    	setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);


  }


  public static int Minimo(int a, int b, int c){
	  int min=a;
	  if(b<min)min=b; if(c<min)min=c;
	  return min;
  }

   public static int Maximo(int a, int b, int c){
	  int max=a;
	  if(b>max)max=b; if(c>max)max=c;
	  return max;
  }
}

