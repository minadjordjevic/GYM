package projekatt;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import java.awt.Color;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.ImageIcon;
import javax.swing.JTextField;
import javax.swing.JCheckBox;
import javax.swing.JTextArea;
import javax.swing.JScrollBar;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Locale;
import java.util.Scanner;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JSpinner;
import javax.swing.JSlider;
import javax.swing.JScrollPane;

public class JFrameNutricionista extends JFrame {

	private JPanel contentPane;
	private JTextField textTezina;
	private JTextField textVisina;
	private Nutricionista nutricionista = new Nutricionista();
	private JTextField textFieldRadno;
	private JTextField textFieldTelefon;
	private JComboBox comboBoxLicni;
	private JTextArea textAreaIspis;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameNutricionista frame = new JFrameNutricionista();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	Scanner x;

	/**
	 * Create the frame.
	 */
	public JFrameNutricionista() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 1022, 659);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);

		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 192, 203));
		panel.setBounds(-13, 0, 1019, 100);
		contentPane.add(panel);
		panel.setLayout(null);

		JLabel lblNewLabel = new JLabel("Nutricionista ");
		lblNewLabel.setForeground(new Color(0, 0, 0));
		lblNewLabel.setBounds(410, 25, 199, 40);
		panel.add(lblNewLabel);
		lblNewLabel.setFont(new Font("Monotype Corsiva", Font.BOLD, 35));

		JLabel lblNewLabel_1 = new JLabel("");
		lblNewLabel_1.setIcon(new ImageIcon(
				"image\\icons8-healthy-food-calories-calculator-48.png"));
		lblNewLabel_1.setBounds(318, 17, 58, 48);
		panel.add(lblNewLabel_1);

		JLabel lblNewLabel_2 = new JLabel("");
		lblNewLabel_2.setIcon(new ImageIcon(
				"image\\icons8-vegetarian-food-48.png"));
		lblNewLabel_2.setBounds(627, 17, 48, 48);
		panel.add(lblNewLabel_2);

		JLabel lblLicniPodaci = new JLabel("Li\u010Dni podaci:");
		lblLicniPodaci.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		lblLicniPodaci.setBounds(487, 124, 132, 24);
		contentPane.add(lblLicniPodaci);

		JPanel panel_1 = new JPanel();
		panel_1.setBackground(new Color(245, 245, 245));
		panel_1.setBounds(483, 148, 483, 268);
		contentPane.add(panel_1);
		panel_1.setLayout(null);

		comboBoxLicni = new JComboBox();
		comboBoxLicni.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		comboBoxLicni.setForeground(new Color(0, 0, 0));
		comboBoxLicni.setBackground(new Color(255, 192, 203));
		comboBoxLicni.setModel(new DefaultComboBoxModel(new String[] {"Izaberi", "Musko", "Zensko"}));
		comboBoxLicni.setBounds(188, 29, 228, 32);
		panel_1.add(comboBoxLicni);

		JLabel lblPol = new JLabel("Pol:");
		lblPol.setBounds(112, 32, 46, 22);
		panel_1.add(lblPol);
		lblPol.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

		textVisina = new JTextField();
		textVisina.setBounds(189, 111, 227, 32);
		panel_1.add(textVisina);
		textVisina.setBackground(new Color(245, 245, 245));
		textVisina.setColumns(10);

		JLabel lblVisina = new JLabel("Visina:");
		lblVisina.setBounds(87, 112, 70, 24);
		panel_1.add(lblVisina);
		lblVisina.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

		textTezina = new JTextField();
		textTezina.setBounds(188, 199, 227, 32);
		panel_1.add(textTezina);
		textTezina.setBackground(new Color(245, 245, 245));
		textTezina.setColumns(10);

		JLabel lblTezina = new JLabel("Te\u017Eina:");
		lblTezina.setBounds(87, 200, 70, 24);
		panel_1.add(lblTezina);
		lblTezina.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));

		JPanel panel_2 = new JPanel();
		panel_2.setBackground(new Color(255, 192, 203));
		panel_2.setBounds(0, 480, 1006, 140);
		contentPane.add(panel_2);
		panel_2.setLayout(null);

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
				new ImageIcon("image\\icons8-back-arrow-30.png"));
		btnNazad.setBounds(31, 51, 110, 39);
		panel_2.add(btnNazad);

		JButton btnUnesi = new JButton("Unesi");
//		Button za unos podataka korisnika
		btnUnesi.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				unosPodatakaKorisnika();
			}
		});
		btnUnesi.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnUnesi.setBackground(new Color(176, 224, 230));
		btnUnesi.setBounds(650, 437, 115, 28);
		contentPane.add(btnUnesi);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(277, 20, 393, 99);
		panel_2.add(scrollPane);

		textAreaIspis = new JTextArea();
		scrollPane.setViewportView(textAreaIspis);

//		Button za ispis plana ishrane
		JButton btnRezultat = new JButton("Plan ishrane");
		btnRezultat.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				planIshraneIspis();
			}

		});
		btnRezultat.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnRezultat.setBackground(new Color(176, 224, 230));
		btnRezultat.setBounds(702, 54, 110, 31);
		panel_2.add(btnRezultat);

		JPanel panel_3 = new JPanel();
		panel_3.setBackground(new Color(245, 245, 245));
		panel_3.setBounds(43, 148, 360, 268);
		contentPane.add(panel_3);
		panel_3.setLayout(null);

		JLabel lblIme = new JLabel("Ime:");
		lblIme.setFont(new Font("Microsoft YaHei UI", Font.PLAIN, 18));
		lblIme.setBounds(56, 13, 51, 24);
		panel_3.add(lblIme);

		JComboBox comboBoxNutricionista = new JComboBox();
		comboBoxNutricionista.setFont(new Font("Microsoft YaHei", Font.PLAIN, 12));
		comboBoxNutricionista.setModel(new DefaultComboBoxModel(
				new String[] { "Izaberi", "Marija Popovic", "Aleksandar Tosic", "Jelena Stankovic" }));
		comboBoxNutricionista.setBounds(101, 11, 203, 32);
		panel_3.add(comboBoxNutricionista);

		JLabel lblIskustvo = new JLabel("Radno iskustvo:");
		lblIskustvo.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		lblIskustvo.setBounds(10, 126, 139, 30);
		panel_3.add(lblIskustvo);

		textFieldRadno = new JTextField();
		textFieldRadno.setBounds(159, 132, 145, 24);
		panel_3.add(textFieldRadno);
		textFieldRadno.setColumns(10);

		JLabel lblTelefon = new JLabel("Broj telefona:");
		lblTelefon.setFont(new Font("Microsoft YaHei", Font.PLAIN, 18));
		lblTelefon.setBounds(31, 182, 117, 30);
		panel_3.add(lblTelefon);

		textFieldTelefon = new JTextField();
		textFieldTelefon.setColumns(10);
		textFieldTelefon.setBounds(159, 188, 145, 24);
		panel_3.add(textFieldTelefon);

		JLabel lblIzaberiNutricionistu = new JLabel("Izaberite nutricionistu:");
		lblIzaberiNutricionistu.setFont(new Font("Microsoft YaHei", Font.PLAIN, 20));
		lblIzaberiNutricionistu.setBounds(43, 124, 212, 24);
		contentPane.add(lblIzaberiNutricionistu);

		JButton btnPotvrdi = new JButton("Potvrdi");
		btnPotvrdi.setBackground(new Color(176, 224, 230));
//		Button za nutricionistu
		btnPotvrdi.addActionListener(new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				String nut_ime = comboBoxNutricionista.getSelectedItem().toString(); // kupimo izabrano ime i prezime
				System.out.println(nut_ime);
				// setuj podatke za field telefon
				textFieldTelefon.setText("");
				textFieldTelefon.setText(iscitavanjeLogovanihKorisnika(nut_ime).getBrojTel());
				textFieldTelefon.disable();
				// setuj podatke za field radno mesto
				textFieldRadno.setText("");
				textFieldRadno.setText(iscitavanjeLogovanihKorisnika(nut_ime).getGodineIskustva());
				textFieldRadno.disable();

			}
		});
		btnPotvrdi.setFont(new Font("Microsoft YaHei", Font.PLAIN, 13));
		btnPotvrdi.setBounds(121, 73, 115, 28);
		panel_3.add(btnPotvrdi);
	}

	// u button action, ne dozvoljava da pristupa objektu nutricionista
	// zasto smo primorani da vratimo objekat Nutricionista
	// i preko naziva metode da pristupamo get/set metodama iz Nutricioniste
	public Nutricionista iscitavanjeLogovanihKorisnika(String imePrezime) {
		String[] ip = imePrezime.split(" ");
		this.nutricionista = new Nutricionista();
		try {
			return this.nutricionista.getNutricionista("Nutricionista.txt", ip[0]);
		} catch (Exception e2) {
			JOptionPane.showMessageDialog(null, e2.getMessage());
			return null;
		}
	}

	public void unosPodatakaKorisnika() {

		textTezina.setText("");
		textTezina.setText(nutricionista.getKlijent().getTezina());

		textVisina.setText("");
		textVisina.setText(nutricionista.getKlijent().getVisina());

		String pol = nutricionista.getKlijent().getPol() == "Musko" ? "Musko" : "Zensko";
		comboBoxLicni.setSelectedItem("");
		comboBoxLicni.setSelectedItem(pol);

		JOptionPane.showMessageDialog(null, "Uspesan unos!");
	}

	public void planIshraneIspis() {
		textAreaIspis.setText("");

		if (nutricionista.getKlijent().getPol().equals("Musko")
				&& Integer.parseInt(nutricionista.getKlijent().getTezina()) > nutricionista.idealnaMuska()) {
			textAreaIspis.append(""
					+ "PONEDELJAK\nDorucak: Kuvana jaja + salata\nUzina: Pomorandza\nRucak: Belo meso + mix salata\nVecera: Ovsena kasa\n"
					+ "UTORAK\nDorucak: 3 jaja + tuna\nUzina: Banana\nRucak: Svinjsko meso + mix salata\nVecera: Tuna + salata\n"
					+ "SREDA\nDorucak: Mladi sir + avokado\nUzina: Banana\nRucak: Corba + mix salata\nVecera: Vocni mix\n"
					+ "CETVRTAK\nDorucak: Avokado + pecenica\nUzina: Vocni mix\nRucak: Pilece meso\nVecera: Tuna + salata\n"
					+ "PETAK\nDorucak: Kajgana + mladi sir\nUzina: Suvo grozdje\nRucak: Svinjsko meso + mix salata\nUzina: Slatkis\nVecera: Ovsena kasa\n");
		} else if (nutricionista.getKlijent().getPol().equals("Musko")
				&& Integer.parseInt(nutricionista.getKlijent().getTezina()) == nutricionista.idealnaMuska()) {
			textAreaIspis.append("Imate idealnu tezinu");
		}
		if (nutricionista.getKlijent().getPol().equals("Musko")
				&& Integer.parseInt(nutricionista.getKlijent().getTezina()) < nutricionista.idealnaMuska()) {
			textAreaIspis.append(""
					+ "Ponedeljak\nDorucak: 2 solje ovsene kase\nUzina: Surutka\nRucak: Kuvani pasulj\nVecera: 200g lososa\n"
					+ "Utorak\nDorucak: 3 jaja + mladi sir\nUzina: Suvo grozdje\nRucak: Svinjsko meso + mix salata\nVecera: 100g buranije+kuvani krompir\n"
					+ "Sreda\nDorucak: 2 kriske hleba+avokado\nUzina: Banana+med\nRucak: Spagete+komad voca\nVecera: 200g Pileci file\n"
					+ "Cetvrtak\nDorucak: Omlet 2 jaja + sir\nUzina: Povrce\nRucak: Kuvani grasak\nVecera: Pire od krompira\n"
					+ "Petak\nDorucak: Palacinke sa marmeladom\nUzina: Dve sljive+jedna jabuka\nRucak: Przeni riblji stapici\nUzina: Sejk za gojenje\nVecera: Pljeskavica+jedna lepinja\n");
		}
		if (nutricionista.getKlijent().getPol().equals("Zensko")
				&& Integer.parseInt(nutricionista.getKlijent().getTezina()) > nutricionista.idealnaZenska()) {
			textAreaIspis.append(""
					+ "PONEDELJAK\nDorucak: Kuvana jaja + salata\nUzina: Pomorandza\nRucak: Belo meso + mix salata\nVecera: Ovsena kasa\n"
					+ "UTORAK\nDorucak: 3 jaja + tuna\nUzina: Banana\nRucak: Svinjsko meso + mix salata\nVecera: Tuna + salata\n"
					+ "SREDA\nDorucak: Mladi sir + avokado\nUzina: Banana\nRucak: Corba + mix salata\nVecera: Vocni mix\n"
					+ "CETVRTAK\nDorucak: Avokado + pecenica\nUzina: Vocni mix\nRucak: Pilece meso\nVecera: Tuna + salata\n"
					+ "PETAK\nDorucak: Kajgana + mladi sir\nUzina: Suvo grozdje\nRucak: Svinjsko meso + mix salata\nUzina: Slatkis\nVecera: Ovsena kasa\n");
		} else if (nutricionista.getKlijent().getPol().equals("Zensko")
				&& Integer.parseInt(nutricionista.getKlijent().getTezina()) == nutricionista.idealnaZenska()) {
			textAreaIspis.append("Imate idealnu tezinu");
		}
		if (nutricionista.getKlijent().getPol().equals("Zensko")
				&& Integer.parseInt(nutricionista.getKlijent().getTezina()) < nutricionista.idealnaZenska()) {
			textAreaIspis.append(""
					+ "Ponedeljak\nDorucak: 2 solje ovsene kase\nUzina: Surutka\nRucak: Kuvani pasulj\nVecera: 200g lososa\n"
					+ "Utorak\nDorucak: 3 jaja + mladi sir\nUzina: Suvo grozdje\nRucak: Svinjsko meso + mix salata\nVecera: 100g buranije+kuvani krompir\n"
					+ "Sreda\nDorucak: 2 kriske hleba+avokado\nUzina: Banana+med\nRucak: Spagete+komad voca\nVecera: 200g Pileci file\n"
					+ "Cetvrtak\nDorucak: Omlet 2 jaja + sir\nUzina: Povrce\nRucak: Kuvani grasak\nVecera: Pire od krompira\n"
					+ "Petak\nDorucak: Palacinke sa marmeladom\nUzina: Dve sljive+jedna jabuka\nRucak: Przeni riblji stapici\nUzina: Sejk za gojenje\nVecera: Pljeskavica+jedna lepinja\n");
		}

	}
}
