package controller;

import java.awt.event.ComponentAdapter;
import java.awt.event.ComponentEvent;

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
	public ComponentAdapter changeWindowSize() {
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
		    	getSortScreen().getDemonstratePane().setBounds(controller.getSortScreen().getWidth()-490,  controller.getSortScreen().getHeight() -208,380 , 65);
		    	getSortScreen().getContainer1().setBounds(45, 30, controller.getSortScreen().getWidth()-200, 522);
		    	getSortScreen().getMain().setBounds(0, 0, controller.getSortScreen().getWidth()-200, 250);
		    	getSortScreen().getSub().setBounds(0, 270, controller.getSortScreen().getWidth()-200, 250);
		    	getSortScreen().getErrorLabel().setBounds((controller.getSortScreen().getWidth()-450)/2, 5, 300, 20);
		    }
		};
	}
	// ArrayUtil methods
	
}
