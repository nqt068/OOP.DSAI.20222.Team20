package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;
import java.lang.reflect.Constructor;
import java.util.List;
import java.util.ListIterator;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import algorithm.SortingAlgorithm;
import algorithm.MergeSortAlgorithm;
import algorithm.ShellSortAlgorithm;
import algorithm.SelectionSortAlgorithm;

import listener.SortingScreenListener;
import view.SortScreen;
import component.InfoWindowComponent;
import component.utils.ArrayUtil;
import component.utils.Element;

public class SortController extends Controller{
	private SortingAlgorithm sortAlgorithm;
	
	public static final int MAX_ARRAY_LENGTH = 30;
	private SortScreen sortScreen;
	protected ArrayUtil sortArray;
	private Timer timer;
	// TODO: Change the parameters
	private int sortingSpeed = 1;
	private boolean isPlaying = true;
	private boolean isSorting = false;
	private int currentStep = 0;
	

	public SortController(SortScreen sortScreen) {
		this.sortScreen = sortScreen;
	}
	public SortScreen getSortScreen() {
		return this.sortScreen;
	}
	@SuppressWarnings("rawtypes")
	public void generateArray(ArrayUtil array) {
		if (sortArray == null) {
			sortArray = new ArrayUtil(MAX_ARRAY_LENGTH);
//			sortArray.dataType = Integer.class; //TODO: Let user choose the dataType


			sortArray.generateRandomArray();
		} else {
			this.sortArray = array;
		}
	}
	public ComponentAdapter adjustWindowSize() {
		return new ComponentAdapter() {
		    @Override
		    public void componentResized( ComponentEvent e ) {
		    	getSortScreen().getButtonStartSorting().setBounds(3, getSortScreen().getHeight()-175 , 150, 32);
		    	getSortScreen().getButtonCreateSortingArray().setBounds(3, getSortScreen().getHeight() -208, 150, 33);
		    	getSortScreen().getButtonCreateRandomArray().setBounds(156, getSortScreen().getHeight()-205, 78,28);
		    	getSortScreen().getArrayEqualsLabel().setBounds(236, getSortScreen().getHeight()-205, 28,28);
		    	getSortScreen().getInputArrayTextField().setBounds(266, getSortScreen().getHeight()-205, 228,28);
		    	getSortScreen().betButtonConfirmInputArray().setBounds(496, getSortScreen().getHeight()-205, 50,28);
		    	getSortScreen().getExplanationDisplayer().setBounds(getSortScreen().getWidth()-490,  getSortScreen().getHeight() -208,380 , 65);
		    }
		};
	}
	public ChangeListener adjustSpeed() {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setSpeed(((JSlider) e.getSource()).getValue());
				// TODO: Show speed in speed label
			}
		};
	}
	public ChangeListener changeProgress() {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Do the changeProgress here
			}
		};
	}

	public ActionListener showExplanation() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton sourceButton = (JButton) e.getSource();
				boolean isBackwardButton = "<".equals(sourceButton.getText());
				if (isBackwardButton) {
				    sourceButton.setText(">");
				    getSortScreen().getExplanationDisplayer().setVisible(true);
				    getSortScreen().getEastPanel().setPreferredSize(new Dimension(200, 590));
				} else {
				    sourceButton.setText("<");
				    getSortScreen().getExplanationDisplayer().setVisible(false);
				    getSortScreen().getEastPanel().setPreferredSize(new Dimension(40, 590));
				}
			}
		};
	}
	public ActionListener buttonCreateSortingArrayClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("hehe");
				getSortScreen().getCreateArrayField().setVisible(!getSortScreen().getCreateArrayField().isVisible());
			}
		};
	}
	public ActionListener buttonCreateRandomArrayClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
//				System.out.println("hehe");
				sortArray = new ArrayUtil(MAX_ARRAY_LENGTH);
				sortArray.generateRandomArray();
				getSortScreen().getCreateArrayField().setVisible(!getSortScreen().getCreateArrayField().isVisible());
				getSortScreen().updateArrayToScreen();


			}
		};
	}
	public ActionListener buttonConfirmInputArrayClicked() {
		return new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void actionPerformed(ActionEvent e) {
				String inputArrayString = getSortScreen().getInputArrayTextField().getText();
				String[] inputArray = inputArrayString.split(" ");
				int[] intArray = new int[inputArray.length];
				
				for (int i = 0; i < inputArray.length; i++) {
				    intArray[i] = Integer.parseInt(inputArray[i]);
				}
				sortArray = new ArrayUtil(inputArray.length);
				for (int i = 0; i < inputArray.length; i ++) {
					sortArray.set(i, new Element<Integer>(intArray[i]));
				}
				sortArray.dataType = Integer.class;
//				sortArray.printArray();
				getSortScreen().getCreateArrayField().setVisible(!getSortScreen().getCreateArrayField().isVisible());
				getSortScreen().updateArrayToScreen();


			}
		};
	}
	public ActionListener buttonStartSortingClicked() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				String algName = sortAlgorithm.getClass().getName();
				
				if (algName == "algorithm.MergeSortAlgorithm") {
					sortAlgorithm = new MergeSortAlgorithm(sortArray);
				} else if (algName == "algorithm.SelectionSortAlgorithm") {
					sortAlgorithm = new SelectionSortAlgorithm(sortArray);
				} else if (algName == "algorithm.ShellSortAlgorithm") {
					int[] gaps = {8,4,2,1};
 					sortAlgorithm = new ShellSortAlgorithm(gaps, sortArray);
				}

				List<ArrayUtil> stepsList = sortAlgorithm.sortAndGetSteps();
				ListIterator LI = stepsList.listIterator();
				
				int delay = 100;
			    ActionListener taskPerformer = new ActionListener() {
			    	public void actionPerformed(ActionEvent evt) {
			    		if (LI.hasNext()) {
			    			sortArray = (ArrayUtil) LI.next();
//			    			sortArray.printArray();
			    			getSortScreen().updateArrayToScreen();
			    		} else {
			    			sortArray = (ArrayUtil) LI.next();
//			    			sortArray.printArray();
			    			getSortScreen().updateArrayToScreen();
			    			((Timer)evt.getSource()).stop();
			    		}
			    	}
			    };
			    timer = new Timer(delay, taskPerformer);
			    timer.start();
			}
		};
	}
	public ChangeListener progressSliderBarChanged() {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(((JSlider)e.getSource()).getValue());
			}
		};
	}
	public ChangeListener speedSliderBarChanged() {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setSpeed(((JSlider)e.getSource()).getValue());
				getSortScreen().getSpeedLabel().setText(getSpeed()+"x");
				if (isSorting()) {
					timer.stop();
					timer.setDelay(1000 - sortingSpeed*100);
					timer.start();
				}
				// TODO: Check the isPlaying if necessary
			}
		};
	}
	public ActionListener buttonHelpClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfoWindowComponent helpWindow = new InfoWindowComponent("Help Window",getSortScreen().getHelpString());
			}
		};
	}
	public ActionListener buttonAboutClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfoWindowComponent aboutWindow = new InfoWindowComponent("About Window",getSortScreen().getAboutString());
			}
		};
	}
	public ActionListener buttonTeamClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				InfoWindowComponent teamWindow = new InfoWindowComponent("Team Window",getSortScreen().getTeamString());
			}
		};
	}
	
	// Setter methods
	public ArrayUtil getSortArray() {
		return this.sortArray;
	}
	public void setSpeed(int newSpeed) {
		this.sortingSpeed = newSpeed;
	}
	public int getSpeed() {
		return this.sortingSpeed;
	}
	public boolean isPlaying() {
		return this.isPlaying;
	}
	public void setPlaying(boolean isPlaying) {
		this.isPlaying = isPlaying;
	}
	public boolean isSorting() {
		return isSorting;
	}
	public void setSorting(boolean isSorting) {
		this.isSorting = isSorting;
	}
	public int getCurrentStep() {
		return currentStep;
	}
	public void setCurrentStep(int currentStep) {
		this.currentStep = currentStep;
	}
	public void setSortAlgorithm(SortingAlgorithm sortingAlgorithm) {
		this.sortAlgorithm = sortingAlgorithm;
	}
	public SortingAlgorithm getSortAlgorithm() {
		return this.sortAlgorithm;
	}
	public Timer getTimer() {
		return this.timer;
	}
	// ArrayUtil methods
	
}
