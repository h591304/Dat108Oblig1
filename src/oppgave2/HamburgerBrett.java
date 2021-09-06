package oppgave2;

import java.util.LinkedList;
import java.util.Random;
import java.util.concurrent.ThreadLocalRandom;

public class HamburgerBrett {

	public int antall;
	
	public HamburgerBrett() {
		
	}
	
	public HamburgerBrett(int kapasitet) {
		antall = kapasitet;
	}
	
	//Oppretter en felles liste der Kokk(legger til) og Servit�r(tar av) deler
	LinkedList<Integer> burgerKo = new LinkedList<>();
	int maksAntBurgere = 4;
	
	//Tilfeldig antall sekunder m�lt i millisekunder mellom 2 og 6 sekunder
	int tilfeldigSek = ThreadLocalRandom.current().nextInt(2000, 6000);
	
//	//Tilfeldig generert 50/50 sjanse for at en kokk legger til eller en servit�r tar av en burger
//	int tilfeldigTall = ThreadLocalRandom.current().nextInt(1, 2);
	
	//l�penummer for � vite hvilken burger som blir lagt p� og tatt av
	int burger = 1;
	
	public synchronized void leggTilHamburger() throws InterruptedException {
		
		while(burgerKo.size() == maksAntBurgere) {
			System.out.println(Thread.currentThread().getName() + " (kokk) er klar med en hamburger, men brett fullt. Venter!");
			wait();
		}
		
		Thread.sleep(tilfeldigSek);
		
		burgerKo.add(burger);
		System.out.println(Thread.currentThread().getName() + " (kokk) legger p� hamburger (" + burger + "). Brett: " + burgerKo);
		burger++;
		
		notifyAll();
	}
	
	public synchronized void taAvHamburger() throws InterruptedException {
				
		while(burgerKo.size() == 0) {
			System.out.println(Thread.currentThread().getName() + " (servit�r) �nsker � ta av hamburger, men brett tomt. Venter!");
			wait();
		}
		
		Thread.sleep(tilfeldigSek);
		
		int f�rste = burgerKo.removeFirst();
		System.out.println(Thread.currentThread().getName() + " (servit�r) tar av hamburger (" + f�rste + "). Brett: " + burgerKo);
		
		notifyAll();
	}

}
