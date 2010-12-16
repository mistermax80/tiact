package tiact.gui;

import java.awt.BorderLayout;
import java.awt.Dimension;

import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;
import javax.swing.JTabbedPane;
import javax.swing.SwingConstants;
import javax.swing.UIManager;
import javax.swing.UnsupportedLookAndFeelException;

public class Time extends JFrame {

	private int width = 800;
	private int height = 640;

	private static final long serialVersionUID = -4263666890794645839L;

	public Time() {
		super();
	}

	public void start() {

		try {
			// Set cross-platform Java L&F (also called "Metal")
			UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
		} catch (UnsupportedLookAndFeelException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Errore nella Inizializzazione della Finestra",
					JOptionPane.ERROR_MESSAGE);
			return;
		} catch (ClassNotFoundException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Errore nella Inizializzazione della Finestra",
					JOptionPane.ERROR_MESSAGE);
			return;
		} catch (InstantiationException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Errore nella Inizializzazione della Finestra",
					JOptionPane.ERROR_MESSAGE);
			return;
		} catch (IllegalAccessException e) {
			JOptionPane.showMessageDialog(null, e.getMessage(),
					"Errore nella Inizializzazione della Finestra",
					JOptionPane.ERROR_MESSAGE);
			return;
		}

		// Creazione del frame principale
		JFrame frame = new JFrame("TIME - Il Tempo che lavoro");
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		// Creazione dei pannelli
		JPanel home = new Home();
		
		// Creazione Tabbed Panel per i pannelli
		JTabbedPane tab = new JTabbedPane(SwingConstants.TOP);

		// Aggiunta dei pannelli
		tab.addTab("Home", home);

		// Aggiunta del Tabbed Panel
		frame.getContentPane().add(tab, BorderLayout.CENTER);

		frame.pack();
		Dimension scrn = frame.getToolkit().getScreenSize();
		frame.setBounds((scrn.width - width) / 2, (scrn.height - height) / 2,
				width, height);

		frame.setVisible(true);
	}
}
