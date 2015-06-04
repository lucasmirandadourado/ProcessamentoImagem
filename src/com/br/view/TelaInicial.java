/**
 * 
 */
package com.br.view;

import java.awt.EventQueue; 

import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JMenuItem;

public class TelaInicial extends JFrame {
	
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
		
		JMenuItem mntmFunoDeProbabilidade = new JMenuItem("Fun\u00E7\u00E3o de probabilidade");
		mnHistogramas.add(mntmFunoDeProbabilidade);
		
		JMenuItem mntmFunoDeDistribuio = new JMenuItem("Fun\u00E7\u00E3o de Distribui\u00E7\u00E3o Acumulada");
		mnHistogramas.add(mntmFunoDeDistribuio);
		
	}
}
