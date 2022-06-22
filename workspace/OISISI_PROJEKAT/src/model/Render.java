package model;

import java.util.List;

public class Render {
	
	private long id;
	private String naziv;
	private List<String> materijali;
	private List<String> kamere;
	private List<String> svetla;
	private List<String> objekti;
	
	public Render(long id, String naziv, List<String> materijali, List<String> kamere, List<String> svetla, List<String> objekti) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.materijali = materijali;
		this.kamere = kamere;
		this.svetla = svetla;
		this.objekti = objekti;
	}
	
	public Render(String naziv, List<String> materijali, List<String> kamere, List<String> svetla, List<String> objekti) {
		super();
		this.naziv = naziv;
		this.materijali = materijali;
		this.kamere = kamere;
		this.svetla = svetla;
		this.objekti = objekti;
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
	
	public List<String> getMaterials() {
		return materijali;
	}

	public void setMaterials(List<String> materijali) {
		this.materijali = materijali;
	}
	
	public List<String> getCameras() {
		return kamere;
	}

	public void setCameras(List<String> kamere) {
		this.kamere = kamere;
	}
	
	public List<String> getLight() {
		return svetla;
	}

	public void setLight(List<String> svetlo) {
		this.svetla = svetlo;
	}
	
	public List<String> getObjects() {
		return objekti;
	}

	public void setObject(List<String> objekti) {
		this.objekti = objekti;
	}
	
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		sb.append(naziv);
		sb.append(" (");
		for (int a = 0; a<materijali.size(); a++) {
			String m = materijali.get(a);
			sb.append(m);
			if(!(a == materijali.size()-1)) {
			sb.append(", ");
			}
		 }
		sb.append("; ");
		for (int a = 0; a<kamere.size(); a++) {
			String c = kamere.get(a);
			sb.append(c);
			if(!(a == kamere.size()-1)) {
			sb.append(", ");
			}
		}
		sb.append("; ");
		for (int a = 0; a<svetla.size(); a++) {
			String c = svetla.get(a);
			sb.append(c);
			if(!(a == svetla.size()-1)) {
			sb.append(", ");
			}
		}
		sb.append("; ");
		for (int a = 0; a<objekti.size(); a++) {
			String o = objekti.get(a);
			sb.append(o);
			if(!(a == objekti.size()-1)) {
			sb.append(", ");
			}
		 }
		sb.append(" )");
		return sb.toString();
	}
}
