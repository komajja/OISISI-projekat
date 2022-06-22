package model;

import java.util.ArrayList;
import java.util.List;

public class Render {
	
	private long id;
	private String naziv;
	private List<String> materijali = new ArrayList<String>();
	private List<String> kamera = new ArrayList<String>();
	private String svetlo;
	private List<String> objekat = new ArrayList<String>();;
	
	public Render(long id, List<String> materijali, List<String> kamera, String svetlo, List<String> objekat, String naziv) {
		super();
		this.id = id;
		this.materijali = materijali;
		this.kamera = kamera;
		this.svetlo = svetlo;
		this.objekat = objekat;
		this.naziv = naziv;
	}
	
	public long getId() {		//NOVO
		return id;
	}

	public void setId(long id) {		//NOVO
		this.id = id;
	}
	
	public String getName() {
		return naziv;
	}

	public void setName(String naziv) {
		this.naziv = naziv;
	}
	
	public List<String> getMaterijali() {
		return materijali;
	}
	public void setMaterijali(List<String> materijali) {
		this.materijali = materijali;
	}
	
	public List<String> getKamera() {
		return kamera;
	}
	public void setKamere(List<String> kamera) {
		this.kamera = kamera;
	}
	
	public String getLight() {
		return svetlo;
	}

	public void setLight(String svetlo) {
		this.svetlo = svetlo;
	}
	
	public List<String> getObjekat() {
		return objekat;
	}
	public void setObjekti(List<String> objekat) {
		this.objekat = objekat;
	}
	
	@Override
	public String toString() {
		return naziv + "," + materijali + "," + kamera + "," + svetlo + "," + objekat;
	}
}
