package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Aviso;
import bbdd.BBDD_Empleado;
import clases.Aviso;

import javax.swing.JComboBox;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Vector;
import java.awt.event.ActionEvent;

public class CrearAviso extends JFrame {

	private JPanel contentPane;
	private LocalDateTime hoy=LocalDateTime.now();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearAviso frame = new CrearAviso();
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
	public CrearAviso() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
	
		BBDD_Empleado bd=new BBDD_Empleado("proyecto");
		BBDD_Aviso bd2=new BBDD_Aviso("proyecto");
		
		JLabel completar = new JLabel("Rellene todos los campos");
		completar.setForeground(Color.WHITE);
		completar.setBounds(121, 232, 152, 14);
		contentPane.add(completar);
		completar.setVisible(false);
		
		JLabel mismodni = new JLabel("Mismo dni");
		mismodni.setForeground(Color.WHITE);
		mismodni.setBounds(270, 197, 152, 14);
		contentPane.add(mismodni);
		mismodni.setVisible(false);
		
		JLabel lblIntroduceDni = new JLabel("Dni creador:");
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(29, 29, 81, 14);
		contentPane.add(lblIntroduceDni);	
		
		JComboBox<String> dnicrea = new JComboBox<String>();
		dnicrea.setBounds(136, 194, 124, 20);
		contentPane.add(dnicrea);
		for(String a : bd.buscarEmpleado())
			dnicrea.addItem(a);
		
		JLabel lblMotivo = new JLabel("Motivo: ");
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setBounds(29, 73, 81, 14);
		contentPane.add(lblMotivo);
		
		JTextPane textPane = new JTextPane();
		textPane.setBounds(95, 73, 285, 99);
		contentPane.add(textPane);
		
		JLabel lblDniDestinatario = new JLabel("Dni destinatario:");
		lblDniDestinatario.setForeground(Color.WHITE);
		lblDniDestinatario.setBounds(29, 197, 97, 14);
		contentPane.add(lblDniDestinatario);
		
		JComboBox<String> dnidest = new JComboBox<String>();
		dnidest.setBounds(136, 26, 124, 20);
		contentPane.add(dnidest);
		for(String a : bd.buscarEmpleado())
			dnidest.addItem(a);
		
		JButton btnNewButton = new JButton("Crear Aviso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> dest=new Vector<String>();
				dest.add((String) dnidest.getSelectedItem());
				if( textPane.getText().equals("") || dnidest.getSelectedItem().equals("") || dnicrea.getSelectedItem().equals(""))
					completar.setVisible(true);
				else
					if( dnidest.getSelectedItem().equals(dnicrea.getSelectedItem())){
						mismodni.setVisible(true);
						completar.setVisible(false);
					}
					else{
						Aviso av=new Aviso((String) dnicrea.getSelectedItem(), textPane.getText(), hoy, dest );
						bd2.crearAviso(av);
						VentanaOpcionesEntrenador obj2=new VentanaOpcionesEntrenador();
						obj2.setVisible(true);
						dispose();
					}
			}
		});
		btnNewButton.setBounds(300, 228, 124, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOpcionesEntrenador obj4=new VentanaOpcionesEntrenador();
				obj4.setVisible(true);
				dispose();
				
			}
		});
		btnVolver.setBounds(10, 228, 89, 23);
		contentPane.add(btnVolver);
		
	}	
}
