package projekatt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class ClanskaKarta {

	private String naziv;
	private boolean traka;
	private String email;
	private int ziroRacun;
	private int cena;
	private Klijent klijent;

	public ClanskaKarta() {
	};

	public ClanskaKarta(String naziv, boolean traka, String email, int ziroRacun, int cena) {
		super();
		this.naziv = naziv;
		this.traka = traka;
		this.email = email;
		this.ziroRacun = ziroRacun;
		this.cena = cena;
		klijent = getKlijent();
	}

	public Klijent vratiKlijenta() {
		return this.klijent;
	}

	public String getNaziv() {
		return naziv;
	}

	public void setNaziv(String naziv) {
		this.naziv = naziv;
	}

	public boolean isTraka() {
		return traka;
	}

	public void setTraka(boolean traka) {
		this.traka = traka;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public int getZiroRacun() {
		return ziroRacun;
	}

	public void setZiroRacun(int ziroRacun) {
		this.ziroRacun = ziroRacun;
	}

	public int getCena() {
		return cena;
	}

	public void setCena(int cena) {
		this.cena = cena;
	}

	public double Racun() {
		if (traka == true) {
			return 300 + cena;
		} else {
			return cena;
		}
	}

	private Scanner x;

	private ClanskaKarta iscitavanjeIzDatoteke(String imeDat) {
		try {
			x = new Scanner(new File(imeDat)); // datoteka kreirana u folderu iz koje iscitavamo
		} catch (FileNotFoundException e1) {
			System.out.println("File not Found!");
		}
		while (x.hasNext()) // cita red po red u datoteci
		{
			String naziv = x.nextLine();
			String traka = x.nextLine();
			String email = x.nextLine();
			String ziroRacun = x.nextLine();
			String cena = x.nextLine();

			x.close();
			return new ClanskaKarta(naziv, Boolean.parseBoolean(traka), email, Integer.parseInt(ziroRacun),
					Integer.parseInt(cena));
		}
		return null;
	}

	private void upisivanjeUdatoteku(ClanskaKarta ck) throws IOException {
		FileWriter ckarta = new FileWriter("ClanskaKarta.txt");

		ckarta.write(ck.getNaziv() + "\n");
		ckarta.write(ck.isTraka() + "\n");
		ckarta.write(ck.getEmail() + "\n");
		ckarta.write(ck.getZiroRacun() + "\n");
		ckarta.write(ck.getCena() + "\n");

		ckarta.close();
	}

	public void upisivanjeClanskeKarte(ClanskaKarta ck) throws IOException {
		this.upisivanjeUdatoteku(ck);
	}

	public String prikazRacuna(String naziv_fajla) {
		ClanskaKarta ck = this.iscitavanjeIzDatoteke(naziv_fajla);
		return "Izabrali ste " + ck.getNaziv() + " kartu. \nVas racun iznosi: " + ck.getCena() + " dinara.\n";
	}

	private Klijent getKlijent() {
		try {
			x = new Scanner(new File("Klijenti.txt")); // datoteka kreirana u folderu iz koje iscitavamo
		} catch (FileNotFoundException e1) {
			System.out.println("File not Found!");
		}
		while (x.hasNext()) // cita red po red u datoteci
		{
			String ime = x.nextLine();
			String prezime = x.nextLine();
			String adresa = x.nextLine();
			String JMBG = x.nextLine();
			String brojTel = x.nextLine();
			String pol = x.nextLine();
			String tezina = x.nextLine();
			String visina = x.nextLine();
			String korisnicko = x.nextLine();
			String lozinka = x.nextLine();

			x.close(); // zatvaranje datoteke
			return new Klijent(ime, prezime, adresa, JMBG, brojTel, pol, tezina, visina, korisnicko, lozinka);

		}
		return null;
	}

	@Override
	public String toString() {
		return "ClanskaKarta [naziv=" + naziv + ", traka=" + traka + ", email=" + email + ", ziroRacun=" + ziroRacun
				+ ", cena=" + cena + ", klijent=" + klijent.toString() + ", x=" + x + "]";
	}

}
