package component;

import javax.swing.*;

public class SliderBarComponent extends JSlider {
    
    public SliderBarComponent(int min, int max, int value) {
        super(min, max, value);
        setMajorTickSpacing((max - min) / 10);
        setPaintTicks(true);
        setPaintLabels(true);
    }
    
    @Override
    public int getValue() {
        int value = super.getValue();
        if (value < getMinimum() + getMajorTickSpacing() / 2) {
            return getMinimum();
        } else if (value > getMaximum() - getMajorTickSpacing() / 2) {
            return getMaximum();
        } else {
            return Math.round((value - getMinimum()) / (float) getMajorTickSpacing()) * getMajorTickSpacing() + getMinimum();
        }
    }
}