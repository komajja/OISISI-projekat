package model;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import baza.BazaSoftware;

public class Software {
	
	
	private long id;		//NOVO
	private String naziv;
	private List<Brush> cetkice;
	private List<String> modifikatori;
	private String fajlFormat;
	private List<String> animationTool;
	private List<Render> render;

	public Software(long id, String naziv, List<Brush> cetkice, List<String> modifikatori, String fajlFormat, List<String>  animationTool, List<Render> render) {
		super();
		this.id = id;		//NOVO KAO I PRVI ARGUMENT 
		this.naziv = naziv;
		this.cetkice = cetkice;
		this.modifikatori = modifikatori;
		this.fajlFormat = fajlFormat;
		this.animationTool = animationTool;
		this.render = render;
	}
	
	public Software(String naziv, List<Brush> cetkice, List<String> modifikatori, String fajlFormat, List<String>  animationTool, List<Render> render) {
		super();
		this.naziv = naziv;
		this.cetkice = cetkice;
		this.modifikatori = modifikatori;
		this.fajlFormat = fajlFormat;
		this.animationTool = animationTool;
		this.render = render;
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

	public List<Brush> getCetkice() {
		return cetkice;
	}
	
	public void setCetkice(List<Brush> cetkice) {
		this.cetkice = cetkice;
	}
	
	public List<String> getModif() {
		return modifikatori;
	}

	public void setModif(List<String> modifikatori) {
		this.modifikatori = modifikatori;
	}
	
	public String getFFormat() {
		return fajlFormat;
	}

	public void setFFormat(String fajlFormat) {
		this.fajlFormat = fajlFormat;
	}
	
	public List<String> getAlati() {
		return animationTool;
	}
	public void setAlati(List<String> animationTool) {
		this.animationTool = animationTool;
	}
	
	public List<Render> getRenders() {
		return render;
	}

	public void setRenders(List<Render> render) {
		this.render = render;
	}
	
}
