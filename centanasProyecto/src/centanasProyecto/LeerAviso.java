package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Vector;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextPane;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Aviso;
import bbdd.BBDD_Empleado;
import clases.Aviso;

/**
 * Clase LeerAviso.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class LeerAviso extends JFrame{
	
	
	protected static final String String = null;
	private JPanel contentPane;

	/**
	 * Método main.
	 *
	 * @param args
	 *        
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeerAviso frame = new LeerAviso(String);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor LeerAviso .
	 *
	 * @param dni
	 *           
	 */
	public LeerAviso(String dni) {
		
		BBDD_Aviso bd=new BBDD_Aviso("proyecto");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
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
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay avisos disponibles");
		lblErrorNoHya.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(275, 226, 273, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JComboBox<Aviso> avisos = new JComboBox<Aviso>();
		avisos.setBounds(233, 175, 386, 20);
		contentPane.add(avisos);
		for(Aviso b : bd.leerAvisos(dni))
			avisos.addItem(b);
		
		JButton btnNewButton = new JButton("Leer Aviso");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Aviso a;
				a=(Aviso) avisos.getSelectedItem();
				if(avisos.getSelectedItem() == null)
					lblErrorNoHya.setVisible(true);
				LeerAviso2 obj = new LeerAviso2(a,dni);
				obj.setVisible(true);
				dispose();
			}
		});
		
		btnNewButton.setBounds(367, 286, 124, 23);
		contentPane.add(btnNewButton);
		
		String dnicompar=bd.buscarEntrenador();
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dni.equals(dnicompar)){
					VentanaOpcionesEntrenador obj4=new VentanaOpcionesEntrenador();
					obj4.setVisible(true);
					dispose();
				}
				else{
					VentanaOpciones obj4=new VentanaOpciones();
					obj4.setVisible(true);
					dispose();
				}
					
				
			}
		});
		btnVolver.setBounds(383, 351, 89, 23);
		contentPane.add(btnVolver);
		
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
