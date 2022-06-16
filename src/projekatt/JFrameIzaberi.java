package projekatt;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JButton;
import java.awt.Font;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public class JFrameIzaberi extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					JFrameIzaberi frame = new JFrameIzaberi();
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
	public JFrameIzaberi() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 511, 547);
		contentPane = new JPanel();
		contentPane.setBackground(new Color(255, 255, 255));
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JButton btnZakazivanjeTr = new JButton("Zakazivanje treninga");
		btnZakazivanjeTr.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameRezervisanje JFRezervisanje= new JFrameRezervisanje();
				JFRezervisanje.show();
				dispose();
			}
		});
		btnZakazivanjeTr.setForeground(new Color(255, 255, 255));
		btnZakazivanjeTr.setBackground(new Color(165, 42, 42));
		btnZakazivanjeTr.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 16));
		btnZakazivanjeTr.setBounds(147, 28, 205, 68);
		btnZakazivanjeTr.setFocusPainted(false);
		contentPane.add(btnZakazivanjeTr);
		
		JButton btnNutricionista = new JButton("Nutricionista");
		btnNutricionista.setForeground(new Color(255, 255, 255));
		btnNutricionista.setBackground(new Color(205, 92, 92));
		btnNutricionista.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 18));
		btnNutricionista.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameNutricionista JFNutricionista= new JFrameNutricionista();
				JFNutricionista.show();
				dispose();
			}
		});
		btnNutricionista.setBounds(147, 125, 205, 68);
		contentPane.add(btnNutricionista);
		
		JButton btnMesecna = new JButton("Mese\u010Dna karta");
		btnMesecna.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameMesecnaKarta JFMesecnaKarta= new JFrameMesecnaKarta();
				JFMesecnaKarta.show();
				dispose();
			}
		});
		btnMesecna.setForeground(new Color(255, 255, 255));
		btnMesecna.setBackground(new Color(240, 128, 128));
		btnMesecna.setFont(new Font("Microsoft YaHei Light", Font.BOLD, 18));
		btnMesecna.setBounds(147, 226, 205, 68);
		contentPane.add(btnMesecna);
		
		JButton btnNazad = new JButton("");
		btnNazad.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrameLogin JFRLogin= new JFrameLogin();
				JFRLogin.show();
				dispose();
			}
		});
		btnNazad.setBackground(new Color(255, 255, 255));
		btnNazad.setIcon(new ImageIcon("image\\icons8-back-arrow-30.png"));
		btnNazad.setBounds(10, 452, 74, 45);
		btnNazad.setFocusPainted(false);
		contentPane.add(btnNazad);
		
		JLabel lblNewLabel = new JLabel("");
		lblNewLabel.setIcon(new ImageIcon("image\\pexels-photo-3764014.jpeg"));
		lblNewLabel.setBounds(0, 0, 500, 572);
		contentPane.add(lblNewLabel);
	}
}
