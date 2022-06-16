package projekatt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import com.toedter.calendar.JMonthChooser;
import com.toedter.calendar.JCalendar;
import com.toedter.calendar.JDayChooser;
import javax.swing.JButton;
import javax.swing.ImageIcon;
import java.awt.event.ActionListener;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.SwingConstants;
import javax.swing.JTextArea;
import javax.swing.JScrollPane;
import javax.swing.JScrollBar;
import javax.swing.JList;
import javax.swing.JOptionPane;

public class JFrameRezervisanje extends JFrame {


	private JPanel contentPane;
	Trening trening= new Trening();
	
	
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameRezervisanje frame = new JFrameRezervisanje();
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
	public JFrameRezervisanje() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 867, 605);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(0, 0, 851, 97);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(52, 11, 752, 63);
		panel.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblRezervisite = new JLabel("Rezervi\u0161ite termin treninga");
		lblRezervisite.setForeground(new Color(165, 42, 42));
		lblRezervisite.setFont(new Font("Perpetua", Font.BOLD, 34));
		lblRezervisite.setBounds(193, 11, 399, 41);
		panel_1.add(lblRezervisite);
		
		JLabel lblProgram = new JLabel("Program:");
		lblProgram.setFont(new Font("Verdana", Font.BOLD, 15));
		lblProgram.setBounds(168, 132, 89, 25);
		contentPane.add(lblProgram);
		
		JComboBox comboBoxProgram = new JComboBox();
		comboBoxProgram.setModel(new DefaultComboBoxModel(new String[] {"CrossFit", "OpenGym", "\u0160kola sporta"}));
		comboBoxProgram.setToolTipText("");
		comboBoxProgram.setEditable(true);
		comboBoxProgram.setBackground(new Color(255, 182, 193));
		comboBoxProgram.setBounds(267, 135, 187, 22);
		contentPane.add(comboBoxProgram);
			
		JLabel lblTrener = new JLabel("Izaberite trenera:");
		lblTrener.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTrener.setBounds(95, 187, 170, 14);
		contentPane.add(lblTrener);
		
		JComboBox comboBoxTrener = new JComboBox();
		comboBoxTrener.setModel(new DefaultComboBoxModel(new String[] {"Aca", "Boki", "Milo\u0161", "Danijela"}));
		comboBoxTrener.setEditable(true);
		comboBoxTrener.setBackground(new Color(72, 209, 204));
		comboBoxTrener.setBounds(267, 185, 187, 22);
		contentPane.add(comboBoxTrener);
		
		JDayChooser dayChooser = new JDayChooser();
		dayChooser.setBounds(272, 247, 182, 133);
		contentPane.add(dayChooser);
		
		JLabel lblDatum = new JLabel("Datum:");
		lblDatum.setFont(new Font("Verdana", Font.BOLD, 15));
		lblDatum.setBounds(183, 247, 82, 14);
		contentPane.add(lblDatum);
		
		JLabel lblVreme = new JLabel("Vreme treninga:");
		lblVreme.setFont(new Font("Verdana", Font.BOLD, 15));
		lblVreme.setBounds(113, 411, 133, 25);
		contentPane.add(lblVreme);
		
		JComboBox comboBoxVreme = new JComboBox();
		comboBoxVreme.setBackground(new Color(255, 160, 122));
		comboBoxVreme.setEditable(true);
		comboBoxVreme.setModel(new DefaultComboBoxModel(new String[] {"10:00-11:00", "12:00-13:00", "14:00-15:00", "17:00-16:00", "19:00-20:00", "21:00-22:00"}));
		comboBoxVreme.setBounds(267, 414, 187, 22);
		contentPane.add(comboBoxVreme);
		
		JButton btnSubmit = new JButton("");
		btnSubmit.setIcon(new ImageIcon("image\\icons8-enter-50.png"));
		btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameIzaberi JFrIzaberi= new JFrameIzaberi();
				JFrIzaberi.show();
				dispose();
			}
		});
		btnSubmit.setForeground(new Color(255, 255, 255));
		btnSubmit.setBackground(new Color(255, 255, 255));
		btnSubmit.setFont(new Font("Verdana", Font.BOLD, 13));
		btnSubmit.setBounds(774, 501, 67, 54);
		contentPane.add(btnSubmit);
		
		JButton btnSumbitt = new JButton("Rezervi\u0161i");
//		rezervacija treninga
		btnSumbitt.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				
				try {
					 String program=comboBoxProgram.getSelectedItem().toString();
					 String trener=comboBoxTrener.getSelectedItem().toString();
					 int datum= dayChooser.getDay();
					 String vreme=comboBoxVreme.getSelectedItem().toString();
					 
					 if(comboBoxProgram.getSelectedIndex() == -1 &&  comboBoxTrener.getSelectedIndex() == -1 && comboBoxVreme.getSelectedIndex() == -1)  {
						 throw new Exception("Morate uneti sve podatke");
					 }
					 
					 trening = new Trening(program,trener,datum,vreme);
					
					 trening.rezervacijaTreninga("Trening.txt", trening);
					
					 
					 JOptionPane.showMessageDialog(null, "Zakazan trening");
					 
					 comboBoxProgram.setSelectedItem("");
					 comboBoxTrener.setSelectedItem("");
					 comboBoxVreme.setSelectedItem("");
					 

				}
				catch(Exception ae) {
					JOptionPane.showMessageDialog(null, "Uneti sve podatke");
				}
				
			}
		});
		btnSumbitt.setBounds(267, 474, 117, 31);
		contentPane.add(btnSumbitt);
		
		JScrollBar scrollBar = new JScrollBar();
		scrollBar.setBounds(785, 132, 17, 248);
		contentPane.add(scrollBar);
		
		JTextArea textAreaTrening = new JTextArea();
		textAreaTrening.setBackground(new Color(245, 245, 245));
		textAreaTrening.setBounds(548, 132, 254, 248);
		contentPane.add(textAreaTrening);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("icons8-dumbbell-100.png"));
		lblNewLabel.setBounds(65, 287, 117, 79);
		contentPane.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Prika\u017Ei izabrani trening");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
					textAreaTrening.append(prikazZakazanihTerminaTreninga());
			}
		});
		btnNewButton.setBounds(600, 410, 170, 31);
		contentPane.add(btnNewButton);
	}
	
	public String prikazZakazanihTerminaTreninga() {
		return this.trening.prikazZakazanihTerminaTreninga("Trening.txt");
	}
}
