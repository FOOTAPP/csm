package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Aviso;
import bbdd.BBDD_Empleado;
import clases.Aviso;

public class LeerAviso extends JFrame{
	
	protected static final String String = null;
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeerAviso frame = new LeerAviso(String);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LeerAviso(String dni) {
		
		BBDD_Aviso bd=new BBDD_Aviso("proyecto");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay empleados disponibles");
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(137, 228, 229, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JComboBox<Aviso> avisos = new JComboBox<Aviso>();
		avisos.setBounds(27, 58, 386, 20);
		contentPane.add(avisos);
		for(Aviso b : bd.leerAvisos(dni))
			avisos.addItem(b);
		
		JButton btnNewButton = new JButton("Leer Aviso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Aviso a;
				a=(Aviso) avisos.getSelectedItem();
				
				LeerAviso2 obj = new LeerAviso2(a,dni);
				obj.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBounds(300, 228, 124, 23);
		contentPane.add(btnNewButton);
		
		String dnicompar=bd.buscarEntrenador();
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dni.equals(dnicompar)){
					VentanaOpcionesEntrenador obj4=new VentanaOpcionesEntrenador();
					obj4.setVisible(true);
					dispose();
				}
				else{
					VentanaOpciones obj4=new VentanaOpciones();
					obj4.setVisible(true);
					dispose();
				}
					
				
			}
		});
		btnVolver.setBounds(10, 228, 89, 23);
		contentPane.add(btnVolver);
		
	}
}
