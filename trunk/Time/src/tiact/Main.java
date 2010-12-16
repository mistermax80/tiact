package tiact;

import tiact.gui.Time;

import java.awt.EventQueue;

public final class Main {

	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				Time mw = new Time();
				mw.start();
			}
		});
	}
}