package component;

import java.awt.Color;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JButton;

import component.utils.ColorUtil;

class HoverMouseAdapter extends MouseAdapter{
	JButton button;
	public HoverMouseAdapter(JButton btn) {
		this.button = btn;
	}
	public void mouseEntered(MouseEvent evt) {
	    button.setBackground(Color.BLACK);
	}
	public void mouseExited(MouseEvent evt){
		button.setBackground(ColorUtil.MY_BLUE);
	}
}