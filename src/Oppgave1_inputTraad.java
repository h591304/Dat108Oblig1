import javax.swing.JOptionPane;

public class Oppgave1_inputTraad extends Thread {

	boolean fortsette = true;
	
	@Override
	public void run() {
		while(fortsette) {
			String svar = JOptionPane.showInputDialog(null, "Hva vil du printe? " + "Tast Q for å avslutte!");
			if(svar.equals("q") || svar.equals("Q")) {
				stopp();
			}
			System.out.println(svar);
			
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		System.out.println("Programmet avsluttes!!");
	}
	
	public void stopp() {
		fortsette = false;
	}
}
