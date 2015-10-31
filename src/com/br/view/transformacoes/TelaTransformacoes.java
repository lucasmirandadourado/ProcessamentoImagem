package com.br.view.transformacoes;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;

import com.br.view.PanelInicial;
import com.br.view.TelaInicial;
import com.br.view.histograma.TelaHistograma;
import com.br.view.operadores.TelaOperadores;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class TelaTransformacoes extends JPanel {

	/**
	 * Create the panel.
	 */
	public TelaTransformacoes() {

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
		
		
		
		JButton botaoMenuFiltros = new JButton("Filtros");
		botaoMenuFiltros.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMenuFiltros.setForeground(Color.BLACK);
		botaoMenuFiltros.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoMenuFiltros.setBackground(SystemColor.scrollbar);
		botaoMenuFiltros.setBounds(10, 181, 184, 39);
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
		botaoMenuHistograma.setBounds(10, 221, 184, 39);
		panelOpcaoLateral.add(botaoMenuHistograma);
		
		JLabel lblImg = new JLabel("");
		lblImg.setIcon(new ImageIcon(TelaTransformacoes.class.getResource("/com/br/images/logo.jpg")));
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
		
		// FIM PANEL LATERAL
		
		// INICIO PANEL OPCAO INTERNA
		
		JPanel panelOpcaoInterno = new JPanel();
		panelOpcaoInterno.setBackground(Color.WHITE);
		panelOpcaoInterno.setBounds(194, 102, 830, 618);
		add(panelOpcaoInterno);
		panelOpcaoInterno.setLayout(null);
		
		JButton botaoTransformacaoNegativo = new JButton("Negativo");
		botaoTransformacaoNegativo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				TelaTransformacaoNegativo telaTransformacaoNegativo= new TelaTransformacaoNegativo();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaTransformacaoNegativo);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoTransformacaoNegativo.setForeground(Color.WHITE);
		botaoTransformacaoNegativo.setBackground(new Color(0, 102, 255));
		botaoTransformacaoNegativo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoTransformacaoNegativo.setBounds(10, 11, 393, 213);
		panelOpcaoInterno.add(botaoTransformacaoNegativo);
		
		JButton botaoTransformacaoGamma = new JButton("Gamma");
		botaoTransformacaoGamma.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				
				
			}
		});
		botaoTransformacaoGamma.setForeground(Color.WHITE);
		botaoTransformacaoGamma.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoTransformacaoGamma.setBackground(new Color(0, 102, 255));
		botaoTransformacaoGamma.setBounds(413, 11, 393, 213);
		panelOpcaoInterno.add(botaoTransformacaoGamma);
		
		JButton botaoTransformacaoLogaritmo = new JButton("Logaritmo");
		botaoTransformacaoLogaritmo.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				
				
			}
		});
		botaoTransformacaoLogaritmo.setForeground(Color.WHITE);
		botaoTransformacaoLogaritmo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoTransformacaoLogaritmo.setBackground(new Color(0, 102, 255));
		botaoTransformacaoLogaritmo.setBounds(10, 235, 393, 213);
		panelOpcaoInterno.add(botaoTransformacaoLogaritmo);
		
		// FIM PANEL OPCAO INTERNA
		
		//INICIO PANEL SUPERIOR
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel labelOperacoesAritmeticas = new JLabel("Transformações");
		labelOperacoesAritmeticas.setForeground(Color.WHITE);
		labelOperacoesAritmeticas.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		labelOperacoesAritmeticas.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelOperacoesAritmeticas);
			
	}

}
