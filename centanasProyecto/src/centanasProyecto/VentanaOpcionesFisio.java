package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.JEditorPane;
import java.awt.Toolkit;

/**
 * Class VentanaOpcionesFisio.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class VentanaOpcionesFisio extends JFrame {

	
	private JPanel contentPane;

	/**
	 * M�todo main.
	 *
	 * @param args
	 *            the arguments
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaOpcionesFisio frame = new VentanaOpcionesFisio();
					frame.setVisible(true);
					frame.setLocationRelativeTo(null);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public VentanaOpcionesFisio() {
		Border border = LineBorder.createBlackLineBorder();
		setTitle("Fisioterapeuta");
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaOpcionesFisio.class.getResource("/Resources/soccer.png")));
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setForeground(new Color(154, 205, 50));
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
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFisio.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JButton btnNewButton_3 = new JButton("Cerrar Sesi\u00F3n");
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaLogin obj= new VentanaLogin();
				obj.setVisible(true);
				dispose();
			}
		});
		
		JButton btnGenerarInforme = new JButton("Generar informe");
		btnGenerarInforme.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				VentanaGenerarInforme obj3=new VentanaGenerarInforme();
				obj3.setVisible(true);
				dispose();
			}
		});
		btnGenerarInforme.setBounds(338, 229, 161, 23);
		contentPane.add(btnGenerarInforme);
		btnNewButton_3.setBounds(338, 349, 161, 23);
		contentPane.add(btnNewButton_3);
		
		JButton btnNewButton_2 = new JButton("Dar alta medica");
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				DarAltaMedica obj=new DarAltaMedica();
			    obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_2.setBounds(338, 280, 161, 23);
		contentPane.add(btnNewButton_2);
		
		JButton btnNewButton_1 = new JButton("Dar baja medica");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ventanabajamedica obj=new ventanabajamedica();
				obj.setVisible(true);
				dispose();
			}
		});
		btnNewButton_1.setBounds(338, 180, 161, 23);
		contentPane.add(btnNewButton_1);
		
		JEditorPane editorPane1 = new JEditorPane();
		editorPane1.setBounds(0, 0, 106, 20);
		contentPane.add(editorPane1);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFisio.class.getResource("/Resources/fondobueno.jpg")));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
	}
}
