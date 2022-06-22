package paketic;

public class MyApp {

	public static void main(String[] args) {
		
		MyFrame frame = new MyFrame();
		
		WindowNewEmployee windowEmployee=new WindowNewEmployee(); //ovo povezati sa dugmetom za dodavanje novog zaposlenog
		WindowNewSoftware windowSoftware= new WindowNewSoftware();
		//AreYouSure DialogAreYouSure=new AreYouSure();
		AboutUsPage AboutUs=new AboutUsPage();
	}
	
}

