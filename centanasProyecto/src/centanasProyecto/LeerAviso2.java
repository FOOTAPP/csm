package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.text.Caret;

import bbdd.BBDD_Aviso;
import clases.Aviso;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;

/**
 * Clase LeerAviso2.
 * @author Pablo Zarzalejo
 * @author Jose Angel Moro
 * @author Ellioth Fernandez C.
 * @author David Valverde Oria
 * @version 29.05.2017
 */
public class LeerAviso2 extends JFrame{
	
	
	protected static final Aviso Aviso = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	protected static String dni;

	/**
	 * Metodo main.
	 *
	 * @param args
	 *          
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					LeerAviso2 frame = new LeerAviso2(Aviso, dni);
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Constructor LeerAviso2.
	 *
	 * @param av
	 *            
	 * @param dni
	 *           
	 */
	public LeerAviso2(Aviso av, String dni) {
		
		BBDD_Aviso bd=new BBDD_Aviso("proyecto");
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeerAviso obj4=new LeerAviso(dni);
				obj4.setVisible(true);
				dispose();
				
			}
		});
		btnVolver.setBounds(10, 228, 89, 23);
		contentPane.add(btnVolver);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(107, 29, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(av.getDni_emple());
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(107, 77, 282, 68);
		contentPane.add(textPane);
		textPane.setText(av.getMotivo());
		
		String fecha=av.getDate().toString();
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(107, 170, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(fecha);
		
	}
}
