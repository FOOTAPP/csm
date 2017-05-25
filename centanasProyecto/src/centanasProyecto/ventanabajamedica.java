package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Fisio;

import javax.swing.JLabel;
import javax.swing.ImageIcon;
import java.awt.Color;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;

import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.UIManager;
import java.awt.Toolkit;

public class ventanabajamedica extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ventanabajamedica frame = new ventanabajamedica();
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
	public ventanabajamedica() {
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		setTitle("Baja m\u00E9dica");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		setIconImage(Toolkit.getDefaultToolkit().getImage(ventanabajamedica.class.getResource("/Resources/soccer.png")));
		contentPane.setBackground(new Color(38, 233, 78));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		int inicioancho=ancho/4;
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		int inicioalto=alto/4;
		ancho=ancho/2;
		alto=alto/2;
		//setBounds()
		setBounds(inicioancho,inicioalto, ancho, alto);
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay jugadores disponibles");
		lblErrorNoHya.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(268, 315, 317, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(ventanabajamedica.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(447, 193, 124, 20);
		contentPane.add(comboBox);
		for(String a : bd.buscarJugadoresLesionados("No"))
			comboBox.addItem(a);
		
		
		JButton btnGenerarBajaMedica = new JButton("Generar baja medica");
		btnGenerarBajaMedica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String) comboBox.getSelectedItem();
				if(dni==null)
					lblErrorNoHya.setVisible(true);
				else{
					bd.darBajaMedica(dni);
					VentanaGenerarInforme obj2=new VentanaGenerarInforme(dni);
					obj2.setVisible(true);
					dispose();
				}
				
			}
		});
		
		JButton btnAtras = new JButton("Volver");
		btnAtras.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				VentanaOpcionesFisio obj2=new VentanaOpcionesFisio();
				obj2.setVisible(true);
				dispose();
			}
		});
		
		
		btnAtras.setBounds(541, 370, 89, 23);
		contentPane.add(btnAtras);
		btnGenerarBajaMedica.setBounds(343, 254, 182, 23);
		contentPane.add(btnGenerarBajaMedica);
		
		JLabel lblIntroduceDni = new JLabel("Seleccione el dni:");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(254, 194, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		Border border = LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(ventanabajamedica.class.getResource("/Resources/fondobueno.jpg")));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
	}
}
