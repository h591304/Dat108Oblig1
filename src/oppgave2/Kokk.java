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
	
	@Override
	public synchronized void run() {
		
		try {
			hb.leggTilHamburger();
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
	}
	
	
}
