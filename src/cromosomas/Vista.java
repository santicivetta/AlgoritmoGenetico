package cromosomas;

import java.awt.EventQueue;

import javax.swing.*;
import javax.swing.border.EmptyBorder;
import java.awt.*;
import java.awt.event.*;

public class Vista extends JFrame {
	
	private static final long serialVersionUID = 1L;
	private JPanel contentPane;

	public Vista() {
		getContentPane().setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		this.setTitle("Algoritmo Genetico");
		this.setIconImage(Toolkit.getDefaultToolkit().getImage("src\\cromosomas\\img\\ico.png"));
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setBounds(100, 100, 400, 450);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		contentPane.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		contentPane.add(new JLabel("Cantidad de Individuos:"));
		TextField cantidadIndividuos = new TextField(5);
		contentPane.add(cantidadIndividuos);

		contentPane.add(new JLabel("Genes por Individuo:"));
		TextField genesPorIndividuo = new TextField(5);
		contentPane.add(genesPorIndividuo);
		
		contentPane.add(new JLabel("Cantidad máxima de bits a mutar:"));
		TextField maximoDeBitsAMutar = new TextField(5);
		contentPane.add(maximoDeBitsAMutar);
		
		contentPane.add(new JLabel("Clave:"));
		
		JRadioButton rdbtnAuto = new JRadioButton("Auto");
		contentPane.add(rdbtnAuto);
		JRadioButton rdbtnManual = new JRadioButton("Manual");
		contentPane.add(rdbtnManual);
		TextField claveManual = new TextField(20);
		contentPane.add(claveManual);
		
		contentPane.add(new JLabel("Generaciones a correr:"));
		TextField generacionesACorrer = new TextField(10);
		contentPane.add(generacionesACorrer);
		
		JButton btnReset = new JButton("Reset");
		contentPane.add(btnReset);
		
		JButton btnComenzar = new JButton("COMENZAR");
		contentPane.add(btnComenzar);
		

		
		this.setVisible(true);
		
	}

}
