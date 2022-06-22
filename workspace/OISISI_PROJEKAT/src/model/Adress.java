package model;

public class Adress {
	  
	private String Ulica;
	private String Broj;
	private String Grad;
	
	public Adress(String ulica, String broj, String grad) {
		super();
		this.Ulica = ulica;
		this.Broj = broj;
		Grad = grad;
	}
	
	public String getUlica() {
		return Ulica;
	}

	public void setUlica(String ulica) {
		this.Ulica = ulica;
	}

	public String getBroj() {
		return Broj;
	}

	public void setBroj(String broj) {
		this.Broj = broj;
	}

	public String getGrad() {
		return Grad;
	}

	public void setGrad(String grad) {
		Grad = grad;
	}

	
	
	public Adress() {
		super();
	}
	
	
	@Override
	public String toString() {
		return Ulica + ", " + Broj + ", " + Grad ;
	}
}
