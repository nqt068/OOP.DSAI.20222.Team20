package test.component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import component.SliderBarComponent;

public class SliderBarTest {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("SliderBar Test");
        JPanel panel = new JPanel();
        
        SliderBarComponent slider = new SliderBarComponent(0, 100, 30);
        
        panel.add(slider);
        
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
