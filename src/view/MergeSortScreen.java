package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class MergeSortScreen extends SortScreen{

	public MergeSortScreen() {
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
	
    protected class MenuItemListener implements ActionListener {
    	public void actionPerformed(ActionEvent e) {
			String menuItem = e.getActionCommand();
			if (menuItem.equals("Help")) {
				//TODO: Add action for help of HomeScreen
			}
			else if (menuItem.equals("About")) {
				//TODO: Add action for about of HomeScreen
			}
		}
    }

}
