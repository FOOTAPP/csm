package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
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
		setIconImage(new ImageIcon(getClass().getResource("soccer.png")).getImage());
		contentPane.setBackground(new Color(60, 179, 113));
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
		lblErrorNoHya.setBounds(224, 352, 317, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\csmx.jpg"));
		lblNewLabel.setBounds(10, 0, 213, 84);
		contentPane.add(lblNewLabel);
		

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(0, 0, 0));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(465, 220, 124, 20);
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
		btnGenerarBajaMedica.setBounds(343, 284, 182, 23);
		contentPane.add(btnGenerarBajaMedica);
		
		JLabel lblIntroduceDni = new JLabel("Seleccione el dni:");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(287, 223, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\fondo2.jpg"));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
	}
}
