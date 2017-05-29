package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.GraphicsConfiguration;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;
import javax.swing.text.Caret;

import bbdd.BBDD_Aviso;
import clases.Aviso;
import javax.swing.JFormattedTextField;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JTextPane;
import java.awt.Toolkit;

public class LeerAviso2 extends JFrame{
	
	protected static final Aviso Aviso = null;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	protected static String dni;

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

	public LeerAviso2(Aviso av, String dni) {
		setTitle("Aviso");
		setIconImage(Toolkit.getDefaultToolkit().getImage(LeerAviso2.class.getResource("/Resources/soccer.png")));
		
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
		contentPane.setLayout(null);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				LeerAviso obj4=new LeerAviso(dni);
				obj4.setVisible(true);
				dispose();
				
			}
		});
		btnVolver.setBounds(394, 347, 89, 23);
		contentPane.add(btnVolver);
		
		textField = new JTextField();
		textField.setEditable(false);
		textField.setBounds(240, 170, 86, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		textField.setText(av.getDni_emple());
		
		JTextPane textPane = new JTextPane();
		textPane.setEditable(false);
		textPane.setBounds(240, 212, 282, 68);
		contentPane.add(textPane);
		textPane.setText(av.getMotivo());
		
		String fecha=av.getDate().toString();
		
		textField_1 = new JTextField();
		textField_1.setEditable(false);
		textField_1.setBounds(240, 302, 86, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		textField_1.setText(fecha);
		
		Border border=LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFisio.class.getResource("/Resources/fondobueno.jpg")));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
	}
}
