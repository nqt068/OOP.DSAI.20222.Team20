package view;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Dimension;
import java.awt.FlowLayout;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.GridLayout;
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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import algorithm.SortingAlgorithm;
import component.*;
import component.utils.*;
import controller.SortController;

public abstract class SortScreen extends Screen{
	protected SortController sortController;
	protected ArrayUtil sortArray;
	protected String sortInfo = "Welcome to our Sorting Algorithms Visualizer";
	protected double unitHeight;
	
	JPanel eastPanel;
	JLayeredPane visualizerArea;
  ArrayGraphic main;
  ArrayGraphic sub;
	JPanel animation;
	JPanel controlPanel;
	
	ButtonComponent showExplanation;
	TextAreaComponent explanationDisplayer;
	
	ButtonComponent buttonCreateSortingArray;
	ButtonComponent buttonCreateRandomArray;
	LabelComponent arrayEqualsLabel;
	TextFieldComponent inputArrayTextField;
	ButtonComponent buttonConfirmInputArray;
	ButtonComponent buttonStartSorting;
	LabelComponent errorLabel;

	SliderBarComponent progressSlider;

	ButtonComponent buttonPlayOrPause;
	ButtonComponent buttonForwardOneStep;
	ButtonComponent buttonBackwardOneStep;
	ButtonComponent buttonForwardToTheEnd;
	ButtonComponent buttonBackwardToTheStart;
	
	LabelComponent speedLabel;
	SliderBarComponent speedSlider;
	
	ButtonComponent buttonAbout;
	ButtonComponent buttonHelp;
	ButtonComponent buttonTeam;	
	
	ButtonComponent showMenuList;

	protected int padding = 5;

	public SortScreen(SortingAlgorithm sortAlgorithm) {
		super();
		sortController = new SortController(this);
		sortController.setSortAlgorithm(sortAlgorithm);
		generateArray(null);
		System.out.println(this.sortArray);
		calculateUnitHeight();
		addBackButtonToNavigationButton();
		add(createCenter(), BorderLayout.CENTER);
		add(createSouth(), BorderLayout.SOUTH);
		add(createWest(), BorderLayout.WEST);
		add(createEast(), BorderLayout.EAST);
		setVisible(true);
	}

	@SuppressWarnings("rawtypes")
	private void generateArray(ArrayUtil array) {
		if (sortArray == null) {
			sortArray = new ArrayUtil(sortController.MAX_ARRAY_LENGTH);
//			sortArray.dataType = Integer.TYPE; //TODO: Let user choose the dataType
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
				this.unitHeight = ((int)300)/((int)this.sortArray.getMax().getValue());
			} else if (this.sortArray.getMax().getValue() != (Double) 0.0) {
				this.unitHeight = ((double)300.0)/((double)this.sortArray.getMax().getValue());			
			} else {
				this.unitHeight = 0;
			}
		}
	}
	private void addBackButtonToNavigationButton() {
		ButtonComponent backButton = new ButtonComponent("Back");
		backButton.addActionListener(controller.backProtocol());
		navigationButton.add(backButton, 2, 0);
	}
	private JLayeredPane createCenter(){
		visualizerArea = new JLayeredPane();
		JPanel container = new JPanel();
		container.setLayout(null);
		container.setSize(1000, 1000);
		container.add(mainBarChartVisualizer(Color.ORANGE));
		sub = new ArrayGraphic(sortArray);
		container.add(sub);
		container.setVisible(true);
    
		animation = new JPanel();
		visualizerArea.add(container, JLayeredPane.DEFAULT_LAYER);
		
		errorLabel = new LabelComponent("Exceptions will be printed here");
		errorLabel.setForeground(Color.RED);
		visualizerArea.add(errorLabel, JLayeredPane.DRAG_LAYER);
		
//		createWest();
		visualizerArea.setVisible(true);		
		return visualizerArea;
	}
	private JPanel createSouth() {
		JPanel southPanel = new JPanel(new BorderLayout());
		southPanel.setPreferredSize(new Dimension(1000, 45));
		southPanel.setBackground(Color.BLACK);
		
		southPanel.add(createControlPanel(), BorderLayout.CENTER);
		southPanel.add(createSpeedChanger(), BorderLayout.WEST);
		southPanel.add(createInfoPanel(), BorderLayout.EAST);
		
		southPanel.setVisible(true);
		return southPanel;
	}
	// Array generator menu list
	private JLayeredPane createWest() {
		JLayeredPane westLayerPane = new JLayeredPane();
		westLayerPane.setBackground(Color.BLACK);
		
		JPanel menuCreateAndStart = new JPanel(new GridLayout(2,1));
		buttonCreateSortingArray = new ButtonComponent("Create (A)", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonCreateSortingArray.addActionListener(sortController.buttonCreateSortingArrayClicked());
		buttonStartSorting = new ButtonComponent("Sort", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonStartSorting.addActionListener(sortController.buttonStartSortingClicked());
		menuCreateAndStart.add(buttonCreateSortingArray);
		menuCreateAndStart.add(buttonStartSorting);
		
		JPanel createArrayField = new JPanel(new FlowLayout());
		buttonCreateRandomArray = new ButtonComponent("Random", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonCreateRandomArray.setSize(new Dimension(100, 34));
		arrayEqualsLabel = new LabelComponent("Array :=");
		inputArrayTextField = new TextFieldComponent(30, "Ex: 1, 8, 3, 5, 7, 15, 21, 34");
		buttonConfirmInputArray = new ButtonComponent("Confirm", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonConfirmInputArray.addActionListener(sortController.buttonConfirmInputArrayClicked());
		createArrayField.add(buttonCreateRandomArray);
		createArrayField.add(arrayEqualsLabel);
		createArrayField.add(inputArrayTextField);
		createArrayField.add(buttonConfirmInputArray);
		
		westLayerPane.add(menuCreateAndStart, JLayeredPane.DRAG_LAYER);
		westLayerPane.add(createArrayField, JLayeredPane.PALETTE_LAYER);
		
		return westLayerPane;
	}
	private JPanel createEast() {
		explanationDisplayer = new TextAreaComponent(new Dimension(70,20), Color.CYAN, "Welcome to the Sorting Algorithm Visualizer");
		eastPanel = new JPanel(new BorderLayout());
		eastPanel.setPreferredSize(new Dimension(40,590));
		eastPanel.setBackground(Color.BLACK);
		eastPanel.setBorder(BorderFactory.createEmptyBorder(0,0,20,0));
		
		showExplanation = new ButtonComponent("<");
		showExplanation.addActionListener(sortController.showExplanation());
		eastPanel.add(showExplanation, BorderLayout.SOUTH);
		
		eastPanel.add(explanationDisplayer, BorderLayout.CENTER);
		return eastPanel;
	}
	// Progress slider bar, play&pause button, next & back buttons
	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel();
		controlPanel.setBackground(new Color(238,238,238));
		
		if ((int)sortController.getSortAlgorithm().stepsList.size()!=0) {
			progressSlider = new SliderBarComponent(0,(int)sortController.getSortAlgorithm().stepsList.size(),0);
		} else {
			progressSlider = new SliderBarComponent(0,1,0);
		}
		// TODO: Add ChangeListener for the progressSlider
		progressSlider.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));
		
		Icon iconPause = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"pause.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		buttonPlayOrPause = new ButtonComponent(iconPause);
		
		Icon iconForward = new ImageIcon(new ImageIcon(IMAGE_RESOURCES +"forward.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonForwardOneStep = new ButtonComponent(iconForward);
		
		Icon iconBackward = new ImageIcon(new ImageIcon(IMAGE_RESOURCES +"backward.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonBackwardOneStep = new ButtonComponent(iconBackward);
		
		Icon iconForwardToTheEnd = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"end.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonForwardToTheEnd = new ButtonComponent(iconForwardToTheEnd);
		
		Icon iconBackwardToTheStart = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"start.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonBackwardToTheStart = new ButtonComponent(iconBackwardToTheStart);
		
		controlPanel.add(buttonBackwardToTheStart);
		controlPanel.add(buttonBackwardOneStep);
		controlPanel.add(buttonPlayOrPause);
		controlPanel.add(buttonForwardOneStep);
		controlPanel.add(buttonForwardToTheEnd);
		controlPanel.add(progressSlider);
		return controlPanel;
	}

	// Speed adjust slider
	private JPanel createSpeedChanger() {
		JPanel speedChanger = new JPanel(new BorderLayout());
		speedChanger.setPreferredSize(new Dimension(300,50));
		speedChanger.setBackground(new Color(238,238,238));
		speedChanger.setBorder(BorderFactory.createEmptyBorder(5,80,0,0));
		
		speedLabel = new LabelComponent(sortController.getSpeed()+"x");
		speedLabel.setForeground(Color.BLACK);
		
		speedSlider = new SliderBarComponent(1,7,1);
		speedSlider.addChangeListener(sortController.speedSliderBarChanged());
		
		speedChanger.add(speedLabel, BorderLayout.EAST);
		speedChanger.add(speedSlider, BorderLayout.WEST);
    
		return speedChanger;
	}
	// Help, About and Team buttons
	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		infoPanel.setPreferredSize(new Dimension(300,50));
		infoPanel.setBackground(new Color(238,238,238));
		
		buttonHelp = new ButtonComponent("Help", Color.WHITE, Color.BLACK, Color.black.brighter());
		buttonHelp.addActionListener(sortController.buttonHelpClicked());
		infoPanel.add(buttonHelp);

		buttonAbout = new ButtonComponent("About", Color.WHITE, Color.BLACK, Color.black.brighter());
		buttonAbout.addActionListener(sortController.buttonAboutClicked());
		infoPanel.add(buttonAbout);
		
		buttonTeam = new ButtonComponent("Team", Color.WHITE, Color.BLACK, Color.black.brighter());
		buttonTeam.addActionListener(sortController.buttonTeamClicked());
		infoPanel.add(buttonTeam);

		return infoPanel;
	}
	private ArrayGraphic mainBarChartVisualizer(Color color) {
		int unitWidth = ((int) getWidth()-200)/this.sortArray.size();
		ArrayGraphic mainBarChart = new ArrayGraphic(sortArray) {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
//				System.out.println("heehe");

				if (sortArray.dataType == Double.class) {
					for (int i = 0; i< sortArray.size();i++) {

						int width = Math.min(unitWidth,60+padding);
						g.fillRect(i*width+(getWidth()-width*sortArray.size())/2,-(int)(Math.round((double)sortArray.get(i).getValue() * unitHeight))
								+ getHeight(),Math.min(width-padding,60),(int)(Math.round((double)sortArray.get(i).getValue()*unitHeight)));
						g.setColor(color);
					}
				} 
				else if (sortArray.dataType == Integer.class) {
					for (int i = 0; i< sortArray.size();i++) {

						int width = Math.min(unitWidth,60+padding);
						g.fillRect(i*width+(getWidth()-width*sortArray.size())/2,-(int)(Math.round((int)sortArray.get(i).getValue() * unitHeight))
								+ getHeight(),Math.min(width-padding,60),(int)(Math.round((int)sortArray.get(i).getValue()*unitHeight)));
						g.setColor(color);
					}
				}// TODO: Write fillRect for String data type here
			}
		};
		// TODO: Redesign the boundary if necessary
		mainBarChart.setBounds(45,30,getWidth()-200,250);
		return mainBarChart;
	}
	public JPanel getEastPanel() {
		return this.eastPanel;
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
	public ButtonComponent getButtonCreateSortingArray() {
		return this.buttonCreateSortingArray;
	}
	public ButtonComponent getButtonCreateRandomArray() {
		return this.buttonCreateRandomArray;
	}
	public LabelComponent getArrayEqualsLabel() {
		return this.arrayEqualsLabel;
	}
	public TextFieldComponent getInputArrayTextField() {
		return this.inputArrayTextField;
	}
	public ButtonComponent betButtonConfirmInputArray() {
		return this.buttonConfirmInputArray;
	}
	public ButtonComponent getButtonStartSorting() {
		return this.buttonStartSorting;
	}
	public LabelComponent getErrorLabel() {
		return this.errorLabel;
	}
	public JLayeredPane getVisualizerArea() {
		return this.visualizerArea;
	}
	public LabelComponent getSpeedLabel() {
		return this.speedLabel;
	}
	public ButtonComponent getAboutButton() {
		return this.buttonAbout;
	}
	public ButtonComponent getHelpButton() {
		return this.buttonHelp;
	}
	public ButtonComponent getTeamButton() {
		return this.buttonTeam;
	}
	
	public abstract String getHelpString();
	public abstract String getAboutString();
	public abstract String getTeamString();
	
	@Override
	public void onEntry() {}

	@Override
	public void onExit() {}

}
