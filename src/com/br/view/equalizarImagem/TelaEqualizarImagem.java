package com.br.view.equalizarImagem;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.beans.FeatureDescriptor;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.br.processarImagem.PanelDaImagem;
import com.br.processarImagem.PanelDaImagemMatriz;
import com.br.view.PanelInicial;
import com.br.view.TelaInicial;
import com.br.view.histograma.GraficoHistograma;

import javax.swing.border.LineBorder;

public class TelaEqualizarImagem extends JPanel {

	private static final long serialVersionUID = 1L;

	BufferedImage imagemOriginal;

	public TelaEqualizarImagem() {
		setSize(1024, 720);
		setLayout(null);
		setVisible(true);

		// Painel lateral
		JPanel panelOpcaoLateral = new JPanel();
		panelOpcaoLateral.setBackground(SystemColor.scrollbar);
		panelOpcaoLateral.setBounds(0, 0, 194, 720);
		add(panelOpcaoLateral);
		panelOpcaoLateral.setLayout(null);

		JButton botaoPaginaInicial = new JButton("Página Inicial");
		botaoPaginaInicial.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {

				PanelInicial panelInicial = new PanelInicial();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(panelInicial);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();

			}
		});
		botaoPaginaInicial.setHorizontalAlignment(SwingConstants.LEFT);
		botaoPaginaInicial.setIcon(new ImageIcon(PanelInicial.class
				.getResource("/com/icon/home.png")));
		botaoPaginaInicial.setBounds(0, 102, 194, 39);
		botaoPaginaInicial.setForeground(Color.BLACK);
		botaoPaginaInicial.setBackground(SystemColor.scrollbar);
		botaoPaginaInicial.setFont(new Font("Segoe UI Semilight", Font.PLAIN,
				18));
		panelOpcaoLateral.add(botaoPaginaInicial);

		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(TelaEqualizarImagem.class.getResource("/com/br/images/logo.jpg")));
		lblImg.setBounds(0, 0, 194, 103);
		panelOpcaoLateral.add(lblImg);

		// INICIO PANEL SUPERIOR

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		// Corpo do sistema
		JLabel labelEqualizarImagem = new JLabel("Equalizar Imagem");
		labelEqualizarImagem.setForeground(Color.WHITE);
		labelEqualizarImagem.setFont(new Font("Segoe UI Semilight",
				Font.PLAIN, 24));
		labelEqualizarImagem.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelEqualizarImagem);
		
		PanelDaImagem panelDaImagem1 = new PanelDaImagem();
		panelDaImagem1.setLocation(221, 135);
		add(panelDaImagem1);
		
		PanelDaImagemMatriz panelDaImagemEqualizada = new PanelDaImagemMatriz();
		panelDaImagemEqualizada.setLocation(552, 400);
		panelDaImagemEqualizada.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(panelDaImagemEqualizada);
		
		GraficoHistograma graficoHistograma = new GraficoHistograma();
		graficoHistograma.setLocation(552, 135);
		graficoHistograma.setBorder(new LineBorder(new Color(0, 0, 0)));
		add(graficoHistograma);

		JButton btnEscolherImagem = new JButton("Escolher imagem");
		btnEscolherImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					// Instanciacao de fileChooser e alteracao do diretorio para
					// buscar a imagem
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File("src/imagens/"));

					// Verificacao do fileChooser
					if (fileChooser.showOpenDialog(btnEscolherImagem) == JFileChooser.APPROVE_OPTION) {

						// Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();

						panelDaImagem1.colocaImagemNoPainel(file.getPath());
						repaint();

						graficoHistograma.colocaImagemNoPainel(file.getPath());
						
						int [][] matrizEqualizada = EqualizarImagem.equalizarImagem(panelDaImagem1.getMatrizImagem());
						
						panelDaImagemEqualizada.colocaImagemNoPainel(matrizEqualizada);
						repaint();

					}

				} catch (Exception erro) {

					JOptionPane.showMessageDialog(null,
							"Não foi possivel carregar a imagem.");
				}
			}
		});
		btnEscolherImagem.setBackground(new Color(0, 102, 255));
		btnEscolherImagem.setFont(new Font("Segoe UI Light", Font.BOLD, 14));
		btnEscolherImagem.setBounds(221, 385, 250, 35);
		add(btnEscolherImagem);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage((Image) imagemOriginal, 0, 0, null);
	}
}
