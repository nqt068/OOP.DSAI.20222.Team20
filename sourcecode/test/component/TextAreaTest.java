package test.component;

import java.awt.Color;
import java.awt.Dimension;

import javax.swing.JFrame;
import component.TextAreaComponent;

public class TextAreaTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Text Area Component Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(400, 400);
        
        String info = "This is a sample text that should be displayed in the text area.";
        Dimension dimension = new Dimension(300, 200);
        Color color = new Color(51, 153, 255);
        TextAreaComponent textArea = new TextAreaComponent(dimension, color, info);
        
        frame.add(textArea);
        
        frame.setVisible(true);
    }
    
}