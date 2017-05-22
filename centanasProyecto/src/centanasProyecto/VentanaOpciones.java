package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
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
import javax.swing.JEditorPane;

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
		contentPane.setBackground(new Color(60, 179, 113));
		
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int inicioancho=ancho/4;
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int inicioalto=alto/4;
		ancho=ancho/2;
		alto=alto/2;
		//setBounds()
		setBounds(inicioancho,inicioalto, ancho, alto);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\csmx.jpg"));
		lblNewLabel.setBounds(10, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(0, 0, 0));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		
		JButton btnNewButton_7 = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin obj=new VentanaLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_7.setBounds(304, 363, 143, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("Ver solicitudes de material");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaMaterial material=new VentanaMaterial();
				material.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(291, 164, 164, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Dar baja");
		btnNewButton_4.setBounds(304, 300, 143, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Dar alta");
		btnNewButton_3.setBounds(304, 266, 143, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton = new JButton("Modificar informaci\u00F3n");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnNewButton.setBounds(304, 232, 143, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCuentasDelClub = new JButton("Cuentas del Club");
		btnCuentasDelClub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		btnCuentasDelClub.setVerticalAlignment(SwingConstants.TOP);
		btnCuentasDelClub.setFont(new Font("Kalinga", Font.PLAIN, 11));
		btnCuentasDelClub.setBounds(304, 198, 143, 23);
		contentPane.add(btnCuentasDelClub);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		lblBienvenidoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblBienvenidoUsuario.setForeground(UIManager.getColor("Button.highlight"));
		lblBienvenidoUsuario.setBounds(207, 63, 240, 41);
		contentPane.add(lblBienvenidoUsuario);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\fondo2.jpg"));
		lblNewLabel_1.setBounds(131, 129, 500, 305);
		contentPane.add(lblNewLabel_1);
		
	}
}
