package model;

import java.util.List;

public class Render {
	
	private long id;
	private String naziv;
	private String materijal;
	private String kamera;
	private String svetlo;
	private String objekat;
	
	public Render(long id, List<String> materijal, List<String> kamera, List<String> svetlo, List<String> objekat, String naziv) {
		super();
		this.id = id;
		this.materijal = materijal;
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
	
	public String getMaterial() {
		return materijal;
	}

	public void setMaterial(String materijal) {
		this.materijal = materijal;
	}
	
	public String getCamera() {
		return kamera;
	}

	public void setCamera(String kamera) {
		this.kamera = kamera;
	}
	
	public String getLight() {
		return svetlo;
	}

	public void setLight(String svetlo) {
		this.svetlo = svetlo;
	}
	
	public String getObject() {
		return objekat;
	}

	public void setObject(String objekat) {
		this.objekat = objekat;
	}
	
	@Override
	public String toString() {
		return naziv + "," + materijal + "," + kamera + "," + svetlo + "," + objekat;
	}
}
