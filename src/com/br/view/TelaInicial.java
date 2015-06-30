/**
 * 
 */
package com.br.view;

import java.awt.EventQueue;
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

import com.br.processarImagem.ProcessamentoDaImagem;

public class TelaInicial extends JFrame {
	
	BufferedImage imagem;

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
		GridBagLayout gridBagLayout = new GridBagLayout();
		gridBagLayout.columnWidths = new int[] { 0, 0, 0, 256, 0, 256, 0 };
		gridBagLayout.rowHeights = new int[] { 0, 0, 256, 0, 0, 0 };
		gridBagLayout.columnWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				0.0, Double.MIN_VALUE };
		gridBagLayout.rowWeights = new double[] { 0.0, 0.0, 0.0, 0.0, 0.0,
				Double.MIN_VALUE };
		getContentPane().setLayout(gridBagLayout);

		JLabel lblImage01 = new JLabel("");
		GridBagConstraints gbc_lblImage01 = new GridBagConstraints();
		gbc_lblImage01.insets = new Insets(0, 0, 5, 5);
		gbc_lblImage01.gridx = 3;
		gbc_lblImage01.gridy = 2;
		getContentPane().add(lblImage01, gbc_lblImage01);

		JButton btnSelecionarImagem02 = new JButton("Selecionar imagem");
		GridBagConstraints gbc_btnSelecionarImagem02 = new GridBagConstraints();
		gbc_btnSelecionarImagem02.gridx = 5;
		gbc_btnSelecionarImagem02.gridy = 4;
		getContentPane().add(btnSelecionarImagem02, gbc_btnSelecionarImagem02);
		

		JButton btnSelecionarImagem01 = new JButton("Selecionar imagem");
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
						
						imagem = ProcessamentoDaImagem.processarImagem(file);
									
						//Converte file para image (bufferedImage)
						//imagem = ImageIO.read(file);
						
						//AQUI PRECISA-SE FAZER ALGUM METODO PAINT
						
						//adiciona a imagem dentro do label
						lblImage01.setIcon(new ImageIcon(imagem));
						repaint();
					}
					
				}catch(Exception erro){  
				        
					JOptionPane.showMessageDialog(null, "Não foi possivel carregar a imagem.");  
				        
				}    
				
			}
		});
		
		GridBagConstraints gbc_btnSelecionarImagem01 = new GridBagConstraints();
		gbc_btnSelecionarImagem01.insets = new Insets(0, 0, 0, 5);
		gbc_btnSelecionarImagem01.gridx = 3;
		gbc_btnSelecionarImagem01.gridy = 4;
		getContentPane().add(btnSelecionarImagem01, gbc_btnSelecionarImagem01);		

	}
}
