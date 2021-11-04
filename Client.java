package CaseStudy_Observer;

public class Client {

	public static void main(String[] args) {
		Compteur ctp = new Compteur(0);
		
		BinaryObserver binary = new BinaryObserver(ctp);
		
		OctalObserver octal = new OctalObserver(ctp);
		
		HexaObserver hexa = new HexaObserver(ctp);
		
		Thread thread = new Thread(ctp);
		
		thread.start();

	}

}
