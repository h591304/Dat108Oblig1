
public class Oppgave1_standardTraad extends Thread {

	boolean fortsette = true;
	
	@Override
	public void run() {
		
		int i = 0;
		while(fortsette) {
			final int x = i;
			System.out.println("3 sekunder mellom hver print: " + x);
			
			try {
				Thread.sleep(3000);
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
			i++;
		}
	}
	
	public void stopp() {
		fortsette = false;
	}
}
