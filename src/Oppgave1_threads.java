import javax.swing.JOptionPane;

public class Oppgave1_threads {
	
	public static void main(String[] args) throws InterruptedException {
		
		//Denne tråden skal kjøre en linje på skjermen en gang hvert 3 sekund
		Oppgave1_standardTraad t = new Oppgave1_standardTraad();
		t.start();
		
		Thread.sleep(10000);
		
		t.stopp();
		
		//Denne tråden skal ha en brukerinput ved JOptionPane med en quit-kommando
		Oppgave1_inputTraad tt = new Oppgave1_inputTraad();
		tt.start();
		
	}
}
