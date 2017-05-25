package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Jugador;

public class DarBajaJugador2 extends JFrame{

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarBajaJugador2 frame = new DarBajaJugador2();
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
	public DarBajaJugador2() {
		BBDD_Jugador bd=new BBDD_Jugador("proyecto");
		setTitle("Dar baja jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay jugadores disponibles");
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(137, 228, 229, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(160, 133, 124, 20);
		contentPane.add(comboBox);		
		for(String a : bd.buscarJugadores())
			comboBox.addItem(a);
		
		
		
		JButton darBajaJugador = new JButton("Dar baja");
		darBajaJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String) comboBox.getSelectedItem();
				if (dni==null)
					lblErrorNoHya.setVisible(true);
				else{
				
				bd.borrarJugador(dni);
				
				OpcionDarBaja obj2=new OpcionDarBaja();
				obj2.setVisible(true);
				dispose();
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionDarBaja obj4=new OpcionDarBaja();
				obj4.setVisible(true);
				dispose();
				
			}
		});
		
		
		btnVolver.setBounds(0, 306, 89, 23);
		contentPane.add(btnVolver);
		darBajaJugador.setBounds(301, 278, 182, 23);
		contentPane.add(darBajaJugador);
		
		
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
