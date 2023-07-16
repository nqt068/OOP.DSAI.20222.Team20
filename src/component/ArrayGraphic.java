package component;

import javax.swing.JPanel;

import component.utils.ArrayUtil;

public class ArrayGraphic extends JPanel{
	private ArrayUtil mainArray;
	public ArrayGraphic(ArrayUtil array) {
		super();
		this.mainArray = array;
	}
	public ArrayUtil getArray() {
		return this.mainArray;
	}
}
