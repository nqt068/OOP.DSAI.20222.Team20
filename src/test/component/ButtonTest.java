package test.component;

import java.awt.Color;
import java.awt.FlowLayout;

import javax.swing.JFrame;

import component.ButtonComponent;

public class ButtonTest {
    
    public static void main(String[] args) {
        // Create a new JFrame
        JFrame frame = new JFrame("Button Component Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 200);
        frame.setLayout(new FlowLayout());
        
        // Create a new ButtonComponent instance
        ButtonComponent button1 = new ButtonComponent("Click Me 1!", Color.WHITE, Color.BLACK, Color.RED);
        ButtonComponent button2 = new ButtonComponent("Click Me 2!");
        
        // Add the button to the frame
        frame.add(button1);
        frame.add(button2);
        
        // Make the frame visible
        frame.setVisible(true);
    }
    
}
