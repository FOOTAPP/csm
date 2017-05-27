package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Aviso;

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
		BBDD_Aviso bd=new BBDD_Aviso("Proyecto");
		
		String dni=bd.buscarPresi();
		
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
		btnNewButton_7.setBounds(131, 411, 143, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("Leer Avisos");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeerAviso obj=new LeerAviso(dni);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(186, 163, 164, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Dar baja");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionDarBaja obj3= new OpcionDarBaja();
				obj3.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(467, 211, 164, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Dar alta");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionDarAlta obj3= new OpcionDarAlta();
				obj3.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(467, 163, 164, 23);
		contentPane.add(btnNewButton_3);
		
		JButton button = new JButton("Modificar cuentas");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionModificarCuenta obj3= new OpcionModificarCuenta(bd.buscarPresi());
				obj3.setVisible(true);
				dispose();
			}
		});
		button.setBounds(282, 270, 262, 23);
		contentPane.add(button);		
		
		JButton btnNewButton = new JButton("Exportar base de datos a XML");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String direccion = "xml\\proyecto.xml";
				try
				                {
									//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccion);
									Runtime.getRuntime().exec("C:\\Program Files (x86)\\Mozilla Firefox\\firefox.exe "+direccion);
				                }
				                catch(Exception err)
				                {
				                    JOptionPane.showMessageDialog(null,"Error: "+err);
				                }
			}
		});
		btnNewButton.setBounds(282, 345, 262, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCrearAviso = new JButton("Crear Aviso");
		btnCrearAviso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearAviso obj = new CrearAviso(dni);
				obj.setVisible(true);
				dispose();
			}
		});
		btnCrearAviso.setBounds(186, 211, 164, 23);
		contentPane.add(btnCrearAviso);
		
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
