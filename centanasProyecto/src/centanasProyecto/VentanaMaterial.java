package centanasProyecto;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JList;
import com.toedter.calendar.JDateChooser;
import java.awt.event.ActionListener;
import java.time.LocalDate;
import java.time.ZoneId;
import java.util.Date;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JCalendar;
import com.toedter.components.JLocaleChooser;
import com.toedter.components.JSpinField;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JDayChooser;
import javax.swing.JButton;
import javax.swing.JComboBox;

public class VentanaMaterial extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					VentanaMaterial frame = new VentanaMaterial();
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
	public VentanaMaterial() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		JComboBox comboBox = new JComboBox();
		comboBox.setBounds(81, 177, 118, 20);
		contentPane.add(comboBox);
		
		JDateChooser dateChooser = new JDateChooser();
		dateChooser.setBounds(130, 93, 217, 20);
		contentPane.add(dateChooser);
		
		JButton btnNewButton = new JButton("New button");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				Date inputDate = new Date();
				inputDate=dateChooser.getDate();
				LocalDate date = inputDate.toInstant().atZone(ZoneId.systemDefault()).toLocalDate();
				comboBox.addItem(date);
			}
		});
		btnNewButton.setBounds(280, 196, 89, 23);
		contentPane.add(btnNewButton);
		
		
		java.util.Vector<String> l=new java.util.Vector<String>();
		l.add("Hola");
			l.add("Adiós");
	}
}
