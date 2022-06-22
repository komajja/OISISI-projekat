package model;

public class Software {
	private long id;		//NOVO
	private String naziv;
	private Brush cetkica;
	private String modifikator;
	private String fajlFormat;
	private String animationTool;
	private Render render;

	
	public Software(long id, String naziv, Brush cetkica, String modifikator, String fajlFormat, String animationTool, Render render) {
		super();
		this.id = id;		//NOVO KAO I PRVI ARGUMENT 
		this.naziv = naziv;
		this.cetkica = cetkica;
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

	public Brush getBrush() {
		return cetkica;
	}

	public void setNaziv(Brush cetkica) {
		this.cetkica = cetkica;
	}
	
	//
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
	
	public String getATool() {
		return animationTool;
	}

	public void setATool(String animationTool) {
		this.animationTool = animationTool;
	}
	
	public Render getRenderl() {
		return render;
	}

	public void setRender(Render render) {
		this.render = render;
	}

	
	
	
	

}
