package CaseStudy_Observer;

import java.util.Observable;
import java.util.Observer;

public class Compteur extends Observable implements Runnable {
	
	private int state ;
	
	Compteur(int state){
		this.state = state;
	}
	

	public int getState() {
		return state;
	}

	public void setState(int state) {
		this.state = state;
		setChanged();
		this.notifyObservers(state);
	}

	@Override
	public void run() {
		try {
		while (!Thread.currentThread().isInterrupted()) {
			wait(3000);
			this.setState((this.getState()+ 1) %60);
			
		}
		}catch (Exception e) {
			
		}
		
	}
	
	
	
	

}
