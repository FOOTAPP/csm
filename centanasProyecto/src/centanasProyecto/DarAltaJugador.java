package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import com.toedter.calendar.JDateChooser;

import bbdd.BBDD_Jugador;
import clases.Jugador;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;

public class DarAltaJugador extends JFrame{

	private JPanel contentPane;
	private JTextField textdni;
	private JTextField textnombre;
	private JTextField texttelf;
	private JTextField textcuenta;
	private JTextField textcorreo;
	private LocalDateTime hoy=LocalDateTime.now();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarAltaJugador frame = new DarAltaJugador();
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
	public DarAltaJugador() {
		BBDD_Jugador bd=new BBDD_Jugador("proyecto");
		setTitle("Dar alta jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(38, 233, 78));
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int inicioancho=ancho/4;
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int inicioalto=alto/4;
		ancho=ancho/2;
		alto=alto/2;
		//setBounds()
		setBounds(inicioancho,inicioalto, ancho, alto);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JLabel lblErrorNoHya = new JLabel("Rellene todos los campos");
		lblErrorNoHya.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(426, 345, 190, 14);
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
		textdni.setBounds(319, 148, 124, 20);
		contentPane.add(textdni);
		textdni.setColumns(10);
		
		JLabel lblFnacimiento = new JLabel("F.Nacimiento:");
		lblFnacimiento.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblFnacimiento.setForeground(Color.WHITE);
		lblFnacimiento.setBounds(220, 248, 89, 14);
		contentPane.add(lblFnacimiento);
		
		JLabel lblIntroduceDni = new JLabel("Dni :");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(220, 151, 81, 14);
		contentPane.add(lblIntroduceDni);
		
		
		JLabel lblNombre = new JLabel("Nombre :");
		lblNombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(220, 176, 81, 14);
		contentPane.add(lblNombre);
		
		JLabel lbltelefono = new JLabel("Tel\u00E9fono: ");
		lbltelefono .setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lbltelefono .setForeground(Color.WHITE);
		lbltelefono .setBounds(398, 286, 81, 14);
		contentPane.add(lbltelefono );
		
		JLabel lblCuentaBancaria = new JLabel("Cuenta bancaria: ");
		lblCuentaBancaria.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblCuentaBancaria.setForeground(Color.WHITE);
		lblCuentaBancaria.setBounds(220, 214, 110, 14);
		contentPane.add(lblCuentaBancaria);
		
		JLabel lblDemarcacin = new JLabel("Demarcaci\u00F3n: ");
		lblDemarcacin.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblDemarcacin.setForeground(Color.WHITE);
		lblDemarcacin.setBounds(220, 286, 81, 14);
		contentPane.add(lblDemarcacin);
		
		JLabel lblCorreo = new JLabel("Correo: ");
		lblCorreo.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setBounds(220, 316, 81, 14);
		contentPane.add(lblCorreo);
		
		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(319, 176, 124, 20);
		contentPane.add(textnombre);
		
		texttelf = new JTextField();
		texttelf.setColumns(10);
		texttelf.setBounds(479, 283, 124, 20);
		contentPane.add(texttelf);
		
		textcuenta = new JTextField();
		textcuenta.setColumns(10);
		textcuenta.setBounds(350, 212, 253, 20);
		contentPane.add(textcuenta);
		
		textcorreo = new JTextField();
		textcorreo.setColumns(10);
		textcorreo.setBounds(319, 314, 284, 20);
		contentPane.add(textcorreo);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(319, 283, 57, 20);
		contentPane.add(comboBox);
		comboBox.addItem("POR");
		comboBox.addItem("DFC");
		comboBox.addItem("LAT");
		comboBox.addItem("MC");
		comboBox.addItem("EXT");
		comboBox.addItem("DC");
		
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(319, 248, 124, 20);
		contentPane.add(dateChooser);
		
		JButton darAltaJugador = new JButton("Dar alta");
		darAltaJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String demarcacion=(String) comboBox.getSelectedItem();
				ValidarDni dni=new ValidarDni(textdni.getText());
				boolean validado=dni.validar();
				boolean nombreok=false;
				boolean dniok=false;
				boolean correook=false;
				boolean cuentaok=false;
				boolean edadok=false;
				boolean telefonook=false;
				Date inputDate = new Date();
				inputDate=dateChooser.getDate();
				LocalDate fnacimiento=null;
				try{
				fnacimiento = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				}
				catch(NullPointerException e){
				}
				if(textnombre.getText().equals(""))
					lblNombre.setForeground(Color.red);
				else{
					lblNombre.setForeground(Color.white);
					nombreok=true;
				}
					
				if(textdni.getText().equals("") || !validado || bd.buscarDni(textdni.getText()) == 1){
					lblIntroduceDni.setForeground(Color.red);
					if(!validado)
						textdni.setText("Dni erroneo");
					if( bd.buscarDni(textdni.getText()) == 1)
						textdni.setText("Dni ya registrado");
				}
					
				else{
					lblIntroduceDni.setForeground(Color.white);
					dniok=true;
				}
					
				if(textcorreo.getText().equals("") || bd.validarCorreo(textcorreo.getText()) == false)
					lblCorreo.setForeground(Color.red);
				    if(bd.validarCorreo(textcorreo.getText()) == false)
				    	textcorreo.setText("Fomato no válido");
				else{
					lblCorreo.setForeground(Color.white);
					correook=true;
				}
					
				
				if(bd.validarCuenta(textcuenta.getText())==false || textcuenta.getText().equals("") || bd.buscarCuenta(textcuenta.getText()) == 1){
					lblCuentaBancaria.setForeground(Color.red);
					if(bd.validarCuenta(textcuenta.getText())==false)
						textcuenta.setText("Formato no válido");
					if(bd.buscarCuenta(textcuenta.getText()) == 1)
						textcuenta.setText("Cuenta ya registrada");
				}
					
				
				else{
					cuentaok=true;
					lblCuentaBancaria.setForeground(Color.white);
				}
					
				if(fnacimiento==null || bd.validarEdad(fnacimiento) == false)
					lblFnacimiento.setForeground(Color.red);
				else{
					edadok=true;
					lblFnacimiento.setForeground(Color.white);
				}
				if(texttelf.getText().equals("") ||  bd.validarTelefono(texttelf.getText()) == false){
					lbltelefono.setForeground(Color.RED);
				}
					
				else{
					lbltelefono.setForeground(Color.WHITE);
					telefonook=true;
				}
					
				
				if(textnombre.getText().equals("") || textdni.getText().equals("") || textcorreo.getText().equals("") || textcuenta.getText().equals("") || texttelf.getText().equals("") || demarcacion.equals(""))
					lblErrorNoHya.setVisible(true);
				else{
					lblErrorNoHya.setVisible(false);
							
							if(nombreok==true && dniok==true && correook==true && cuentaok==true && edadok==true && telefonook==true){
								Jugador nuevojugador=new Jugador(textnombre.getText(),textdni.getText(), textcorreo.getText(), demarcacion, textcuenta.getText(), texttelf.getText(), hoy, fnacimiento);
								bd.altaJugador(nuevojugador);
								VentanaOpcionesEntrenador obj2=new VentanaOpcionesEntrenador();
								obj2.setVisible(true);
								dispose();
								}
					}
				}
			}
		);
		
		btnVolver.setBounds(210, 370, 89, 23);
		contentPane.add(btnVolver);
		darAltaJugador.setBounds(448, 370, 182, 23);
		contentPane.add(darAltaJugador);
		
		Border border=LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setForeground(Color.WHITE);
		lblNewLabel_1.setBounds(0, 0, 0, 0);
		lblNewLabel_1.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/fondobueno.jpg")));
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		lblNewLabel_1.setBorder(border);
	}
}