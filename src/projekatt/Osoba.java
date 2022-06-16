package projekatt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.Scanner;

public class Osoba {
	private String ime;
	private String prezime;
	private String brojTel;

	public Osoba() {
	}

	public Osoba(String ime, String prezime, String brojTel) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.brojTel = brojTel;

	}

	public String getIme() {
		return ime;
	}

	public void setIme(String ime) {
		this.ime = ime;
	}

	public String getPrezime() {
		return prezime;
	}

	public void setPrezime(String prezime) {
		this.prezime = prezime;
	}

	public String getBrojTel() {
		return brojTel;
	}

	public void setBrojTel(String brojTel) {
		this.brojTel = brojTel;
	}

	// citanje unosa iz datoteke
	private Scanner x;

//	public void citajListu(String imeDat, ArrayList<Osoba> lista) {
//		try {
//			x = new Scanner(new File("Ulogovani.txt")); // datoteka kreirana u folderu iz koje iscitavamo
//		} catch (FileNotFoundException e1) {
//			System.out.println("File not Found!");
//		}
//		while (x.hasNext()) // cita red po red u datoteci
//		{
//			String ime = x.nextLine();
//			String prezime = x.nextLine();
//			String adresa = x.nextLine();
//			String JMBG = x.nextLine();
//			String brojTel = x.nextLine();
//			String pol = x.nextLine();
//			String tezina = x.nextLine();
//			String visina = x.nextLine();
//			String korisnicko = x.nextLine();
//			String lozinka = x.nextLine();
//
//			Osoba s = new Osoba(ime, prezime, adresa, JMBG, brojTel, pol, tezina, visina, korisnicko, lozinka);
//			lista.add(s);
//		}
//		x.close(); // zatvaranje datoteke
//	}

	@Override
	public String toString() {
		return "\nIme=" + ime + "\nPrezime=" + prezime + "\nBroj telefona= " + brojTel;
	}
}