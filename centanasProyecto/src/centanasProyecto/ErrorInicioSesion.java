package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Dialog.ModalExclusionType;

/**
 * Clase ErrorInicioSesion.
 */
public class ErrorInicioSesion extends JFrame {

	
	private JPanel contentPane;

	/**
	 Método main, lanzamiento.
	 *
	 * @param args
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					ErrorInicioSesion frame = new ErrorInicioSesion();
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
	public ErrorInicioSesion() {
		setModalExclusionType(ModalExclusionType.APPLICATION_EXCLUDE);
		setResizable(false);
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		contentPane = new JPanel();
		setIconImage(new ImageIcon(getClass().getResource("soccer.png")).getImage());
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		int ancho=java.awt.Toolkit.getDefaultToolkit().getScreenSize().width;
		
		int alto=java.awt.Toolkit.getDefaultToolkit().getScreenSize().height;
		
		ancho=ancho/4;
		
		alto=alto/4;
		int inicioancho=ancho+215;
		int inicioalto=alto*2-110;
		//setBounds()
		setBounds(inicioancho,inicioalto, ancho, alto);
		
		JLabel lblUsuarioOContrasea = new JLabel("Usuario o contrase\u00F1a incorrectos");
		lblUsuarioOContrasea.setFont(new Font("Arial Black", Font.BOLD, 14));
		lblUsuarioOContrasea.setBounds(95, 59, 291, 62);
		contentPane.add(lblUsuarioOContrasea);
		
		JButton btnOk = new JButton("OK");
		btnOk.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		btnOk.setBounds(142, 159, 129, 23);
		contentPane.add(btnOk);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("C:\\Users\\admin\\Desktop\\cancel.png"));
		lblNewLabel.setBounds(46, 73, 31, 37);
		contentPane.add(lblNewLabel);
	}

}
