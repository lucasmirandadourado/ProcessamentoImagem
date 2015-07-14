package com.br.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
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
		
		// INICIO PANEL OPCAO INTERNA
		
		JPanel panelOpcaoLateral = new JPanel();
		panelOpcaoLateral.setBackground(SystemColor.scrollbar);
		panelOpcaoLateral.setBounds(0, 0, 194, 720);
		add(panelOpcaoLateral);
		panelOpcaoLateral.setLayout(null);
		
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
		
		JLabel labelOperacoesLogicasAritmeticas = new JLabel("Operadores L�gicos e Aritm�ticos");
		labelOperacoesLogicasAritmeticas.setForeground(Color.WHITE);
		labelOperacoesLogicasAritmeticas.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		labelOperacoesLogicasAritmeticas.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelOperacoesLogicasAritmeticas);
			
	}

}
