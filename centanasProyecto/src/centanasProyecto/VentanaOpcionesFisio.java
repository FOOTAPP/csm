package centanasProyecto;

import java.awt.BorderLayout;
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

public class VentanaOpcionesFisio extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcionesFisio frame = new VentanaOpcionesFisio();
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
	public VentanaOpcionesFisio() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 663, 569);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnNewButton_6 = new JButton("");
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JButton btnNewButton = new JButton("Apuntar sesion");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
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
		btnNewButton_3.setBounds(57, 439, 161, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Dar alta medica");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ventanabajamedica obj=new ventanabajamedica();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(356, 200, 161, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Dar baja medica");
		btnNewButton_1.setBounds(356, 150, 161, 23);
		contentPane.add(btnNewButton_1);
		btnNewButton.setBounds(138, 200, 161, 23);
		contentPane.add(btnNewButton);
		btnNewButton_6.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\exit.png"));
		btnNewButton_6.setBounds(488, 407, 107, 55);
		contentPane.add(btnNewButton_6);
		
		JButton btnCrearInformeDe = new JButton("Crear informe de lesiones");
		btnCrearInformeDe.setBounds(138, 150, 161, 23);
		contentPane.add(btnCrearInformeDe);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		lblBienvenidoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblBienvenidoUsuario.setForeground(UIManager.getColor("Button.highlight"));
		lblBienvenidoUsuario.setBounds(191, 98, 240, 41);
		contentPane.add(lblBienvenidoUsuario);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(25, 11, 600, 521);
		contentPane.add(lblNewLabel);
	}

}
