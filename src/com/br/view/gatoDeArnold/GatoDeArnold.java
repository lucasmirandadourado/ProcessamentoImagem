package com.br.view.gatoDeArnold;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.Timer;

public class GatoDeArnold {

        private int[][] img;
        private int[][] copyImg;
        private int[][] arnold;
        private ImagemPGM imagem;
        private int iteracoes;

        public GatoDeArnold(ImagemPGM img) {
                this.img = img.pixels;
                this.arnold = new int[this.img.length][this.img[0].length];
                this.imagem = img;
                this.iteracoes = 0;
                this.createCopy();

        }

        public boolean condicaoDeContinuidade(){
                if (!this.equals(this.img, this.arnold))
                        return true;
                else
                        return false;
        }
        private boolean equals(int[][] matrizA, int[][] matrizB) {
                for (int i = 0; i < matrizA.length; i++) {
                        for (int j = 0; j < matrizA[i].length; j++) {
                                if (matrizA[i][j] != matrizB[i][j])
                                        return false;
                        }
                }
                return true;
        }

        private void createCopy() {
                this.copyImg = new int[img.length][img[0].length];
                for (int i = 0; i < copyImg.length; i++) {
                        for (int j = 0; j < copyImg[i].length; j++) {
                                copyImg[i][j] = img[i][j];
                        }
                }
        }

        public void processaUmaVez() {
                int x = 0;
                int y = 0;
                this.iteracoes++;
                for (int i = 0; i < arnold.length; i++) {
                        for (int j = 0; j < arnold[i].length; j++) {
                                x = ((i + j) % img.length);
                                y = ((j + 2 * i) % img[0].length);
                                arnold[x][y] = copyImg[i][j];
                        }
                }

                for (int i = 0; i < copyImg.length; i++) {
                        for (int j = 0; j < copyImg[i].length; j++) {
                                copyImg[i][j] = arnold[i][j];
                        }
                }

        }

        public ImagemPGM getArnoldImage() {
                return new ImagemPGM(this.imagem.largura, this.imagem.altura,
                                this.imagem.maxValue, this.arnold);
        }

        public int getIteracoes(){
                return this.iteracoes;
        }


        JLabel label;
        JLabel contagem;
        ImageIcon icon;
        JFrame frame;

        public void mostraGato(){
                frame = new JFrame("Gato de Arnold");
                frame.setLayout(null);
                frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                icon = new ImageIcon(this.getArnoldImage().geraBuffer());
                label = new JLabel(icon);
                frame.add(label);
                label.setBounds(10, 10, 256, 256);
                contagem = new JLabel("Iterações: 0");
                frame.add(contagem);
                contagem.setBounds(100, 276, 100, 30);
                Dimension d = new Dimension(300,350);
                frame.setSize(d);
                frame.setPreferredSize(d);
                frame.setResizable(false);
                frame.setVisible(true);
                frame.validate();
                frame.repaint();
        }


        public void executa() {
                while(this.condicaoDeContinuidade()){
                        this.processaUmaVez();
                        this.icon.setImage(this.getArnoldImage().geraBuffer());
                        this.label.setIcon(this.icon);
                        this.contagem.setText("Iterações: " + this.getIteracoes());
                        this.frame.validate();
                        this.frame.revalidate();
                        
                        this.frame.repaint();

                        try {

                                Thread.sleep(100);
                        } catch (InterruptedException e) {
                                System.out.println("Erro na execução da thread");
                                e.printStackTrace();
                        }
                }

        }

}