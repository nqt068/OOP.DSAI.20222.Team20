package test.component;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import component.ButtonComponent;

public class ButtonTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Test");
        JPanel panel = new JPanel();
        ButtonComponent buttonComponent = new ButtonComponent("Click me!", Color.BLACK, Color.BLUE, Color.CYAN);

        panel.add(buttonComponent);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
