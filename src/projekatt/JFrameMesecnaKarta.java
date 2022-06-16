package projekatt;

import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;
import javax.swing.JTextField;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JRadioButton;

public class JFrameMesecnaKarta extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldEmail;
	private JTextField textFieldZiro;
	private ClanskaKarta clanskaKarta = new ClanskaKarta();
	private JTextField textFieldEmailS;
	private JTextField textFieldZiroS;
	private JTextField textFieldStandard;
	private JTextField textFieldZiroStand;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameMesecnaKarta frame = new JFrameMesecnaKarta();
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
	public JFrameMesecnaKarta() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 979, 777);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setBounds(840, 0, 123, 113);
		contentPane.add(lblNewLabel);
		lblNewLabel.setIcon(
				new ImageIcon("image\\heroj-vranje2-540x400.jpg"));

		JPanel Kartica1 = new JPanel();
		Kartica1.setBackground(new Color(245, 245, 245));
		Kartica1.setBounds(46, 157, 260, 425);
		contentPane.add(Kartica1);
		Kartica1.setLayout(null);

		JPanel Kartica11 = new JPanel();
		Kartica11.setBackground(new Color(105, 105, 105));
		Kartica11.setBounds(0, 0, 260, 50);
		Kartica1.add(Kartica11);
		Kartica11.setLayout(null);

		JLabel lblDnevna = new JLabel("DNEVNA");
		lblDnevna.setForeground(new Color(255, 255, 255));
		lblDnevna.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblDnevna.setBounds(97, 11, 99, 28);
		Kartica11.add(lblDnevna);

		JLabel lbl16 = new JLabel("");
		lbl16.setIcon(new ImageIcon("image\\icons8-16-24.png"));
		lbl16.setBounds(41, 118, 38, 25);
		Kartica1.add(lbl16);

		JLabel lblNewLabel_2 = new JLabel("Treninga mese\u010Dno");
		lblNewLabel_2.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		lblNewLabel_2.setBounds(80, 118, 144, 25);
		Kartica1.add(lblNewLabel_2);

		JLabel lblNewLabel_9 = new JLabel("2690 RSD");
		lblNewLabel_9.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_9.setBounds(74, 331, 114, 35);
		Kartica1.add(lblNewLabel_9);

		JCheckBox chckbxTraka = new JCheckBox("Traka za trcanje+300RSD");
		chckbxTraka.setBounds(41, 161, 179, 33);
		Kartica1.add(chckbxTraka);

		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblEmail.setBounds(24, 234, 55, 25);
		Kartica1.add(lblEmail);

		textFieldEmail = new JTextField();
		textFieldEmail.setBounds(80, 234, 144, 25);
		Kartica1.add(textFieldEmail);
		textFieldEmail.setColumns(10);

		JLabel lblZiro = new JLabel("\u017Diro ra\u010Dun:");
		lblZiro.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblZiro.setBounds(24, 279, 71, 25);
		Kartica1.add(lblZiro);

		textFieldZiro = new JTextField();
		textFieldZiro.setBounds(105, 281, 119, 23);
		Kartica1.add(textFieldZiro);
		textFieldZiro.setColumns(10);

		JComboBox comboBoxKartica = new JComboBox();
		comboBoxKartica.setBounds(39, 68, 184, 22);
		Kartica1.add(comboBoxKartica);
		comboBoxKartica.setBackground(new Color(211, 211, 211));
		comboBoxKartica.setModel(new DefaultComboBoxModel(new String[] { "Dnevna" }));

		JButton btnDnevna = new JButton("Kupite");
//		Kupovina clanske karte 1
		btnDnevna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String naziv = comboBoxKartica.getSelectedItem().toString();
					Boolean traka = chckbxTraka.isSelected();
					String email = textFieldEmail.getText();
					int ziroRacun = Integer.parseInt(textFieldZiro.getText());	
					int cena = traka ? 2990 :  2690;
					
					ClanskaKarta ck = new ClanskaKarta(naziv, traka, email, ziroRacun, cena);
					File file = new File("ClanskaKarta.txt");
					if(file.exists()) {
						file.delete();
					}
					clanskaKarta.upisivanjeClanskeKarte(ck);

					JOptionPane.showMessageDialog(null, "Uspesno ste kupili");

					comboBoxKartica.setSelectedItem("");
					chckbxTraka.setSelected(false);
					textFieldEmail.setText("");
					textFieldZiro.setText("");

				} catch (Exception ae) {
					JOptionPane.showMessageDialog(null, "Uneti sve podatke");
				}
			}

		});
		btnDnevna.setForeground(new Color(255, 255, 255));
		btnDnevna.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		btnDnevna.setBackground(new Color(204, 51, 51));
		btnDnevna.setBounds(73, 372, 105, 31);
		btnDnevna.setFocusPainted(false);
		Kartica1.add(btnDnevna);

		JPanel Kartica1_1 = new JPanel();
		Kartica1_1.setLayout(null);
		Kartica1_1.setBackground(new Color(245, 245, 245));
		Kartica1_1.setBounds(371, 157, 260, 425);
		contentPane.add(Kartica1_1);

		JPanel Kartica11_1 = new JPanel();
		Kartica11_1.setLayout(null);
		Kartica11_1.setBackground(SystemColor.controlDkShadow);
		Kartica11_1.setBounds(0, 0, 260, 50);
		Kartica1_1.add(Kartica11_1);

		JLabel lblStudent = new JLabel("STUDENT");
		lblStudent.setForeground(Color.WHITE);
		lblStudent.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblStudent.setBounds(87, 11, 84, 28);
		Kartica11_1.add(lblStudent);

		JLabel lblNewLabel_2_1 = new JLabel("Treninga mese\u010Dno");
		lblNewLabel_2_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		lblNewLabel_2_1.setBounds(78, 101, 144, 25);
		Kartica1_1.add(lblNewLabel_2_1);

		JLabel lblNewLabel_3 = new JLabel("");
		lblNewLabel_3
				.setIcon(new ImageIcon("image\\icons8-16-24.png"));
		lblNewLabel_3.setBounds(40, 101, 36, 25);
		Kartica1_1.add(lblNewLabel_3);

		JLabel lblPersTr_1 = new JLabel("Personalni trener");
		lblPersTr_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		lblPersTr_1.setBounds(78, 137, 141, 26);
		Kartica1_1.add(lblPersTr_1);

		JLabel lblNewLabel_6 = new JLabel("");
		lblNewLabel_6.setIcon(
				new ImageIcon("image\\icons8-check-all-24.png"));
		lblNewLabel_6.setBounds(40, 137, 46, 26);
		Kartica1_1.add(lblNewLabel_6);

		JLabel lblNewLabel_9_1 = new JLabel("2100 RSD");
		lblNewLabel_9_1.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_9_1.setBounds(78, 331, 114, 35);
		Kartica1_1.add(lblNewLabel_9_1);

		JCheckBox chckbxTrakaStudent = new JCheckBox("Traka za trcanje+300RSD");
		chckbxTrakaStudent.setBounds(43, 183, 179, 33);
		Kartica1_1.add(chckbxTrakaStudent);

		textFieldEmailS = new JTextField();
		textFieldEmailS.setColumns(10);
		textFieldEmailS.setBounds(78, 234, 144, 25);
		Kartica1_1.add(textFieldEmailS);

		JLabel lblEmailS = new JLabel("Email:");
		lblEmailS.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblEmailS.setBounds(21, 234, 55, 25);
		Kartica1_1.add(lblEmailS);

		textFieldZiroS = new JTextField();
		textFieldZiroS.setColumns(10);
		textFieldZiroS.setBounds(103, 280, 119, 23);
		Kartica1_1.add(textFieldZiroS);

		JLabel lblZiroS = new JLabel("\u017Diro ra\u010Dun:");
		lblZiroS.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblZiroS.setBounds(21, 280, 71, 25);
		Kartica1_1.add(lblZiroS);

		JComboBox comboBoxStudent = new JComboBox();
		comboBoxStudent.setBackground(new Color(211, 211, 211));
		comboBoxStudent.setModel(new DefaultComboBoxModel(new String[] { "Student" }));
		comboBoxStudent.setBounds(38, 68, 184, 22);
		Kartica1_1.add(comboBoxStudent);
//		Kupovina clanske karte 2
		JButton btnStudent = new JButton("Kupite");
		btnStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {

					String nazivS = comboBoxStudent.getSelectedItem().toString();
					Boolean trakaS = chckbxTrakaStudent.isSelected();
					String emailS = textFieldEmailS.getText();
					int ziroRacunS = Integer.parseInt(textFieldZiroS.getText());
					int cenaS = trakaS ? 2400 : 2100;

					ClanskaKarta ck = new ClanskaKarta(nazivS, trakaS, emailS, ziroRacunS, cenaS);
					File file = new File("ClanskaKarta.txt");
					if(file.exists()) {
						file.delete();
					}
					clanskaKarta.upisivanjeClanskeKarte(ck);

					JOptionPane.showMessageDialog(null, "Uspesno ste kupili");

					comboBoxStudent.setSelectedItem("");
					chckbxTrakaStudent.setSelected(false);
					textFieldEmailS.setText("");
					textFieldZiroS.setText("");

				} catch (Exception ae) {
					JOptionPane.showMessageDialog(null, "Uneti sve podatke");
				}

			}
		});
		btnStudent.setForeground(new Color(255, 255, 255));
		btnStudent.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		btnStudent.setBackground(new Color(204, 51, 51));
		btnStudent.setBounds(78, 372, 105, 31);
		btnStudent.setFocusPainted(false);
		Kartica1_1.add(btnStudent);

		JPanel Kartica1_2 = new JPanel();
		Kartica1_2.setLayout(null);
		Kartica1_2.setBackground(new Color(245, 245, 245));
		Kartica1_2.setBounds(690, 157, 260, 425);
		contentPane.add(Kartica1_2);

		JPanel Kartica11_3 = new JPanel();
		Kartica11_3.setBackground(SystemColor.controlDkShadow);
		Kartica11_3.setBounds(0, 0, 260, 50);
		Kartica1_2.add(Kartica11_3);
		Kartica11_3.setLayout(null);

		JLabel lblStandard = new JLabel("STANDARD");
		lblStandard.setForeground(Color.WHITE);
		lblStandard.setFont(new Font("Microsoft YaHei", Font.BOLD, 17));
		lblStandard.setBounds(88, 11, 106, 28);
		Kartica11_3.add(lblStandard);

		JLabel lblNewLabel_2_1_1 = new JLabel("Treninga mese\u010Dno");
		lblNewLabel_2_1_1.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		lblNewLabel_2_1_1.setBounds(81, 111, 144, 25);
		Kartica1_2.add(lblNewLabel_2_1_1);

		JLabel lblNewLabel_4 = new JLabel("");
		lblNewLabel_4
				.setIcon(new ImageIcon("image\\icons8-16-24.png"));
		lblNewLabel_4.setBounds(40, 111, 38, 25);
		Kartica1_2.add(lblNewLabel_4);

		JLabel lblPersTr = new JLabel("Personalni trener");
		lblPersTr.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		lblPersTr.setBounds(81, 147, 141, 26);
		Kartica1_2.add(lblPersTr);

		JLabel lblNewLabel_5 = new JLabel("");
		lblNewLabel_5.setIcon(
				new ImageIcon("image\\icons8-check-all-24.png"));
		lblNewLabel_5.setBounds(40, 147, 30, 30);
		Kartica1_2.add(lblNewLabel_5);

		JLabel lblNewLabel_7 = new JLabel("Aplikacija  ");
		lblNewLabel_7.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		lblNewLabel_7.setBounds(84, 184, 126, 20);
		Kartica1_2.add(lblNewLabel_7);

		JLabel lblNewLabel_8 = new JLabel("");
		lblNewLabel_8.setIcon(new ImageIcon("image\\mm.png"));
		lblNewLabel_8.setBounds(42, 184, 38, 20);
		Kartica1_2.add(lblNewLabel_8);

		JLabel lblNewLabel_9_2 = new JLabel("3890 RSD");
		lblNewLabel_9_2.setFont(new Font("Bookman Old Style", Font.BOLD, 19));
		lblNewLabel_9_2.setBounds(81, 331, 114, 35);
		Kartica1_2.add(lblNewLabel_9_2);

		JComboBox comboBoxStandard = new JComboBox();
		comboBoxStandard.setBackground(new Color(211, 211, 211));
		comboBoxStandard.setModel(new DefaultComboBoxModel(new String[] { "Standard" }));
		comboBoxStandard.setBounds(40, 68, 184, 22);
		Kartica1_2.add(comboBoxStandard);

		textFieldStandard = new JTextField();
		textFieldStandard.setColumns(10);
		textFieldStandard.setBounds(81, 253, 144, 25);
		Kartica1_2.add(textFieldStandard);

		JLabel lblEmailStandard = new JLabel("Email:");
		lblEmailStandard.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblEmailStandard.setBounds(23, 251, 55, 25);
		Kartica1_2.add(lblEmailStandard);

		textFieldZiroStand = new JTextField();
		textFieldZiroStand.setColumns(10);
		textFieldZiroStand.setBounds(106, 289, 119, 23);
		Kartica1_2.add(textFieldZiroStand);

		JLabel lblZiroSt = new JLabel("\u017Diro ra\u010Dun:");
		lblZiroSt.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		lblZiroSt.setBounds(23, 289, 71, 25);
		Kartica1_2.add(lblZiroSt);

		JCheckBox chckbxTrakaSta = new JCheckBox("Traka za trcanje+300RSD");
		chckbxTrakaSta.setBounds(40, 221, 185, 23);
		Kartica1_2.add(chckbxTrakaSta);

//		Kupovina clanske karte 3
		JButton btnStandard = new JButton("Kupite");
		btnStandard.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					String nazivSt = comboBoxStandard.getSelectedItem().toString();
					Boolean trakaSt = chckbxTrakaSta.isSelected();
					String emailSt = textFieldStandard.getText();
					int ziroRacunSt = Integer.parseInt(textFieldZiroStand.getText());
					int cenaSt = trakaSt ? 4190 : 3890;

					ClanskaKarta ck = new ClanskaKarta(nazivSt, trakaSt, emailSt, ziroRacunSt, cenaSt);
					File file = new File("ClanskaKarta.txt");
					if(file.exists()) {
						file.delete();
					}
					clanskaKarta.upisivanjeClanskeKarte(ck);

					JOptionPane.showMessageDialog(null, "Uspesno ste kupili");

					comboBoxStandard.setSelectedItem("");
					chckbxTrakaSta.setSelected(false);
					textFieldStandard.setText("");
					textFieldZiroStand.setText("");

				} catch (Exception ae) {
					JOptionPane.showMessageDialog(null, "Uneti sve podatke");
				}
			}
		});
		btnStandard.setForeground(new Color(255, 255, 255));
		btnStandard.setFont(new Font("Microsoft YaHei", Font.PLAIN, 15));
		btnStandard.setBackground(new Color(204, 51, 51));
		btnStandard.setBounds(81, 372, 105, 31);
		btnStandard.setFocusPainted(false);
		Kartica1_2.add(btnStandard);

		JLabel lblNewLabel_1 = new JLabel("Kupite \u010Dlansku kartu");
		lblNewLabel_1.setFont(new Font("Times New Roman", Font.BOLD, 38));
		lblNewLabel_1.setBounds(319, 35, 385, 44);
		contentPane.add(lblNewLabel_1);

		JButton btnNazad = new JButton("Nazad");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameIzaberi JFIzaberi = new JFrameIzaberi();
				JFIzaberi.show();
				dispose();
			}
		});
		btnNazad.setBackground(new Color(255, 255, 255));
		btnNazad.setIcon(
				new ImageIcon("image\\icons8-enter-50.png"));
		btnNazad.setBounds(872, 671, 81, 56);
		contentPane.add(btnNazad);

		JTextArea textAreaIspis = new JTextArea();
		textAreaIspis.setFont(new Font("Monospaced", Font.PLAIN, 13));
		textAreaIspis.setBackground(new Color(245, 245, 245));
		textAreaIspis.setBounds(371, 624, 260, 86);
		contentPane.add(textAreaIspis);

		JButton btnRacun = new JButton("VA\u0160 RA\u010CUN:");
//		RACUN 
		btnRacun.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textAreaIspis.setText("");
				textAreaIspis.setText(prikazRacuna());
				textAreaIspis.disable();
			}
		});
		btnRacun.setBackground(new Color(220, 220, 220));
		btnRacun.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		btnRacun.setBounds(126, 651, 180, 29);
		contentPane.add(btnRacun);
	}
	
	public String prikazRacuna() {
		return this.clanskaKarta.prikazRacuna("ClanskaKarta.txt"); 
	}
}
