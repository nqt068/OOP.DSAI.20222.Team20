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
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import component.*;
import component.utils.*;
import controller.SortController;

public abstract class SortScreen extends Screen{
	
	protected SortController sortController;
	protected ArrayUtil sortArray;
	protected String sortInfo = "Welcome to our Sorting Algorithms Visualizer";
	protected double unitHeight;
	
	JLayeredPane visualizerArea;
    ArrayGraphic main;
    ArrayGraphic sub;
	JPanel animation;
	JPanel controlPanel;
	
	SliderBarComponent progressSlider;
	
	TextAreaComponent explanationDisplayer;
	
	ButtonComponent buttonCreateSortingArray;
	ButtonComponent buttonCreateRandomArray;
	LabelComponent arrayEqualsLabel;
	TextFieldComponent inputArrayTextField;
	ButtonComponent buttonConfirmInputArray;
	ButtonComponent buttonStartSorting;
	LabelComponent errorLabel;
	
	
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
	
	protected int padding = 5;

	public SortScreen() {
		super();
		sortController = new SortController(this);
		generateArray(null);
		calculateUnitHeight();
		addBackButtonToNavigationButton();
		add(createCenter(), BorderLayout.CENTER);
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
		ButtonComponent backButton = new ButtonComponent("Back", Color.WHITE, Color.BLUE, Color.CYAN);
		backButton.addActionListener(controller.backProtocol());
		navigationButton.add(backButton, 2, 0);
	}
	private JLayeredPane createCenter(){
		visualizerArea = new JLayeredPane();
		JPanel container = new JPanel();
		container.setLayout(null);
		container.add(mainBarChartVisualizer(Color.ORANGE));
		sub = new ArrayGraphic(sortArray);
		container.add(sub);
		animation = new JPanel();
		visualizerArea.add(container, JLayeredPane.DEFAULT_LAYER);
		
		errorLabel = new LabelComponent("Exceptions will be printed here");
		errorLabel.setForeground(Color.RED);
		visualizerArea.add(errorLabel, JLayeredPane.DRAG_LAYER);
		
		createMenuList();
		
		return visualizerArea;
	}
	private JPanel createSouth() {
		JPanel bottomFunctionalBar = new JPanel(new BorderLayout());
		bottomFunctionalBar.setPreferredSize(new Dimension(1000, 45));
		bottomFunctionalBar.setBackground(Color.BLACK);
		
		bottomFunctionalBar.add(createControlPanel(), BorderLayout.CENTER);
		bottomFunctionalBar.add(createSpeedChanger(), BorderLayout.WEST);
		bottomFunctionalBar.add(createInfoPanel(), BorderLayout.EAST);
		return bottomFunctionalBar;
	}
	private JPanel createControlPanel() {
		JPanel controlPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		controlPanel.setBackground(Color.BLACK);
		
		if ((int)sortController.getSortAlgorithm().stepsList.size()!=0) {
			progressSlider = new SliderBarComponent(0,(int)sortController.getSortAlgorithm().stepsList.size(),0);
		} else {
			progressSlider = new SliderBarComponent(0,1,0);
		}
		// TODO: Add ChangeListener for the progressSlider
		progressSlider.setBorder(BorderFactory.createEmptyBorder(5, 10, 0, 0));
		controlPanel.add(progressSlider);
		
		Icon iconPause = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"pause.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
		buttonPlayOrPause = new ButtonComponent(iconPause);
		controlPanel.add(buttonPlayOrPause);
		
		Icon iconForward = new ImageIcon(new ImageIcon(IMAGE_RESOURCES +"forward.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonForwardOneStep = new ButtonComponent(iconForward);
		controlPanel.add(buttonForwardOneStep);
		
		Icon iconBackward = new ImageIcon(new ImageIcon(IMAGE_RESOURCES +"backward.png").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonBackwardOneStep = new ButtonComponent(iconBackward);
		controlPanel.add(buttonBackwardOneStep);
		
		Icon iconForwardToTheEnd = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"end.jpg").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonForwardToTheEnd = new ButtonComponent(iconForwardToTheEnd);
		controlPanel.add(buttonForwardToTheEnd);
		
		Icon iconBackwardToTheStart = new ImageIcon(new ImageIcon(IMAGE_RESOURCES+"start.jpg").getImage().getScaledInstance(18, 18, Image.SCALE_SMOOTH));
		buttonBackwardToTheStart = new ButtonComponent(iconBackwardToTheStart);
		controlPanel.add(buttonBackwardToTheStart);
		
		return controlPanel;
	}
	private void createMenuList() {
		buttonCreateSortingArray = new ButtonComponent("Create (A)", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonCreateSortingArray.addActionListener(sortController.buttonCreateSortingArrayClicked());
		visualizerArea.add(buttonCreateSortingArray, JLayeredPane.MODAL_LAYER);
		
		buttonCreateRandomArray = new ButtonComponent("Random", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonCreateRandomArray.setSize(new Dimension(100, 34));
//		buttonCreateRandomArray.addActionListener();
		visualizerArea.add(buttonCreateRandomArray, JLayeredPane.MODAL_LAYER);
		
		arrayEqualsLabel = new LabelComponent("Array :=");
		visualizerArea.add(arrayEqualsLabel, JLayeredPane.MODAL_LAYER);
		
		inputArrayTextField = new TextFieldComponent(30, "Ex: 1, 8, 3, 5, 7, 15, 21, 34");
		visualizerArea.add(inputArrayTextField, JLayeredPane.MODAL_LAYER);
		
		buttonConfirmInputArray = new ButtonComponent("Confirm", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonConfirmInputArray.addActionListener(sortController.buttonConfirmInputArrayClicked());
		visualizerArea.add(buttonConfirmInputArray, JLayeredPane.MODAL_LAYER);
		
		buttonStartSorting = new ButtonComponent("Sort", Color.WHITE, Color.CYAN, Color.cyan.darker());
		buttonStartSorting.addActionListener(sortController.buttonStartSortingClicked());
		visualizerArea.add(buttonStartSorting, JLayeredPane.MODAL_LAYER);
	}
	private JPanel createSpeedChanger() {
		JPanel speedChanger = new JPanel(new BorderLayout());
		speedChanger.setPreferredSize(new Dimension(300,50));
		speedChanger.setBackground(Color.BLACK);
		speedChanger.setBorder(BorderFactory.createEmptyBorder(5,80,0,0));
		
		speedLabel = new LabelComponent(sortController.getSpeed()+"x");
		speedLabel.setForeground(Color.WHITE);
		
		speedSlider = new SliderBarComponent(1,7,1);
		speedSlider.addChangeListener(sortController.speedSliderBarChanged());
		
		speedChanger.add(speedLabel, BorderLayout.EAST);
		speedChanger.add(speedSlider, BorderLayout.WEST);
		
		return speedChanger;
	}
	private JPanel createInfoPanel() {
		JPanel infoPanel = new JPanel(new FlowLayout(FlowLayout.LEFT));
		infoPanel.setPreferredSize(new Dimension(300,50));
		infoPanel.setBackground(Color.BLACK);
		
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
