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

import bbdd.BBDD_Empleado;
import clases.Empleado;

public class ModificarCuentaEmpleado extends JFrame{

	private JPanel contentPane;
	private JTextField nuevacuenta;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCuentaEmpleado frame = new ModificarCuentaEmpleado();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public ModificarCuentaEmpleado() {
		BBDD_Empleado bd=new BBDD_Empleado("proyecto");
		setTitle("Modificar cuenta Empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(0, 0, 530, 329);
		contentPane.add(lblNewLabel);
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay empleados disponibles");
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(137, 228, 229, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JLabel rellenarcuenta = new JLabel("Rellene el campo de la cuenta");
		rellenarcuenta.setForeground(Color.WHITE);
		rellenarcuenta.setBounds(185, 143, 229, 14);
		contentPane.add(rellenarcuenta);
		rellenarcuenta.setVisible(false);
		
		JLabel lblIntroduceDni = new JLabel("Introduce dni:");
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(62, 48, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(185, 45, 124, 20);
		contentPane.add(comboBox);		
		for(String a : bd.buscarEmpleado())
			comboBox.addItem(a);
		
		JLabel lblNuevaCuenta = new JLabel("Nueva Cuenta:");
		lblNuevaCuenta.setForeground(Color.WHITE);
		lblNuevaCuenta.setBounds(62, 112, 155, 14);
		contentPane.add(lblNuevaCuenta);
		
		nuevacuenta = new JTextField();
		nuevacuenta.setBounds(185, 108, 229, 22);
		contentPane.add(nuevacuenta);
		nuevacuenta.setColumns(10);
		
		JButton modificarDatos = new JButton("Modificar datos bancarios");
		modificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String) comboBox.getSelectedItem();
				if (dni==null)
					lblErrorNoHya.setVisible(true);
				if(nuevacuenta.getText().equals("")){
					rellenarcuenta.setVisible(true);
					lblErrorNoHya.setVisible(false);
				}
				else{
					Empleado e=new Empleado(dni, nuevacuenta.getText());
					bd.actualizarCuentaEmpleado(e);
					VentanaOpcionesFinanciero obj2=new VentanaOpcionesFinanciero();
					obj2.setVisible(true);
					dispose();
				}
			}
		});
		modificarDatos.setBounds(301, 278, 182, 23);
		contentPane.add(modificarDatos);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOpcionesFinanciero obj4=new VentanaOpcionesFinanciero();
				obj4.setVisible(true);
				dispose();
			}
		});
		btnVolver.setBounds(12, 284, 89, 23);
		contentPane.add(btnVolver);
		
	}
}
