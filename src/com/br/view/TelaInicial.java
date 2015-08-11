package com.br.view;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import java.awt.Dimension;


public class TelaInicial extends JFrame {

	public static JPanel contentPane;
	PanelInicial panelInicial2 = new PanelInicial();

	/** 
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					TelaInicial frame = new TelaInicial();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public TelaInicial() {
		setMinimumSize(new Dimension(1024, 720));
		setTitle("Projeto de processamento de imagem");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(0, 0, 1024, 720);
		contentPane = new JPanel();
		setContentPane(contentPane);
		contentPane.setLayout(null);
		panelInicial2.setBounds(0, 0, 1024, 682);
		contentPane.add(panelInicial2);
		setVisible(true);
	}

}
