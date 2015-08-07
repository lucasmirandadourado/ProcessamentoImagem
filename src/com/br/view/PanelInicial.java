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
		
		JButton botaoPaginaInicial = new JButton("Página Inicial");
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
		
		JButton botaoOperacoesLogicas = new JButton("Operadores Lógicos e Aritméticos");
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
		botaoOperacoesLogicas.setBounds(10, 11, 393, 213);
		panelOpcaoInterno.add(botaoOperacoesLogicas);
		
		JButton botaoFiltros = new JButton("Filtros");
		botaoFiltros.setForeground(Color.WHITE);
		botaoFiltros.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoFiltros.setBackground(new Color(0, 102, 255));
		botaoFiltros.setBounds(413, 11, 393, 213);
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
		botaoHistogramas.setBounds(10, 235, 393, 213);
		panelOpcaoInterno.add(botaoHistogramas);
		
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
