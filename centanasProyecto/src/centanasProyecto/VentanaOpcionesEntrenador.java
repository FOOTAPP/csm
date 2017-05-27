package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Aviso;
import java.awt.Toolkit;

/**
 * The Class VentanaOpcionesEntrenador.
 */
public class VentanaOpcionesEntrenador extends JFrame {

	/** The content pane. */
	private JPanel contentPane;

	/**
	 * Launch the application.
	 *
	 * @param args
	 *            the arguments
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
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaOpcionesEntrenador.class.getResource("/Resources/soccer.png")));
		setTitle("Entrenador");
		BBDD_Aviso bd=new BBDD_Aviso("Proyecto");
		
		String dni=bd.buscarEntrenador();
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 716, 515);
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
		
		JButton btnNewButton = new JButton("Crear Aviso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				CrearAviso obj = new CrearAviso(dni);
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton.setBounds(229, 163, 180, 23);
		contentPane.add(btnNewButton);
		
		JButton btnLeerAvisos = new JButton("Leer Avisos");
		btnLeerAvisos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				LeerAviso obj = new LeerAviso(dni);
				obj.setVisible(true);
				dispose();
			}
		});
		btnLeerAvisos.setBounds(437, 163, 180, 23);
		contentPane.add(btnLeerAvisos);
		
		JButton btnNewButton_2 = new JButton("Dar alta jugador");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarAltaJugador obj2 = new DarAltaJugador();
				obj2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(229, 206, 180, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_3 = new JButton("Dar baja jugador");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarBajaJugador obj = new DarBajaJugador();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_3.setBounds(437, 206, 180, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnDarAltaCuerpo = new JButton("Dar alta cuerpo tecnico");
		btnDarAltaCuerpo.addActionListener(new ActionListener(){
			public void actionPerformed(ActionEvent e) {
				DarAltaEmpleado obj = new DarAltaEmpleado();
				obj.setVisible(true);
				dispose();
			}
		});
		btnDarAltaCuerpo.setBounds(229, 260, 180, 23);
		contentPane.add(btnDarAltaCuerpo);
		//holaaaa
		JButton btnNewButton_5 = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaLogin obj2=new VentanaLogin();
				obj2.setVisible(true);
				dispose();
			}
		});
		btnNewButton_5.setBounds(348, 317, 162, 23);
		contentPane.add(btnNewButton_5);
		
		JButton btnNewButton_4 = new JButton("Dar baja cuerpo tecnico");
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarBajaEmpleado obj = new DarBajaEmpleado();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_4.setBounds(437, 260, 180, 23);
		contentPane.add(btnNewButton_4);
		
		
		Border border=LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 0, 0);
		lblNewLabel_1.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/fondobueno.jpg")));
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		lblNewLabel_1.setBorder(border);
	}
}
