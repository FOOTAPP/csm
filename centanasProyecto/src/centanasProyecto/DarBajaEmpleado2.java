package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Empleado;
import java.awt.Toolkit;

/**
 * Clase DarBajaEmpleado2.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class DarBajaEmpleado2 extends JFrame{

	
	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Método main, lanzamiento.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarBajaEmpleado2 frame = new DarBajaEmpleado2();
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
	public DarBajaEmpleado2() {
		setIconImage(Toolkit.getDefaultToolkit().getImage(DarBajaEmpleado2.class.getResource("/Resources/soccer.png")));
		BBDD_Empleado bd=new BBDD_Empleado("proyecto");
		setTitle("Dar baja empleado");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
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
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 213, 84);
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/csmx.jpg")));
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(0, 0, 834, 84);
		editorPane.setBackground(new Color(1,3,64));
		contentPane.add(editorPane);
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay empleados disponibles");
		lblErrorNoHya.setFont(new Font("Microsoft YaHei", Font.BOLD, 11));
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(336, 219, 229, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(441, 170, 124, 20);
		contentPane.add(comboBox);		
		for(String a : bd.buscarEmpleado())
			comboBox.addItem(a);
		
		
		
		JButton darBajaJugador = new JButton("Dar baja");
		darBajaJugador.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String) comboBox.getSelectedItem();
				if (dni==null)
					lblErrorNoHya.setVisible(true);
				else{
				bd.borrarEmpleado(dni);
				VentanaOpciones obj4=new VentanaOpciones();
				obj4.setVisible(true);
				dispose();
				
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOpciones obj4=new VentanaOpciones();
				obj4.setVisible(true);
				dispose();
				
			}
		});
		
		
		btnVolver.setBounds(385, 324, 89, 23);
		contentPane.add(btnVolver);
		darBajaJugador.setBounds(341, 257, 182, 23);
		contentPane.add(darBajaJugador);
		
		JLabel lblIntroduceDni = new JLabel("Seleccione dni: ");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDni.setBounds(265, 171, 155, 14);
		lblIntroduceDni.setForeground(Color.WHITE);
		contentPane.add(lblIntroduceDni);
		
		Border border=LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(210, 131, 420, 262);
		lblNewLabel_1.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/fondobueno.jpg")));
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
	}
}
