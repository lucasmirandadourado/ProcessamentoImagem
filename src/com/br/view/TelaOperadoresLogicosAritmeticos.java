package com.br.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaOperadoresLogicosAritmeticos extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaOperadoresLogicosAritmeticos() {

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
		botaoPaginaInicial.setIcon(new ImageIcon(PanelInicial.class.getResource("/com/icon/home.png")));
		botaoPaginaInicial.setBounds(0, 102, 194, 39);
		botaoPaginaInicial.setForeground(Color.BLACK);
		botaoPaginaInicial.setBackground(SystemColor.scrollbar);
		botaoPaginaInicial.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		panelOpcaoLateral.add(botaoPaginaInicial);
		
		JButton botaoOperadoresAritmeticos = new JButton("Operadores Aritméticos");
		botaoOperadoresAritmeticos.setHorizontalAlignment(SwingConstants.LEFT);
		botaoOperadoresAritmeticos.setForeground(Color.BLACK);
		botaoOperadoresAritmeticos.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoOperadoresAritmeticos.setBackground(Color.GRAY);
		botaoOperadoresAritmeticos.setBounds(10, 141, 184, 39);
		panelOpcaoLateral.add(botaoOperadoresAritmeticos);
		
		JButton botaoMenuFiltros = new JButton("Filtros");
		botaoMenuFiltros.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMenuFiltros.setForeground(Color.BLACK);
		botaoMenuFiltros.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoMenuFiltros.setBackground(SystemColor.scrollbar);
		botaoMenuFiltros.setBounds(10, 180, 184, 39);
		panelOpcaoLateral.add(botaoMenuFiltros);
		
		JButton botaoMenuOperadores = new JButton("Operadores");
		botaoMenuOperadores.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMenuOperadores.setForeground(Color.BLACK);
		botaoMenuOperadores.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoMenuOperadores.setBackground(SystemColor.scrollbar);
		botaoMenuOperadores.setBounds(10, 219, 184, 39);
		panelOpcaoLateral.add(botaoMenuOperadores);
		
		JButton botaoMenuHistograma = new JButton("Histogramas");
		botaoMenuHistograma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				TelaHistograma telaHistograma = new TelaHistograma();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaHistograma);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoMenuHistograma.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMenuHistograma.setForeground(Color.BLACK);
		botaoMenuHistograma.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoMenuHistograma.setBackground(SystemColor.scrollbar);
		botaoMenuHistograma.setBounds(10, 258, 184, 39);
		panelOpcaoLateral.add(botaoMenuHistograma);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(TelaOperadoresLogicosAritmeticos.class.getResource("/com/br/images/logo.jpg")));
		lblImg.setBounds(0, 0, 194, 103);
		panelOpcaoLateral.add(lblImg);
		
		// FIM PANEL LATERAL
		
		// INICIO PANEL OPCAO INTERNA
		
		JPanel panelOpcaoInterno = new JPanel();
		panelOpcaoInterno.setBackground(Color.WHITE);
		panelOpcaoInterno.setBounds(194, 102, 830, 618);
		add(panelOpcaoInterno);
		panelOpcaoInterno.setLayout(null);
		
		JButton botaoAdicao = new JButton("Adição");
		botaoAdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaOperadorAritmeticoAdicao telaOperadorAritmeticoAdicao = new TelaOperadorAritmeticoAdicao();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadorAritmeticoAdicao);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoAdicao.setForeground(Color.WHITE);
		botaoAdicao.setBackground(new Color(0, 102, 255));
		botaoAdicao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoAdicao.setBounds(10, 11, 393, 213);
		panelOpcaoInterno.add(botaoAdicao);
		
		JButton botaoSubtracao = new JButton("Subtração");
		botaoSubtracao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaOperadorAritmeticoSubtracao telaOperadorAritmeticoSubtracao = new TelaOperadorAritmeticoSubtracao();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadorAritmeticoSubtracao);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoSubtracao.setForeground(Color.WHITE);
		botaoSubtracao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoSubtracao.setBackground(new Color(0, 102, 255));
		botaoSubtracao.setBounds(413, 11, 393, 213);
		panelOpcaoInterno.add(botaoSubtracao);
		
		JButton botaoDivisao = new JButton("Divisão");
		botaoDivisao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				TelaOperadorAritmeticoDivisao telaOperadorAritmeticoDivisao = new TelaOperadorAritmeticoDivisao();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadorAritmeticoDivisao);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		botaoDivisao.setForeground(Color.WHITE);
		botaoDivisao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoDivisao.setBackground(new Color(0, 102, 255));
		botaoDivisao.setBounds(10, 235, 393, 213);
		panelOpcaoInterno.add(botaoDivisao);
		
		JButton botaoMultiplicacao = new JButton("Multiplicação");
		botaoMultiplicacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaOperadorAritmeticoMultiplicacao telaOperadorAritmeticoMultiplicacao = new TelaOperadorAritmeticoMultiplicacao();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadorAritmeticoMultiplicacao);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoMultiplicacao.setForeground(Color.WHITE);
		botaoMultiplicacao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoMultiplicacao.setBackground(new Color(0, 102, 255));
		botaoMultiplicacao.setBounds(413, 235, 393, 213);
		panelOpcaoInterno.add(botaoMultiplicacao);
		
		// FIM PANEL OPCAO INTERNA
		
		//INICIO PANEL SUPERIOR
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel labelOperacoesLogicasAritmeticas = new JLabel("Operadores Lógicos e Aritméticos");
		labelOperacoesLogicasAritmeticas.setForeground(Color.WHITE);
		labelOperacoesLogicasAritmeticas.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		labelOperacoesLogicasAritmeticas.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelOperacoesLogicasAritmeticas);
			
	}

}
