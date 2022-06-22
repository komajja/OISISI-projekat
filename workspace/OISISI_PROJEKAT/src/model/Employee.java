package model;

import java.util.ArrayList;
import java.util.List;

public class Employee {

	private long id;		//NOVO
	private String ime;
	private String prezime;
	private String jmbg;
	private List<String> datumRodjenja = new ArrayList<String>();
	private String email;
	private Adress adresa;
	private Software softver;
	private String radnoMesto;
	
	public Employee() {
		super();
	}
	
	public Employee(long id, String ime, String prezime, String jmbg, List<String> datumRodjenja, String email, Adress adresa, Software softver, String radnoMesto) {
		super();
		this.id = id;		//NOVO KAO I PRVI ARGUMENT 
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.email = email;
		this.adresa = adresa;
		this.softver = softver;
		this.radnoMesto=radnoMesto;
		}
	
	public Employee(String ime, String prezime, String jmbg, List<String> datumRodjenja, String email, Adress adresa, Software softver, String radnoMesto) {
		super();
		this.ime = ime;
		this.prezime = prezime;
		this.jmbg = jmbg;
		this.datumRodjenja = datumRodjenja;
		this.email = email;
		this.adresa = adresa;
		this.softver = softver;
		this.radnoMesto=radnoMesto;
		}

	public long getId() {		//NOVO
		return id;
	}

	public void setId(long id) {		//NOVO
		this.id = id;
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

public String getJmbg() {
	return jmbg;
}

public void setJmbg(String jmbg) {
	this.jmbg = jmbg;
}

public List<String> getDatumRodjenja() {
	return datumRodjenja;
}

public void setDatumRodjenja(List<String> datumRodjenja) {
	this.datumRodjenja = datumRodjenja;
}


public String getEmail() {
	return email;
}

public void setEmail(String email) {
	this.email = email;
}


public Adress getAdresa() {
	return adresa;
}

public void setAdresa(Adress adresa) {
	this.adresa = adresa;
}

public Software getSoftver() {
	return softver;
}

public void setSoftver(Software softver) {
	this.softver = softver;
}

public String getRadnoMesto() {
	return radnoMesto;
}

public void setRadnoMesto(String radnoMesto) {
	this.radnoMesto = radnoMesto;
}

//da li treba jos nesto?

}