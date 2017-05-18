package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Jugador;
import clases.Jugador;

public class DarAltaEmpleado extends JFrame{

	private JPanel contentPane;
	private JTextField textdni;
	private JTextField textnombre;
	private JTextField texttelf;
	private JTextField textcuenta;
	private JTextField textcorreo;
	private LocalDateTime hoy=LocalDateTime.now();
	private LocalDate nacimiento=LocalDate.now();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarAltaEmpleado frame = new DarAltaEmpleado();
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
	public DarAltaEmpleado() {
		BBDD_Jugador bd=new BBDD_Jugador("proyecto");
		setTitle("Dar alta empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErrorNoHya = new JLabel("Rellene todos los campos");
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(324, 280, 152, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOpcionesEntrenador obj4=new VentanaOpcionesEntrenador();
				obj4.setVisible(true);
				dispose();
				
			}
		});
		
		textdni = new JTextField();
		textdni.setBounds(160, 26, 124, 20);
		contentPane.add(textdni);
		textdni.setColumns(10);
		
		JLabel lblIntroduceDni = new JLabel("Introduce dni:");
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(69, 29, 81, 14);
		contentPane.add(lblIntroduceDni);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(0, 0, 530, 329);
		contentPane.add(lblNewLabel);
		
		JLabel lblNombre = new JLabel("Nombre");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(69, 69, 81, 14);
		contentPane.add(lblNombre);
		
		JLabel lblFechaNacimiento = new JLabel("Tel\u00E9fono: ");
		lblFechaNacimiento.setForeground(Color.WHITE);
		lblFechaNacimiento.setBounds(69, 111, 81, 14);
		contentPane.add(lblFechaNacimiento);
		
		JLabel lblCuentaBancaria = new JLabel("Cuenta bancaria: ");
		lblCuentaBancaria.setForeground(Color.WHITE);
		lblCuentaBancaria.setBounds(69, 149, 89, 14);
		contentPane.add(lblCuentaBancaria);
		
		JLabel lblDemarcacin = new JLabel("Demarcaci\u00F3n: ");
		lblDemarcacin.setForeground(Color.WHITE);
		lblDemarcacin.setBounds(69, 188, 81, 14);
		contentPane.add(lblDemarcacin);
		
		JLabel lblCorreo = new JLabel("Correo: ");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setBounds(69, 228, 81, 14);
		contentPane.add(lblCorreo);
		
		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(160, 66, 124, 20);
		contentPane.add(textnombre);
		
		texttelf = new JTextField();
		texttelf.setColumns(10);
		texttelf.setBounds(160, 108, 124, 20);
		contentPane.add(texttelf);
		
		textcuenta = new JTextField();
		textcuenta.setColumns(10);
		textcuenta.setBounds(168, 146, 160, 20);
		contentPane.add(textcuenta);
		
		textcorreo = new JTextField();
		textcorreo.setColumns(10);
		textcorreo.setBounds(119, 225, 182, 20);
		contentPane.add(textcorreo);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(160, 185, 141, 20);
		contentPane.add(comboBox);
		comboBox.addItem("");
		comboBox.addItem("ENTRENADOR");
		comboBox.addItem("SEGUNDO ENTRENADOR");
		comboBox.addItem("FISIOTERAPEUTA");
		comboBox.addItem("OJEADOR");
		comboBox.addItem("OTRO");
		String demarcacion=(String) comboBox.getSelectedItem();
		
		JButton darAltaJugador = new JButton("Dar alta");
		darAltaJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textnombre.getText().equals("") || textdni.getText().equals("") || textcorreo.getText().equals("") || textcuenta.getText().equals("") || texttelf.getText().equals(""))
					lblErrorNoHya.setVisible(true);
				else{
					Jugador nuevojugador=new Jugador(textnombre.getText(),textdni.getText(), textcorreo.getText(), demarcacion, textcuenta.getText(), texttelf.getText(), hoy, nacimiento);
					bd.altaJugador(nuevojugador);
					VentanaOpcionesEntrenador obj2=new VentanaOpcionesEntrenador();
					obj2.setVisible(true);
					dispose();
					}
				}
			}
		);
		
		btnVolver.setBounds(0, 306, 89, 23);
		contentPane.add(btnVolver);
		darAltaJugador.setBounds(324, 295, 182, 23);
		contentPane.add(darAltaJugador);
	}
}
