package view;

import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.*;

import controller.Controller;
import component.ButtonComponent;
import component.InfoWindowComponent;

public class Screen extends JFrame {
    private int width;
    private int height;
    JPanel navigationBar;
    JPanel navigationButton;
    Controller controller;
	protected MenuItemListener menuItemListener = new MenuItemListener();
    public static final String IMAGE_RESOURCES = System.getProperty("user.dir") + "\\Image_Resources\\";
    

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
//        this.menuItemListener = menuItemListener;
    	controller = new Controller();
    	add(createNorth(), "North");
    	setTitle("Sorting Algorithm Visualizer");
    	setSize(this.width, this.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
    }
    public Screen() {
    	this.width = 1600;
    	this.height = 1200;
//        this.menuItemListener = menuItemListener;
    	controller = new Controller();
    	add(createNorth(), "North");
    	setTitle("Sorting Algorithm Visualizer");
    	setSize(this.width, this.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
		setVisible(true);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    protected JPanel createNorth() {
    	navigationBar = new JPanel(new BorderLayout());
    	navigationBar.setBackground(Color.WHITE);
    	navigationBar.setPreferredSize(new Dimension(800, 30));
    	navigationBar.setBorder(BorderFactory.createEmptyBorder(0,35,0,40));
    	
		Icon visualSoLogo= new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"\\VisualSO_icon1.png").getImage().getScaledInstance(180, 30, Image.SCALE_SMOOTH));
		JLabel icon = new JLabel(visualSoLogo);
		navigationBar.add(icon,"Center");
		
    	JMenuBar menuBar = createMenuBar();
    	
    	navigationBar.add(menuBar, "West");
    	
		navigationButton = new JPanel(new GridLayout(1,2));
		navigationButton.setBackground(Color.WHITE);
		
		ButtonComponent exitButton = new ButtonComponent("Exit", Color.WHITE, Color.RED, Color.PINK);
		exitButton.addActionListener(controller.exitProtol());
		navigationButton.add(exitButton,1,0);
		navigationBar.add(navigationButton, "East");
		return navigationBar;
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
    
    protected class MenuItemListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
			String menuItem = e.getActionCommand();
			if (menuItem.equals("Help")) {
				
			}
			else if (menuItem.equals("About")) {
				
			}
    	}
    }
		
    public void onEntry() {};
    public void onExit() {};
}
