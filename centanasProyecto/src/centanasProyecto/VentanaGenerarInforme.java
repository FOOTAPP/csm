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


public class VentanaGenerarInforme extends JFrame {

	private JPanel contentPane;

	private static boolean  validadodnijugador=true;
	private static boolean  validadodniemple=true;
	private JTextField textField;
	private JTextField textField_1;
	private String dnijugador;
	private String dniemple;
	JComboBox comboBox = new JComboBox();
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaGenerarInforme frame = new VentanaGenerarInforme();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	
	private void pintarVentana(){
		Border border = LineBorder.createBlackLineBorder();
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setIconImage(Toolkit.getDefaultToolkit().getImage(VentanaGenerarInforme.class.getResource("/Resources/soccer.png")));
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
		lblNewLabel.setIcon(new ImageIcon(VentanaGenerarInforme.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		

		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		
		JLabel lblErrorFaltanCampos = new JLabel("Rellene todos los campos");
		lblErrorFaltanCampos.setFont(new Font("Arial Black", Font.BOLD, 13));
		lblErrorFaltanCampos.setForeground(Color.WHITE);
		lblErrorFaltanCampos.setBounds(307, 313, 317, 14);
		contentPane.add(lblErrorFaltanCampos);
		lblErrorFaltanCampos.setVisible(false);
		lblErrorFaltanCampos.setVisible(false);
		
		comboBox.setBounds(422, 167, 153, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(422, 197, 153, 20);
		contentPane.add(comboBox_1);
		for(String a : bd.buscarFisioterapeutas())
			comboBox_1.addItem(a);
		dniemple=(String) comboBox_1.getSelectedItem();
		
		textField_1 = new JTextField();
		textField_1.setBounds(422, 256, 153, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(422, 228, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		lblErrorFaltanCampos.setForeground(Color.WHITE);
		lblErrorFaltanCampos.setBounds(299, 324, 227, 14);
		contentPane.add(lblErrorFaltanCampos);
		
		JButton btnGenerarBajaMedica = new JButton("Generar informe");
		btnGenerarBajaMedica.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if(textField.getText().equals("")||textField_1.getText().equals("")){
					lblErrorFaltanCampos.setVisible(true);
				}
				else{
					
					String motivo=textField.getText();
					String diagnostico=textField_1.getText();
						BBDD_Fisio bd=new BBDD_Fisio("proyecto");
						LocalDateTime hoy=LocalDateTime.now();
						Tratamiento t=new Tratamiento(dnijugador,motivo,dniemple,diagnostico,hoy);
						bd.nuevaSesion(t);
						VentanaOpcionesFisio obj2=new VentanaOpcionesFisio();
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
		btnVolver.setBounds(210, 370, 89, 23);
		contentPane.add(btnVolver);
		btnGenerarBajaMedica.setBounds(448, 370, 182, 23);
		contentPane.add(btnGenerarBajaMedica);
		

		
		JLabel lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setBounds(266, 257, 117, 14);
		lblDiagnostico.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblDiagnostico.setForeground(Color.WHITE);
		contentPane.add(lblDiagnostico);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setBounds(266, 227, 101, 14);
		lblMotivo.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblMotivo.setForeground(Color.WHITE);
		contentPane.add(lblMotivo);
		
		
		
		JLabel lblIntroduceDniDel = new JLabel("Dni fisio: ");
		lblIntroduceDniDel.setBounds(266, 198, 134, 14);
		lblIntroduceDniDel.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDniDel.setForeground(Color.WHITE);
		contentPane.add(lblIntroduceDniDel);
		
		JLabel lblIntroduceDni = new JLabel("Dni jugador:");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(266, 168, 134, 14);
		contentPane.add(lblIntroduceDni);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(VentanaGenerarInforme.class.getResource("/Resources/fondobueno.jpg")));
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBorder(border);
	}
	
	public VentanaGenerarInforme(String dni){
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		pintarVentana();
		comboBox.addItem(dni);
		dnijugador= (String) comboBox.getSelectedItem();
	}
	
	public VentanaGenerarInforme() {
		setTitle("Informe");
		pintarVentana();
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		for(String a : bd.buscarJugadores())
			comboBox.addItem(a);
		
		
		
		
	}
}
