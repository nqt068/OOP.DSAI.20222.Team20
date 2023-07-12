package test.component;

import javax.swing.*;
import java.awt.*;

import component.ToggleMenu;

public class ToggleMenuTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ToggleMenu Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        ToggleMenu toggleMenu = new ToggleMenu("Toggle me");
        toggleMenu.addItem("Bubble Sort");
        toggleMenu.addItem("Insertion Sort");
        toggleMenu.addItem("Selection Sort");

        JPanel panel = new JPanel();
        panel.add(toggleMenu);

        frame.add(panel);
        frame.setVisible(true);
    }
}