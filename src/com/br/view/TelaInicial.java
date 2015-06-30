/**
 * 
 */
package com.br.view;

import java.awt.EventQueue;
import java.awt.Graphics;
import java.awt.GridBagConstraints;
import java.awt.GridBagLayout;
import java.awt.Image;
import java.awt.Insets;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFileChooser;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JTextField;

import com.br.processarImagem.PanelDaImagem;
import com.br.processarImagem.ProcessamentoDaImagem;

public class TelaInicial extends JFrame {
	
	BufferedImage imagem;
	PanelDaImagem panelDaImagem = new PanelDaImagem();

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

		JButton btnSelecionarImagem02 = new JButton("Selecionar imagem");
		btnSelecionarImagem02.setBounds(443, 346, 121, 23);
		getContentPane().add(btnSelecionarImagem02);
		
		panelDaImagem.setBounds(100, 100, 200, 200);
		panelDaImagem.setVisible(true);
		getContentPane().add(panelDaImagem);
		
		JButton btnSelecionarImagem01 = new JButton("Selecionar imagem");
		btnSelecionarImagem01.setBounds(155, 346, 121, 23);
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
						
						panelDaImagem.processarImagem(file);
									
						//Converte file para image (bufferedImage)
						//imagem = ImageIO.read(file);
						
						//AQUI PRECISA-SE FAZER ALGUM METODO PAINT
						//paint(getGraphics().drawImage((Image)imagem, 0, 0, null));
						
						//adiciona a imagem dentro do label
						//lblImage01.setIcon(new ImageIcon(imagem));
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
