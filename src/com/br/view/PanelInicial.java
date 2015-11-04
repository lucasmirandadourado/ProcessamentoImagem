package com.br.view;

import javax.swing.JPanel;

import java.awt.Color;
import java.awt.SystemColor;

import javax.swing.JLabel;

import java.awt.Font;

import javax.swing.JButton;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.SwingConstants;

import com.br.view.equalizarImagem.TelaEqualizarImagem;
import com.br.view.filtros.TelaFiltros;
import com.br.view.gatoArnold.TelaGatoDeArnold;
import com.br.view.histograma.TelaHistograma;
import com.br.view.operadores.TelaOperadores;
import com.br.view.transformacoes.TelaTransformacoes;

public class PanelInicial extends JPanel {

	/**
	 * Create the panel.
	 */
	public PanelInicial() {
		setSize(1024, 720);
		setLayout(null);
		setVisible(true);
		
		// INICIO PANEL OPCAO LATERAL
		
		JPanel panelOpcaoLateral = new JPanel();
		panelOpcaoLateral.setBackground(SystemColor.scrollbar);
		panelOpcaoLateral.setBounds(0, 0, 194, 720);
		add(panelOpcaoLateral);
		panelOpcaoLateral.setLayout(null);
		
		JButton botaoPaginaInicial = new JButton("P�gina Inicial");
		botaoPaginaInicial.setHorizontalAlignment(SwingConstants.LEFT);
		botaoPaginaInicial.setIcon(new ImageIcon(PanelInicial.class.getResource("/com/icon/home.png")));
		botaoPaginaInicial.setBounds(0, 102, 194, 39);
		botaoPaginaInicial.setForeground(Color.BLACK);
		botaoPaginaInicial.setBackground(Color.GRAY);
		botaoPaginaInicial.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		panelOpcaoLateral.add(botaoPaginaInicial);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(PanelInicial.class.getResource("/com/br/images/logo.jpg")));
		lblImg.setBounds(0, 0, 194, 104);
		panelOpcaoLateral.add(lblImg);
		
		// FIM PANEL LATERAL
		
		// INICIO PANEL OPCAO INTERNA
		
		JPanel panelOpcaoInterno = new JPanel();
		panelOpcaoInterno.setBackground(Color.WHITE);
		panelOpcaoInterno.setBounds(194, 102, 830, 618);
		add(panelOpcaoInterno);
		panelOpcaoInterno.setLayout(null);
		
		JButton botaoOperacoesLogicas = new JButton("Operadores L�gicos e Aritm�ticos");
		botaoOperacoesLogicas.setToolTipText("");
		botaoOperacoesLogicas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaOperadores telaOperadores = new TelaOperadores();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadores);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoOperacoesLogicas.setForeground(Color.WHITE);
		botaoOperacoesLogicas.setBackground(new Color(0, 102, 255));
		botaoOperacoesLogicas.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoOperacoesLogicas.setBounds(15, 11, 385, 180);
		panelOpcaoInterno.add(botaoOperacoesLogicas);
		
		JButton botaoFiltros = new JButton("Filtros");
		botaoFiltros.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaFiltros telaFiltros = new TelaFiltros();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaFiltros);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoFiltros.setForeground(Color.WHITE);
		botaoFiltros.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoFiltros.setBackground(new Color(0, 102, 255));
		botaoFiltros.setBounds(415, 11, 385, 180);
		panelOpcaoInterno.add(botaoFiltros);
		
		JButton botaoHistogramas = new JButton("Histogramas");
		botaoHistogramas.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				TelaHistograma telaHistograma = new TelaHistograma();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaHistograma);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoHistogramas.setForeground(Color.WHITE);
		botaoHistogramas.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoHistogramas.setBackground(new Color(0, 102, 255));
		botaoHistogramas.setBounds(15, 202, 385, 180);
		panelOpcaoInterno.add(botaoHistogramas);
		
		JButton botaoGatoDeArnold = new JButton("Gato de Arnold");
		botaoGatoDeArnold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaGatoDeArnold telaGatoDeArnold = new TelaGatoDeArnold();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaGatoDeArnold);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		botaoGatoDeArnold.setForeground(Color.WHITE);
		botaoGatoDeArnold.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoGatoDeArnold.setBackground(new Color(0, 102, 255));
		botaoGatoDeArnold.setBounds(415, 202, 385, 180);
		panelOpcaoInterno.add(botaoGatoDeArnold);
		
		JButton botaoTransformacoes = new JButton("Transforma��es");
		botaoTransformacoes.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaTransformacoes telaTransformacoes = new TelaTransformacoes();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaTransformacoes);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();

			}
		});
		botaoTransformacoes.setForeground(Color.WHITE);
		botaoTransformacoes.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoTransformacoes.setBackground(new Color(0, 102, 255));
		botaoTransformacoes.setBounds(15, 393, 385, 180);
		panelOpcaoInterno.add(botaoTransformacoes);
		
		JButton botaoEqualizarImagem = new JButton("Equalizar Imagem");
		botaoEqualizarImagem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaEqualizarImagem telaEqualizarImagem = new TelaEqualizarImagem();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaEqualizarImagem);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoEqualizarImagem.setForeground(Color.WHITE);
		botaoEqualizarImagem.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoEqualizarImagem.setBackground(new Color(0, 102, 255));
		botaoEqualizarImagem.setBounds(415, 393, 385, 180);
		panelOpcaoInterno.add(botaoEqualizarImagem);
		
		// FIM PANEL OPCAO INTERNA
		
		//INICIO PANEL SUPERIOR
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel labelMenuPrincipal = new JLabel("Projeto de Processamento de Imagens");
		labelMenuPrincipal.setForeground(Color.WHITE);
		labelMenuPrincipal.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		labelMenuPrincipal.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelMenuPrincipal);
		
		// FIM PANEL SUPERIOR

	}
}
