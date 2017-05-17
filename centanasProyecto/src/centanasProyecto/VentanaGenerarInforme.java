package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
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
import javax.swing.JComboBox;


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
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblErrorFaltanCampos = new JLabel("Error, faltan campos por rellenar");
		lblErrorFaltanCampos.setVisible(false);
		
		comboBox.setBounds(209, 66, 153, 20);
		contentPane.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(209, 97, 153, 20);
		contentPane.add(comboBox_1);
		for(String a : bd.buscarFisioterapeutas())
			comboBox_1.addItem(a);
		dniemple=(String) comboBox_1.getSelectedItem();
		
		textField_1 = new JTextField();
		textField_1.setBounds(209, 147, 153, 20);
		contentPane.add(textField_1);
		textField_1.setColumns(10);
		
		textField = new JTextField();
		textField.setBounds(209, 122, 153, 20);
		contentPane.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("Formato dni no valido");
		lblNewLabel_2.setForeground(Color.WHITE);
		lblNewLabel_2.setBounds(385, 75, 145, 14);
		contentPane.add(lblNewLabel_2);
		
		lblErrorFaltanCampos.setForeground(Color.WHITE);
		lblErrorFaltanCampos.setBounds(68, 221, 227, 14);
		contentPane.add(lblErrorFaltanCampos);
		lblNewLabel_2.setVisible(false);
		
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
		btnVolver.setBounds(0, 306, 89, 23);
		contentPane.add(btnVolver);
		btnGenerarBajaMedica.setBounds(301, 278, 182, 23);
		contentPane.add(btnGenerarBajaMedica);
		

		
		JLabel lblDiagnostico = new JLabel("Diagnostico:");
		lblDiagnostico.setForeground(Color.WHITE);
		lblDiagnostico.setBounds(68, 150, 117, 14);
		contentPane.add(lblDiagnostico);
		
		JLabel lblMotivo = new JLabel("Motivo:");
		lblMotivo.setForeground(Color.WHITE);
		lblMotivo.setBounds(68, 125, 134, 14);
		contentPane.add(lblMotivo);
		
		
		
		JLabel lblIntroduceDniDel = new JLabel("Introduce dni del empleado:");
		lblIntroduceDniDel.setForeground(Color.WHITE);
		lblIntroduceDniDel.setBounds(68, 100, 155, 14);
		contentPane.add(lblIntroduceDniDel);
		
		JLabel lblIntroduceDni = new JLabel("Introduce dni del jugador:");
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(68, 75, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\Proyecto csm\\ventanas proyecto\\fondo2.jpg"));
		lblNewLabel.setBounds(0, 0, 530, 329);
		contentPane.add(lblNewLabel);
		
	}
	
	public VentanaGenerarInforme(String dni){
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		pintarVentana();
		comboBox.addItem(dni);
		dnijugador= (String) comboBox.getSelectedItem();
	}
	
	public VentanaGenerarInforme() {
		pintarVentana();
		BBDD_Fisio bd=new BBDD_Fisio("proyecto");
		for(String a : bd.buscarJugadores())
			comboBox.addItem(a);
		
		
		
		
	}
}
