package test.component;

import java.awt.Color;
import javax.swing.JFrame;
import javax.swing.JPanel;
import component.Button;

public class ButtonTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("Button Test");
        JPanel panel = new JPanel();
        Button button = new Button("Click me!");
        button.setButtonColor(Color.GREEN);
        button.setHoverColor(Color.YELLOW);
        button.setTextColor(Color.BLACK);
        panel.add(button);
        frame.add(panel);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.pack();
        frame.setVisible(true);
    }
}
