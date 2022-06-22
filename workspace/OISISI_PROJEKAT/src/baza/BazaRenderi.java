package baza;

import java.util.ArrayList;
import java.util.List;

import model.Render;

public class BazaRenderi {

	private static BazaRenderi instance = null;

	public static BazaRenderi getInstance() {
		if (instance == null) {
			instance = new BazaRenderi();
		}
		return instance;
	}

	private List<Render> renderi = new ArrayList<Render>();
	private List<String> kolone;
	
	static Render render_a = new Render(1,"Room", new ArrayList<String>(List.of("Water","Wood","Stone","Fabric")), 
			new ArrayList<String>(List.of("Perspective")), new ArrayList<String>(List.of("Plane","Sphere")), 
			new ArrayList<String>(List.of("Toy","Statue","House")));
	static Render render_b = new Render(2, "Road", new ArrayList<String>(List.of("Plastic", "Metal", "Sand")), 
			new ArrayList<String>(List.of("Perspective", "Ortographic")), new ArrayList<String>(List.of("Sun")), 
			new ArrayList<String>(List.of("House","Human", "Car")));
		
	
	private BazaRenderi() {
		
		initRenders();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Name");
		this.kolone.add("Materials");
		this.kolone.add("Cameras");
		this.kolone.add("Lights");
		this.kolone.add("Objects");
		
	}
	
	private void initRenders() {
		this.renderi = new ArrayList<Render>();
		renderi.add(render_a);
		renderi.add(render_b);
	}
	
	public List<Render> getRenders() {
		return this.renderi;
	}
	
	public void setRenders(List<Render> renderi) {
		this.renderi = renderi;
	}
	
	public void addRender(Render r) {
		this.renderi.add(r);
	}

	public void editRender(String trnName, String naziv, List<String> materijali, List<String> kamere, List<String> svetla, List<String> objekti) {
		for (Render render : renderi) {
			if (render.getName() == trnName) {
				render.setName(naziv);
				render.setMaterials(materijali);
				render.setCameras(kamere);
				render.setLight(svetla);
				render.setObject(objekti);
			}
		}
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Render getRow(int rowIndex) {
		return this.renderi.get(rowIndex);
	}
	
	public Object getValueAt(int row, int column) {
		Render render;
		render = renderi.get(row);
		switch (column) {
		case 0:
			return render.getName();
		case 1:
			return conv2string(render.getMaterials());
		case 2:
			return conv2string(render.getCameras());
		case 3:
			return conv2string(render.getLight());
		case 4:
			return conv2string(render.getObjects());
		
		default:
		return null;
	}
}
	public String conv2string(List<String> listrend) {
		StringBuilder sb = new StringBuilder();
		for (int a = 0; a<listrend.size(); a++) {
			String m = listrend.get(a);
			sb.append(m);
			if(!(a == listrend.size()-1)) {
			sb.append(", ");
			}
		 }
		return sb.toString();
	}

}
