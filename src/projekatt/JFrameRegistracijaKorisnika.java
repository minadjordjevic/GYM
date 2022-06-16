package projekatt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.border.LineBorder;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JFormattedTextField;
import javax.swing.ImageIcon;
import javax.swing.SwingConstants;
import javax.swing.JRadioButton;
import com.toedter.calendar.JDateChooser;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileWriter;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.FlowLayout;
import javax.swing.GroupLayout;
import javax.swing.GroupLayout.Alignment;
import javax.swing.BoxLayout;
import javax.swing.JTextArea;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;

public class JFrameRegistracijaKorisnika extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldIme;
	private JTextField textFieldPrezime;
	private JTextField textAdresa;
	private JTextField textJmbg;
	private JTextField textBrTelefona;
	private JTextField textFieldTezina;
	private JTextField textFieldVisina;
	private JTextField textFieldKorIme;
	private JTextField textFieldLozinka;
	private FileWriter upisi;
	private Klijent klijent = new Klijent();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameRegistracijaKorisnika frame = new JFrameRegistracijaKorisnika();
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
	public JFrameRegistracijaKorisnika() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1076, 628);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(205, 92, 92));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panelRegistracija = new JPanel();
		panelRegistracija.setBorder(new LineBorder(new Color(105, 105, 105)));
		panelRegistracija.setToolTipText("");
		panelRegistracija.setForeground(new Color(0, 0, 0));
		panelRegistracija.setBackground(new Color(205, 92, 92));
		panelRegistracija.setBounds(30, 98, 332, 320);
		contentPane.add(panelRegistracija);
		panelRegistracija.setLayout(null);
		
		JLabel lblIme = new JLabel("Ime:");
		lblIme.setBackground(new Color(255, 255, 255));
		lblIme.setForeground(new Color(255, 255, 255));
		lblIme.setFont(new Font("Verdana", Font.BOLD, 15));
		lblIme.setBounds(10, 33, 46, 14);
		panelRegistracija.add(lblIme);
		
		textFieldIme = new JTextField();
		textFieldIme.setBackground(new Color(245, 245, 245));
		textFieldIme.setForeground(new Color(0, 0, 0));
		textFieldIme.setBounds(102, 32, 184, 20);
		panelRegistracija.add(textFieldIme);
		textFieldIme.setColumns(10);
		
		JLabel lblPrezime = new JLabel("Prezime:");
		lblPrezime.setForeground(new Color(255, 255, 255));
		lblPrezime.setFont(new Font("Verdana", Font.BOLD, 15));
		lblPrezime.setBounds(10, 79, 82, 14);
		panelRegistracija.add(lblPrezime);
		
		textFieldPrezime = new JTextField();
		textFieldPrezime.setBackground(new Color(245, 245, 245));
		textFieldPrezime.setText("");
		textFieldPrezime.setBounds(102, 78, 184, 20);
		panelRegistracija.add(textFieldPrezime);
		textFieldPrezime.setColumns(10);
		
		JLabel lblAdresa = new JLabel("Adresa:");
		lblAdresa.setForeground(new Color(255, 255, 255));
		lblAdresa.setFont(new Font("Verdana", Font.BOLD, 15));
		lblAdresa.setBounds(10, 127, 73, 14);
		panelRegistracija.add(lblAdresa);
		
		textAdresa = new JTextField();
		textAdresa.setBackground(new Color(245, 245, 245));
		textAdresa.setBounds(102, 127, 184, 20);
		panelRegistracija.add(textAdresa);
		textAdresa.setColumns(10);
		
		JLabel lblJMBG = new JLabel("JMBG:");
		lblJMBG.setForeground(new Color(255, 255, 255));
		lblJMBG.setFont(new Font("Verdana", Font.BOLD, 15));
		lblJMBG.setBounds(10, 182, 60, 14);
		panelRegistracija.add(lblJMBG);
		
		textJmbg = new JTextField();
		textJmbg.setBackground(new Color(245, 245, 245));
		textJmbg.setBounds(102, 181, 184, 20);
		panelRegistracija.add(textJmbg);
		textJmbg.setColumns(10);
		
		JLabel lblTelefon = new JLabel("Broj telefona:");
		lblTelefon.setForeground(new Color(255, 255, 255));
		lblTelefon.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTelefon.setBounds(10, 230, 125, 19);
		panelRegistracija.add(lblTelefon);
		
		textBrTelefona = new JTextField();
		textBrTelefona.setBackground(new Color(245, 245, 245));
		textBrTelefona.setBounds(135, 231, 151, 20);
		panelRegistracija.add(textBrTelefona);
		textBrTelefona.setColumns(10);
		
		JPanel panel = new JPanel();
		panel.setBorder(new LineBorder(new Color(105, 105, 105)));
		panel.setBackground(new Color(205, 92, 92));
		panel.setBounds(359, 98, 362, 320);
		contentPane.add(panel);
		panel.setLayout(null);
		
		JLabel lblPol = new JLabel("Pol:");
		lblPol.setForeground(new Color(255, 255, 255));
		lblPol.setFont(new Font("Verdana", Font.BOLD, 15));
		lblPol.setBounds(30, 36, 46, 14);
		panel.add(lblPol);
		
		JLabel lblTezina = new JLabel("Te\u017Eina:");
		lblTezina.setForeground(new Color(255, 255, 255));
		lblTezina.setFont(new Font("Verdana", Font.BOLD, 15));
		lblTezina.setBounds(30, 77, 62, 14);
		panel.add(lblTezina);
		
		textFieldTezina = new JTextField();
		textFieldTezina.setBackground(new Color(245, 245, 245));
		textFieldTezina.setBounds(95, 76, 222, 20);
		panel.add(textFieldTezina);
		textFieldTezina.setColumns(10);
		
		JLabel lblVisina = new JLabel("Visina:");
		lblVisina.setForeground(new Color(255, 255, 255));
		lblVisina.setFont(new Font("Verdana", Font.BOLD, 15));
		lblVisina.setBounds(30, 124, 62, 14);
		panel.add(lblVisina);
		
		textFieldVisina = new JTextField();
		textFieldVisina.setBackground(new Color(245, 245, 245));
		textFieldVisina.setBounds(95, 123, 222, 20);
		panel.add(textFieldVisina);
		textFieldVisina.setColumns(10);
		
		JLabel lblKorIme = new JLabel("Korisni\u010Dko ime:");
		lblKorIme.setForeground(Color.WHITE);
		lblKorIme.setFont(new Font("Verdana", Font.BOLD, 15));
		lblKorIme.setBounds(30, 168, 136, 14);
		panel.add(lblKorIme);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setForeground(Color.WHITE);
		lblLozinka.setFont(new Font("Verdana", Font.BOLD, 15));
		lblLozinka.setBounds(30, 212, 79, 14);
		panel.add(lblLozinka);
		
		textFieldKorIme = new JTextField();
		textFieldKorIme.setBounds(168, 167, 149, 20);
		panel.add(textFieldKorIme);
		textFieldKorIme.setColumns(10);
		
		textFieldLozinka = new JTextField();
		textFieldLozinka.setBounds(117, 211, 200, 20);
		panel.add(textFieldLozinka);
		textFieldLozinka.setColumns(10);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setBackground(Color.WHITE);
		comboBox.setModel(new DefaultComboBoxModel(new String[] {"Izaberi", "Musko", "Zensko"}));
		comboBox.setBounds(95, 34, 222, 22);
		panel.add(comboBox);
		
		JButton btnPrijava = new JButton("");
		btnPrijava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		
				JFrameIzaberi JFIzaberi= new JFrameIzaberi();
				JFIzaberi.show();
				dispose();
			
			}	
		});
		btnPrijava.setIcon(new ImageIcon("image\\mm.png"));
		btnPrijava.setFont(new Font("Verdana", Font.BOLD, 13));
		btnPrijava.setBackground(new Color(255, 255, 255));
		btnPrijava.setBounds(962, 542, 88, 36);
		contentPane.add(btnPrijava);
		
		JButton btnNazad = new JButton("");
		btnNazad.setIcon(new ImageIcon("image\\icons8-back-arrow-30.png"));
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameLogin JFLogin= new JFrameLogin();
				JFLogin.show();
				dispose();
			}
		});
		btnNazad.setFont(new Font("Verdana", Font.BOLD, 13));
		btnNazad.setBackground(new Color(255, 255, 255));
		btnNazad.setBounds(21, 542, 88, 36);
		contentPane.add(btnNazad);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(0, 0, 1060, 69);
		contentPane.add(panel_1);
		panel_1.setLayout(null);
		
		JLabel lblKreiranjenaloga = new JLabel("Kreiranje novog naloga");
		lblKreiranjenaloga.setBackground(new Color(0, 0, 0));
		lblKreiranjenaloga.setForeground(new Color(0, 0, 0));
		lblKreiranjenaloga.setBounds(336, 11, 404, 47);
		lblKreiranjenaloga.setFont(new Font("MingLiU-ExtB", Font.BOLD, 34));
		panel_1.add(lblKreiranjenaloga);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\icons8-new-contact-30.png"));
		lblNewLabel.setBounds(741, 11, 46, 47);
		panel_1.add(lblNewLabel);
		
		JTextArea textAreaPodaci = new JTextArea();
		textAreaPodaci.setBounds(757, 98, 293, 320);
		contentPane.add(textAreaPodaci);
		
		JButton btnNewButton = new JButton("Potvrdi");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent ae) {
				
				if(ae.getActionCommand()==btnNewButton.getActionCommand()) {
					
					try {
						
					if(textFieldIme.getText().isEmpty() || textFieldPrezime.getText().isEmpty() || textFieldVisina.getText().isEmpty() || textBrTelefona.getText().isEmpty()) {
						throw new Exception("Unesi sve podatke");
					}
					
					 String ime=textFieldIme.getText();
					 String prezime=textFieldPrezime.getText();
					 String adresa=textAdresa.getText();
					 String JMBG=textJmbg.getText();
					 String brojTel=textBrTelefona.getText();
					 String pol=comboBox.getSelectedItem().toString();
					 String tezina=textFieldTezina.getText();
					 String visina=textFieldVisina.getText();
					 String korisnicko_ime=textFieldKorIme.getText();
					 String lozinka=textFieldLozinka.getText();
					 
					 klijent = new Klijent(ime, prezime, adresa, JMBG, brojTel, pol, tezina, visina, korisnicko_ime, lozinka);
//					 Brisi fajl, ako se pravi novi nalog
					 File file = new File("Klijenti.txt");
					 if(file.exists()) {
						 file.delete();
					 }
					
					 klijent.registracija("Klijenti.txt", klijent); //upisujemo u datoteku Klijenti 
				
					 JOptionPane.showMessageDialog(null, "Uspesan unos");
					  
					 textFieldIme.setText("");
					 textFieldPrezime.setText("");
					 textAdresa.setText("");
					 textJmbg.setText("");
					 comboBox.setSelectedItem("");
					 textFieldTezina.setText("");
					 textFieldVisina.setText("");
					 textFieldKorIme.setText("");
					 textBrTelefona.setText("");
					 textFieldLozinka.setText("");
					 	 					
				}
				catch(Exception e) {
					JOptionPane.showMessageDialog(null, "Uneti sve podatke");
				}
			}
			}
		});
		btnNewButton.setBackground(new Color(255, 228, 225));
		btnNewButton.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
		btnNewButton.setBounds(308, 457, 117, 36);
		contentPane.add(btnNewButton);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("image\\track-and-field (1).png"));
		lblNewLabel_1.setBounds(890, 529, 72, 60);
		contentPane.add(lblNewLabel_1);
		
		JButton btnPrikazi = new JButton("Prikazi podatke");
		btnPrikazi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textAreaPodaci.setText("");
				
				if(klijent.prikazKorisnikovihPodataka() == null) {
					textAreaPodaci.setText("Niste uneli podatke!");
				}
				else {
					textAreaPodaci.append(klijent.prikazKorisnikovihPodataka());
				}
			}
		});
		btnPrikazi.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 13));
		btnPrikazi.setBackground(new Color(255, 228, 225));
		btnPrikazi.setBounds(845, 457, 138, 36);
		contentPane.add(btnPrikazi);
	}
}
