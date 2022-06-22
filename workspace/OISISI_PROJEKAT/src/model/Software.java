package model;

import java.util.ArrayList;
import java.util.List;

public class Software {
	private long id;		//NOVO
	private String naziv;
	private List<Brush> cetkice = new ArrayList<Brush>();
	private String modifikator;
	private String fajlFormat;
	private List<String> animationTool = new ArrayList<String>();
	private Render render;

	
	public Software(long id, String naziv, List<Brush> cetkice, String modifikator, String fajlFormat, List<String>  animationTool, Render render) {
		super();
		this.id = id;		//NOVO KAO I PRVI ARGUMENT 
		this.naziv = naziv;
		this.cetkice = cetkice;
		this.modifikator = modifikator;
		this.fajlFormat = fajlFormat;
		this.animationTool = animationTool;
		this.render = render;
	}
	
	public Software(String naziv, List<Brush> cetkice, String modifikator, String fajlFormat, List<String>  animationTool, Render render) {
		super();
		this.naziv = naziv;
		this.cetkice = cetkice;
		this.modifikator = modifikator;
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
	
	public String getModif() {
		return modifikator;
	}

	public void setModif(String modifikator) {
		this.modifikator = modifikator;
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
	
	public Render getRender() {
		return render;
	}

	public void setRender(Render render) {
		this.render = render;
	}

	
	
	
	

}
