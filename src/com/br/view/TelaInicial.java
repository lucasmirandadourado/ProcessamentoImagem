package com.br.view;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import com.br.processarImagem.PanelDaImagem;

/**
 * @author Lucas Miranda
 * @author Daniel Marques
 */


public class TelaInicial extends JFrame {
	
	BufferedImage imagem;
	PanelDaImagem panelDaImagem1 = new PanelDaImagem();
	PanelDaImagem panelDaImagem2 = new PanelDaImagem();

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
					frame.setResizable(false);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public TelaInicial() {
		
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setSize(1024, 720);
		setLocationRelativeTo(null);

		JMenuBar barraDeMenu = new JMenuBar();
		setJMenuBar(barraDeMenu);

		JMenu menuOperadores = new JMenu("Operadores lógicos e aritméticos");
		barraDeMenu.add(menuOperadores);

		JMenuItem mntmAdio = new JMenuItem("Adi\u00E7\u00E3o");
		menuOperadores.add(mntmAdio);

		JMenuItem mntmSubtrao = new JMenuItem("Subtra\u00E7\u00E3o");
		menuOperadores.add(mntmSubtrao);

		JMenuItem mntmMultiplicao = new JMenuItem("Multiplica\u00E7\u00E3o");
		menuOperadores.add(mntmMultiplicao);

		JMenuItem mntmDiviso = new JMenuItem("Divis\u00E3o");
		menuOperadores.add(mntmDiviso);

		JMenu mnFiltros = new JMenu("Filtros");
		barraDeMenu.add(mnFiltros);

		JMenuItem mntmMedia = new JMenuItem("Media");
		mnFiltros.add(mntmMedia);

		JMenuItem mntmMediana = new JMenuItem("Mediana");
		mnFiltros.add(mntmMediana);

		JMenu mnRuidos = new JMenu("Ruidos");
		mnFiltros.add(mnRuidos);

		JMenuItem mntmRudoGaussiano = new JMenuItem("Ru\u00EDdo Gaussiano");
		mnRuidos.add(mntmRudoGaussiano);

		JMenuItem mntmSalEPimenta = new JMenuItem("Sal e Pimenta");
		mnRuidos.add(mntmSalEPimenta);

		JMenu mnOperadores = new JMenu("Operadores");
		barraDeMenu.add(mnOperadores);

		JMenuItem mntmOperadorDeRoberts = new JMenuItem("Robert\u2019s");
		mnOperadores.add(mntmOperadorDeRoberts);

		JMenuItem mntmPrewitt = new JMenuItem("Prewitt");
		mnOperadores.add(mntmPrewitt);

		JMenuItem mntmAltoReforo = new JMenuItem("Alto Refor\u00E7o");
		mnOperadores.add(mntmAltoReforo);

		JMenuItem mntmOperadorDeSobel = new JMenuItem("Operador de Sobel ");
		mnOperadores.add(mntmOperadorDeSobel);

		JMenu mnHistogramas = new JMenu("Histogramas");
		barraDeMenu.add(mnHistogramas);

		JMenuItem mntmFunoDeProbabilidade = new JMenuItem(
				"Fun\u00E7\u00E3o de probabilidade");
		mnHistogramas.add(mntmFunoDeProbabilidade);

		JMenuItem mntmFunoDeDistribuio = new JMenuItem(
				"Fun\u00E7\u00E3o de Distribui\u00E7\u00E3o Acumulada");
		mnHistogramas.add(mntmFunoDeDistribuio);
		getContentPane().setLayout(null);
		
		panelDaImagem1.setBounds(100, 100, 250, 250);
		panelDaImagem1.setVisible(true);
		getContentPane().add(panelDaImagem1);
		
		panelDaImagem2.setBounds(400, 100, 250, 250);
		panelDaImagem2.setVisible(true);
		getContentPane().add(panelDaImagem2);

		JButton btnSelecionarImagem02 = new JButton("Selecionar imagem");
		btnSelecionarImagem02.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{  
					
					//Instanciacao de fileChooser e alteracao do diretorio para buscar a imagem
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File ("src/"));
					
					//Verificacao do fileChooser
					if (fileChooser.showOpenDialog(btnSelecionarImagem02) == JFileChooser.APPROVE_OPTION) {
						
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
		btnSelecionarImagem02.setBounds(422, 361, 215, 23);
		getContentPane().add(btnSelecionarImagem02);
		
		JButton btnSelecionarImagem01 = new JButton("Selecionar imagem");
		btnSelecionarImagem01.setBounds(121, 361, 215, 23);
		btnSelecionarImagem01.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try{  
					
					//Instanciacao de fileChooser e alteracao do diretorio para buscar a imagem
					final JFileChooser fileChooser = new JFileChooser();
					fileChooser.setCurrentDirectory(new File ("src/"));
					
					//Verificacao do fileChooser
					if (fileChooser.showOpenDialog(btnSelecionarImagem01) == JFileChooser.APPROVE_OPTION) {
						
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
		getContentPane().add(btnSelecionarImagem01);		

	}
}
