package com.br.view.filtros;

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
import com.br.view.PanelInicial;
import com.br.view.TelaInicial;
import com.br.view.histograma.TelaHistograma;

import javax.swing.border.LineBorder;

public class Filtros extends JPanel {

	private static final long serialVersionUID = 1L;

	BufferedImage imagemOriginal;

	public Filtros(){
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
		lblImg.setIcon(new ImageIcon(TelaHistograma.class.getResource("/com/br/images/logo.jpg")));
		lblImg.setBounds(0, 0, 194, 103);
		panelOpcaoLateral.add(lblImg);

		// INICIO PANEL SUPERIOR

		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);

		// Corpo do sistema
		JLabel labelFiltros = new JLabel("Filtros");
		labelFiltros.setForeground(Color.WHITE);
		labelFiltros.setFont(new Font("Segoe UI Semilight",
				Font.PLAIN, 24));
		labelFiltros.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelFiltros);
		
		JButton botaoMedia = new JButton("Média");
		botaoMedia.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaFiltroMedia telaFiltroMedia = new TelaFiltroMedia();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaFiltroMedia);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoMedia.setForeground(Color.WHITE);
		botaoMedia.setBackground(new Color(0, 102, 255));
		botaoMedia.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		botaoMedia.setBounds(224, 137, 200, 82);
		add(botaoMedia);
		
		JButton botaoSobel = new JButton("Sobel");
		botaoSobel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaFiltroSobel sobel = new TelaFiltroSobel();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(sobel);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		botaoSobel.setForeground(SystemColor.text);
		botaoSobel.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		botaoSobel.setBackground(new Color(0, 102, 255));
		botaoSobel.setBounds(224, 377, 200, 82);
		add(botaoSobel);
		
		JButton botaoMediana = new JButton("Mediana");
		botaoMediana.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaFiltroMediana telaFiltroMediana = new TelaFiltroMediana();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaFiltroMediana);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoMediana.setForeground(SystemColor.text);
		botaoMediana.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		botaoMediana.setBackground(new Color(0, 102, 255));
		botaoMediana.setBounds(470, 137, 200, 82);
		add(botaoMediana);
		
		JButton botaoPassaAlta = new JButton("Passa alta");
		botaoPassaAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaFiltroPassaAlta passa = new TelaFiltroPassaAlta();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(passa);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		botaoPassaAlta.setForeground(SystemColor.text);
		botaoPassaAlta.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		botaoPassaAlta.setBackground(new Color(0, 102, 255));
		botaoPassaAlta.setBounds(728, 137, 200, 82);
		add(botaoPassaAlta);
		
		JButton botaoPrewitt = new JButton("Prewitt");
		botaoPrewitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaFiltroPrewitt telaFiltroPrewitt = new TelaFiltroPrewitt();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaFiltroPrewitt);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoPrewitt.setForeground(SystemColor.text);
		botaoPrewitt.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		botaoPrewitt.setBackground(new Color(0, 102, 255));
		botaoPrewitt.setBounds(224, 250, 200, 82);
		add(botaoPrewitt);
		
		JButton botaoRoberts = new JButton("Roberts");
		botaoRoberts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaFiltroRoberts	roberts = new TelaFiltroRoberts();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(roberts);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		botaoRoberts.setForeground(SystemColor.text);
		botaoRoberts.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		botaoRoberts.setBackground(new Color(0, 102, 255));
		botaoRoberts.setBounds(470, 250, 200, 82);
		add(botaoRoberts);
		
		JButton botaoRobertsCruzado = new JButton("Roberts cruzado");
		botaoRobertsCruzado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaFiltroRobertsCruzado robertsCruzado = new TelaFiltroRobertsCruzado();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(robertsCruzado);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoRobertsCruzado.setForeground(SystemColor.text);
		botaoRobertsCruzado.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		botaoRobertsCruzado.setBackground(new Color(0, 102, 255));
		botaoRobertsCruzado.setBounds(728, 250, 200, 82);
		add(botaoRobertsCruzado);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage((Image) imagemOriginal, 0, 0, null);
	}
}
