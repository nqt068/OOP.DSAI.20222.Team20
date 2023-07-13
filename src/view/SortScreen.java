package view;

import javax.swing.JLayeredPane;
import javax.swing.JPanel;

import component.*;
import component.utils.*;
import controller.SortController;

public class SortScreen extends Screen{
	
	protected SortController sortController;
	protected ArrayUtil<Integer> sortArray;
	protected String sortInfo = "Welcome to our Sorting Algorithms Visualizer";
	JLayeredPane visualizer;
	JPanel container;
    Visualizer main;
    Visualizer sub;
	JPanel animation;
	SliderBar processSlider;
	DemonstratePane demonstratePane;
	MySideButton btnCreate;
	MySideButton btnRandom;
	MyLabel A;
	MyTextField inputArrayField;
	MySideButton btnGo;
	MySideButton btnSort;
	MyLabel errorLabel;
	public final String placeHolder = "Ex: 1, 2, 3, 4, 8";
	
	protected double unitHeight;
	protected int padding = 5;
	
	

	public SortScreen() {
		super();
		sortController = new SortController();
		generateArray(null);
	}

	private void generateArray(Object object) {
		if (sortArray == null) {
			sortArray.randomizeArray(sortController.MAX_ARRAY_LENGTH);
		}
	}

	@Override
	public void onEntry() {}

	@Override
	public void onExit() {}

}
