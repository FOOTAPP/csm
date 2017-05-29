package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
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
					frame.setLocationRelativeTo(null);
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
		Border border = LineBorder.createBlackLineBorder();
		setResizable(false);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaLogin.class.getResource("/Resources/soccer.png")));
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
		contentPane.setBackground(new Color(38, 233, 78));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		
		contentPane.setLayout(null);
		
		JButton btnNewButton = new JButton("");
		btnNewButton.setForeground(SystemColor.infoText);
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 11));
		btnNewButton.setBackground(SystemColor.scrollbar);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		btnNewButton.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Resources/power-button-off.png")));
		btnNewButton.setBounds(439, 317, 77, 65);
		contentPane.add(btnNewButton);
		
		JLabel lblUsuario = new JLabel("Usuario:");
		lblUsuario.setFont(new Font("Lucida Sans", Font.BOLD, 15));
		lblUsuario.setForeground(Color.WHITE);
		lblUsuario.setBackground(UIManager.getColor("Button.darkShadow"));
		lblUsuario.setBounds(282, 214, 102, 23);
		contentPane.add(lblUsuario);
		
		JLabel lblContrasea = new JLabel("Contrase\u00F1a: ");
		lblContrasea.setFont(new Font("Lucida Sans", Font.BOLD, 16));
		lblContrasea.setForeground(Color.WHITE);
		lblContrasea.setBackground(Color.BLACK);
		lblContrasea.setBounds(282, 237, 141, 33);
		contentPane.add(lblContrasea);
		
		JButton btnIniciciarSesion = new JButton("");
		btnIniciciarSesion.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Resources/login.png")));
		btnIniciciarSesion.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("presidente") && passwordField.getText().equals("presidente")){
					VentanaOpciones obj=new VentanaOpciones();
					obj.setVisible(true);
					dispose();
				}
				else
					if(textField.getText().equals("entrenador") && passwordField.getText().equals("entrenador")){
						VentanaOpcionesEntrenador obj2= new VentanaOpcionesEntrenador();
						obj2.setVisible(true);
						dispose();
					}
					else
						if(textField.getText().equals("financiero") && passwordField.getText().equals("financiero")){
							VentanaOpcionesFinanciero obj3= new VentanaOpcionesFinanciero();
							obj3.setVisible(true);
							dispose();
						}
						else
							if(textField.getText().equals("fisio") && passwordField.getText().equals("fisio")){
								VentanaOpcionesFisio obj4= new VentanaOpcionesFisio();
								obj4.setVisible(true);
								dispose();
							}
							else
								JOptionPane.showMessageDialog(null,"Usuario o contraseña incorrecto.");
			}
		});
		
		textField = new JTextField();
		textField.setBounds(388, 217, 161, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		passwordField = new JPasswordField();
		passwordField.setBounds(388, 245, 161, 20);
		contentPane.add(passwordField);
		
		btnIniciciarSesion.setForeground(SystemColor.infoText);
		btnIniciciarSesion.setFont(new Font("Kartika", Font.BOLD, 14));
		btnIniciciarSesion.setBackground(SystemColor.scrollbar);
		btnIniciciarSesion.setBounds(321, 317, 77, 65);
		contentPane.add(btnIniciciarSesion);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1, 3, 64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaLogin.class.getResource("/Resources/fondobueno.jpg")));
		lblNewLabel_1.setBounds(267, 169, 305, 243);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
	}
}
