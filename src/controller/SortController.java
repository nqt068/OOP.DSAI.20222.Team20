package controller;

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

public class SortController extends Controller{
	private SortingAlgorithm sortAlgorithm;
	private SortingScreenListener sortListener;
	public static final int MAX_ARRAY_LENGTH = 30;
	private SortScreen sortScreen;
	// TODO: Change the parameters
	private int speed = 50;
	private boolean isPlay = true;
	private boolean isSorting = false;
	private int curStep = 0;
	

	public SortController() {
		this.sortScreen = new SortScreen();
	}
	public SortScreen getSortScreen() {
		return this.sortScreen;
	}
	public ComponentAdapter adjustWindowSize() {
		return new ComponentAdapter() {
		    @Override
		    public void componentResized( ComponentEvent e ) {
		    	getSortScreen().getBtnSort().setBounds(3, controller.getSortScreen().getHeight()-175 , 150, 32);
		    	getSortScreen().getBtnCreate().setBounds(3, controller.getSortScreen().getHeight() -208, 150, 33);
		    	getSortScreen().getBtnRandom().setBounds(156, controller.getSortScreen().getHeight()-205, 78,28);
		    	getSortScreen().getA().setBounds(236, controller.getSortScreen().getHeight()-205, 28,28);
		    	getSortScreen().getInputArrayField().setBounds(266, controller.getSortScreen().getHeight()-205, 228,28);
		    	getSortScreen().getBtnGo().setBounds(496, controller.getSortScreen().getHeight()-205, 50,28);
		    	getSortScreen().getAnimation().setBounds(45, 30, controller.getSortScreen().getWidth()-200, 520);
		    	getSortScreen().getExplanationDisplayer().setBounds(controller.getSortScreen().getWidth()-490,  getSortScreen().getHeight() -208,380 , 65);
		    	getSortScreen().getContainer1().setBounds(45, 30, controller.getSortScreen().getWidth()-200, 522);
		    	getSortScreen().getMain().setBounds(0, 0, controller.getSortScreen().getWidth()-200, 250);
		    	getSortScreen().getSub().setBounds(0, 270, controller.getSortScreen().getWidth()-200, 250);
		    	getSortScreen().getErrorLabel().setBounds((controller.getSortScreen().getWidth()-450)/2, 5, 300, 20);
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
	public ActionListener showExplaination() {
		return new ActionListener() {
			@Override
			public void actionPerformed(ActionEvent e) {
				JButton sourceButton = (JButton) e.getSource();
				boolean isBackwardButton = "<".equals(sourceButton.getText());
				if (isBackwardButton) {
				    sourceButton.setText(">");
				    getSortScreen().getExplanationDisplayer().setVisible(true);
				} else {
				    sourceButton.setText("<");
				    getSortScreen().getExplanationDisplayer().setVisible(false);
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
	// Setter methods
	private void setSpeed(int newSpeed) {
		this.speed = newSpeed;
	}
	// ArrayUtil methods
	
}
