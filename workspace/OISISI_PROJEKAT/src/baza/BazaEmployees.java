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

public class BazaEmployees{
	
	private static BazaEmployees instance = null;

	public static BazaEmployees getInstance() {
		if (instance == null) {
			instance = new BazaEmployees();
		}
		return instance;
	}
	
	private long generator;
	
	public static List<Adress> adresses = new ArrayList<Adress>();
	public static List<Employee>employees  = new ArrayList<Employee>();
	private List<String> kolone;
	
	static Adress adress_a = new Adress ("Balzakova", "21", "Novi Sad");
	static Adress adress_b= new Adress ("Njegoseva", "4", "Novi Sad");
	static Adress adress_c= new Adress ("Pariska", "5", "Beograd");
	
	static Employee employee1= new Employee(1, "Vuk", "Vukovic", 
			"666", new ArrayList<String>(List.of("2", "1", "1969")), "vukyvuky@gmail.com", 
			adress_a, BazaSoftware.software_a, "Menadzer");
	static Employee employee2= new Employee(2, "Mirnko", "Mirkovic", 
			"420", new ArrayList<String>(List.of("2", "1", "1969")), "Mirky420@gmail.com", 
			adress_b, BazaSoftware.software_b, "Dizajner");
	static Employee employee3= new Employee(3, "Boban", "Bobic", 
			"390", new ArrayList<String>(List.of("2", "1", "1969")), "bobyca@gmail.com", 
			adress_c, BazaSoftware.software_c, "Modelar");
		
	public static void popuniListe() {
		adresses.add(adress_a);
		adresses.add(adress_b);
		adresses.add(adress_c);
	}
	
	private BazaEmployees() {
		generator = 0;
		
		initEmployees();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("First Name");
		this.kolone.add("Last Name");
		this.kolone.add("JMBG");
		this.kolone.add("Date of birth");
		this.kolone.add("Email");
		this.kolone.add("Adress");
		this.kolone.add("Position");
		this.kolone.add("Software");
	}
	
	private void initEmployees() {
		this.employees = new ArrayList<Employee>();
		employees.add(employee1);
		employees.add(employee2);
		employees.add(employee3);
	}
	
	public List<Employee> getEmployees() {
		return employees;
	}
	
	public void setEmployees(List<Employee> employees) {
		this.employees = employees;
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Employee getRow(int rowIndex) {
		return this.employees.get(rowIndex);
	}
	
	private long generateId() {
		return ++generator;
	}
	
	public void addEmployee(Employee e) {
		this.employees.add(e);
	}

	public void deleteEmployee(long id) {
		for (Employee employee : employees) {
			if (employee.getId() == id) {
				employees.remove(employee);
				break;
			}
		}
	}

	public void editEmployee(String ime, String prezime, String jmbg, List<String> datumRodjenja, String email, Adress adresa, Software softver, String radnoMesto, String stariJmbg) {
		for (Employee employee : employees) {
			if (employee.getJmbg() == stariJmbg) {
				employee.setIme(ime);
				employee.setPrezime(prezime);
				employee.setJmbg(jmbg);
				employee.setDatumRodjenja(datumRodjenja);
				employee.setEmail(email);
				employee.setAdresa(adresa);
				employee.setSoftver(softver);
				employee.setRadnoMesto(radnoMesto);
			}
		}
	}

	public Object getValueAt(int row, int column) {
		Employee employee;
		employee = employees.get(row);
		switch (column) {
		case 0:
			return employee.getIme();
		case 1:
			return employee.getPrezime();
		case 2:
			return employee.getJmbg();
		case 3:
			return conv2String(employee.getDatumRodjenja());
		case 4:
			return employee.getEmail();
		case 5:
			return employee.getAdresa().toString();
		case 6:
			return employee.getSoftver().getName();
		case 7:
			return employee.getRadnoMesto();
		default:
		return null;
	}
		
}

public String conv2String(List<String> datumRodjenja) {
	StringBuilder sb = new StringBuilder();
	for (String s : datumRodjenja)
	{
	    sb.append(s);
	    sb.append(". ");
	}
	return sb.toString();
}
}