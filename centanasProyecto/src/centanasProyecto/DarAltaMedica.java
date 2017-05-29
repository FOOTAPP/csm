package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Fisio;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import java.awt.Toolkit;

/**
 * Clase DarAltaMedica.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class DarAltaMedica extends JFrame {

	
	private JPanel contentPane;

	/**
	 * Método main, lanzamiento.
	 *
	 * @param args
	 *        
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					DarAltaMedica frame = new DarAltaMedica();
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
	public DarAltaMedica() {
		Border border = LineBorder.createBlackLineBorder();
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		setTitle("Baja m\u00E9dica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(Toolkit.getDefaultToolkit().getImage(DarAltaMedica.class.getResource("/Resources/soccer.png")));
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		contentPane.setBackground(new Color(60, 179, 113));
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
		lblNewLabel.setIcon(new ImageIcon(DarAltaMedica.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay jugadores disponibles");
		lblErrorNoHya.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(275, 316, 317, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(437, 195, 124, 20);
		contentPane.add(comboBox);		
		for(String a : bd.buscarJugadoresLesionados("Si"))
			comboBox.addItem(a);
		
		
		
		JButton btnGenerarBajaMedica = new JButton("Generar alta medica");
		btnGenerarBajaMedica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String) comboBox.getSelectedItem();
				if (dni==null)
					lblErrorNoHya.setVisible(true);
				else{
				
				bd.darAltaMedica(dni);
				
				VentanaGenerarInforme obj2=new VentanaGenerarInforme(dni);
				obj2.setVisible(true);
				dispose();
				}
			}
		});
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaOpcionesFisio obj2=new VentanaOpcionesFisio();
				obj2.setVisible(true);
				dispose();
			}
		});
		
		
		btnVolver.setBounds(541, 370, 89, 23);
		contentPane.add(btnVolver);
		btnGenerarBajaMedica.setBounds(338, 260, 182, 23);
		contentPane.add(btnGenerarBajaMedica);
		
		JLabel lblIntroduceDni = new JLabel("Seleccione el dni:");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(240, 196, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(DarAltaMedica.class.getResource("/Resources/fondobueno.jpg")));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
	}
}
