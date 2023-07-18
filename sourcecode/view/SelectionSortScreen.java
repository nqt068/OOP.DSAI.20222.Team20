package view;

import algorithm.SelectionSortAlgorithm;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import component.InfoWindowComponent;
import view.MergeSortScreen.MenuItemListener;

public class SelectionSortScreen extends SortScreen{

	public SelectionSortScreen() {
		super(new SelectionSortAlgorithm());
	}

	@Override
	public String getHelpString() {
		// TODO Auto-generated method stub
		return "To sort an array: \n Click Create (A) to create an array (random or self-declared) \n Then press sort and try out yourself the controls";
	}

	@Override
	public String getAboutString() {
		// TODO Auto-generated method stub
		return " Selection sort is a simple and efficient sorting algorithm that works"
				+ " by repeatedly selecting the smallest (or largest) element from "
				+ "the unsorted portion of the list and moving it to the sorted portion of the list.";
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
				InfoWindowComponent helpWindow = new InfoWindowComponent("Help", getHelpString());
			}
			else if (menuItem.equals("About")) {
				InfoWindowComponent aboutWindow = new InfoWindowComponent("About", getAboutString());
			}
		}
    }

}
