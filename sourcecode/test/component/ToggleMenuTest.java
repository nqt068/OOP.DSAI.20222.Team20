package test.component;

import javax.swing.*;
import java.awt.*;

import component.ToggleMenuComponent;

public class ToggleMenuTest {
    public static void main(String[] args) {
        JFrame frame = new JFrame("ToggleMenu Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(300, 200);
        frame.setLocationRelativeTo(null);

        ToggleMenuComponent toggleMenuComponent = new ToggleMenuComponent("Toggle me");
        toggleMenuComponent.addItem("Bubble Sort");
        toggleMenuComponent.addItem("Insertion Sort");
        toggleMenuComponent.addItem("Selection Sort");

        JPanel panel = new JPanel();
        panel.add(toggleMenuComponent);

        frame.add(panel);
        frame.setVisible(true);
    }
}