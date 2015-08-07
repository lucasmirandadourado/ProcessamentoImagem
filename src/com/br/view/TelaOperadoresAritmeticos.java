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

public class TelaOperadoresAritmeticos extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaOperadoresAritmeticos() {

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
		
		JButton botaoOperadoresAritmeticos = new JButton("Aritm�ticos");
		botaoOperadoresAritmeticos.setHorizontalAlignment(SwingConstants.LEFT);
		botaoOperadoresAritmeticos.setForeground(Color.BLACK);
		botaoOperadoresAritmeticos.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoOperadoresAritmeticos.setBackground(Color.GRAY);
		botaoOperadoresAritmeticos.setBounds(20, 180, 174, 39);
		panelOpcaoLateral.add(botaoOperadoresAritmeticos);
		
		JButton botaoMenuFiltros = new JButton("Filtros");
		botaoMenuFiltros.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMenuFiltros.setForeground(Color.BLACK);
		botaoMenuFiltros.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoMenuFiltros.setBackground(SystemColor.scrollbar);
		botaoMenuFiltros.setBounds(10, 261, 184, 39);
		panelOpcaoLateral.add(botaoMenuFiltros);
		
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
		botaoMenuHistograma.setBounds(10, 301, 184, 39);
		panelOpcaoLateral.add(botaoMenuHistograma);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(TelaOperadoresAritmeticos.class.getResource("/com/br/images/logo.jpg")));
		lblImg.setBounds(0, 0, 194, 103);
		panelOpcaoLateral.add(lblImg);
		
		JButton botaoOperadores = new JButton("Operadores");
		botaoOperadores.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaOperadores telaOperadores = new TelaOperadores();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadores);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoOperadores.setHorizontalAlignment(SwingConstants.LEFT);
		botaoOperadores.setForeground(Color.BLACK);
		botaoOperadores.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoOperadores.setBackground(SystemColor.scrollbar);
		botaoOperadores.setBounds(10, 141, 184, 39);
		panelOpcaoLateral.add(botaoOperadores);
		
		JButton botaoOperadoresLogicos = new JButton("L�gicos");
		botaoOperadoresLogicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaOperadorLogico telaOperadorLogico = new TelaOperadorLogico();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadorLogico);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoOperadoresLogicos.setHorizontalAlignment(SwingConstants.LEFT);
		botaoOperadoresLogicos.setForeground(Color.BLACK);
		botaoOperadoresLogicos.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoOperadoresLogicos.setBackground(SystemColor.scrollbar);
		botaoOperadoresLogicos.setBounds(20, 221, 174, 39);
		panelOpcaoLateral.add(botaoOperadoresLogicos);
		
		// FIM PANEL LATERAL
		
		// INICIO PANEL OPCAO INTERNA
		
		JPanel panelOpcaoInterno = new JPanel();
		panelOpcaoInterno.setBackground(Color.WHITE);
		panelOpcaoInterno.setBounds(194, 102, 830, 618);
		add(panelOpcaoInterno);
		panelOpcaoInterno.setLayout(null);
		
		JButton botaoAdicao = new JButton("Adi��o");
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
		
		JButton botaoSubtracao = new JButton("Subtra��o");
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
		
		JButton botaoDivisao = new JButton("Divis�o");
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
		
		JButton botaoMultiplicacao = new JButton("Multiplica��o");
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
		
		JLabel labelOperacoesAritmeticas = new JLabel("Operadores Aritm�ticos");
		labelOperacoesAritmeticas.setForeground(Color.WHITE);
		labelOperacoesAritmeticas.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		labelOperacoesAritmeticas.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelOperacoesAritmeticas);
			
	}

}
