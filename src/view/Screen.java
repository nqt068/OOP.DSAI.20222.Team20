package view;

import java.awt.*;

import javax.swing.*;

import controller.Controller;
import component.ButtonComponent;

public class Screen extends JFrame {
    private int width;
    private int height;
    JPanel navigationBar;
    JPanel navigationButton;
    Controller controller;
    public static final String IMAGE_RESOURCES = System.getProperty("user.dir") + "\\Image_Resources\\";
    

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
    	controller = new Controller();
    	add(createNorth(), "North");
    	setTitle("Sorting Algorithm Visualizer");
    	setSize(this.width, this.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
//		setVisible(true);
    }
    public Screen() {
    	this.width = 800;
    	this.height = 600;
    	controller = new Controller();
    	add(createNorth(), "North");
    	setTitle("Sorting Algorithm Visualizer");
    	setSize(this.width, this.height);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setLocationRelativeTo(null);
		setResizable(true);
//		setVisible(true);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }
    
    private JPanel createNorth() {
    	navigationBar = new JPanel(new BorderLayout());
    	navigationBar.setBackground(Color.WHITE);
    	navigationBar.setPreferredSize(new Dimension(800, 30));
    	navigationBar.setBorder(BorderFactory.createEmptyBorder(0,35,0,40));
    	
		Icon visualSoLogo= new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"\\VisualSO_icon.png").getImage().getScaledInstance(180, 30, Image.SCALE_SMOOTH));
		JLabel icon = new JLabel(visualSoLogo);
		navigationBar.add(icon,"West");
		
		navigationButton = new JPanel(new GridLayout(1,2));
		navigationButton.setBackground(Color.WHITE);
		
		ButtonComponent exitButton = new ButtonComponent("Exit", Color.BLACK, Color.RED, Color.PINK);
		exitButton.addActionListener(controller.exitProtol());
		navigationButton.add(exitButton,1,0);
		navigationBar.add(navigationButton, "East");
		return navigationBar;
	}

    public void onEntry() {};
    public void onExit() {};
}
