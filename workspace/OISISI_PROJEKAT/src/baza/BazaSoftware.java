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

	public static List<Software> softwares = new ArrayList<Software>();
	private List<String> kolones;
	
	static Software software_a= new Software(1, "3ds Max", new ArrayList<Brush>(List.of(BazaCetkica.brush_a)), new ArrayList<String>(List.of("Noise", "Bevel")),".max", new ArrayList<String>(List.of("Bone tool", "Curve graph")), new ArrayList<Render>(List.of(BazaRenderi.render_a)));
	static Software software_b= new Software(2, "Zbrush", new ArrayList<Brush>(List.of(BazaCetkica.brush_a,BazaCetkica.brush_b, BazaCetkica.brush_c)), new ArrayList<String>(List.of("Extrude")), ".obj", new ArrayList<String>(List.of("MassFX", "Constraints")), new ArrayList<Render>(List.of(BazaRenderi.render_b)));
	static Software software_c= new Software(3, "Blender", new ArrayList<Brush>(List.of(BazaCetkica.brush_c)), new ArrayList<String>(List.of("Bevel")), ".fbx", new ArrayList<String>(List.of("Constraints", "Timeline")), new ArrayList<Render>(List.of(BazaRenderi.render_a)));
	static Software software_d= new Software(4, "Maya", new ArrayList<Brush>(List.of(BazaCetkica.brush_a, BazaCetkica.brush_b)), new ArrayList<String>(List.of("Cloth", "Extrude")),".max", new ArrayList<String>(List.of("Bone tool", "MassFX")), new ArrayList<Render>(List.of(BazaRenderi.render_b)));
	static Software software_e= new Software(5, "Photoshop", new ArrayList<Brush>(List.of(BazaCetkica.brush_b, BazaCetkica.brush_a)), new ArrayList<String>(List.of("Noise")),".ps", new ArrayList<String>(List.of("Bone tool", "Curve graph")), new ArrayList<Render>(List.of(BazaRenderi.render_a)));
	static Software software_f= new Software(6, "Cinema4D", new ArrayList<Brush>(List.of(BazaCetkica.brush_a, BazaCetkica.brush_c)), new ArrayList<String>(List.of("Edit Poly")),".max", new ArrayList<String>(List.of("Bone tool", "Curve graph", "MassFX")), new ArrayList<Render>(List.of(BazaRenderi.render_a)));
	
	private BazaSoftware() {
		
		initSoftwares();
		
		this.kolones = new ArrayList<String>();
		this.kolones.add("Name");
		this.kolones.add("Brush (use,color) - hover to see colour");
		this.kolones.add("Modifiers");
		this.kolones.add("File format");
		this.kolones.add("Animation tools");
		this.kolones.add("Render (materials, cameras, light, objects)");

	}

	private void initSoftwares() {
		this.softwares = new ArrayList<Software>();
		softwares.add(software_a);
		softwares.add(software_b);
		softwares.add(software_c);
		softwares.add(software_d);
		softwares.add(software_e);
		softwares.add(software_f);
	}
	
	public List<Software> getSoftware() {
		return this.softwares;
	}
	
	public void setSoftware(List<Software> softwares) {
		this.softwares = softwares;
	}
	
	public String getColumnName(int index) {
		return this.kolones.get(index);
	}
	
	public Software getRow(int rowIndex) {
		return this.softwares.get(rowIndex);
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

	public void editSoftware(String trnNaziv, String naziv, List<Brush> cetkica, List<String> modifikator, String fajlFormat, List<String>  animationTool, List<Render> render) {
		for (Software software : softwares) {
			if (software.getName() == trnNaziv) {
				software.setName(naziv);
				software.setCetkice(cetkica);
				software.setModif(modifikator);
				software.setFFormat(fajlFormat);
				software.setAlati(animationTool);
				software.setRenders(render);
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
			return conv2StringM(software.getModif());
		case 3:
			return software.getFFormat();
		case 4:
			return conv2StringAT(software.getAlati());
		case 5:
			return conv2StringR(software.getRenders());
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
	
	public String conv2StringM(List<String> modif) {
		
		StringBuilder out = new StringBuilder();
		for (int a = 0; a<modif.size(); a++) {
			String b = modif.get(a);
			out.append(b);
			if(!(a == modif.size()-1)) {
			out.append(", ");
			}
		 }
		return out.toString();
	}
	
	public String conv2StringR(List<Render> renderi) {
		
		StringBuilder out = new StringBuilder();
		for (int a = 0; a<renderi.size(); a++) {
			Render r = renderi.get(a);
			out.append(r.toString());
			if(!(a == renderi.size()-1)) {
			out.append(", ");
			}
		 }
		return out.toString();
	}
}