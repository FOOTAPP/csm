package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class VentanaOpciones extends JFrame {

	private JPanel contentPane;

	private static VentanaOpciones frame;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpciones frame = new VentanaOpciones();
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
	public VentanaOpciones() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_1 = new JButton("Gestionar movimientos de jugadores");
		btnNewButton_1.setHorizontalAlignment(SwingConstants.TRAILING);
		btnNewButton_1.setVerticalAlignment(SwingConstants.TOP);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_2 = new JButton("Gestionar movimientos \r\nde tecnicos ");
		btnNewButton_2.setToolTipText("");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnNewButton_7 = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin obj=new VentanaLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setBounds(72, 405, 143, 23);
		contentPane.add(btnNewButton_7);
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\exit.png"));
		btnNewButton_6.setBounds(501, 373, 107, 55);
		contentPane.add(btnNewButton_6);
		
		JButton btnNewButton_5 = new JButton("Ver solicitudes de material");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMaterial material=new VentanaMaterial();
				material.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(100, 322, 211, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Dar baja");
		btnNewButton_4.setBounds(131, 274, 143, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Dar alta");
		btnNewButton_3.setBounds(131, 225, 143, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton_2.setBounds(382, 225, 143, 72);
		contentPane.add(btnNewButton_2);
		btnNewButton_1.setBounds(382, 115, 143, 69);
		contentPane.add(btnNewButton_1);
		
		JButton btnNewButton = new JButton("Modificar informaci\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(116, 172, 180, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCuentasDelClub = new JButton("Cuentas del Club");
		btnCuentasDelClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuentasDelClub.setVerticalAlignment(SwingConstants.TOP);
		btnCuentasDelClub.setFont(new Font("Kalinga", Font.PLAIN, 11));
		btnCuentasDelClub.setBounds(131, 115, 143, 23);
		contentPane.add(btnCuentasDelClub);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		lblBienvenidoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblBienvenidoUsuario.setForeground(UIManager.getColor("Button.highlight"));
		lblBienvenidoUsuario.setBounds(207, 63, 240, 41);
		contentPane.add(lblBienvenidoUsuario);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(41, 0, 608, 473);
		contentPane.add(lblNewLabel);
		
	}
}
