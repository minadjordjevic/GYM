package projekatt;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class Nutricionista extends Osoba{

	private String godineIskustva;
	
	public Nutricionista() {}

	public Nutricionista(String ime, String prezime, String brojTel, String godinaIskustva) {
		super(ime, prezime, brojTel);
		this.godineIskustva = godinaIskustva;

	}

	public String getGodineIskustva() {
		return godineIskustva;
	}

	public void setGodineIskustva(String godinaIskustva) {
		this.godineIskustva = godinaIskustva;
	}
	
	private Scanner x;
	
	private Nutricionista iscitavanjeIzDatoteke(String imeDat, String i) {
		try {
			x = new Scanner(new File(imeDat)); // datoteka kreirana u folderu iz koje iscitavamo
		} catch (FileNotFoundException e1) {
			System.out.println("File not Found!");
			return null;
		}
		String ime = "";
		String prezime = "";
		String brojTel = "";
		String godIskustva = "";
		int brojZvezdice = 0;
		
		while (x.hasNext()) // cita red po red u datoteci
		{
			
//			TODO: logika kog nutricionistu ce da iscita
			if (i.toLowerCase().equals("marija")) {  	//pretvara string u mala slova 
				ime = x.nextLine();
				prezime = x.nextLine();
				brojTel = x.nextLine();
				godIskustva = x.nextLine();
				break;
			}
			else if (i.toLowerCase().equals("aleksandar")) {
				for(int j = 0; j < 5;j ++) {
					x.nextLine();
				}
				ime = x.nextLine();
				prezime = x.nextLine();
				brojTel = x.nextLine();
				godIskustva = x.nextLine();
				break;
			}
			else if (i.toLowerCase().equals("jelena")) {
				for(int j = 0; j < 10;j ++) {
					x.nextLine();
				}
				ime = x.nextLine();
				prezime = x.nextLine();
				brojTel = x.nextLine();
				godIskustva = x.nextLine();
				break;
			}
			System.out.println(x.nextLine());
		}
		x.close();
		return new Nutricionista(ime, prezime, brojTel, godIskustva);
	}
	
	public Nutricionista getNutricionista(String ime_fajla, String ime_nutricioniste) {
		return this.iscitavanjeIzDatoteke(ime_fajla, ime_nutricioniste);
	}
	
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
	
	public Klijent getKlijent() {
		return this.iscitavanjeIzDatoteke("Klijenti.txt");
	}
	
	public double idealnaMuska() {
		double s=0;
		s= Integer.parseInt(getKlijent().getVisina()) -100;
		return s;
	}
	public double idealnaZenska() {
		double z=0;
		z= Integer.parseInt(getKlijent().getVisina()) -110;
		return z;
	}
	
	@Override
	public String toString() {
		return "Nutricionista" + super.toString() + "godinaIskustva=" + godineIskustva;
	}
}
