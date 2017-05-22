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
import javax.swing.JEditorPane;
import javax.swing.JDialog;

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
		contentPane.setBackground(new Color(60, 179, 113));
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
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\csmx.jpg"));
		lblNewLabel.setBounds(10, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		btnNewButton.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\WorkSpaceEclipse\\centanasProyecto\\power-button-off.png"));
		btnNewButton.setBounds(573, 131, 57, 42);
		contentPane.add(btnNewButton);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(377, 284, 161, 20);
		contentPane.add(passwordField);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Arial Black", Font.BOLD, 16));
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBackground(Color.BLACK);
		lblContrasea.setBounds(226, 275, 141, 33);
		contentPane.add(lblContrasea);
		
		textField = new JTextField();
		textField.setBounds(377, 222, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Arial Black", Font.BOLD, 15));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBackground(UIManager.getColor("Button.darkShadow"));
		lblUsuario.setBounds(226, 219, 102, 23);
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
					//JDialog obj14=new JDialog(this);
					//obj14.setModal(true);
				
					//obj14.setBounds(100, 100, 450, 300);
					//OtroErrorInicioSesion obj14=new OtroErrorInicioSesion();
					//ErrorInicioSesion obj14=new ErrorInicioSesion();
					//obj14.setVisible(true);
				}
			}
		});
		btnIniciciarSesion.setForeground(SystemColor.infoText);
		btnIniciciarSesion.setFont(new Font("Kartika", Font.BOLD, 14));
		btnIniciciarSesion.setBackground(SystemColor.scrollbar);
		btnIniciciarSesion.setBounds(324, 345, 172, 33);
		contentPane.add(btnIniciciarSesion);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(0, 0, 0));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\fondo2.jpg"));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
		setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{contentPane, btnNewButton, passwordField, lblContrasea, textField, lblUsuario, btnIniciciarSesion}));
	}
}
