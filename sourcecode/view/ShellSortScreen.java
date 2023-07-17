package view;

import algorithm.ShellSortAlgorithm;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import component.InfoWindowComponent;

public class ShellSortScreen extends SortScreen{

	public ShellSortScreen() {
		super(new ShellSortAlgorithm());
	}

	@Override
	public String getHelpString() {
		// TODO Auto-generated method stub
		return "To sort an array: \n Click Create (A) to create an array (random or self-declared) \n Then press sort and try out yourself the controls";
	}

	@Override
	public String getAboutString() {
		// TODO Auto-generated method stub
		return " Team 20 has developed this capstone project with \n "
				+ "the aim of providing you with a visualization of how "
				+ "\n sorting algorithms operate on arrays.";
	}

	@Override
	public String getTeamString() {
		// TODO Auto-generated method stub
		return "We are team 20!";
	}
	
    protected class MenuItemListener extends view.Screen.MenuItemListener implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
			String menuItem = e.getActionCommand();
			if (menuItem.equals("Help")) {
				InfoWindowComponent helpWindow = new InfoWindowComponent("Help", "ShellSortScreenHelp");
			}
			else if (menuItem.equals("About")) {
				InfoWindowComponent aboutWindow = new InfoWindowComponent("About", "ShellSortScreenAbout");
			}
		}
    }

}
