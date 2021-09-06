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
	
	//Oppretter en felles liste der Kokk(legger til) og Servitør(tar av) deler
	LinkedList<Integer> burgerKo = new LinkedList<>();
	int maksAntBurgere = 4;
	
	//Tilfeldig antall sekunder målt i millisekunder mellom 2 og 6 sekunder
	int tilfeldigSek = ThreadLocalRandom.current().nextInt(2000, 6000);
	
//	//Tilfeldig generert 50/50 sjanse for at en kokk legger til eller en servitør tar av en burger
//	int tilfeldigTall = ThreadLocalRandom.current().nextInt(1, 2);
	
	//løpenummer for å vite hvilken burger som blir lagt på og tatt av
	int burger = 1;
	
	public synchronized void leggTilHamburger() throws InterruptedException {
		
		while(burgerKo.size() == maksAntBurgere) {
			System.out.println(Thread.currentThread().getName() + " (kokk) er klar med en hamburger, men brett fullt. Venter!");
			wait();
		}
		
		Thread.sleep(tilfeldigSek);
		
		burgerKo.add(burger);
		System.out.println(Thread.currentThread().getName() + " (kokk) legger på hamburger (" + burger + "). Brett: " + burgerKo);
		burger++;
		
		notifyAll();
	}
	
	public synchronized void taAvHamburger() throws InterruptedException {
				
		while(burgerKo.size() == 0) {
			System.out.println(Thread.currentThread().getName() + " (servitør) ønsker å ta av hamburger, men brett tomt. Venter!");
			wait();
		}
		
		Thread.sleep(tilfeldigSek);
		
		int første = burgerKo.removeFirst();
		System.out.println(Thread.currentThread().getName() + " (servitør) tar av hamburger (" + første + "). Brett: " + burgerKo);
		
		notifyAll();
	}

}
