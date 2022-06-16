package projekatt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JPasswordField;
import javax.swing.border.EmptyBorder;

import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.ImageIcon;
import java.awt.Color;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JCheckBox;

public class JFrameLogin extends JFrame {

	private JPanel contentPane;
	private JTextField textFieldKorIme;
	private Klijent klijent = new Klijent();
	JPasswordField pw= new JPasswordField(20);
	private JPasswordField passwordFieldLozinka;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {	
					JFrameLogin frame = new JFrameLogin();
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
	public JFrameLogin() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 962, 647);
		contentPane = new JPanel();
		contentPane.setBackground(Color.WHITE);
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\photo-1571902943202-507ec2618e8f.jfif"));
		lblNewLabel.setBounds(-51, 0, 560, 608);
		contentPane.add(lblNewLabel);
		
		JLabel lblHerojlogo = new JLabel("");
		lblHerojlogo.setIcon(new ImageIcon("image\\heroj-vranje2-540x400.jpg"));
		lblHerojlogo.setBounds(669, 11, 140, 100);
		contentPane.add(lblHerojlogo);
		
		JLabel lblKorisnicko = new JLabel("Korisni\u010Dko ime:");
		lblKorisnicko.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		lblKorisnicko.setBounds(572, 184, 161, 31);
		contentPane.add(lblKorisnicko);
		
		textFieldKorIme = new JTextField();
		textFieldKorIme.setFont(new Font("Verdana", Font.PLAIN, 12));
		textFieldKorIme.setBackground(Color.WHITE);
		textFieldKorIme.setBounds(616, 229, 299, 23);
		contentPane.add(textFieldKorIme);
		textFieldKorIme.setColumns(10);
		
		JLabel lblLozinka = new JLabel("Lozinka:");
		lblLozinka.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		lblLozinka.setBounds(572, 299, 99, 17);
		contentPane.add(lblLozinka);
		
		passwordFieldLozinka = new JPasswordField();
		passwordFieldLozinka.setBackground(Color.WHITE);
		passwordFieldLozinka.setBounds(616, 340, 299, 23);
		contentPane.add(passwordFieldLozinka);
		
		JButton btnPrijava = new JButton("Prijava");
		btnPrijava.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				loginKorisnika();
				proveraPodatakaKorisnika();
			}
		});
		btnPrijava.setForeground(new Color(255, 255, 255));
		btnPrijava.setBackground(new Color(178, 34, 34));
		btnPrijava.setFont(new Font("Microsoft YaHei UI Light", Font.BOLD, 17));
		btnPrijava.setBounds(572, 482, 134, 40);
		contentPane.add(btnPrijava);
		
		JButton btnNoviNalog = new JButton("Novi nalog");
		btnNoviNalog.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameRegistracijaKorisnika JFRegistr= new JFrameRegistracijaKorisnika();
				JFRegistr.show();
				dispose();
			}
		});
		btnNoviNalog.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 17));
		btnNoviNalog.setForeground(new Color(255, 255, 255));
		btnNoviNalog.setBackground(new Color(178, 34, 34));
		btnNoviNalog.setBounds(775, 482, 140, 40);
		contentPane.add(btnNoviNalog);
		
		JLabel lblPswIcon = new JLabel("");
		lblPswIcon.setIcon(new ImageIcon("image\\icons8-password-30.png"));
		lblPswIcon.setBounds(572, 332, 24, 31);
		contentPane.add(lblPswIcon);
		
		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon("image\\icons8-name-24.png"));
		lblNewLabel_1.setBounds(572, 229, 24, 23);
		contentPane.add(lblNewLabel_1);
		
		
		JCheckBox chckbxLozinka = new JCheckBox("Prikazi lozinku ");
		chckbxLozinka.setFont(new Font("Microsoft YaHei", Font.BOLD, 12));
		chckbxLozinka.setBackground(Color.WHITE);
		chckbxLozinka.addActionListener(new ActionListener() {
		public void actionPerformed(ActionEvent e) {
				if(chckbxLozinka.isSelected()) {
					passwordFieldLozinka.setEchoChar((char)0);
				}
				else {
					passwordFieldLozinka.setEchoChar('*');
				}
			}
		});
		chckbxLozinka.setBounds(572, 388, 134, 23);
		contentPane.add(chckbxLozinka);
		
	}
	
	public void loginKorisnika() { //iscitavamo 
		try
		{
			this.klijent = this.klijent.login("Klijenti.txt");
		}
		catch(Exception e2)
		{
			JOptionPane.showMessageDialog(null, "GRESKA PRI ISCITAVANJU");
		}
	}
	
	public void proveraPodatakaKorisnika() {
		try {
			//kupimo podatke koje korisnik unese
			String korisnicko=textFieldKorIme.getText();
			String lozinka=passwordFieldLozinka.getText();
			
			//uslov provere unosa 
			if(textFieldKorIme.getText().trim().isEmpty() || passwordFieldLozinka.getText().trim().isEmpty()) {
				throw new Exception("Unesite korisnicko ime ili lozinku");
			}
			else if(klijent.getKorisnickoIme().equals(korisnicko) && klijent.getLozinka().equals(lozinka))
				{
					JFrameIzaberi JFizaberi=new JFrameIzaberi();
					JFizaberi.show();
					dispose();
					JOptionPane.showMessageDialog(null, "USPESNA REGISTRACIJA");
				}
			else {
					if(!klijent.getKorisnickoIme().equals(korisnicko) && klijent.getLozinka().equals(lozinka))
						throw new Exception("Pogresno korisnicko ime\n Pokusajte ponovo!");
					else {
						if(klijent.getKorisnickoIme().equals(korisnicko) && !klijent.getLozinka().equals(lozinka))
							throw new Exception("Pogresa lozinka \nPokusajte ponovo!");
					}
				}
		}
		catch(Exception e1) {
			JOptionPane.showMessageDialog(null, e1.getMessage());
		}
	}
	
}
