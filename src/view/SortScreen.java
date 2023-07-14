package view;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JLabel;
import javax.swing.JLayeredPane;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.SwingConstants;
import javax.swing.Timer;

import component.*;
import component.utils.*;
import controller.SortController;

public class SortScreen extends Screen{
	
	protected SortController sortController;
	protected ArrayUtil sortArray;
	protected String sortInfo = "Welcome to our Sorting Algorithms Visualizer";
	protected double unitHeight;
	
	
	JLayeredPane arrayGraphicArea;
    ArrayGraphic main;
    ArrayGraphic sub;
	JPanel animation;
	SliderBarComponent processSlider;
	DemonstratePane demonstratePane;
	MySideButton btnCreate;
	MySideButton btnRandom;
	MyLabel A;
	MyTextField inputArrayField;
	MySideButton btnGo;
	MySideButton btnSort;
	MyLabel errorLabel;
	public final String placeHolder = "Ex: 1, 2, 3, 4, 8";
	
	protected int padding = 5;
	
	

	public SortScreen() {
		super();
		sortController = new SortController();
		generateArray(null);
		calculateUnitHeight();
		addBackButtonToNavigationButton();
	}

	@SuppressWarnings("rawtypes")
	private void generateArray(ArrayUtil array) {
		if (sortArray == null) {
			sortArray = new ArrayUtil(sortController.MAX_ARRAY_LENGTH);
			sortArray.generateRandomArray();
		} else {
			this.sortArray = array;
		}
	}
	private void calculateUnitHeight() {
		if (this.sortArray.getMax().getValue() != (Integer) 0) {
			this.unitHeight = ((double)300)/((double)this.sortArray.getMax().getValue());
		} else if (this.sortArray.getMax().getValue() != (Double) 0.0) {
			this.unitHeight = ((double)300)/((double)this.sortArray.getMax().getValue());			
		} else {
			this.unitHeight = 0;
		}
	}
	private void addBackButtonToNavigationButton() {
		ButtonComponent backButton = new ButtonComponent("Back", Color.BLACK, Color.BLUE, Color.CYAN);
		backButton.addActionListener(controller.backProtocol());
		navigationButton.add(backButton, 2, 0);
	}
	private void createCenter(){
		arrayGraphicArea = new JLayeredPane();
		JPanel container = new JPanel();
		container.setLayout(null);
		container.add(mainBarChartVisualizer(Color.ORANGE));
		sub = new ArrayGraphic(sortArray);
		container.add(sub);
		animation = new JPanel();
		
	}
	private ArrayGraphic mainBarChartVisualizer(Color color) {
		int unitWidth = ((int) getWidth()-200)/this.sortArray.size();
		ArrayGraphic mainBarChart = new ArrayGraphic(sortArray) {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (sortArray.dataType == Integer.class || sortArray.dataType == Double.class) {
					for (int i = 0; i< sortArray.size();i++) {
						g.setColor(color);
						int width = Math.min(unitWidth,60+padding);
						g.fillRect(i*width+(getWidth()-width*sortArray.size())/2,-(int)((int)sortArray.get(i).getValue() * unitHeight)
								+ getHeight(),Math.min(width-padding,60),(int)((int)sortArray.get(i).getValue()*unitHeight));
					}
				} // TODO: Write fillRect for String data type here
			}
		};
		// TODO: Redesign the boundary if necessary
		mainBarChart.setBounds(45,30,getWidth()-200,250);
		return mainBarChart;
	}
	
	@Override
	public void onEntry() {}

	@Override
	public void onExit() {}

}
