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
import com.br.view.equalizarImagem.TelaEqualizarImagem;
import com.br.view.filtros.TelaFiltros;
import com.br.view.gatoDeArnold.TelaGatoDeArnold;
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
		
		JButton botaoMenuFiltros = new JButton("Filtros");
		botaoMenuFiltros.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaFiltros telaFiltro = new TelaFiltros();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaFiltro);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
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
		botaoMenuHistograma.setBounds(10, 217, 184, 39);
		panelOpcaoLateral.add(botaoMenuHistograma);
		
		
		JButton btnGatoDeArnold = new JButton("Gato de Arnold");
		btnGatoDeArnold.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				TelaGatoDeArnold gato = new TelaGatoDeArnold();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(gato);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		btnGatoDeArnold.setHorizontalAlignment(SwingConstants.LEFT);
		btnGatoDeArnold.setForeground(Color.BLACK);
		btnGatoDeArnold.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		btnGatoDeArnold.setBackground(SystemColor.scrollbar);
		btnGatoDeArnold.setBounds(10, 253, 184, 39);
		panelOpcaoLateral.add(btnGatoDeArnold);
		
		JButton botaoMenuTransformacao = new JButton("Transforma\u00E7\u00E3o");
		botaoMenuTransformacao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				com.br.view.transformacoes.TelaTransformacoes telaTransformacao = new com.br.view.transformacoes.TelaTransformacoes();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaTransformacao);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		botaoMenuTransformacao.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMenuTransformacao.setForeground(Color.BLACK);
		botaoMenuTransformacao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoMenuTransformacao.setBackground(SystemColor.scrollbar);
		botaoMenuTransformacao.setBounds(10, 290, 184, 39);
		panelOpcaoLateral.add(botaoMenuTransformacao);
		
		JButton botaoMenuEqualizacao = new JButton("Equaliza\u00E7\u00E3o");
		botaoMenuEqualizacao.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				TelaEqualizarImagem TelaEqualizacao = new TelaEqualizarImagem();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(TelaEqualizacao);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
			}
		});
		botaoMenuEqualizacao.setHorizontalAlignment(SwingConstants.LEFT);
		botaoMenuEqualizacao.setForeground(Color.BLACK);
		botaoMenuEqualizacao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 14));
		botaoMenuEqualizacao.setBackground(SystemColor.scrollbar);
		botaoMenuEqualizacao.setBounds(10, 327, 184, 39);
		panelOpcaoLateral.add(botaoMenuEqualizacao);

		
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
				
				TelaTransformacaoGamma telaTransformacaoGamma= new TelaTransformacaoGamma();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaTransformacaoGamma);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
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
				
				TelaTransformacaoLogaritmo telaTransformacaoLogaritmo = new TelaTransformacaoLogaritmo();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaTransformacaoLogaritmo);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		botaoTransformacaoLogaritmo.setForeground(Color.WHITE);
		botaoTransformacaoLogaritmo.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoTransformacaoLogaritmo.setBackground(new Color(0, 102, 255));
		botaoTransformacaoLogaritmo.setBounds(10, 235, 393, 213);
		panelOpcaoInterno.add(botaoTransformacaoLogaritmo);
		
		JButton btnRotacao = new JButton("Rota\u00E7\u00E3o");
		btnRotacao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				TelaTransformacaoRotacao telaTransformacaoRotacao = new TelaTransformacaoRotacao();
				TelaInicial.contentPane.removeAll();
				TelaInicial.contentPane.add(telaTransformacaoRotacao);
				TelaInicial.contentPane.validate();
				TelaInicial.contentPane.repaint();
				
			}
		});
		btnRotacao.setForeground(Color.WHITE);
		btnRotacao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnRotacao.setBackground(new Color(0, 102, 255));
		btnRotacao.setBounds(413, 235, 393, 213);
		panelOpcaoInterno.add(btnRotacao);
		
		JButton btnEscala = new JButton("Escala");
		btnEscala.setForeground(Color.WHITE);
		btnEscala.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnEscala.setBackground(new Color(0, 102, 255));
		btnEscala.setBounds(10, 458, 393, 213);
		panelOpcaoInterno.add(btnEscala);
		
		JButton btnCisalhamento = new JButton("Cisalhamento");
		btnCisalhamento.setForeground(Color.WHITE);
		btnCisalhamento.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		btnCisalhamento.setBackground(new Color(0, 102, 255));
		btnCisalhamento.setBounds(413, 458, 393, 213);
		panelOpcaoInterno.add(btnCisalhamento);
		
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
