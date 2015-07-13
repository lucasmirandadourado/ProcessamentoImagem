package com.br.view;

import java.awt.Color;
import java.awt.Font;
import java.awt.SystemColor;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;

import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

import com.br.algoritmos.Panel_OperadorAritmetico_Adicao;
import com.br.processarImagem.PanelDaImagem;

import javax.swing.JTextPane;

public class TelaOperadorAritmeticoAdicao extends JPanel {

	//BufferedImage imagem;
	PanelDaImagem panelDaImagem1 = new PanelDaImagem();
	PanelDaImagem panelDaImagem2 = new PanelDaImagem();
	Panel_OperadorAritmetico_Adicao panelDaImagem3 = new Panel_OperadorAritmetico_Adicao();
	
	/**
	 * Create the panel.
	 */
	public TelaOperadorAritmeticoAdicao() {
		
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
		panelOpcaoInterno.setLayout(null);
		add(panelOpcaoInterno);
		
		panelDaImagem1.setBounds(266, 11, 250, 250);
		panelDaImagem1.setVisible(true);
		panelOpcaoInterno.add(panelDaImagem1);
		
		panelDaImagem2.setBounds(551, 11, 250, 250);
		panelDaImagem2.setVisible(true);
		panelOpcaoInterno.add(panelDaImagem2);
		
		panelDaImagem3.setBounds(551, 311, 250, 250);
		panelDaImagem3.setVisible(true);
		panelOpcaoInterno.add(panelDaImagem3);
		
		JButton botaoSelecionarImagem1 = new JButton("Selecionar Imagem");
		botaoSelecionarImagem1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				try{  
					
					//Instanciacao de fileChooser e alteracao do diretorio para buscar a imagem
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File ("src/"));
					
					//Verificacao do fileChooser
					if (fileChooser.showOpenDialog(botaoSelecionarImagem1) == JFileChooser.APPROVE_OPTION) {
						
						//Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();
						
						panelDaImagem1.colocaImagemNoPainel(file.getPath());			
						repaint();
					}
					
				}catch(Exception erro){  
				        
					JOptionPane.showMessageDialog(null, "Não foi possivel carregar a imagem.");  
				        
				}    
				
			}
		});
		botaoSelecionarImagem1.setForeground(Color.WHITE);
		botaoSelecionarImagem1.setBackground(new Color(0, 102, 255));
		botaoSelecionarImagem1.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoSelecionarImagem1.setBounds(266, 261, 250, 29);
		panelOpcaoInterno.add(botaoSelecionarImagem1);
		
		JButton botaoSelecionarImagem2 = new JButton("Selecionar Imagem");
		botaoSelecionarImagem2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try{  
					
					//Instanciacao de fileChooser e alteracao do diretorio para buscar a imagem
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File ("src/"));
					
					//Verificacao do fileChooser
					if (fileChooser.showOpenDialog(botaoSelecionarImagem2) == JFileChooser.APPROVE_OPTION) {
						
						//Cria um file onde eh armazenada a imagem
						File file = fileChooser.getSelectedFile();
						
						panelDaImagem2.colocaImagemNoPainel(file.getPath());
						repaint();	
					}
					
				}catch(Exception erro){  
					JOptionPane.showMessageDialog(null, "Não foi possivel carregar a imagem.");         
				}    
			}
		});
		botaoSelecionarImagem2.setForeground(Color.WHITE);
		botaoSelecionarImagem2.setBackground(new Color(0, 102, 255));
		botaoSelecionarImagem2.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoSelecionarImagem2.setBounds(551, 261, 250, 29);
		panelOpcaoInterno.add(botaoSelecionarImagem2);
		
		JTextPane textPaneSelecionarImagem = new JTextPane();
		textPaneSelecionarImagem.setEditable(false);
		textPaneSelecionarImagem.setForeground(Color.WHITE);
		textPaneSelecionarImagem.setBackground(new Color(153, 153, 153));
		textPaneSelecionarImagem.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textPaneSelecionarImagem.setText("Selecione as duas imagens a serem processadas com a função aritmética de adição");
		textPaneSelecionarImagem.setBounds(22, 11, 220, 90);
		panelOpcaoInterno.add(textPaneSelecionarImagem);
		
		JTextPane textPane = new JTextPane();
		textPane.setText("Imagem processada com o algoritmo de adição");
		textPane.setForeground(Color.WHITE);
		textPane.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		textPane.setEditable(false);
		textPane.setBackground(new Color(153, 153, 153));
		textPane.setBounds(22, 311, 220, 90);
		panelOpcaoInterno.add(textPane);
		
		JButton botaoAdicao = new JButton("Processar Adição");
		botaoAdicao.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent eventoDeMouse) {
				
				panelDaImagem3.colocaImagemNoPainel(panelDaImagem1.altura, panelDaImagem1.largura, panelDaImagem1.matrizImagem, panelDaImagem2.altura, panelDaImagem2.largura, panelDaImagem2.matrizImagem);
				
			}
		});
		botaoAdicao.setForeground(Color.WHITE);
		botaoAdicao.setBackground(new Color(0, 102, 255));
		botaoAdicao.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 18));
		botaoAdicao.setBounds(266, 311, 250, 250);
		panelOpcaoInterno.add(botaoAdicao);
		
		
		// FIM PANEL OPCAO INTERNA
		
		//INICIO PANEL SUPERIOR
		
		JPanel panelSuperior = new JPanel();
		panelSuperior.setBackground(SystemColor.windowBorder);
		panelSuperior.setBounds(194, 0, 830, 102);
		add(panelSuperior);
		panelSuperior.setLayout(null);
		
		JLabel labelOperacoesLogicasAritmeticas = new JLabel("Operadores Lógicos e Aritméticos   >>   Adição");
		labelOperacoesLogicasAritmeticas.setForeground(Color.WHITE);
		labelOperacoesLogicasAritmeticas.setFont(new Font("Segoe UI Semilight", Font.PLAIN, 24));
		labelOperacoesLogicasAritmeticas.setBounds(10, 24, 730, 55);
		panelSuperior.add(labelOperacoesLogicasAritmeticas);

	}
}
