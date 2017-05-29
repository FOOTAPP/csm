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
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Empleado;
import clases.Empleado;
import com.toedter.calendar.JDayChooser;
import com.toedter.calendar.JDateChooser;
import java.awt.Toolkit;

/**
 * Class DarAltaEmpleado2.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class DarAltaEmpleado2 extends JFrame{

	
	private JPanel contentPane;
	private JTextField textdni;
	private JTextField textnombre;
	private JTextField texttelf;
	private JTextField textcuenta;
	private JTextField textcorreo;
	private LocalDateTime hoy=LocalDateTime.now();

	/**
	 * Método main.
	 *
	 * @param args
	 *            
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarAltaEmpleado2 frame = new DarAltaEmpleado2();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}


	/**
	 * Constructor DarAltaEmpleado2.
	 */
	public DarAltaEmpleado2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DarAltaEmpleado2.class.getResource("/Resources/soccer.png")));
		BBDD_Empleado bd=new BBDD_Empleado("proyecto");
		setTitle("Dar alta empleado");
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
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOpciones obj3=new VentanaOpciones();
				obj3.setVisible(true);
				dispose();
				
			}
		});
		
		JLabel lblErrorNoHya = new JLabel("Rellene todos los campos");
		lblErrorNoHya.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(448, 348, 182, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JLabel lblIntroduceDni = new JLabel("Introduce dni:");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(231, 154, 81, 14);
		contentPane.add(lblIntroduceDni);
		
		textdni = new JTextField();
		textdni.setBounds(353, 151, 124, 20);
		contentPane.add(textdni);
		textdni.setColumns(10);
		
		JLabel lblNombre = new JLabel("Nombre:");
		lblNombre.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblNombre.setForeground(Color.WHITE);
		lblNombre.setBounds(231, 179, 81, 14);
		contentPane.add(lblNombre);
		
		textnombre = new JTextField();
		textnombre.setColumns(10);
		textnombre.setBounds(353, 176, 124, 20);
		contentPane.add(textnombre);
		
		JLabel lblTelefono = new JLabel("Tel\u00E9fono: ");
		lblTelefono.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblTelefono.setForeground(Color.WHITE);
		lblTelefono.setBounds(231, 204, 81, 14);
		contentPane.add(lblTelefono);
		
		texttelf = new JTextField();
		texttelf.setColumns(10);
		texttelf.setBounds(353, 201, 124, 20);
		contentPane.add(texttelf);
		
		JLabel lblCuentaBancaria = new JLabel("Cuenta bancaria: ");
		lblCuentaBancaria.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblCuentaBancaria.setForeground(Color.WHITE);
		lblCuentaBancaria.setBounds(231, 263, 112, 14);
		contentPane.add(lblCuentaBancaria);
		
		JLabel lblFnacimiento = new JLabel("F.Nacimiento:");
		lblFnacimiento.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblFnacimiento.setForeground(Color.WHITE);
		lblFnacimiento.setBounds(231, 229, 89, 14);
		contentPane.add(lblFnacimiento);
		
		textcuenta = new JTextField();
		textcuenta.setColumns(10);
		textcuenta.setBounds(353, 261, 213, 20);
		contentPane.add(textcuenta);
		
		Border border=LineBorder.createBlackLineBorder();
		
		JLabel lblDemarcacin = new JLabel("Cargo: ");
		lblDemarcacin.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblDemarcacin.setForeground(Color.WHITE);
		lblDemarcacin.setBounds(231, 290, 81, 14);
		contentPane.add(lblDemarcacin);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(353, 288, 168, 20);
		contentPane.add(comboBox);
		comboBox.addItem("ENTRENADOR");
		comboBox.addItem("SEGUNDO ENTRENADOR");
		comboBox.addItem("FISIOTERAPEUTA");
		comboBox.addItem("OJEADOR");
		comboBox.addItem("OTRO");
		
		
		JLabel lblCorreo = new JLabel("Correo: ");
		lblCorreo.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblCorreo.setForeground(Color.WHITE);
		lblCorreo.setBounds(231, 319, 81, 14);
		contentPane.add(lblCorreo);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		textcorreo = new JTextField();
		textcorreo.setColumns(10);
		textcorreo.setBounds(300, 317, 315, 20);
		contentPane.add(textcorreo);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(353, 230, 124, 20);
		contentPane.add(dateChooser);
		
		
		JButton darAltaJugador = new JButton("Dar alta");
		darAltaJugador.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent arg0) {
				String cargo=(String) comboBox.getSelectedItem();
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
					lblTelefono.setForeground(Color.RED);
				}
					
				else{
					lblTelefono.setForeground(Color.WHITE);
					telefonook=true;
				}
					
				
				if(textnombre.getText().equals("") || textdni.getText().equals("") || textcorreo.getText().equals("") || textcuenta.getText().equals("") || texttelf.getText().equals("") || cargo.equals(""))
					lblErrorNoHya.setVisible(true);
				else{
					lblErrorNoHya.setVisible(false);
							
							if(nombreok && dniok && correook && cuentaok && edadok && telefonook){
								
								
								Empleado nuevoempleado=new Empleado(textnombre.getText(),textdni.getText(), textcorreo.getText(), cargo, textcuenta.getText(), texttelf.getText(), hoy, fnacimiento);
								
								if(bd.buscarCargo() == 1 && cargo.equals("ENTRENADOR")){
								//if(==-1)
									errorotroEntrenador obj4=new errorotroEntrenador();
									obj4.setVisible(true);
									dispose();
								}
								else{
									bd.altaEmpleado(nuevoempleado);
									VentanaOpciones obj2=new VentanaOpciones();
									obj2.setVisible(true);
									dispose();
								}
								
								}
					}
				}
			
			
			}
		);
		
		btnVolver.setBounds(210, 370, 89, 23);
		contentPane.add(btnVolver);
		darAltaJugador.setBounds(448, 370, 182, 23);
		contentPane.add(darAltaJugador);
		
		
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
