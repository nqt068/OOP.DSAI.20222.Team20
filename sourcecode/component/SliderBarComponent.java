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
    }
    public SliderBarComponent(int min, int max, int value, int width) {
    	super(min, max, value);
    	setPreferredSize(new Dimension(width, 20));
    }
}