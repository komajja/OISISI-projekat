package baza;

import java.awt.Color;
import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;


import model.Adress;
import model.Brush;
import model.Employee;
import model.Render;
import model.Software;

public class Baza{
	public static List<Adress> adresses = new ArrayList<Adress>();
	public static List<Brush> brushes = new ArrayList<Brush>();
	public static List<Employee>employees  = new ArrayList<Employee>();
	public static List<Render> renders = new ArrayList<Render>();
	public static List<Software> software = new ArrayList<Software>();
	
	static Adress adress_a = new Adress (1, "Balzakova", 21, "Novi Sad");
	static Adress adress_b= new Adress (2, "Njegoseva", 4, "Novi Sad");
	static Adress adress_c= new Adress (3,  "Pariska", 5, "Beograd");
	
	static Brush brush_a = new Brush(1, "Move", "Pomera geometriju", new Color(0, 0, 0, 0));
	static Brush brush_b = new Brush(2, "Curve", "Dodaje oblike", new Color(0, 0, 0, 0));
	static Brush brush_c = new Brush(3, "Polish", "Uglacava povrsinu", new Color(0, 0, 0, 0));
	
	static Render render_a = new Render(1, new ArrayList<String>(List.of("voda", "zemlja", "zlato")), 
			new ArrayList<String>(List.of("cam1")), 
			new ArrayList<String>(List.of("blato, reka, zlatnik, bara")), "Zlatnik");
	static Render render_b = new Render(2, new ArrayList<String>(List.of("plastika", "metal", "pesak")), 
			new ArrayList<String>(List.of("cam2")), 
			new ArrayList<String>(List.of("tobogan, ljuljaska, igracke, jama")), "Igracke");
		
	static Software software_a= new Software(1, "3ds Max", new ArrayList<Brush>(List.of(brush_a)), "Noise","max", new ArrayList<String>(List.of("animationTool")), render_a);
	static Software software_b= new Software(1, "Zbrush", new ArrayList<Brush>(List.of(brush_b)), "Extrude", "obj", new ArrayList<String>(List.of("animationTool")), render_b);
	static Software software_c= new Software(1, "Blender", new ArrayList<Brush>(List.of(brush_c)), "Bevel", "fbx", new ArrayList<String>(List.of("animationTool")), render_a);
	
	static Employee kurac = new Employee(4, "Kel", "Zek", "092", null, null, adress_a, software_a, null);
	
	static Employee employee1= new Employee(1, "Vuk", "Vukovic", 
			"666", LocalDate.of(1969, 1, 2), "vukyvuky@gmail.com", 
			adress_a, software_a, "Menadzer");
	static Employee employee2= new Employee(2, "Mirnko", "Mirkovic", 
			"420", LocalDate.of(1969, 1, 2), "Mirky420@gmail.com", 
			adress_b, software_b, "Dizajner");
	static Employee employee3= new Employee(3, "Boban", "Bobic", 
			"390", LocalDate.of(1969, 1, 2), "bobyca@gmail.com", 
			adress_c, software_c, "Modelar");
		
	public static void popuniListe() {
		adresses.add(adress_a);
		adresses.add(adress_b);
		adresses.add(adress_c);
		brushes.add(brush_a);
		brushes.add(brush_b);
		brushes.add(brush_c);
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
		renders.add(render_a);
		renders.add(render_b);
		software.add(software_a);
		software.add(software_b);
		software.add(software_c);
		
	}
}