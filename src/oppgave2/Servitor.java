package oppgave2;

public class Servitor extends Thread {
	
	private HamburgerBrett brett;
	private String navn;
	
	public Servitor(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	@Override
	public synchronized void run() {
		
		while(true) {
			try {
				Kokk.hb.taAvHamburger();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
	
}
