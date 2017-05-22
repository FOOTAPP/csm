package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Empleado;
import clases.Empleado;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;

public class DarAltaEmpleado extends JFrame{

	private JPanel contentPane;
	private JTextField textdni;
	private JTextField textnombre;
	private JTextField texttelf;
	private JTextField textcuenta;
	private JTextField textcorreo;
	private LocalDateTime hoy=LocalDateTime.now();

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


	public DarAltaEmpleado() {
		BBDD_Empleado bd=new BBDD_Empleado("proyecto");
		setTitle("Dar alta empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOpcionesEntrenador obj4=new VentanaOpcionesEntrenador();
				obj4.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblErrorNoHya = new JLabel("Rellene todos los campos");
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(160, 280, 152, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JLabel dnierroneo = new JLabel("Dni erroneo");
		dnierroneo.setForeground(Color.WHITE);
		dnierroneo.setBounds(335, 29, 152, 14);
		contentPane.add(dnierroneo);
		dnierroneo.setVisible(false);
		
		JLabel dniexiste = new JLabel("Este Dni ya existe");
		dniexiste.setForeground(Color.WHITE);
		dniexiste.setBounds(335, 29, 152, 14);
		contentPane.add(dniexiste);
		dniexiste.setVisible(false);
		
		JLabel errortelefono = new JLabel("Teléfono erroneo");
		errortelefono.setForeground(Color.WHITE);
		errortelefono.setBounds(300, 111, 152, 14);
		contentPane.add(errortelefono);
		errortelefono.setVisible(false);

		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(0, 0, 530, 329);
		contentPane.add(lblNewLabel);
		
		JLabel lblIntroduceDni = new JLabel("Introduce dni:");
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(69, 29, 81, 14);
		contentPane.add(lblIntroduceDni);
		
		textdni = new JTextField();
		textdni.setBounds(160, 26, 124, 20);
		contentPane.add(textdni);
		textdni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(69, 69, 81, 14);
		contentPane.add(lblNombre);
		
		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(160, 66, 124, 20);
		contentPane.add(textnombre);
		
		JLabel lblFechaNacimiento = new JLabel("Tel\u00E9fono: ");
		lblFechaNacimiento.setForeground(Color.WHITE);
		lblFechaNacimiento.setBounds(69, 111, 81, 14);
		contentPane.add(lblFechaNacimiento);
		
		texttelf = new JTextField();
		texttelf.setColumns(10);
		texttelf.setBounds(160, 108, 124, 20);
		contentPane.add(texttelf);
		
		JLabel lblCuentaBancaria = new JLabel("Cuenta bancaria: ");
		lblCuentaBancaria.setForeground(Color.WHITE);
		lblCuentaBancaria.setBounds(69, 149, 89, 14);
		contentPane.add(lblCuentaBancaria);
		
		textcuenta = new JTextField();
		textcuenta.setColumns(10);
		textcuenta.setBounds(168, 146, 160, 20);
		contentPane.add(textcuenta);
		
		JLabel lblDemarcacin = new JLabel("Cargo: ");
		lblDemarcacin.setForeground(Color.WHITE);
		lblDemarcacin.setBounds(69, 188, 81, 14);
		contentPane.add(lblDemarcacin);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(160, 185, 168, 20);
		contentPane.add(comboBox);
		comboBox.addItem("ENTRENADOR");
		comboBox.addItem("SEGUNDO ENTRENADOR");
		comboBox.addItem("FISIOTERAPEUTA");
		comboBox.addItem("OJEADOR");
		comboBox.addItem("OTRO");
		String cargo=(String) comboBox.getSelectedItem();
		
		JLabel lblCorreo = new JLabel("Correo: ");
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setBounds(69, 228, 81, 14);
		contentPane.add(lblCorreo);
		
		textcorreo = new JTextField();
		textcorreo.setColumns(10);
		textcorreo.setBounds(119, 225, 209, 20);
		contentPane.add(textcorreo);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(392, 182, 95, 20);
		contentPane.add(dateChooser);
		
		
		JButton darAltaJugador = new JButton("Dar alta");
		darAltaJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ValidarDni dni=new ValidarDni(textdni.getText());
				boolean validado=dni.validar();
				
				Date inputDate = new Date();
				inputDate=dateChooser.getDate();
				LocalDate fnacimiento = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				
				if(textnombre.getText().equals("") || textdni.getText().equals("") || textcorreo.getText().equals("") || textcuenta.getText().equals("") || texttelf.getText().equals("") || cargo.equals(""))
					lblErrorNoHya.setVisible(true);
				else{
					lblErrorNoHya.setVisible(false);
					if(!validado)
						dnierroneo.setVisible(true);
					else
						if(bd.buscarDni(textdni.getText()) == 1){
							dniexiste.setVisible(true);
							dnierroneo.setVisible(false);
						}
						else
							if(texttelf.getText().length() != 9){
								dniexiste.setVisible(false);
								errortelefono.setVisible(true);
							}
							else{
							Empleado nuevoempleado=new Empleado(textnombre.getText(),textdni.getText(), textcorreo.getText(), cargo, textcuenta.getText(), texttelf.getText(), hoy, fnacimiento);
							bd.altaEmpleado(nuevoempleado);
							VentanaOpcionesEntrenador obj2=new VentanaOpcionesEntrenador();
							obj2.setVisible(true);
							dispose();
								}
					}
				}
			}
		);
		
		btnVolver.setBounds(10, 295, 89, 23);
		contentPane.add(btnVolver);
		darAltaJugador.setBounds(324, 295, 182, 23);
		contentPane.add(darAltaJugador);
		
		
	}
}
