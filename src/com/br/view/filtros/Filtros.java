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

		JButton botaoPaginaInicial = new JButton("P�gina Inicial");
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
		JLabel lbl_filtros = new JLabel("Filtros");
		lbl_filtros.setForeground(Color.WHITE);
		lbl_filtros.setFont(new Font("Segoe UI Semilight",
				Font.PLAIN, 24));
		lbl_filtros.setBounds(10, 24, 730, 55);
		panelSuperior.add(lbl_filtros);
		
		JButton botaoMedia = new JButton("M�dia");
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
		
		JButton btnSobel = new JButton("Sobel");
		btnSobel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Sobel sobel = new Sobel();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(sobel);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		btnSobel.setForeground(SystemColor.text);
		btnSobel.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		btnSobel.setBackground(new Color(0, 102, 255));
		btnSobel.setBounds(224, 377, 200, 82);
		add(btnSobel);
		
		JButton btnMedina = new JButton("Mediana");
		btnMedina.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaFiltroMediana telaFiltroMediana = new TelaFiltroMediana();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaFiltroMediana);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		btnMedina.setForeground(SystemColor.text);
		btnMedina.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		btnMedina.setBackground(new Color(0, 102, 255));
		btnMedina.setBounds(470, 137, 200, 82);
		add(btnMedina);
		
		JButton btnPassaAlta = new JButton("Passa alta");
		btnPassaAlta.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				PassaAlta passa = new PassaAlta();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(passa);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		btnPassaAlta.setForeground(SystemColor.text);
		btnPassaAlta.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		btnPassaAlta.setBackground(new Color(0, 102, 255));
		btnPassaAlta.setBounds(728, 137, 200, 82);
		add(btnPassaAlta);
		
		JButton btnPrewitt = new JButton("Prewitt");
		btnPrewitt.setForeground(SystemColor.text);
		btnPrewitt.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		btnPrewitt.setBackground(new Color(0, 102, 255));
		btnPrewitt.setBounds(224, 250, 200, 82);
		add(btnPrewitt);
		
		JButton btnRoberts = new JButton("Roberts");
		btnRoberts.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Roberts	roberts = new Roberts();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(roberts);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		btnRoberts.setForeground(SystemColor.text);
		btnRoberts.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		btnRoberts.setBackground(new Color(0, 102, 255));
		btnRoberts.setBounds(470, 250, 200, 82);
		add(btnRoberts);
		
		JButton btnRobertsCruzado = new JButton("Roberts cruzado");
		btnRobertsCruzado.setForeground(SystemColor.text);
		btnRobertsCruzado.setFont(new Font("Segoe UI Light", Font.BOLD, 18));
		btnRobertsCruzado.setBackground(new Color(0, 102, 255));
		btnRobertsCruzado.setBounds(728, 250, 200, 82);
		add(btnRobertsCruzado);

	}

	@Override
	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		super.paintComponent(g);
		g.drawImage((Image) imagemOriginal, 0, 0, null);
	}
}
