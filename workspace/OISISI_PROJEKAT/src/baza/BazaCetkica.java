package baza;

import java.awt.Color;
import java.util.ArrayList;
import java.util.List;

import model.Brush;

public class BazaCetkica {
	
	private static BazaCetkica instance = null;

	public static BazaCetkica getInstance() {
		if (instance == null) {
			instance = new BazaCetkica();
		}
		return instance;
	}


	public static List<Brush> cetkice = new ArrayList<Brush>();
	private List<String> kolone;
	
	public static Brush brush_a = new Brush(1, "Move", "Pomera geometriju", new Color(10, 10, 10, 0));
	public static Brush brush_b = new Brush(2, "Curve", "Dodaje oblike", new Color(2, 5, 50, 0));
	public static Brush brush_c = new Brush(3, "Polish", "Uglacava povrsinu", new Color(45, 80, 4, 0));
	
	
	private BazaCetkica() {
		
		initBrushes();
		
		this.kolone = new ArrayList<String>();
		this.kolone.add("Name");
		this.kolone.add("Use");
		this.kolone.add("Colour");
		
	}
	
	private void initBrushes() {
		this.cetkice = new ArrayList<Brush>();
		cetkice.add(brush_a);
		cetkice.add(brush_b);
		cetkice.add(brush_c);
	}
	
	public List<Brush> getBrushes() {
		return this.cetkice;
	}
	
	public void setBrushes(List<Brush> cetkice) {
		this.cetkice = cetkice;
	}
	
	public void addBrush(Brush b) {
		this.cetkice.add(b);
	}

	public void editBrush(String trnnaziv, String naziv, String namena, Color boja) {
		for (Brush brush : cetkice) {
			if (brush.getName() == trnnaziv) {
				brush.setName(naziv);
				brush.setUse(namena);
				brush.setColor(boja);
			}
		}
	}
	
	public String getColumnName(int index) {
		return this.kolone.get(index);
	}
	
	public Brush getRow(int rowIndex) {
		return this.cetkice.get(rowIndex);
	}
	
	public Object getValueAt(int row, int column) {
		Brush brush;
		brush = cetkice.get(row);
		switch (column) {
		case 0:
			return brush.getName();
		case 1:
			return brush.getUse();
		case 2:
			return brush.getColor().getRed()+","+brush.getColor().getGreen()+","+brush.getColor().getBlue();
		
		default:
		return null;
	}
}
	
}
