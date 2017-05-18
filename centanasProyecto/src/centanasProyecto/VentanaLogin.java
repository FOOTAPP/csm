package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;


import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.SystemColor;
import java.awt.Toolkit;
import java.awt.Font;
import java.awt.Image;
import java.awt.Color;
import javax.swing.UIManager;
import javax.swing.JPasswordField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;
import java.awt.Dialog.ModalExclusionType;
import java.awt.event.FocusAdapter;
import java.awt.event.FocusEvent;

public class VentanaLogin extends JFrame {

	private static VentanaLogin frame;
	private JPanel contentPane;
	private JTextField textField;
	private JPasswordField passwordField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaLogin frame = new VentanaLogin();
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
	
	
	
	public VentanaLogin() {
		setResizable(false);
		setIconImage(new ImageIcon(getClass().getResource("soccer.png")).getImage());
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setTitle("Login");
		setBackground(Color.WHITE);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int inicioancho=ancho/4;
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int inicioalto=alto/4;
		ancho=ancho/2;
		alto=alto/2;
		//setBounds()
		setBounds(inicioancho,inicioalto, ancho, alto);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(102, 153, 51));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(Color.WHITE);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBackground(Color.WHITE);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\WorkSpaceEclipse\\centanasProyecto\\power-button-off.png"));
		btnNewButton.setBounds(767, 455, 57, 42);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(312, 118, 161, 20);
		contentPane.add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBackground(Color.BLACK);
		lblContrasea.setBounds(224, 121, 86, 14);
		contentPane.add(lblContrasea);
		
		JLabel error = new JLabel("Error, usuario o contrase\u00F1a incorrectos");
		error.setForeground(Color.WHITE);
		error.setBounds(65, 371, 243, 14);
		contentPane.add(error);
		error.setVisible(false);
		
		textField = new JTextField();
		textField.setBounds(312, 88, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBackground(UIManager.getColor("Button.darkShadow"));
		lblUsuario.setBounds(224, 87, 86, 23);
		contentPane.add(lblUsuario);
		
		JButton btnIniciciarSesion = new JButton("Iniciciar Sesion");
		btnIniciciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("presidente") && passwordField.getText().equals("presidente")){
					VentanaOpciones obj=new VentanaOpciones();
					obj.setVisible(true);
					dispose();
				}
				if(textField.getText().equals("entrenador") && passwordField.getText().equals("entrenador")){
					VentanaOpcionesEntrenador obj2= new VentanaOpcionesEntrenador();
					obj2.setVisible(true);
					dispose();
				}
				if(textField.getText().equals("financiero") && passwordField.getText().equals("financiero")){
					VentanaOpcionesFinanciero obj3= new VentanaOpcionesFinanciero();
					obj3.setVisible(true);
					dispose();
				}
				if(textField.getText().equals("fisio") && passwordField.getText().equals("fisio")){
					VentanaOpcionesFisio obj4= new VentanaOpcionesFisio();
					obj4.setVisible(true);
					dispose();
				}
				else{
					if(textField.getText().equals("presidente")){
						lblUsuario.setForeground(Color.GREEN);;
						lblContrasea.setForeground(Color.RED);
					}
					if(passwordField.getText().equals("presidente")){
						lblUsuario.setForeground(Color.RED);
						lblContrasea.setForeground(Color.GREEN);
					}
					error.setVisible(true);
				}
			}
		});
		btnIniciciarSesion.setForeground(UIManager.getColor("Button.darkShadow"));
		btnIniciciarSesion.setFont(new Font("Verdana", Font.PLAIN, 11));
		btnIniciciarSesion.setBackground(UIManager.getColor("Button.background"));
		btnIniciciarSesion.setBounds(239, 165, 134, 23);
		contentPane.add(btnIniciciarSesion);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, btnNewButton, passwordField, lblContrasea, error, textField, lblUsuario, btnIniciciarSesion}));
	}
}
