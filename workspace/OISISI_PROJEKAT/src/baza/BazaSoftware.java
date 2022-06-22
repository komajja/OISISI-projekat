package baza;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import model.Adress;
import model.Brush;
import model.Employee;
import model.Render;
import model.Software;

public class BazaSoftware {
	
	private static BazaSoftware instance = null;

	public static BazaSoftware getInstance() {
		if (instance == null) {
			instance = new BazaSoftware();
		}
		return instance;
	}
	
	private long generator;

	public static List<Software> softwares = new ArrayList<Software>();
	private List<String> kolone;
	
	static Brush brush_a = new Brush(1, "Move", "Pomera geometriju", new Color(10, 10, 10, 0));
	static Brush brush_b = new Brush(2, "Curve", "Dodaje oblike", new Color(2, 5, 50, 0));
	static Brush brush_c = new Brush(3, "Polish", "Uglacava povrsinu", new Color(45, 80, 4, 0));
	
	static Render render_a = new Render(1,"Zlatnik", new ArrayList<String>(List.of("voda", "zemlja", "zlato")), 
			new ArrayList<String>(List.of("cam1", "cam 2")), "svetlo1", 
			new ArrayList<String>(List.of("blato, reka, zlatnik, bara")));
	static Render render_b = new Render(2, "Igracke", new ArrayList<String>(List.of("plastika", "metal", "pesak")), 
			new ArrayList<String>(List.of("cam2", "cam5")), "svetlo2", 
			new ArrayList<String>(List.of("tobogan, ljuljaska, igracke, jama")));
		
	static Software software_a= new Software(1, "3ds Max", new ArrayList<Brush>(List.of(brush_a, brush_b)), "Noise",".max", new ArrayList<String>(List.of("bone tool, curve graph")), render_a);
	static Software software_b= new Software(1, "Zbrush", new ArrayList<Brush>(List.of(brush_b,brush_c,brush_a)), "Extrude", ".obj", new ArrayList<String>(List.of("animationTool")), render_b);
	static Software software_c= new Software(1, "Blender", new ArrayList<Brush>(List.of(brush_c)), "Bevel", ".fbx", new ArrayList<String>(List.of("animationTool")), render_a);
	
	
	private BazaSoftware() {
		generator = 0;
		
		initSoftwares();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Name");
		this.kolone.add("Brush (use,color) - hover to see colour");
		this.kolone.add("Modifier");
		this.kolone.add("File format");
		this.kolone.add("Animation tools");
		this.kolone.add("Render (materials, cameras, light, objects)");
	}

	private void initSoftwares() {
		this.softwares = new ArrayList<Software>();
		softwares.add(software_a);
		softwares.add(software_b);
		softwares.add(software_c);
	}
	
	public List<Software> getSoftware() {
		return this.softwares;
	}
	
	public void setSoftware(List<Software> softwares) {
		this.softwares = softwares;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Software getRow(int rowIndex) {
		return this.softwares.get(rowIndex);
	}
	
	private long generateId() {
		return ++generator;
	}
	
	public void addSoftware(Software s) {
		this.softwares.add(s);
	}

	public void deleteSoftware(long id) {
		for (Software software : softwares) {
			if (software.getId() == id) {
				softwares.remove(software);
				break;
			}
		}
	}

	public void editSoftware(long id, String naziv, List<Brush> cetkica, String modifikator, String fajlFormat, List<String>  animationTool, Render render) {
		for (Software software : softwares) {
			if (software.getId() == id) {
				software.setName(naziv);
				software.setCetkice(cetkica);
				software.setModif(modifikator);
				software.setFFormat(fajlFormat);
				software.setAlati(animationTool);
				software.setRender(render);
			}
		}
	}

	public Object getValueAt(int row, int column) {
		Software software;
		software = softwares.get(row);
		switch (column) {
		case 0:
			return software.getName();
		case 1:
			return conv2StringB(software.getCetkice());
		case 2:
			return software.getModif();
		case 3:
			return software.getFFormat();
		case 4:
			return conv2StringAT(software.getAlati());
		case 5:
			return software.getRender().toString();
		default:
		return null;
	}
}
	public String conv2StringB(List<Brush> cetkice) {
		
		StringBuilder out = new StringBuilder();
		for (int a = 0; a<cetkice.size(); a++) {
			Brush b = cetkice.get(a);
			out.append(b.bString());
			if(!(a == cetkice.size()-1)) {
			out.append(", ");
			}
		 }
		return out.toString();
	}
	
	public String conv2StringAT(List<String> alati) {
		
		StringBuilder out = new StringBuilder();
		for (int a = 0; a<alati.size(); a++) {
			String b = alati.get(a);
			out.append(b);
			if(!(a == alati.size()-1)) {
			out.append(", ");
			}
		 }
		return out.toString();
	}
}