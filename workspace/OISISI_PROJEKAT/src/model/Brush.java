package model;

import java.awt.Color;

public class Brush {
	
	private long id;		//NOVO
	private String naziv;
	private String namena;
	private Color boja; //? kako se moze prikazati mozda u panel neki?
	public String getName() {
		return naziv;
	}
	
	public Brush(long id, String naziv, String namena, Color boja) {
		super();
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
	
	@Override
	public String toString() {
		return naziv + "," + namena + "," + boja ;
	}
}
