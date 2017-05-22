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
import javax.swing.border.EmptyBorder;

import bbdd.BBDD_Fisio;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;

public class DarAltaMedica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
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
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		setTitle("Baja m\u00E9dica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setIconImage(new ImageIcon(getClass().getResource("soccer.png")).getImage());
		
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
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay jugadores disponibles");
		lblErrorNoHya.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(224, 352, 317, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(435, 222, 124, 20);
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
		btnGenerarBajaMedica.setBounds(336, 281, 182, 23);
		contentPane.add(btnGenerarBajaMedica);
		
		JLabel lblIntroduceDni = new JLabel("Seleccione el dni:");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(249, 223, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\fondo2.jpg"));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
	}
}
