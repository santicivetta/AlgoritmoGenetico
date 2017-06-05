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
		this.setBounds(100, 100, 450, 350);
		this.contentPane = new JPanel();
		this.contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		this.setContentPane(contentPane);
		GridBagLayout gbl_contentPane = new GridBagLayout();
		gbl_contentPane.columnWidths = new int[]{66, 21, 12, 0, 39, 19, 13, 14, 31, 3, 54, 0};
		gbl_contentPane.rowHeights = new int[]{22, 0, 0, 23, 23, 23, 0, 0, 30, 0, 35, 0, 0, 0, 0, 0};
		gbl_contentPane.columnWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		gbl_contentPane.rowWeights = new double[]{0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, 0.0, Double.MIN_VALUE};
		contentPane.setLayout(gbl_contentPane);
		
				GridBagConstraints gbc_1 = new GridBagConstraints();
				gbc_1.anchor = GridBagConstraints.WEST;
				gbc_1.insets = new Insets(0, 0, 5, 5);
				gbc_1.gridwidth = 2;
				gbc_1.gridx = 2;
				gbc_1.gridy = 3;
				JLabel label_1 = new JLabel("Genes por Individuo:");
				contentPane.add(label_1, gbc_1);
		TextField genesPorIndividuo = new TextField(5);
		GridBagConstraints gbc_genesPorIndividuo = new GridBagConstraints();
		gbc_genesPorIndividuo.anchor = GridBagConstraints.NORTHWEST;
		gbc_genesPorIndividuo.insets = new Insets(0, 0, 5, 5);
		gbc_genesPorIndividuo.gridx = 5;
		gbc_genesPorIndividuo.gridy = 3;
		contentPane.add(genesPorIndividuo, gbc_genesPorIndividuo);
		
		GridBagConstraints gbc = new GridBagConstraints();
		gbc.anchor = GridBagConstraints.WEST;
		gbc.insets = new Insets(0, 0, 5, 5);
		gbc.gridwidth = 2;
		gbc.gridx = 2;
		gbc.gridy = 4;
		JLabel label_4 = new JLabel("Cantidad de Individuos:");
		contentPane.add(label_4, gbc);
		TextField cantidadIndividuos = new TextField(5);
		GridBagConstraints gbc_cantidadIndividuos = new GridBagConstraints();
		gbc_cantidadIndividuos.anchor = GridBagConstraints.NORTHWEST;
		gbc_cantidadIndividuos.insets = new Insets(0, 0, 5, 5);
		gbc_cantidadIndividuos.gridx = 5;
		gbc_cantidadIndividuos.gridy = 4;
		contentPane.add(cantidadIndividuos, gbc_cantidadIndividuos);
		
		GridBagConstraints gbc_2 = new GridBagConstraints();
		gbc_2.anchor = GridBagConstraints.WEST;
		gbc_2.insets = new Insets(0, 0, 5, 5);
		gbc_2.gridwidth = 3;
		gbc_2.gridx = 2;
		gbc_2.gridy = 5;
		JLabel label_2 = new JLabel("Cantidad máxima de bits a mutar:");
		contentPane.add(label_2, gbc_2);
		TextField maximoDeBitsAMutar = new TextField(5);
		GridBagConstraints gbc_maximoDeBitsAMutar = new GridBagConstraints();
		gbc_maximoDeBitsAMutar.anchor = GridBagConstraints.NORTHWEST;
		gbc_maximoDeBitsAMutar.insets = new Insets(0, 0, 5, 5);
		gbc_maximoDeBitsAMutar.gridx = 5;
		gbc_maximoDeBitsAMutar.gridy = 5;
		contentPane.add(maximoDeBitsAMutar, gbc_maximoDeBitsAMutar);
		
		GridBagConstraints gbc_3 = new GridBagConstraints();
		gbc_3.anchor = GridBagConstraints.WEST;
		gbc_3.insets = new Insets(0, 0, 5, 5);
		gbc_3.gridx = 2;
		gbc_3.gridy = 6;
		JLabel label_3 = new JLabel("Clave:");
		contentPane.add(label_3, gbc_3);
		
		JRadioButton rdbtnAuto = new JRadioButton("Auto");
		GridBagConstraints gbc_rdbtnAuto = new GridBagConstraints();
		gbc_rdbtnAuto.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnAuto.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnAuto.gridwidth = 2;
		gbc_rdbtnAuto.gridx = 3;
		gbc_rdbtnAuto.gridy = 6;
		contentPane.add(rdbtnAuto, gbc_rdbtnAuto);
		JRadioButton rdbtnManual = new JRadioButton("Manual");
		GridBagConstraints gbc_rdbtnManual = new GridBagConstraints();
		gbc_rdbtnManual.anchor = GridBagConstraints.NORTHWEST;
		gbc_rdbtnManual.insets = new Insets(0, 0, 5, 5);
		gbc_rdbtnManual.gridx = 3;
		gbc_rdbtnManual.gridy = 7;
		contentPane.add(rdbtnManual, gbc_rdbtnManual);
		TextField claveManual = new TextField(20);
		GridBagConstraints gbc_claveManual = new GridBagConstraints();
		gbc_claveManual.anchor = GridBagConstraints.NORTHWEST;
		gbc_claveManual.insets = new Insets(0, 0, 5, 5);
		gbc_claveManual.gridwidth = 4;
		gbc_claveManual.gridx = 5;
		gbc_claveManual.gridy = 7;
		contentPane.add(claveManual, gbc_claveManual);
		
		GridBagConstraints gbc_4 = new GridBagConstraints();
		gbc_4.anchor = GridBagConstraints.WEST;
		gbc_4.insets = new Insets(0, 0, 5, 5);
		gbc_4.gridwidth = 2;
		gbc_4.gridx = 2;
		gbc_4.gridy = 9;
		JLabel label = new JLabel("Generaciones a correr:");
		contentPane.add(label, gbc_4);
		TextField generacionesACorrer = new TextField(10);
		GridBagConstraints gbc_generacionesACorrer = new GridBagConstraints();
		gbc_generacionesACorrer.anchor = GridBagConstraints.NORTHWEST;
		gbc_generacionesACorrer.insets = new Insets(0, 0, 5, 5);
		gbc_generacionesACorrer.gridwidth = 3;
		gbc_generacionesACorrer.gridx = 5;
		gbc_generacionesACorrer.gridy = 9;
		contentPane.add(generacionesACorrer, gbc_generacionesACorrer);
		
		JButton btnReset = new JButton("Reset");
		GridBagConstraints gbc_btnReset = new GridBagConstraints();
		gbc_btnReset.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnReset.insets = new Insets(0, 0, 5, 5);
		gbc_btnReset.gridwidth = 2;
		gbc_btnReset.gridx = 3;
		gbc_btnReset.gridy = 11;
		contentPane.add(btnReset, gbc_btnReset);
		
		JButton btnComenzar = new JButton("COMENZAR");
		GridBagConstraints gbc_btnComenzar = new GridBagConstraints();
		gbc_btnComenzar.insets = new Insets(0, 0, 5, 5);
		gbc_btnComenzar.anchor = GridBagConstraints.NORTHWEST;
		gbc_btnComenzar.gridwidth = 5;
		gbc_btnComenzar.gridx = 5;
		gbc_btnComenzar.gridy = 11;
		contentPane.add(btnComenzar, gbc_btnComenzar);
		

		
		this.setVisible(true);
		
	}

}
