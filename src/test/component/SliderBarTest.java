package test.component;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;

import component.SliderBarComponent;

public class SliderBarTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("SliderBar Test");
        JPanel panel = new JPanel();
        SliderBarComponent slider = new SliderBarComponent(0, 100, 50);
        slider.setThumbColor(Color.RED);
        slider.setTrackColor(Color.GREEN);
        panel.add(slider);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
