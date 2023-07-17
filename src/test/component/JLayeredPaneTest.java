package test.component;

import javax.swing.*;
import java.awt.*;

public class JLayeredPaneTest extends JFrame {
    public JLayeredPaneTest() {
        setTitle("JLayeredPane Test");
        setSize(400, 400);

        JLayeredPane layeredPane = getLayeredPane();

        JLabel label1 = new JLabel("Label 1", JLabel.CENTER);
        label1.setOpaque(true);
        label1.setBackground(Color.YELLOW);
        label1.setBounds(0, 50, 300, 100);
        layeredPane.add(label1, new Integer(1));

        JLabel label2 = new JLabel("Label 2", JLabel.CENTER);
        label2.setOpaque(true);
        label2.setBackground(Color.GREEN);
        label2.setBounds(75, 75, 100, 100);
        layeredPane.add(label2, new Integer(2));

        JLabel label3 = new JLabel("Label 3", JLabel.CENTER);
        label3.setOpaque(true);
        label3.setBackground(Color.BLUE);
        label3.setBounds(100, 100, 100, 100);
        layeredPane.add(label3, new Integer(3));

        setVisible(true);
    }

    public static void main(String[] args) {
        JLayeredPaneTest test = new JLayeredPaneTest();
        test.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    }
}