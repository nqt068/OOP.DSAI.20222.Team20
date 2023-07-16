package view;

import algorithm.MergeSortAlgorithm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import component.InfoWindowComponent;
import view.HomeScreen.MenuItemListener;


public class MergeSortScreen extends SortScreen{

	public MergeSortScreen() {
		super(new MergeSortAlgorithm());
		revalidate();
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
	
    protected JMenuBar createMenuBar() {
    	this.menuItemListener = new MenuItemListener();
    	
    	JMenu menu = new JMenu("Menu");
    	
    	JMenuItem help = new JMenuItem("Help");
    	JMenuItem about = new JMenuItem("About");
    	
    	help.addActionListener(menuItemListener);
    	about.addActionListener(menuItemListener);

    	menu.add(help);
    	menu.add(about);
    	
    	JMenuBar menuBar = new JMenuBar();
    	menuBar.add(menu);
    	
    	return menuBar;
    }
	
    protected class MenuItemListener extends view.Screen.MenuItemListener implements ActionListener {
    	@Override
    	public void actionPerformed(ActionEvent e) {
			String menuItem = e.getActionCommand();
			if (menuItem.equals("Help")) {
				InfoWindowComponent helpWindow = new InfoWindowComponent("Help", "MergeSortScreenHelp");
			}
			else if (menuItem.equals("About")) {
				InfoWindowComponent aboutWindow = new InfoWindowComponent("About", "MergeSortScreenAbout");
			}
		}
    }

}
