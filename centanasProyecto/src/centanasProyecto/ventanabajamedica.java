package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Fisio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;

public class ventanabajamedica extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanabajamedica frame = new ventanabajamedica();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public ventanabajamedica() {
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		setTitle("Baja m\u00E9dica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay jugadores disponibles");
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(65, 233, 228, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(160, 133, 124, 20);
		contentPane.add(comboBox);
		try{
		for(String a : bd.buscarJugadoresLesionados("No"))
			comboBox.addItem(a);
		}
		catch (NullPointerException e){}
		

		
		
		JButton btnGenerarBajaMedica = new JButton("Generar baja medica");
		btnGenerarBajaMedica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String) comboBox.getSelectedItem();
				try{
				bd.darBajaMedica(dni);
				}
				catch(NullPointerException e){
					lblErrorNoHya.setVisible(true);
				}
				VentanaGenerarInforme obj2=new VentanaGenerarInforme(dni);
				obj2.setVisible(true);
				dispose();
			}
		});
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaOpcionesFisio obj2=new VentanaOpcionesFisio();
				obj2.setVisible(true);
				dispose();
			}
		});
		
		
		btnAtras.setBounds(0, 306, 89, 23);
		contentPane.add(btnAtras);
		btnGenerarBajaMedica.setBounds(301, 278, 182, 23);
		contentPane.add(btnGenerarBajaMedica);
		
		textField = new JTextField();
		textField.setBounds(160, 133, 124, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblIntroduceDni = new JLabel("Introduce dni:");
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(65, 136, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(0, 0, 530, 329);
		contentPane.add(lblNewLabel);
	}
}
