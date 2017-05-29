package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Aviso;

import javax.swing.UIManager;
import javax.swing.SwingConstants;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

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
		setTitle("Presidente");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaOpciones.class.getResource("/Resources/soccer.png")));
		BBDD_Aviso bd=new BBDD_Aviso("Proyecto");
		
		String dni=bd.buscarPresi();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 699, 519);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(38, 233, 78));
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int inicioancho=ancho/4;
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int inicioalto=alto/4;
		ancho=ancho/2;
		alto=alto/2;
		//setBounds()
		setBounds(inicioancho,inicioalto, ancho, alto);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
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
		btnNewButton_7.setBounds(355, 355, 143, 23);
		contentPane.add(btnNewButton_7);
		
		JButton btnNewButton_5 = new JButton("Leer Avisos");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeerAviso obj=new LeerAviso(dni);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(221, 163, 164, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Dar baja");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionDarBaja obj3= new OpcionDarBaja();
				obj3.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(454, 211, 164, 23);
		contentPane.add(btnNewButton_4);
		
		JButton btnNewButton_3 = new JButton("Dar alta");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionDarAlta obj3= new OpcionDarAlta();
				obj3.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(454, 163, 164, 23);
		contentPane.add(btnNewButton_3);
		
		JButton button = new JButton("Modificar cuentas");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				OpcionModificarCuenta obj3= new OpcionModificarCuenta(bd.buscarPresi());
				obj3.setVisible(true);
				dispose();
			}
		});
		button.setBounds(282, 260, 262, 23);
		contentPane.add(button);		
		
		JButton btnNewButton = new JButton("Exportar base de datos a XML");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				String direccion = "src\\Resources\\xml\\proyecto.xml";
				try{
					//Runtime.getRuntime().exec("rundll32 url.dll,FileProtocolHandler " + direccion);
					Runtime.getRuntime().exec("C:\\Program Files\\Mozilla Firefox\\firefox.exe "+direccion);
			    }
				catch(Exception err){
					JOptionPane.showMessageDialog(null,"Error: "+err);
				}
			}
		});
		btnNewButton.setBounds(282, 304, 262, 23);
		contentPane.add(btnNewButton);
		
		JButton btnCrearAviso = new JButton("Crear Aviso");
		btnCrearAviso.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearAviso obj = new CrearAviso(dni);
				obj.setVisible(true);
				dispose();
			}
		});
		btnCrearAviso.setBounds(221, 211, 164, 23);
		contentPane.add(btnCrearAviso);
		
		JLabel lblBienvenidoUsuario = new JLabel("Bienvenido Usuario");
		lblBienvenidoUsuario.setFont(new Font("Modern No. 20", Font.PLAIN, 20));
		lblBienvenidoUsuario.setHorizontalAlignment(SwingConstants.CENTER);
		lblBienvenidoUsuario.setVerticalAlignment(SwingConstants.TOP);
		lblBienvenidoUsuario.setForeground(UIManager.getColor("Button.highlight"));
		lblBienvenidoUsuario.setBounds(207, 63, 240, 41);
		contentPane.add(lblBienvenidoUsuario);
		
		Border border=LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFisio.class.getResource("/Resources/fondobueno.jpg")));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
		
	}
}
