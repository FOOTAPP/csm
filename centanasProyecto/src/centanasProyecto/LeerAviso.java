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
	
	private JPanel contentPane;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeerAviso frame = new LeerAviso();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	public LeerAviso() {
		
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
		
		String linea="";
		JComboBox avisos = new JComboBox();
		avisos.setBounds(148, 58, 173, 20);
		contentPane.add(avisos);
		for(Aviso b : bd.leerAvisos("77598912M"))
			linea=linea+"\n"+b.getDni_emple()+", "+b.getFh_creado();
			
		
		JButton btnNewButton = new JButton("Leer Aviso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
