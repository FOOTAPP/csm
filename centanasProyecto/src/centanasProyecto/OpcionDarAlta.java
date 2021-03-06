package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;

import javax.swing.ImageIcon;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;

/**
 * Clase OpcionDarAlta.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class OpcionDarAlta extends JFrame {

	
	private JPanel contentPane;

	/**
	  M�todo main, lanzamiento.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					OpcionDarAlta frame = new OpcionDarAlta();
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
	public OpcionDarAlta() {
		setTitle("Dar alta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(OpcionDarAlta.class.getResource("/Resources/soccer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setBackground(new Color(38, 233, 78));
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int inicioancho=ancho/4;
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int inicioalto=alto/4;
		ancho=ancho/2;
		alto=alto/2;
		//setBounds()
		setBounds(inicioancho,inicioalto, ancho, alto);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOpciones obj7= new VentanaOpciones();
				obj7.setVisible(true);
				dispose();
				
			}
		});
		btnVolver.setBounds(378, 294, 76, 23);
		contentPane.add(btnVolver);
		
		JButton btnDarAltaEmpleado = new JButton("Dar alta empleado");
		btnDarAltaEmpleado.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				DarAltaEmpleado2 obj= new DarAltaEmpleado2();
				obj.setVisible(true);
				dispose();
			}
		});
		btnDarAltaEmpleado.setBounds(348, 239, 151, 23);
		contentPane.add(btnDarAltaEmpleado);
		
		JButton btnDarAltaJugador = new JButton("Dar alta jugador");
		btnDarAltaJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DarAltaJugador2 obj= new DarAltaJugador2();
				obj.setVisible(true);
				dispose();
			}
		});
		btnDarAltaJugador.setBounds(348, 191, 151, 23);
		contentPane.add(btnDarAltaJugador);
		
		Border border=LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFisio.class.getResource("/Resources/fondobueno.jpg")));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
	}
}
