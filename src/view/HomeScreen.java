package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.GridLayout;
import java.awt.Image;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JPanel;
import javax.swing.JLabel;

import controller.HomeScreenController;
import component.Button;
import component.Card;

public class HomeScreen extends Screen{
	private final HomeScreenController homeScreenController;

	public HomeScreen() {
		super();
		homeScreenController = new HomeScreenController();
		JPanel homeScreen = new JPanel(new GridLayout(2,1));
		
		homeScreen.add(infoPanel());
		homeScreen.add(sortPanel());
		// TODO: Change the design margin
		homeScreen.setBorder(BorderFactory.createEmptyBorder(0,0,45,0));
	}

	@Override
	public void onEntry() {}

	@Override
	public void onExit() {}
	
	private JPanel infoPanel() {
		JPanel infoPanel = new JPanel(new BorderLayout()); 
		infoPanel.add(logoPanel());
		infoPanel.add(helpPanel(),BorderLayout.SOUTH);
		// TODO: Adjust the dimension of the empty border
		infoPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));;
		return infoPanel;
	}
	
	private JPanel logoPanel() {
		JPanel logoPanel = new JPanel(new BorderLayout());
		JLabel appNameLabel = new JLabel("Sorting Algorithm Visualizer");
		JPanel a = new JPanel();
		a.add(appNameLabel);
		logoPanel.add(a, BorderLayout.SOUTH);
		return logoPanel;
	}
	
	private JPanel helpPanel() {
		JPanel helpPanel = new JPanel();
		Button helpBtn = new Button("Help", Color.WHITE, new Color(11,102,106), new Color(7,25,82)); 
//		TODO: Add actionListener for helpBtn
//		btnHelp.addActionListener();
		helpPanel.add(helpBtn);
		
		Button aboutBtn = new Button("About", Color.WHITE, new Color(11,102,106), new Color(7,25,82));
		helpPanel.add(aboutBtn);
//		TODO: Add actionListener for aboutBtn
//		aboutBtn.addActionListener();
		helpPanel.add(aboutBtn);
		return helpPanel;
	}
	
	private JPanel sortPanel() {
		JPanel sortPanel = new JPanel(new GridLayout(1,3));
		Image mergeSortImage = new ImageIcon("mergeSortImage.png").getImage();
		Image selectionSortImage = new ImageIcon("selectionSortImage.png").getImage();
		Image shellSortImage = new ImageIcon("shellSortImage.png").getImage();
		String mergeSortDescription = "Give some description for merge sort algorithm here";
		String selectionSortDescription = "Give some description for selection sort algorithm here";
		String shellSortDescription = "Give some description for shell sort algorithm here";
		Card mergeSortCard = new Card("Merge Sort", mergeSortImage, mergeSortDescription);
		Card selectionSortCard = new Card("Selection Sort", selectionSortImage, selectionSortDescription);
		Card shellSortCard = new Card("Shell Sort", shellSortImage, shellSortDescription);
		
		
		
		sortPanel.add(mergeSortCard);
		sortPanel.add(selectionSortCard);
		sortPanel.add(shellSortCard);
		return sortPanel;
	}

}
