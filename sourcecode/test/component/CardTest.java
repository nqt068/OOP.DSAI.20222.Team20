package test.component;

import java.awt.Image;
import javax.swing.ImageIcon;
import javax.swing.JFrame;

import component.CardComponent;

public class CardTest {
    public static void main(String[] args) {
        // Create a sample image
        Image image = new ImageIcon(System.getProperty("user.dir") + "\\Image_Resources\\" + "sampleImage.png").getImage();

        // Create a CardPanel object
        CardComponent cardPanel = new CardComponent("Sample Heading", image);
        // Create a JFrame and add the CardPanel to it
        JFrame frame = new JFrame("CardPanel Test");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.getContentPane().add(cardPanel);
        frame.pack();
        frame.setVisible(true);
    }
}
