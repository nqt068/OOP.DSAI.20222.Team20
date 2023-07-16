package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import component.InfoWindowComponent;

public class ShellSortScreen extends SortScreen{

	public ShellSortScreen() {
		super();
	}

	@Override
	public String getHelpString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getAboutString() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public String getTeamString() {
		// TODO Auto-generated method stub
		return null;
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
