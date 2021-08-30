package oppgave2;

public class Main {

	public static void main(String[] args) {
		
		final String[] kokker = {"Anne", "Erik", "Knut"};
		final String[] servitorer = {"Mia", "Per"};
		final int KAPASITET = 4;
		
		skrivUtHeader(kokker, servitorer, KAPASITET);
		
		HamburgerBrett brett = new HamburgerBrett(KAPASITET);
		
		for(String navn : kokker) {
			
			Thread k = new Kokk(brett, navn);
			k.setName(navn);
			k.start();
		}
		
		for(String navn : servitorer) {
			Thread s = new Servitor(brett, navn);
			s.setName(navn);
			s.start();
		}

	}
	
	public static void skrivUtHeader(String[] kokker, String[] servitorer, int KAPASITET) {
		
		System.out.println("----- HAMBURGER SIMULATOR -----\n");
		System.out.println("I denne simuleringen har vi");
		
		System.out.print("      De 3 kokkene er: ");
		for(int i = 0; i < kokker.length; i++) {
			System.out.print(kokker[i] + " ");
		}
		System.out.println();
		
		System.out.print("      De 2 servitørene er: ");
		for(int i = 0; i < servitorer.length; i++) {
			System.out.print(servitorer[i] + " ");
		}
		System.out.println();
		System.out.print("      Kapasiteten er: " + KAPASITET);
		
		System.out.println();
		System.out.println("Vi starter ...");
		System.out.println();
	}

}
