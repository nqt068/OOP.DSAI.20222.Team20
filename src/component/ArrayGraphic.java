package component;

import java.awt.Dimension;

import javax.swing.JPanel;

import component.utils.ArrayUtil;

public class ArrayGraphic extends JPanel{
	private ArrayUtil mainArray;
	
	@Override
	public Dimension getPreferredSize()
	{
	    return new Dimension(100, 100);
	}
	
	public ArrayGraphic(ArrayUtil array) {
		super();
		this.mainArray = array;
	}
	public ArrayUtil getArray() {
		return this.mainArray;
	}

}
