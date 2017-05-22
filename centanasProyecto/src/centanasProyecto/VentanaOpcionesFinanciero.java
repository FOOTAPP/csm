package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;

public class VentanaOpcionesFinanciero extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcionesFinanciero frame = new VentanaOpcionesFinanciero();
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
	public VentanaOpcionesFinanciero() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 681, 505);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton4 = new JButton("");
		btnNewButton4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnNewButton_3 = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin obj= new VentanaLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(64, 405, 156, 23);
		contentPane.add(btnNewButton_3);
		btnNewButton4.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\exit.png"));
		btnNewButton4.setBounds(496, 374, 108, 54);
		contentPane.add(btnNewButton4);
		
		JButton btnNewButton_2 = new JButton("Modificar cuenta bancaria Jugador");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCuentaJugador obj = new ModificarCuentaJugador();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(199, 187, 300, 30);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Modificar cuenta bancaria Empleado");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ModificarCuentaEmpleado obj = new ModificarCuentaEmpleado();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(199, 144, 300, 30);
		contentPane.add(btnNewButton_1);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		lblBienvenidoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblBienvenidoUsuario.setForeground(UIManager.getColor("Button.highlight"));
		lblBienvenidoUsuario.setBounds(199, 57, 240, 41);
		contentPane.add(lblBienvenidoUsuario);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(33, 0, 600, 472);
		contentPane.add(lblNewLabel);
	}

}
