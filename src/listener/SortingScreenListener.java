package listener;

import javax.swing.JButton;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import controller.SortController;
import view.SortScreen;

import java.awt.event.*;

public class SortingScreenListener {
	private SortController sortController;
	
	public ComponentAdapter changeWindowSize;
	public ChangeListener changeSpeed;
	public ChangeProgressListener changeProgress;
	public ShowExplanationListener showExplanation;
	public SortingOptionsListener sortOptions;
	public SortControllingButtonListener sortControllingButton;
	public SortingScreenListener() {
		// TODO Auto-generated constructor stub
	}
	public ComponentAdapter changeWindowSize() {
		this.changeWindowSize = new ComponentAdapter() {
		    @Override
		    public void componentResized( ComponentEvent e ) {
		    	sortController.getSortScreen().getBtnSort().setBounds(3, controller.getSortScreen().getHeight()-175 , 150, 32);
		    	sortController.getSortScreen().getBtnCreate().setBounds(3, controller.getSortScreen().getHeight() -208, 150, 33);
		    	sortController.getSortScreen().getBtnRandom().setBounds(156, controller.getSortScreen().getHeight()-205, 78,28);
		    	sortController.getSortScreen().getA().setBounds(236, controller.getSortScreen().getHeight()-205, 28,28);
		    	sortController.getSortScreen().getInputArrayField().setBounds(266, controller.getSortScreen().getHeight()-205, 228,28);
		    	sortController.getSortScreen().getBtnGo().setBounds(496, controller.getSortScreen().getHeight()-205, 50,28);
		    	sortController.getSortScreen().getDemonstratePane().setBounds(controller.getSortScreen().getWidth()-490,  controller.getSortScreen().getHeight() -208,380 , 65);
		    	sortController.getSortScreen().getAnimation().setBounds(45, 30, controller.getSortScreen().getWidth()-200, 520);
		    	sortController.getSortScreen().getContainer1().setBounds(45, 30, controller.getSortScreen().getWidth()-200, 522);
		    	sortController.getSortScreen().getMain().setBounds(0, 0, controller.getSortScreen().getWidth()-200, 250);
		    	sortController.getSortScreen().getSub().setBounds(0, 270, controller.getSortScreen().getWidth()-200, 250);
		    	sortController.getSortScreen().getErrorLabel().setBounds((controller.getSortScreen().getWidth()-450)/2, 5, 300, 20);
		    }
		};
	}
	
	public ChangeListener changeSpeed() {
		this.changeSpeed = new ChangeListener() {

			@Override
			public void stateChanged(ChangeEvent e) {
				sortController.setSpeed(((JSlider) e.getSource()).getValue());
				
			}
			
		};
	}

}

class ShowExplanationListener implements ActionListener{
	public void DemonstrateListener(SortController sortController) {
		super(sortController);
	}
    @Override
    public void actionPerformed(ActionEvent e) {
        JButton button = (JButton) e.getSource();
        String buttonText = button.getText();
        boolean isVisible = buttonText.equals("<");
        button.setText(isVisible ? ">" : "<");
        controller.getSortScreen().getDemonstratePane().setVisible(isVisible);
    }
}
