package view;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
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
	SliderBarComponent progressSlider;
	SliderBarComponent speedSlider;
	TextAreaComponent explanationDisplayer;
	
	ButtonComponent buttonCreateSortingArray;
	ButtonComponent buttonCreateRandomArray;
	LabelComponent arrayEqualsLabel;
	TextFieldComponent inputArrayTextField;
	ButtonComponent buttonConfirmInputArray;
	ButtonComponent buttonStartSorting;
	LabelComponent errorLabel;
	
	JPanel controlPanel;
	
	protected int padding = 5;
	
	

	public SortScreen() {
		super();
		sortController = new SortController();
		generateArray(null);
		calculateUnitHeight();
		addBackButtonToNavigationButton();
		setVisible(true);
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
		if (this.sortArray.getMax() == null) {
			this.unitHeight = 0;
		} else {			
			if (this.sortArray.getMax().getValue() != (Integer) 0) {
				this.unitHeight = ((double)300)/((double)this.sortArray.getMax().getValue());
			} else if (this.sortArray.getMax().getValue() != (Double) 0.0) {
				this.unitHeight = ((double)300)/((double)this.sortArray.getMax().getValue());			
			} else {
				this.unitHeight = 0;
			}
		}
	}
	private void addBackButtonToNavigationButton() {
		ButtonComponent backButton = new ButtonComponent("Back", Color.BLACK, Color.BLUE, Color.CYAN);
		backButton.addActionListener(controller.backProtocol());
		navigationButton.add(backButton, 2, 0);
	}
	private JLayeredPane createCenter(){
		arrayGraphicArea = new JLayeredPane();
		JPanel container = new JPanel();
		container.setLayout(null);
		container.add(mainBarChartVisualizer(Color.ORANGE));
		sub = new ArrayGraphic(sortArray);
		container.add(sub);
		animation = new JPanel();
		arrayGraphicArea.add(container, JLayeredPane.DEFAULT_LAYER);
		
		errorLabel = new LabelComponent("");
		errorLabel.setForeground(Color.RED);
		arrayGraphicArea.add(errorLabel, JLayeredPane.DRAG_LAYER);
		
		createMenuList();
		
		return arrayGraphicArea;
	}
	private JPanel createSouth() {
		
	}
	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(Color.BLACK);
		
		progressSlider = new SliderBarComponent();
		
		
		return controlPanel;
	}
	private void createMenuList() {
		buttonCreateSortingArray = new ButtonComponent("Create (A)", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonCreateSortingArray.addActionListener(sortController.buttonCreateSortingArrayClicked());
		arrayGraphicArea.add(buttonCreateSortingArray, JLayeredPane.MODAL_LAYER);
		
		buttonCreateRandomArray = new ButtonComponent("Random", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonCreateRandomArray.setSize(new Dimension(100, 34));
		arrayGraphicArea.add(buttonCreateRandomArray, JLayeredPane.MODAL_LAYER);
		
		arrayEqualsLabel = new LabelComponent("Array :=");
		arrayGraphicArea.add(arrayEqualsLabel, JLayeredPane.MODAL_LAYER);
		
		inputArrayTextField = new TextFieldComponent(30, "Ex: 1, 8, 3, 5, 7, 15, 21, 34");
		arrayGraphicArea.add(inputArrayTextField, JLayeredPane.MODAL_LAYER);
		
		buttonConfirmInputArray = new ButtonComponent("Confirm", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonConfirmInputArray.addActionListener(sortController.buttonConfirmInputArrayClicked());
		arrayGraphicArea.add(buttonConfirmInputArray, JLayeredPane.MODAL_LAYER);
		
		buttonStartSorting = new ButtonComponent("Sort", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonStartSorting.addActionListener(sortController.buttonStartSortingClicked());
		arrayGraphicArea.add(buttonStartSorting, JLayeredPane.MODAL_LAYER);
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
	public TextAreaComponent getExplanationDisplayer() {
		return this.explanationDisplayer;
	}
	public SliderBarComponent getProgressSlider() {
		return this.progressSlider;
	}
	public SliderBarComponent getSpeedSlider() {
		return this.progressSlider;
	}
	
	@Override
	public void onEntry() {}

	@Override
	public void onExit() {}

}
