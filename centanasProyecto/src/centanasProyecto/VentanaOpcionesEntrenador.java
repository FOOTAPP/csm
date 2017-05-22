package centanasProyecto;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;

public class VentanaOpcionesEntrenador extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcionesEntrenador frame = new VentanaOpcionesEntrenador();
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
	public VentanaOpcionesEntrenador() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 515);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		lblBienvenidoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblBienvenidoUsuario.setForeground(UIManager.getColor("Button.highlight"));
		lblBienvenidoUsuario.setBounds(207, 63, 252, 28);
		contentPane.add(lblBienvenidoUsuario);
		
		JButton btnNewButton = new JButton("Crear Aviso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearAviso obj = new CrearAviso();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(118, 116, 180, 23);
		contentPane.add(btnNewButton);
		
		
		JButton btnLeerAvisos = new JButton("Leer Avisos");
		btnLeerAvisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeerAviso obj = new LeerAviso();
				obj.setVisible(true);
				dispose();
			}
		});
		btnLeerAvisos.setBounds(417, 116, 180, 23);
		contentPane.add(btnLeerAvisos);
		
		JButton btnNewButton_2 = new JButton("Dar alta jugador");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarAltaJugador obj2 = new DarAltaJugador();
				obj2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(118, 167, 180, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dar baja jugador");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarBajaJugador obj = new DarBajaJugador();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(417, 167, 180, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnDarAltaCuerpo = new JButton("Dar alta cuerpo tecnico");
		btnDarAltaCuerpo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DarAltaEmpleado obj = new DarAltaEmpleado();
				obj.setVisible(true);
				dispose();
			}
		});
		btnDarAltaCuerpo.setBounds(118, 221, 180, 23);
		contentPane.add(btnDarAltaCuerpo);
		
		JButton btnNewButton_5 = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin obj2=new VentanaLogin();
				obj2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(79, 405, 162, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Dar baja cuerpo tecnico");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarBajaEmpleado obj = new DarBajaEmpleado();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(417, 221, 180, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\exit.png"));
		btnNewButton_6.setBounds(497, 373, 107, 55);
		contentPane.add(btnNewButton_6);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(47, 0, 600, 473);
		contentPane.add(lblNewLabel);
	}
}
