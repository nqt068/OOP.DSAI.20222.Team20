package controller;

import java.awt.Dimension;
import java.awt.Image;
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

import view.SortScreen;
import component.InfoWindowComponent;
import component.utils.ArrayUtil;
import component.utils.Element;


public class SortController extends Controller{
	
	private SortingAlgorithm sortAlgorithm;
	private String algName;
	private List<ArrayUtil> stepsList;
	private ListIterator LI;
	private int delay = DELAY;
	private Timer timer;
	
	public static final int MAX_ARRAY_LENGTH = 30;
	public static final int DELAY = 1000;

	private SortScreen sortScreen;
	protected ArrayUtil sortArray;
	private int sortingSpeed = 1;
	private boolean isPlaying = true;
	private boolean isSorting = false;
	private boolean isManuallyControlling = false;
	private int currentStep = 0;
	

	public SortController(SortScreen sortScreen) {
		this.sortScreen = sortScreen;
	}
	public SortScreen getSortScreen() {
		return this.sortScreen;
	}
	
	// Only do this after setting the sortAlgorithm
	public void setAttributes() {
		algName = sortAlgorithm.getClass().getName();
	}
	
	@SuppressWarnings("rawtypes")
	public void generateArray(ArrayUtil array) {
		if (sortArray == null) {
			sortArray = new ArrayUtil(MAX_ARRAY_LENGTH);

			sortArray.generateRandomArray();
		} else {
			this.sortArray = array;
		}
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
				getSortScreen().getCreateArrayField().setVisible(!getSortScreen().getCreateArrayField().isVisible());
			}
		};
	}
	public ActionListener buttonCreateRandomArrayClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				sortArray = new ArrayUtil(MAX_ARRAY_LENGTH);
				sortArray.generateRandomArray();
				getSortScreen().getCreateArrayField().setVisible(!getSortScreen().getCreateArrayField().isVisible());
				getSortScreen().updateNewArrayToScreen(-1);
			}
		};
	}
	public ActionListener buttonConfirmInputArrayClicked() {
		return new ActionListener() {
			@SuppressWarnings({ "unchecked", "rawtypes" })
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					String[] inputArray;
					String inputArrayString;
					
					try {
						inputArrayString = getSortScreen().getInputArrayTextField().getText();
						inputArray = inputArrayString.split(" ");
						if (inputArray.length > 30) {
							throw new ArrayIndexOutOfBoundsException();
						}
					}
					catch (Exception ee) {
						throw new IllegalArgumentException();
					}
					try {
						int[] intArray = new int[inputArray.length];
						
						for (int i = 0; i < inputArray.length; i++) {
						    intArray[i] = Integer.parseInt(inputArray[i]);
						}
						sortArray = new ArrayUtil(inputArray.length);
						for (int i = 0; i < inputArray.length; i ++) {
							sortArray.set(i, new Element<Integer>(intArray[i]));
						}
						sortArray.dataType = Integer.class;
					}
					catch (Exception ee){
						try {
							double[] intArray = new double[inputArray.length];
							
							for (int i = 0; i < inputArray.length; i++) {
							    intArray[i] = Double.parseDouble(inputArray[i]);
							}
							sortArray = new ArrayUtil(inputArray.length);
							for (int i = 0; i < inputArray.length; i ++) {
								sortArray.set(i, new Element<Double>(intArray[i]));
							}
							sortArray.dataType = Double.class;
						}
						catch (Exception eee){
							throw eee;
						}
					}
					getSortScreen().getCreateArrayField().setVisible(!getSortScreen().getCreateArrayField().isVisible());
					getSortScreen().updateNewArrayToScreen(-1);
				}
				catch (Exception eee){
					getSortScreen().getErrorLabel().setText("<html><body style='text-align: center'>Invalid inputArray. <br> Please check our example for reference.</html>");
				}

			}
		};
	}
	
    public ActionListener updateArraySequentially = new ActionListener() {
    	public void actionPerformed(ActionEvent evt) {
    		if (LI.hasNext()) {
    			int index = -1;
    			ArrayUtil tempArray = sortArray.clone();
    			setCurrentStep(LI.nextIndex());
    			sortArray = (ArrayUtil) LI.next();
    			
    			for (int i = 0; i < tempArray.size(); i++) {
    				if (tempArray.get(i) != sortArray.get(i)) {
    					index = i;
    					break;
    				}
    			}
    			setManuallyControlling(true);
    			getSortScreen().getProgressSlider().setValue(currentStep);
    			getSortScreen().updateArrayToScreen(index);
    			if (!LI.hasNext()) {
    				((Timer)evt.getSource()).stop();
    			}
    		}
    	}
    };
    
	public ActionListener buttonStartSortingClicked() {
		return new ActionListener() {
			public void actionPerformed(ActionEvent e) {	
				setSorting(true);
				if (algName == "algorithm.MergeSortAlgorithm") {
					sortAlgorithm = new MergeSortAlgorithm(sortArray.clone());
				} else if (algName == "algorithm.SelectionSortAlgorithm") {
					sortAlgorithm = new SelectionSortAlgorithm(sortArray.clone());
				} else if (algName == "algorithm.ShellSortAlgorithm") {
					int[] gaps = {8,4,2,1};
					sortAlgorithm = new ShellSortAlgorithm(gaps, sortArray.clone());
				} else {}

//				sortAlgorithm.sort();
				stepsList = sortAlgorithm.sortAndGetSteps();
				LI = stepsList.listIterator();
				getSortScreen().updateControl();
			    timer = new Timer(DELAY - sortingSpeed*(DELAY/10), updateArraySequentially);
			    setPlaying(true);
			    timer.start();
			}
		};
	}
	public ActionListener buttonPlayOrPauseClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				Icon pauseIcon = new ImageIcon(new ImageIcon(getSortScreen().IMAGE_RESOURCES+"pause.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
				Icon playIcon = new ImageIcon(new ImageIcon(getSortScreen().IMAGE_RESOURCES+"play.png").getImage().getScaledInstance(20, 20, Image.SCALE_SMOOTH));
				if (isSorting) {
					if (!isPlaying()) {
						getSortScreen().getButtonPlayOrPause().setIcon(pauseIcon);
						setPlaying(true);
						LI = stepsList.listIterator(currentStep);
						timer.start();
					} else {
						getSortScreen().getButtonPlayOrPause().setIcon(playIcon);
						setPlaying(false);
						timer.stop();
					}
				}
			}
		};
	}
	public ActionListener buttonBackwardToTheStartClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (isSorting) {
						if (isPlaying) {
							getSortScreen().getButtonPlayOrPause().doClick();
						}
	;					setCurrentStep(0);
						getSortScreen().getProgressSlider().setValue(currentStep);
					} else {
						throw new NullPointerException();
					}
				}
				catch (NullPointerException npe){
					getSortScreen().getErrorLabel().setText("Click the button \"Sort\" first.");
				}
			}
		};
	}
	public ActionListener buttonBackwardOneStepClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (isSorting) {
						if (isPlaying) {
							getSortScreen().getButtonPlayOrPause().doClick();
						}
						if (currentStep > 0) {
							currentStep--;
							getSortScreen().getProgressSlider().setValue(currentStep);
						} else {
							throw new IllegalArgumentException();
						}
					} else {
						throw new NullPointerException();
					}
				}
				catch (NullPointerException npe){
					getSortScreen().getErrorLabel().setText("Click the button \"Sort\" first.");
				}
				catch (IllegalArgumentException iae) {
					getSortScreen().getErrorLabel().setText("You have already been in the end point.");
				}
			}
		};
	}
	public ActionListener buttonForwardOneStepClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (isSorting) {
						if (isPlaying) {
							getSortScreen().getButtonPlayOrPause().doClick();
						}
						if (currentStep < stepsList.size()-1) {
							currentStep++;
							getSortScreen().getProgressSlider().setValue(currentStep);
						} else {
							throw new IllegalArgumentException();
						}
					} else {
						throw new NullPointerException();
					}
				}
				catch (NullPointerException npe){
					getSortScreen().getErrorLabel().setText("Click the button \"Sort\" first.");
				}
				catch (IllegalArgumentException iae) {
					getSortScreen().getErrorLabel().setText("You have already been in the end point.");
				}
			}
		};
	}
	public ActionListener buttonForwardToTheEndClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				try {
					if (isSorting) {
						if (isPlaying) {
							getSortScreen().getButtonPlayOrPause().doClick();
						}
						setCurrentStep(stepsList.size()-1);
						getSortScreen().getProgressSlider().setValue(currentStep);
					} else {
						throw new NullPointerException();
					}
				}
				catch (NullPointerException npe){
					getSortScreen().getErrorLabel().setText("Click the button \"Sort\" first.");
				}
			}
		};
	}
	public ChangeListener progressSliderBarChanged() {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				try {
					if (isSorting) {
						if (isPlaying && !isManuallyControlling) {
							getSortScreen().getButtonPlayOrPause().doClick();
						}
						setCurrentStep(((JSlider)e.getSource()).getValue());
						sortArray = (ArrayUtil) stepsList.get(currentStep);
						LI = stepsList.listIterator(currentStep);
						getSortScreen().updateArrayToScreen(-1);
					} else {
						throw new NullPointerException();
					}
				}
				catch (NullPointerException npe){
					getSortScreen().getErrorLabel().setText("Click the button \"Sort\" first.");
				}
			}
		};
	}
	public ChangeListener speedSliderBarChanged() {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				if (isPlaying) {
					timer.stop();
					setSpeed(((JSlider)e.getSource()).getValue());
					getSortScreen().getSpeedLabel().setText(getSpeed()+"x");
					timer.setDelay(DELAY - sortingSpeed*(DELAY/10));
					timer.start();
				}
				else {
					setSpeed(((JSlider)e.getSource()).getValue());
					getSortScreen().getSpeedLabel().setText(getSpeed()+"x");
					timer.setDelay(DELAY - sortingSpeed*(DELAY/10));
				}
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
//	public ActionListener buttonTeamClicked() {
//		return new ActionListener() {
//			@Override
//			public void actionPerformed(ActionEvent e) {
//				InfoWindowComponent teamWindow = new InfoWindowComponent("Team Window",getSortScreen().getTeamString());
//			}
//		};
//	}
	
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
		if (isPlaying == true) {
			setManuallyControlling(false);
		}
		else {
			setManuallyControlling(true);
		}
	}
	public void setManuallyControlling(boolean isManuallyControlling) {
		this.isManuallyControlling = isManuallyControlling;
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
	private void setCurrentStep(int currentStep) {
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
