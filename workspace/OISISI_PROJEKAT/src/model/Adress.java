package model;

public class Adress {
	
	private long id;  //NOVO    
	private String Ulica;
	private int Broj;
	private String Grad;
	
	public Adress(long id, String ulica, int broj, String grad) {
		super();
		this.id = id;		//NOVO KAO I PRVI ARGUMENT
		this.Ulica = ulica;
		this.Broj = broj;
		Grad = grad;
	}
	
	public long getId() {		//NOVO
		return id;
	}

	public void setId(long id) {		//NOVO
		this.id = id;
	}
	public String getUlica() {
		return Ulica;
	}

	public void setUlica(String ulica) {
		this.Ulica = ulica;
	}

	public int getBroj() {
		return Broj;
	}

	public void setBroj(int broj) {
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
		return Ulica + "," + Broj + "," + Grad ;
	}//mozda ne treba?
}
