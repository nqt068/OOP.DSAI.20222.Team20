package listener;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JOptionPane;
import javax.swing.SwingUtilities;

import view.HomeScreen;

public class ScreenListener {
	public ExitListener exitListener;
	public BackListener backListener;

	public ScreenListener() {
		this.exitListener = new ExitListener();
		this.backListener = new BackListener();
	}
	
}
class ExitListener implements ActionListener{
	// TODO: Rewrite the protocol
	@Override
	public void actionPerformed(ActionEvent e) {
		int option= JOptionPane.showConfirmDialog(null, "Do you want to exit the program?","Notification",JOptionPane.OK_CANCEL_OPTION);
		if (option == JOptionPane.OK_OPTION) {
			SwingUtilities.windowForComponent(((JButton)e.getSource())).dispose();
		}
	}
}
class BackListener implements ActionListener{
	// TODO: Rewrite the protocol
	@Override
	public void actionPerformed(ActionEvent e) {
		new HomeScreen().setVisible(true);
		SwingUtilities.windowForComponent(((JButton)e.getSource())).dispose();	
	}
}