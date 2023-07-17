package view;

import java.awt.BorderLayout;  
import java.awt.Color;
import java.awt.Container;
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
	
	protected String sortInfo = "Welcome to our Sorting Algorithms Visualizer";
	protected double unitHeight;
	
	Container cp;

	JPanel eastPanel;
	JLayeredPane visualizerArea;
	ArrayGraphic main;
	ArrayGraphic sub;
	JPanel animation;
	JPanel controlPanel;
	
	ButtonComponent showExplanation;
	TextAreaComponent explanationDisplayer;
	
	JPanel createArrayField;
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

	public SortScreen(@SuppressWarnings("rawtypes") SortingAlgorithm sortAlgorithm) {
		super();
		sortController = new SortController(this);
		sortController.setSortAlgorithm(sortAlgorithm);
		sortController.generateArray(null);
		sortController.setAttributes();
//		System.out.println(this.sortController.getSortArray());
		calculateUnitHeight();
		addBackButtonToNavigationButton();

		this.cp = new Container();
		cp.setLayout(new BorderLayout());
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.add(createSouth(), BorderLayout.SOUTH);
		cp.add(createEast(), BorderLayout.EAST);
		cp.add(createWest(), BorderLayout.WEST);
		add(cp);
		
		setVisible(true);
	}

	private void calculateUnitHeight() {
		if (sortController.getSortArray().getMax() == null) {
			this.unitHeight = 0;
		} else {			
			if (sortController.getSortArray().getMax().getValue() != (Integer) 0) {
				this.unitHeight = ((int)200)/((int)sortController.getSortArray().getMax().getValue());
			} else if (sortController.getSortArray().getMax().getValue() != (Double) 0.0) {
				this.unitHeight = ((double)200.0)/((double)sortController.getSortArray().getMax().getValue());			

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
		sub = new ArrayGraphic(sortController.getSortArray());
		container.add(sub);
		container.setBounds(0,0,1200,500);
		container.setVisible(true);
    
		animation = new JPanel();
		visualizerArea.add(container, new Integer(1));

		errorLabel = new LabelComponent("Exceptions will be printed here");
		errorLabel.setAlignment(SwingConstants.CENTER, SwingConstants.CENTER);
		errorLabel.setForeground(Color.RED);
//		errorLabel.setPreferredSize(new Dimension(2000,50));
		errorLabel.setBounds(0,0,1200,50);
		visualizerArea.setPreferredSize(new Dimension(1000, 350));


		visualizerArea.add(errorLabel, new Integer(2));
		
		visualizerArea.add(createWest(), new Integer(3));
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
	private JPanel createWest() {
		JPanel westLayerPane = new JPanel();
		westLayerPane.setBackground(Color.BLACK);
		
		JPanel menuCreateAndStart = new JPanel(new GridLayout(2,1));
		buttonCreateSortingArray = new ButtonComponent("Create (A)", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonCreateSortingArray.addActionListener(sortController.buttonCreateSortingArrayClicked());
		buttonStartSorting = new ButtonComponent("Sort", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonStartSorting.addActionListener(sortController.buttonStartSortingClicked());
		menuCreateAndStart.add(buttonCreateSortingArray);
		menuCreateAndStart.add(buttonStartSorting);
		menuCreateAndStart.setVisible(true);
		
		createArrayField = new JPanel(new FlowLayout());
		buttonCreateRandomArray = new ButtonComponent("Random", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonCreateRandomArray.setSize(new Dimension(100, 34));
		buttonCreateRandomArray.addActionListener(sortController.buttonCreateRandomArrayClicked());

		arrayEqualsLabel = new LabelComponent("Array :=");
		inputArrayTextField = new TextFieldComponent(30, "Ex: 1 8 3 5 7 15 21 34");
		buttonConfirmInputArray = new ButtonComponent("Confirm", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonConfirmInputArray.addActionListener(sortController.buttonConfirmInputArrayClicked());
		
		createArrayField.add(buttonCreateRandomArray);
		createArrayField.add(arrayEqualsLabel);
		createArrayField.add(inputArrayTextField);
		createArrayField.add(buttonConfirmInputArray);
		createArrayField.setVisible(false);
		
		westLayerPane.add(menuCreateAndStart);
		westLayerPane.add(createArrayField);
		
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
		JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		controlPanel.setBackground(new Color(238,238,238));
		controlPanel.setPreferredSize(new Dimension(800, 50));
		
		if ((int)sortController.getSortAlgorithm().stepsList.size()!=0) {
			progressSlider = new SliderBarComponent(0,(int)sortController.getSortAlgorithm().stepsList.size(),0,700);
		} else {
			progressSlider = new SliderBarComponent(0,1,0,700);
		}
		progressSlider.addChangeListener(sortController.progressSliderBarChanged());
		progressSlider.setBorder(BorderFactory.createEmptyBorder(5, 0, 0, 0));
		
		Icon iconPause = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"pause.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		buttonPlayOrPause = new ButtonComponent(iconPause);
		buttonPlayOrPause.addActionListener(sortController.buttonPlayOrPauseClicked());
		
		Icon iconForward = new ImageIcon(new ImageIcon(IMAGE_RESOURCES +"forward.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonForwardOneStep = new ButtonComponent(iconForward);
		buttonForwardOneStep.addActionListener(sortController.buttonForwardOneStepClicked());
		
		Icon iconBackward = new ImageIcon(new ImageIcon(IMAGE_RESOURCES +"backward.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonBackwardOneStep = new ButtonComponent(iconBackward);
		buttonBackwardOneStep.addActionListener(sortController.buttonBackwardOneStepClicked());
		
		Icon iconForwardToTheEnd = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"end.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonForwardToTheEnd = new ButtonComponent(iconForwardToTheEnd);
		buttonForwardToTheEnd.addActionListener(sortController.buttonForwardToTheEndClicked());
		
		Icon iconBackwardToTheStart = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"start.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonBackwardToTheStart = new ButtonComponent(iconBackwardToTheStart);
		buttonBackwardToTheStart.addActionListener(sortController.buttonBackwardToTheStartClicked());
		
		controlPanel.add(buttonBackwardToTheStart);
		controlPanel.add(buttonBackwardOneStep);
		controlPanel.add(buttonPlayOrPause);
		controlPanel.add(buttonForwardOneStep);
		controlPanel.add(buttonForwardToTheEnd);
		controlPanel.add(progressSlider);
//		controlPanel.setVisible(true);
		return controlPanel;
	}

	// Speed adjust slider
	private JPanel createSpeedChanger() {
		JPanel speedChanger = new JPanel(new FlowLayout(FlowLayout.LEFT));
		speedChanger.setPreferredSize(new Dimension(400,50));
		speedChanger.setBackground(new Color(238,238,238));
		speedChanger.setBorder(BorderFactory.createEmptyBorder(5,10,0,0));
		
		speedLabel = new LabelComponent(sortController.getSpeed()+"x");
		speedLabel.setForeground(Color.BLACK);
		speedLabel.setVisible(true);
		
		speedSlider = new SliderBarComponent(1,10,1,250);
		speedSlider.addChangeListener(sortController.speedSliderBarChanged());
		
		speedChanger.add(speedSlider);
		speedChanger.add(speedLabel);
    
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
		int unitWidth = ((int) getWidth()-200)/sortController.getSortArray().size();
		ArrayGraphic mainBarChart = new ArrayGraphic(sortController.getSortArray()) {
			@Override
			public void paintComponent(Graphics g) {
				super.paintComponent(g);
				if (sortController.getSortArray().dataType == Double.class) {

					for (int i = 0; i< sortController.getSortArray().size();i++) {

						int width = Math.min(unitWidth,15+padding);
						g.fillRect(i*width+(getWidth()-width*sortController.getSortArray().size())/2,-(int)(Math.round((double)sortController.getSortArray().get(i).getValue() * unitHeight))
								+ getHeight(),Math.min(width-padding,60),(int)(Math.round((double)sortController.getSortArray().get(i).getValue()*unitHeight)));
						g.setColor(color);
					}
				} 
				else if (sortController.getSortArray().dataType == Integer.class) {

					for (int i = 0; i< sortController.getSortArray().size();i++) {

						int width = Math.min(unitWidth,15+padding);
						g.fillRect(i*width+(getWidth()-width*sortController.getSortArray().size())/2,-(int)(Math.round((int)sortController.getSortArray().get(i).getValue() * unitHeight))
								+ getHeight(),Math.min(width-padding,60),(int)(Math.round((int)sortController.getSortArray().get(i).getValue()*unitHeight)));
						g.setColor(color);
					}
				}// TODO: Write fillRect for String data type here
			}
		};
		// TODO: Redesign the boundary if necessary
		mainBarChart.setBounds(-250,250,getWidth()-200,250);
		return mainBarChart;
	}
	
	public void updateArrayToScreen() {
    	BorderLayout layout = (BorderLayout) cp.getLayout();
    	cp.remove(layout.getLayoutComponent(BorderLayout.WEST));
    	cp.remove(layout.getLayoutComponent(BorderLayout.EAST));
    	cp.remove(layout.getLayoutComponent(BorderLayout.SOUTH));
    	cp.remove(layout.getLayoutComponent(BorderLayout.CENTER));
    	
		calculateUnitHeight();
//		System.out.println(unitHeight);
//		addBackButtonToNavigationButton();
		cp.add(createCenter(), BorderLayout.CENTER);
		cp.add(createSouth(), BorderLayout.SOUTH);
		cp.add(createEast(), BorderLayout.EAST);
		cp.add(createWest(), BorderLayout.WEST);
    	revalidate();
    	repaint();
	}
//	public Container getContainer() {
//		return this.cp;
//	}


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
	public JPanel getCreateArrayField() {
		return this.createArrayField;
	}
	public ButtonComponent getButtonPlayOrPause() {
		return this.buttonPlayOrPause;
	}
	public ButtonComponent getButtonBackwardToTheStart() {
		return this.buttonBackwardToTheStart;
	}
	public ButtonComponent getButtonBackwardOneStep() {
		return this.buttonBackwardOneStep;
	}
	public ButtonComponent getButtonForwardOneStep() {
		return this.buttonForwardOneStep;
	}
	public ButtonComponent getButtonForwardToTheEnd() {
		return this.buttonForwardToTheEnd;
	}
	public abstract String getHelpString();
	public abstract String getAboutString();
	public abstract String getTeamString();
	
	@Override
	public void onEntry() {}

	@Override
	public void onExit() {}

}
