package centanasProyecto;

import java.awt.Color;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JEditorPane;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JTextField;
import javax.swing.border.Border;
import javax.swing.border.EmptyBorder;
import javax.swing.border.LineBorder;

import bbdd.BBDD_Jugador;
import clases.Jugador;
import java.awt.Toolkit;

public class ModificarCuentaJugador extends JFrame{
	protected static final String String = null;
	private JPanel contentPane;
	private JTextField nuevacuenta;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ModificarCuentaJugador frame = new ModificarCuentaJugador(String);
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

	public ModificarCuentaJugador(String dni) {
  setIconImage(Toolkit.getDefaultToolkit().getImage(ModificarCuentaJugador.class.getResource("/Resources/soccer.png")));
		BBDD_Jugador bd=new BBDD_Jugador("proyecto");
		setTitle("Modificar cuenta Jugador");
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 546, 367);
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
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon(VentanaOpcionesFisio.class.getResource("/Resources/csmx.jpg")));
		lblNewLabel.setBounds(0, 0, 213, 84);
		contentPane.add(lblNewLabel);
		
		JEditorPane editorPane = new JEditorPane();
		editorPane.setBackground(new Color(1,3,64));
		editorPane.setBounds(0, 0, 834, 84);
		contentPane.add(editorPane);
		
		JLabel lblErrorNoHya = new JLabel("Error, no hay jugadores disponibles");
		lblErrorNoHya.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblErrorNoHya.setForeground(Color.WHITE);
		lblErrorNoHya.setBounds(281, 274, 266, 14);
		contentPane.add(lblErrorNoHya);
		lblErrorNoHya.setVisible(false);
		
		JLabel rellenarcuenta = new JLabel("La cuenta introducida no es v\u00E1lida");
		rellenarcuenta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		rellenarcuenta.setForeground(Color.WHITE);
		rellenarcuenta.setBounds(281, 249, 278, 14);
		contentPane.add(rellenarcuenta);
		rellenarcuenta.setVisible(false);
		
		JLabel lblIntroduceDni = new JLabel("Seleccione dni:");
		lblIntroduceDni.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblIntroduceDni.setForeground(Color.WHITE);
		lblIntroduceDni.setBounds(223, 168, 155, 14);
		contentPane.add(lblIntroduceDni);
		
		JComboBox<String> comboBox = new JComboBox<String>();
		comboBox.setBounds(388, 167, 124, 20);
		contentPane.add(comboBox);		
		for(String a : bd.buscarJugadores())
			comboBox.addItem(a);
		
		JLabel lblNuevaCuenta = new JLabel("Nueva Cuenta:");
		lblNuevaCuenta.setFont(new Font("Microsoft YaHei", Font.BOLD, 15));
		lblNuevaCuenta.setForeground(Color.WHITE);
		lblNuevaCuenta.setBounds(223, 200, 155, 14);
		contentPane.add(lblNuevaCuenta);
		
		nuevacuenta = new JTextField();
		nuevacuenta.setBounds(388, 198, 229, 22);
		contentPane.add(nuevacuenta);
		nuevacuenta.setColumns(10);
		
		JButton modificarDatos = new JButton("Modificar datos bancarios");
		modificarDatos.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String dni = (String) comboBox.getSelectedItem();
				boolean valido=bd.validarCuenta(nuevacuenta.getText());
				int cuentaok=bd.buscarCuenta(nuevacuenta.getText());
				if (dni==null)
					lblErrorNoHya.setVisible(true);
				if(nuevacuenta.getText().equals("") || valido==false || cuentaok==1)
					rellenarcuenta.setVisible(true);
				else{
					Jugador j=new Jugador(dni, nuevacuenta.getText());
					bd.actualizarCuentaJugador(j);
					VentanaOpcionesFinanciero obj2=new VentanaOpcionesFinanciero();
					obj2.setVisible(true);
					dispose();
				}
			}
		});
		modificarDatos.setBounds(329, 316, 182, 23);
		contentPane.add(modificarDatos);
		
		
		JButton btnVolver = new JButton("Volver");
		btnVolver.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(dni.equals(bd.buscarPresi())){
					OpcionModificarCuenta obj4=new OpcionModificarCuenta(dni);
					obj4.setVisible(true);
					dispose();
				}
				else{
					VentanaOpcionesFinanciero obj4=new VentanaOpcionesFinanciero();
					obj4.setVisible(true);
					dispose();
				}
			}
		});
		btnVolver.setBounds(373, 370, 89, 23);
		contentPane.add(btnVolver);
		
		Border border=LineBorder.createBlackLineBorder();
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setBounds(0, 0, 0, 0);
		lblNewLabel_1.setFont(new Font("Informal Roman", Font.PLAIN, 11));
		lblNewLabel_1.setIcon(new ImageIcon(VentanaOpcionesFinanciero.class.getResource("/Resources/fondobueno.jpg")));
		contentPane.add(lblNewLabel_1);
		lblNewLabel_1.setBounds(ancho/4, alto/4, ancho/2, alto/2);
		lblNewLabel_1.setBorder(border);
		
	}
	
}
