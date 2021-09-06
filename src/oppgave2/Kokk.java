package oppgave2;

import java.util.concurrent.ThreadLocalRandom;

public class Kokk extends Thread{

	private HamburgerBrett brett;
	private String navn;
	
	public Kokk(HamburgerBrett brett, String navn) {
		this.brett = brett;
		this.navn = navn;
	}
	
	static HamburgerBrett hb = new HamburgerBrett();
	
	int tilfeldigSek = ThreadLocalRandom.current().nextInt(2000, 6000);
	
	@Override
	public synchronized void run() {
		
		while(true) {
			try {
				hb.leggTilHamburger();
				Thread.sleep(tilfeldigSek);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
	}
}
