package component;

import java.awt.Point;
import java.awt.Dimension;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.*;

public class SliderBarComponent extends JSlider {
    
    public SliderBarComponent(int min, int max, int value) {
        super(min, max, value);
        setMajorTickSpacing((max - min) / 10);
        setPaintTicks(true);
        setPaintLabels(true);
	    addMouseListener(new MouseAdapter() {
	          @Override
	          public void mousePressed(MouseEvent e) {
	             Point p = e.getPoint();
	             double percent = p.x / ((double) getWidth());
	             int range = getMaximum() - getMinimum();
	             double newVal = range * percent;
	             int result = (int)(getMinimum() + newVal);
	             setValue(result);
	          }
	       });
    }
    public SliderBarComponent(int min, int max, int value, int width) {
    	super(min, max, value);
    	setPreferredSize(new Dimension(width, 20));
	    addMouseListener(new MouseAdapter() {
	          @Override
	          public void mousePressed(MouseEvent e) {
	             Point p = e.getPoint();
	             double percent = p.x / ((double) getWidth());
	             int range = getMaximum() - getMinimum();
	             double newVal = range * percent;
	             int result = (int)(getMinimum() + newVal);
	             setValue(result);
	          }
	       });
    }
}