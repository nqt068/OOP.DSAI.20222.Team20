package controller;

import javax.swing.JLabel;

import listener.BackListener;
import listener.ControlBtnListener;
import listener.DemonstrateListener;
import listener.LeftSideBarBtnListener;
import listener.ProgressSliderListener;
import listener.SpeedSliderListener;
import listener.TimerListener;
import listener.WindowResize;
import sorting.SortingAlgorithm;
import view.SortingScreen;

public class SortController{
	private final SortingScreen sortingScreen;
	private SortingAlgorithm sortingModel;

	private int speed = 50;
	private boolean isPlay = true;    //if playing
	private boolean isSorting = false;  // if in sorting process, else all the manipulate button will be ignored
	private int curStep = 0;
	public static final int MAX_LENGTH = 100;
		
	public SortController(SortingScreen sortingScreen) {
		this.sortingScreen = sortingScreen;
	}
	
	public WindowResize changeWindowSize() {
		return new WindowResize(this);
	}
	public SpeedSliderListener changeSpeed(JLabel count) {
		return new SpeedSliderListener(count, this);
	}
	public ProgressSliderListener changeProgressSlider() {
		return new ProgressSliderListener(this);
	}
	public DemonstrateListener rightSideButtonClicked() {
		return new DemonstrateListener(this);
	}
	public LeftSideBarBtnListener leftSideButtonClicked() {
		return new LeftSideBarBtnListener(this);
	}
	public TimerListener setTimer() {
		return new TimerListener(this);
	}
	public ControlBtnListener controlButtonCLicked() {
		return new ControlBtnListener(this);
	}
	public BackListener backButtonClicked() {
		return new BackListener();
	}
	
	public int[][] getArrayStates() {
		return sortingModel.getArrayLog();
	}
	public int[][] getTempStates() {
		return sortingModel.getTempLog();
	}
	public int[][] getPointerStates() {
		return sortingModel.getPointerLog();
	}
	public String[] getGuideStates() {
		return sortingModel.getGuideLog();
	}
	public int getStep() {
		return sortingModel.getNumSteps() - 1;
	}

	public void setSpeed(int defaultSpeed) {
		this.speed = defaultSpeed;
	}
	public int getSpeed() {
		return this.speed;
	}
	public boolean isPlay() {
		return isPlay;
	}
	public void setPlay(boolean isPlay) {
		this.isPlay = isPlay;
	}
	public boolean isSorting() {
		return isSorting;
	}
	public void setSorting(boolean isSorting) {
		this.isSorting = isSorting;
	}
	public int getCurStep() {
		return curStep;
	}
	public void setCurStep(int curStep) {
		this.curStep = curStep;
	}
	
	public SortingAlgorithm getModel() {
		return sortingModel;
	}
	public void setModel(SortingAlgorithm model) {
		this.sortingModel = model;
	}
	public SortingScreen getView() {
		return sortingScreen;
	}
}