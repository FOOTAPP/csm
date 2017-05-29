package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GraphicsConfiguration;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Aviso;
import bbdd.BBDD_Empleado;
import clases.Aviso;

import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JLabel;
import javax.swing.JTextPane;
import javax.swing.JScrollBar;
import javax.swing.JProgressBar;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.time.LocalDateTime;
import java.util.Vector;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.DropMode;
import java.awt.Toolkit;

public class CrearAviso extends JFrame {

	protected static final java.lang.String String = null;
	private JPanel contentPane;
	private LocalDateTime hoy=LocalDateTime.now();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					CrearAviso frame = new CrearAviso(String);
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
	public CrearAviso(String dni) {
		setTitle("Crear Aviso");
		setIconImage(Toolkit.getDefaultToolkit().getImage(CrearAviso.class.getResource("/Resources/soccer.png")));
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
	
		BBDD_Empleado bd=new BBDD_Empleado("proyecto");
		BBDD_Aviso bd2=new BBDD_Aviso("proyecto");
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(0, 0, 213, 84);
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/csmx.jpg")));
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBounds(0, 0, 834, 84);
		editorPane.setBackground(new Color(1,3,64));
		contentPane.add(editorPane);
		
		JLabel completar = new JLabel("Rellene todos los campos");
		completar.setBounds(306, 337, 226, 14);
		completar.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		completar.setForeground(Color.WHITE);
		contentPane.add(completar);
		completar.setVisible(false);
		
		JLabel mismodni = new JLabel("Mismo dni");
		mismodni.setBounds(306, 312, 152, 14);
		mismodni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		mismodni.setForeground(Color.WHITE);
		contentPane.add(mismodni);
		mismodni.setVisible(false);
		
		JLabel lblIntroduceDni = new JLabel("Dni remitente:");
		lblIntroduceDni.setBounds(239, 162, 124, 14);
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDni.setForeground(Color.WHITE);
		contentPane.add(lblIntroduceDni);	
		
		JComboBox<String> dnicrea = new JComboBox<String>();
		dnicrea.setBounds(388, 159, 124, 20);
		contentPane.add(dnicrea);
		dnicrea.addItem(dni);
		
		JLabel lblMotivo = new JLabel("Motivo: ");
		lblMotivo.setBounds(239, 198, 81, 14);
		lblMotivo.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblMotivo.setForeground(Color.WHITE);
		contentPane.add(lblMotivo);
		
		JTextArea textArea = new JTextArea();
		textArea.setBounds(388, 195, 195, 71);
		contentPane.add(textArea);
		
		JLabel lblDniDestinatario = new JLabel("Dni destinatario:");
		lblDniDestinatario.setBounds(239, 287, 124, 14);
		lblDniDestinatario.setFont(new Font("Microsoft Tai Le", Font.BOLD, 15));
		lblDniDestinatario.setForeground(Color.WHITE);
		contentPane.add(lblDniDestinatario);
		
		JComboBox<String> dnidest = new JComboBox<String>();
		dnidest.setBounds(388, 281, 124, 20);
		contentPane.add(dnidest);
		for(String a : bd.buscarEmpleado()){
			if(dni.equals(a)){}
			else
			dnidest.addItem(a);
		}
			
		
		JButton btnNewButton = new JButton("Crear Aviso");
		btnNewButton.setBounds(506, 370, 124, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Vector<String> dest=new Vector<String>();
				dest.add((String) dnidest.getSelectedItem());
				if( textArea.getText().equals("") || dnidest.getSelectedItem().equals("") || dnicrea.getSelectedItem().equals(""))
					completar.setVisible(true);
				else
					if( dnidest.getSelectedItem().equals(dnicrea.getSelectedItem())){
						mismodni.setVisible(true);
						completar.setVisible(false);
					}
					else{
						Aviso av=new Aviso((String) dnicrea.getSelectedItem(), textArea.getText(), hoy, dest );
						bd2.crearAviso(av);
						VentanaOpcionesEntrenador obj2=new VentanaOpcionesEntrenador();
						obj2.setVisible(true);
						dispose();
					}
			}
		});
		contentPane.add(btnNewButton);
		
		String dnicompar=bd2.buscarEntrenador();
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.setBounds(210, 370, 89, 23);
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
		
		
		contentPane.add(btnVolver);
		Border border=LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(210, 131, 420, 262);
		lblNewLabel_1.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/fondobueno.jpg")));
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
		
	
		
	}	
}
