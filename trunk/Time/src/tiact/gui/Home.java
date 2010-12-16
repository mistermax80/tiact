package tiact.gui;

import java.awt.BorderLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import tiact.model.TableTodayModel;

public class Home extends JPanel {

	private static final long serialVersionUID = -3838963069312985695L;

	private JPanel buttonPanel;
	private JPanel datailsPanel;
	private JPanel topPanel;
	private JPanel todayPanel;

	private JLabel usernameLabel;
	private JLabel todayLabel;

	private JTextField usernameText;

	private JButton button1;
	private JButton button2;
	private JButton button3;
	private JButton button4;
	private JButton button5;
	private JButton button6;
	
	private JTable todayTable;
	private TableTodayModel todayTableModel;
	private JScrollPane scrollPane;

	public Home() {
		super(new BorderLayout());

		// TOP Panel
		datailsPanel = new JPanel(new GridLayout(1, 2));
		usernameLabel = new JLabel("Username:");
		datailsPanel.add(usernameLabel);
		
		usernameText = new JTextField("Massimo");
		datailsPanel.add(usernameText);

		buttonPanel = new JPanel(new GridLayout(1, 6));
		button1 = new JButton("Inizio");
		button2 = new JButton("Inizio Break");
		button3 = new JButton("Fine Break");
		button4 = new JButton("Pausa Pranzo");
		button5 = new JButton("Fine Pausa Pranzo");
		button6 = new JButton("Fine");
		buttonPanel.add(button1);
		buttonPanel.add(button2);
		buttonPanel.add(button3);
		buttonPanel.add(button4);
		buttonPanel.add(button5);
		buttonPanel.add(button6);
		
		topPanel = new JPanel(new BorderLayout());
		topPanel.add(datailsPanel,BorderLayout.NORTH);
		topPanel.add(buttonPanel,BorderLayout.CENTER);
		// Today Panel
		todayPanel = new JPanel(new BorderLayout());
		todayLabel = new JLabel("OGGI: 9 Dicembre 2010");
		
		scrollPane = new JScrollPane();
		
		todayTableModel = new TableTodayModel();
		todayTable = new JTable(todayTableModel);
		scrollPane.getViewport().add(todayTable);

		todayPanel.add(todayLabel,BorderLayout.WEST);
		todayPanel.add(scrollPane,BorderLayout.CENTER);

		this.add(topPanel, BorderLayout.NORTH);
		this.add(todayPanel, BorderLayout.CENTER);
	}

}
