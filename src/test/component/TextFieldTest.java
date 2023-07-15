package test.component;

import javax.swing.JFrame;
import javax.swing.JPanel;

import component.TextFieldComponent;

public class TextFieldTest {
    
    public static void main(String[] args) {
        JFrame frame = new JFrame("TextField Test");
        JPanel panel = new JPanel();
        
        TextFieldComponent textField1 = new TextFieldComponent(10, "Enter your name");
        TextFieldComponent textField2 = new TextFieldComponent(20, "Enter your email");
        
        panel.add(textField1);
        panel.add(textField2);
        
        frame.add(panel);
        frame.pack();
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);
    }
    
}