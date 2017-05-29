package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Empleado;
import clases.Empleado;
import clases.Jugador;

/**
 * Clase ModificarCuentaEmpleado.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class ModificarCuentaEmpleado extends JFrame{

	
	protected static final String String = null;
	private JPanel contentPane;
	private JTextField nuevacuenta;

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
					ModificarCuentaEmpleado frame = new ModificarCuentaEmpleado(String);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor ModificarCuentaEmpleado.
	 *
	 * @param dni
	 *           
	 */
	public ModificarCuentaEmpleado(String dni) {
		BBDD_Empleado bd=new BBDD_Empleado("proyecto");
		setTitle("Modificar cuenta Empleado");
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
		lblNewLabel.setIcon(new ImageIcon(ModificarCuentaEmpleado.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JLabel rellenarcuenta = new JLabel("La cuenta introducida no es v\u00E1lida");
		rellenarcuenta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		rellenarcuenta.setForeground(Color.WHITE);
		rellenarcuenta.setBounds(304, 292, 278, 14);
		contentPane.add(rellenarcuenta);
		rellenarcuenta.setVisible(false);
		
		JLabel lblNewLabel_2 = new JLabel("Dni no valido");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(376, 267, 124, 14);
		contentPane.add(lblNewLabel_2);
		lblNewLabel_2.setVisible(false);
		
		JLabel lblIntroduceDni = new JLabel("Selecciona dni");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 14));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(233, 185, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(401, 179, 124, 20);
		contentPane.add(comboBox);		
		for(String a : bd.buscarEmpleado())
			comboBox.addItem(a);
		
		JLabel lblNuevaCuenta = new JLabel("Nueva Cuenta:");
		lblNuevaCuenta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNuevaCuenta.setForeground(Color.WHITE);
		lblNuevaCuenta.setBounds(233, 212, 155, 14);
		contentPane.add(lblNuevaCuenta);
		
		nuevacuenta = new JTextField();
		nuevacuenta.setBounds(401, 210, 229, 22);
		contentPane.add(nuevacuenta);
		nuevacuenta.setColumns(10);
		String cuenta=nuevacuenta.getText();
		
		JButton modificarDatos = new JButton("Modificar datos bancarios");
		modificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String) comboBox.getSelectedItem();
				boolean valido=bd.validarCuenta(nuevacuenta.getText());
				int cuentaok=bd.buscarCuenta(nuevacuenta.getText());
				if (dni==null)
					lblNewLabel_2.setVisible(true);
				if(nuevacuenta.getText().equals("") || valido==false || cuentaok==1)
					rellenarcuenta.setVisible(true);
				else{
					Empleado e=new Empleado(dni, nuevacuenta.getText());
					bd.actualizarCuentaEmpleado(e);
					VentanaOpcionesFinanciero obj2=new VentanaOpcionesFinanciero();
					obj2.setVisible(true);
					dispose();
				}
			}
		});
		modificarDatos.setBounds(343, 317, 182, 23);
		contentPane.add(modificarDatos);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dni.equals(bd.buscarPresi())){
					OpcionModificarCuenta obj4=new OpcionModificarCuenta(dni);
					obj4.setVisible(true);
					dispose();
				}
				else{
					VentanaOpcionesFinanciero obj4=new VentanaOpcionesFinanciero();
					obj4.setVisible(true);
					dispose();
				}
			}
		});
		btnVolver.setBounds(387, 370, 89, 23);
		contentPane.add(btnVolver);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 0, 0);
		lblNewLabel_1.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNewLabel_1.setIcon(new ImageIcon(ModificarCuentaEmpleado.class.getResource("/Resources/fondobueno.jpg")));
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
	}
	
	/**
	 * Validar cuenta.
	 *
	 * @param cuenta
	 *            the cuenta
	 * @return true, if successful
	 */
	public static boolean validarCuenta(String cuenta){
		String miCuenta[];
		if(!cuenta.substring(0, 2).equals("ES"))
			return false;
		if(cuenta.length() != 27 )
			return false;
		miCuenta=cuenta.split("-");
		if (miCuenta.length!=5)
			 return false;
		try{
		Integer.parseInt(miCuenta[0].substring(2, 4));
		}
		catch(StringIndexOutOfBoundsException e){
			return false;
		}
		catch(NumberFormatException e){
			return false;
		}
		
		for (int i=1;i<miCuenta.length;i++){
		try{
		Integer.parseInt(miCuenta[i]);
		}
		catch(NumberFormatException e){
			return false;
		}
		}
		return true;
	}
}
