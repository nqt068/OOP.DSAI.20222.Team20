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
		return "Shell sort is mainly a variation of Insertion Sort. "
				+ "In insertion sort, we move elements only one position "
				+ "ahead. When an element has to be moved far ahead, many"
				+ " movements are involved. The idea of ShellSort is to allow "
				+ "the exchange of far items. In Shell sort, we make the array "
				+ "h-sorted for a large value of h. We keep reducing the value "
				+ "of h until it becomes 1. An array is said to be h-sorted if "
				+ "all sublists of every h’th element are sorted.";
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
