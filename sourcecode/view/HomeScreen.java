package view;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Font;
import java.awt.GridLayout;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.Icon;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import controller.HomeScreenController;
import view.Screen.MenuItemListener;
import component.*;

public class HomeScreen extends Screen{
	private final HomeScreenController homeScreenController;

	public HomeScreen() {
		super();
		this.menuItemListener = new MenuItemListener();
		homeScreenController = new HomeScreenController();
		JPanel homeScreen = new JPanel(new GridLayout(2,1));
		add(homeScreen, BorderLayout.CENTER);
		
		homeScreen.add(infoPanel());
		homeScreen.add(sortPanel());
		// TODO: Change the design margin
		homeScreen.setBorder(BorderFactory.createEmptyBorder(0,0,45,0));
		
		setVisible(true);
	}

	@Override
	public void onEntry() {}

	@Override
	public void onExit() {}
	
	private JPanel infoPanel() {
		JPanel infoPanel = new JPanel(new BorderLayout()); 
		infoPanel.add(logoPanel());
//		infoPanel.add(helpPanel(),BorderLayout.SOUTH);
		// TODO: Adjust the dimension of the empty border
		infoPanel.setBorder(BorderFactory.createEmptyBorder(50, 0, 50, 0));;
		return infoPanel;
	}
	
	private JPanel logoPanel() {
	
		JPanel logoPanel = new JPanel(new BorderLayout());
		
		 // Create the logo label and add it to the panel
		Icon visualSoIcon= new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"VisualSO_icon1.png").getImage().getScaledInstance(350, 168, Image.SCALE_SMOOTH));
		JLabel logo = new JLabel(visualSoIcon);
		logoPanel.add(logo, BorderLayout.CENTER); 
		
		// Create the appNameLabel 
		JLabel appNameLabel = new JLabel("SORTING ALGORITHM VISUALIZER");
		appNameLabel.setFont(new Font("Silkscreen", Font.PLAIN, 20));
		
		//add it to a separate panel with horizontal space
		JPanel a = new JPanel();
		a.add(appNameLabel, BorderLayout.CENTER);
		logoPanel.add(a, BorderLayout.SOUTH);
		return logoPanel;
	}
	
	private JPanel sortPanel() {
		JPanel sortPanel = new JPanel(new GridLayout(1,3));
		Image mergeSortImage = new ImageIcon(IMAGE_RESOURCES + "mergeSortImage.png").getImage();
		Image selectionSortImage = new ImageIcon(IMAGE_RESOURCES + "selectionSortImage.png").getImage();
		Image shellSortImage = new ImageIcon(IMAGE_RESOURCES + "shellSortImage.png").getImage();
		/*String mergeSortDescription = "This is merge sort";
		String selectionSortDescription = "This is selection sort";
		String shellSortDescription = "This is Shell sort"; */
		CardComponent mergeSortCard = new CardComponent("Merge Sort", mergeSortImage);
		CardComponent selectionSortCard = new CardComponent("Selection Sort", selectionSortImage);
		CardComponent shellSortCard = new CardComponent("Shell Sort", shellSortImage);
	
		sortPanel.add(mergeSortCard);
		sortPanel.add(selectionSortCard);
		sortPanel.add(shellSortCard);
		return sortPanel;
	}
	
    protected JMenuBar createMenuBar() {
    	this.menuItemListener = new MenuItemListener();
    	
    	JMenu menu = new JMenu("Menu");
    	
    	JMenuItem help = new JMenuItem("Help");
    	JMenuItem about = new JMenuItem("About");
    	
    	help.addActionListener(menuItemListener);
    	about.addActionListener(menuItemListener);

    	menu.add(help);
    	menu.add(about);
    	
    	JMenuBar menuBar = new JMenuBar();
    	menuBar.add(menu);
    	
    	return menuBar;
    }    
    protected class MenuItemListener extends view.Screen.MenuItemListener implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
			String menuItem = e.getActionCommand();
			if (menuItem.equals("Help")) {
				InfoWindowComponent helpWindow = new InfoWindowComponent("Help", "HomeScreenHelp");
			}
			else if (menuItem.equals("About")) {
				String message=" Team 20 has developed this capstone project with \n "
						+ "the aim of providing you with a visualization of how "
						+ "\n sorting algorithms operate on arrays.";
				InfoWindowComponent aboutWindow = new InfoWindowComponent("About", message);
			}
		}
    }    
}
