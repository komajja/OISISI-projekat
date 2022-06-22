package model;

import java.awt.Color;

public class Brush {
	
	private long id;		//NOVO
	private String naziv;
	private String namena;
	private Color boja; //? kako se moze prikazati mozda u panel neki?
	
	public Brush(long id, String naziv, String namena, Color boja) {
		super();
		this.id = id;
		this.naziv = naziv;
		this.namena = namena;
		this.boja = boja;
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
	
	public String getUse() {
		return namena;
	}

	public void setUse(String namena) {
		this.namena = namena;
	}
	
	public Color getColor() {
		return boja;
	}

	public void setColor(Color boja) {
		this.boja = boja;
	}
	
	public String bString() {
		StringBuilder out = new StringBuilder();
		out.append(naziv);
		out.append(" (");
		out.append(namena);
		out.append(", ");
		out.append("rgb(");
		out.append(String.valueOf(boja.getRed())+","+String.valueOf(boja.getGreen())+","+String.valueOf(boja.getBlue()));
		out.append(")");
		out.append(")");
		return out.toString();
	}
}
