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

public class TelaOperadores extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaOperadores() {

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
		
		JButton botaoOperadores = new JButton("Operadores");
		botaoOperadores.setHorizontalAlignment(SwingConstants.LEFT);
		botaoOperadores.setForeground(Color.BLACK);
		botaoOperadores.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoOperadores.setBackground(Color.GRAY);
		botaoOperadores.setBounds(10, 141, 184, 39);
		panelOpcaoLateral.add(botaoOperadores);
		
		JButton botaoMenuFiltros = new JButton("Filtros");
		botaoMenuFiltros.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMenuFiltros.setForeground(Color.BLACK);
		botaoMenuFiltros.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoMenuFiltros.setBackground(SystemColor.scrollbar);
		botaoMenuFiltros.setBounds(10, 180, 184, 39);
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
		botaoMenuHistograma.setBounds(10, 218, 184, 39);
		panelOpcaoLateral.add(botaoMenuHistograma);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(TelaOperadoresAritmeticos.class.getResource("/com/br/images/logo.jpg")));
		lblImg.setBounds(0, 0, 194, 103);
		panelOpcaoLateral.add(lblImg);
		
		// FIM PANEL LATERAL
		
		// INICIO PANEL OPCAO INTERNA
		
		JPanel panelOpcaoInterno = new JPanel();
		panelOpcaoInterno.setBackground(Color.WHITE);
		panelOpcaoInterno.setBounds(194, 102, 830, 618);
		add(panelOpcaoInterno);
		panelOpcaoInterno.setLayout(null);
		
		JButton botaoOperadoresAritmeticos = new JButton("Operadores Aritm�ticos");
		botaoOperadoresAritmeticos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				TelaOperadoresAritmeticos telaOperadoresAritmeticos = new TelaOperadoresAritmeticos();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadoresAritmeticos);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoOperadoresAritmeticos.setForeground(Color.WHITE);
		botaoOperadoresAritmeticos.setBackground(new Color(0, 102, 255));
		botaoOperadoresAritmeticos.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoOperadoresAritmeticos.setBounds(10, 11, 393, 213);
		panelOpcaoInterno.add(botaoOperadoresAritmeticos);
		
		JButton botaoOperadoresLogicos = new JButton("Operadores L�gicos");
		botaoOperadoresLogicos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaOperadorLogico telaOperadorLogico = new TelaOperadorLogico();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaOperadorLogico);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoOperadoresLogicos.setForeground(Color.WHITE);
		botaoOperadoresLogicos.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoOperadoresLogicos.setBackground(new Color(0, 102, 255));
		botaoOperadoresLogicos.setBounds(413, 11, 393, 213);
		panelOpcaoInterno.add(botaoOperadoresLogicos);
		
		// FIM PANEL OPCAO INTERNA
		
		//INICIO PANEL SUPERIOR
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel labelOperadores = new JLabel("Operadores");
		labelOperadores.setForeground(Color.WHITE);
		labelOperadores.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		labelOperadores.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelOperadores);
			
	}

}
