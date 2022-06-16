package projekatt;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class Trening {
	private String program;
	private String trener;
	private int datum;
	private String  vreme;
	private Klijent klijent;
	private Nutricionista nutricionista;
	
	public Trening() {
		
	}
	
	public Trening(String program, String trener, int datum, String vreme) {
		super();
		this.program = program;
		this.trener = trener;
		this.datum = datum;
		this.vreme = vreme;
		this.klijent = getKlijent();
		this.nutricionista = getNutricionista();
	}
	
	public String getProgram() {
		return program;
	}
	
	public void setProgram(String program) {
		this.program = program;
	}
	
	public String getTrener() {
		return trener;
	}
	
	public void setTrener(String trener) {
		this.trener = trener;
	}
	
	public int getDatum() {
		return datum;
	}
	
	public void setDatum(int datum) {
		this.datum = datum;
	}
	
	public String getVreme() {
		return vreme;
	}
	
	public void setVreme(String vreme) {
		this.vreme = vreme;
	}
	
	Scanner x;
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
	
	private Nutricionista getNutricionista() {
		try {
			x = new Scanner(new File("Nutricionista.txt")); // datoteka kreirana u folderu iz koje iscitavamo
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
			
				ime = x.nextLine();
				prezime = x.nextLine();
				brojTel = x.nextLine();
				godIskustva = x.nextLine();
				break;
		
		}
		x.close();
		return new Nutricionista(ime, prezime, brojTel, godIskustva);
	}
	
	private void upisPodatakaUDatoteku(String naziv_datoteke, Trening trener) throws IOException {
		FileWriter reader = new FileWriter(naziv_datoteke);
		reader.write(trener.getProgram() + "\n");
		reader.write(trener.getTrener() + "\n");
		reader.write(trener.getDatum() + "\n");
		reader.write(trener.getVreme() + "\n");
		reader.close();
	}
	
	public void rezervacijaTreninga(String naziv_datoteke, Trening trening) throws IOException {
		this.upisPodatakaUDatoteku(naziv_datoteke, trening);
	}
	
	private Trening iscitavanjeIzDatoteka(String naziv_datoteke) {
		try {
			x = new Scanner(new File(naziv_datoteke)); // datoteka kreirana u folderu iz koje iscitavamo
		} catch (FileNotFoundException e1) {
			System.out.println("File not Found!");
		}
		while (x.hasNext()) // cita red po red u datoteci
		{
			String program = x.nextLine();
			String trener = x.nextLine();
			Integer datum = Integer.parseInt(x.nextLine());
			String vreme = x.nextLine();
			
			x.close();
			return new Trening(program, trener, datum, vreme);
		}
		return null;
	}
	
	public String prikazZakazanihTerminaTreninga(String naziv_datoteke) {
		Trening t =  this.iscitavanjeIzDatoteka(naziv_datoteke);
		return t.getProgram() + "\n" + t.getTrener() + "\n" + t.getDatum() + "\n" + t.getVreme();
	}

	@Override
	public String toString() {
		System.out.println("Trening [program=" + program + ", trener=" + trener + ", datum=" + datum + ", vreme=" + vreme
				+ ", klijent=" + klijent.toString() + ", nutricionista=" + nutricionista.toString() + ", x=" + x + "]");
		return "Trening [program=" + program + ", trener=" + trener + ", datum=" + datum + ", vreme=" + vreme
				+ ", klijent=" + klijent.toString() + ", nutricionista=" + nutricionista.toString() + ", x=" + x + "]";
	}
}