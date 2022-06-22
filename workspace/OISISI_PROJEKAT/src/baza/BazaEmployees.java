package baza;

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
	
	public static List<Adress> adresses = new ArrayList<Adress>();
	public static List<Employee>employees  = new ArrayList<Employee>();
	private List<String> kolone;
	
	static Adress adress_a = new Adress ("Narodnog Fronta", "27", "Novi Sad");
	static Adress adress_b= new Adress ("Strosmajerova", "3", "Beograd");
	static Adress adress_c= new Adress ("Djure Jaksica", "53", "Novi Sad");
	
	static Employee employee1= new Employee(1, "Pera", "Peric", 
			"010298870006", new ArrayList<String>(List.of("1", "2", "1988")), "pekipeca@gmail.com", 
			adress_a, new ArrayList<Software>(List.of(BazaSoftware.software_a)), "Animator");
	static Employee employee2= new Employee(2, "Mika", "Mikic", 
			"020199680443", new ArrayList<String>(List.of("2", "1", "1996")), "mikicmika@gmail.com", 
			adress_b, new ArrayList<Software>(List.of(BazaSoftware.software_b)), "Designer");
	static Employee employee3= new Employee(3, "Ivana", "Ivanovic", 
			"151299255034", new ArrayList<String>(List.of("15", "12", "1992")), "ivanica@gmail.com", 
			adress_c, new ArrayList<Software>(List.of(BazaSoftware.software_c, BazaSoftware.software_a)), "3D Generalist");
		
	public static void popuniListe() {
		adresses.add(adress_a);
		adresses.add(adress_b);
		adresses.add(adress_c);
	}
	
	private BazaEmployees() {
		
		initEmployees();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("First Name");
		this.kolone.add("Last Name");
		this.kolone.add("JMBG");
		this.kolone.add("Date of birth");
		this.kolone.add("Email");
		this.kolone.add("Adress");
		this.kolone.add("Software");
		this.kolone.add("Position");
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

	public void editEmployee(String ime, String prezime, String jmbg, List<String> datumRodjenja, String email, Adress adresa, List<Software> softver, String radnoMesto, String stariJmbg) {
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
			return conv2StringS(employee.getSoftver());
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

public String conv2StringS(List<Software> softwares) {
	
	StringBuilder out = new StringBuilder();
	for (int a = 0; a<softwares.size(); a++) {
		Software s = softwares.get(a);
		out.append(s.getName());
		if(!(a == softwares.size()-1)) {
		out.append(", ");
		}
	 }
	return out.toString();
}
}