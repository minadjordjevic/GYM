package projekatt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

public class Klijent extends Osoba {
	private String adresa;
	private String JMBG;
	private String pol;
	private String tezina;
	private String visina;
	private String korisnickoIme;
	private String lozinka;

	public Klijent() {
	}

	public Klijent(String ime, String prezime, String adresa, String jMBG, String brojTel, String pol, String tezina,
			String visina, String korisnicko, String lozinka) {
		super(ime, prezime, brojTel);
		this.adresa = adresa;
		this.JMBG = jMBG;
		this.pol = pol;
		this.tezina = tezina;
		this.visina = visina;
		this.korisnickoIme = korisnicko;
		this.lozinka = lozinka;
	}

	public String getAdresa() {
		return adresa;
	}

	public void setAdresa(String adresa) {
		this.adresa = adresa;
	}

	public String getJMBG() {
		return JMBG;
	}

	public void setJMBG(String jMBG) {
		JMBG = jMBG;
	}

	public String getPol() {
		return pol;
	}

	public void setPol(String pol) {
		this.pol = pol;
	}

	public String getTezina() {
		return tezina;
	}

	public void setTezina(String tezina) {
		this.tezina = tezina;
	}

	public String getVisina() {
		return visina;
	}

	public void setVisina(String visina) {
		this.visina = visina;
	}

	public String getKorisnickoIme() {
		return korisnickoIme;
	}

	public void setKorisnickoIme(String korisnicko) {
		this.korisnickoIme = korisnicko;
	}

	public String getLozinka() {
		return lozinka;
	}

	public void setLozinka(String lozinka) {
		this.lozinka = lozinka;
	}

	private Scanner x;

	private Klijent iscitavanjeIzDatoteke(String imeDat) {
		try {
			x = new Scanner(new File(imeDat)); // datoteka kreirana u folderu iz koje iscitavamo
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

	private void upisivanjeUDatoteku(String imeDat, Klijent klijent) throws IOException {
		FileWriter upis = new FileWriter(imeDat, true);
		upis.write(klijent.getIme() + "\n");
		upis.write(klijent.getPrezime() + "\n");
		upis.write(klijent.getAdresa() + "\n");
		upis.write(klijent.getJMBG() + "\n");
		upis.write(klijent.getBrojTel() + "\n");
		upis.write(klijent.getPol() + "\n");
		upis.write(klijent.getTezina() + "\n");
		upis.write(klijent.getVisina() + "\n");
		upis.write(klijent.getKorisnickoIme() + "\n");
		upis.write(klijent.getLozinka() + "\n");

		upis.close();

	}

	//prijavljivanje korisnika
	public Klijent login(String imeDat) {
		return this.iscitavanjeIzDatoteke(imeDat);
	}
	//odnosi se na novi nalog- registracija 
	public void registracija(String imeDat, Klijent klijent) throws IOException {
		this.upisivanjeUDatoteku(imeDat, klijent);
	}
	//prikaz podataka Korisnika iz datoteke
	public String prikazKorisnikovihPodataka() {
		return this.iscitavanjeIzDatoteke("Klijenti.txt").toString();
	}

	@Override
	public String toString() {
		return "Klijent " + super.toString() + "\nAdresa=" + adresa + "\nJMBG=" + JMBG + "\npol=" + pol + "\ntezina="
				+ tezina + "\nvisina=" + visina + "\nkorisnicko=" + korisnickoIme + "\nlozinka=" + lozinka;
	}

}
