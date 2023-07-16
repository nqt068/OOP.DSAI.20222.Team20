package test.component;

import java.awt.Dimension;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

import component.SliderBarComponent;

public class SliderBarTest {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("SliderBar Test");
        JPanel panel = new JPanel(new FlowLayout());
        
        SliderBarComponent slider = new SliderBarComponent(0, 100, 30, 300);
        slider.addChangeListener(new ChangeListener() {
			@Override
			public void stateChanged(ChangeEvent e) {
				System.out.println(slider.getValue());
			}
        });
//        slider.setPreferredSize(new Dimension(200,10));
        
        panel.add(slider);
        
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}
