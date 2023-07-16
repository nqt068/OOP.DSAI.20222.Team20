package controller;

import java.awt.Dimension;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import algorithm.SortingAlgorithm;
import listener.SortingScreenListener;
import view.SortScreen;
import component.InfoWindowComponent;

public class SortController extends Controller{
	private SortingAlgorithm sortAlgorithm;
	private SortingScreenListener sortListener;
	public static final int MAX_ARRAY_LENGTH = 30;
	private SortScreen sortScreen;
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
//		    	getSortScreen().getAnimation().setBounds(45, 30, getSortScreen().getWidth()-200, 520);
		    	getSortScreen().getExplanationDisplayer().setBounds(getSortScreen().getWidth()-490,  getSortScreen().getHeight() -208,380 , 65);
//		    	getSortScreen().getContainer1().setBounds(45, 30, getSortScreen().getWidth()-200, 522);
//		    	getSortScreen().getMain().setBounds(0, 0, getSortScreen().getWidth()-200, 250);
//		    	getSortScreen().getSub().setBounds(0, 270, getSortScreen().getWidth()-200, 250);
//		    	getSortScreen().getErrorLabel().setBounds((getSortScreen().getWidth()-450)/2, 5, 300, 20);
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
				// TODO Auto-generated method stub
				
			}
		};
	}
	public ActionListener buttonConfirmInputArrayClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	public ActionListener buttonStartSortingClicked() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	public ChangeListener progressSliderBarChanged() {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				// TODO Auto-generated method stub
				
			}
		};
	}
	public ChangeListener speedSliderBarChanged() {
		return new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				setSpeed(((JSlider)e.getSource()).getValue());
				getSortScreen().getSpeedLabel().setText(getSpeed()+"");
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
