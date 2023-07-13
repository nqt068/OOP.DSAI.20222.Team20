package component;

import javax.swing.*;

import controller.HomeScreenController;

import java.awt.*;
import java.awt.event.*;

public class Card extends JPanel implements MouseListener {
    private JLabel headingLabel;
    private JLabel imageLabel;
    private JTextArea descriptionTextArea;
    private HomeScreenController homeScreenController;

    public Card(String heading, Image image, String description) {
        setLayout(new BorderLayout());

        // Create the heading label and add it to the panel
        headingLabel = new JLabel(heading);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
        add(headingLabel, BorderLayout.NORTH);

        // Create the image label or blank box and add it to the panel
        JPanel imagePanel = new JPanel(new BorderLayout());
        if (image != null) {
            imageLabel = new JLabel(new ImageIcon(image));
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } else {
            imagePanel.setPreferredSize(new Dimension(300, 200));
            imagePanel.setBackground(Color.WHITE);
        }
        add(imagePanel, BorderLayout.CENTER);

        // Create the description text area and add it to the panel
        descriptionTextArea = new JTextArea(description);
        descriptionTextArea.setLineWrap(true);
        descriptionTextArea.setWrapStyleWord(true);
        descriptionTextArea.setEditable(false);
        add(new JScrollPane(descriptionTextArea), BorderLayout.SOUTH);

        setPreferredSize(new Dimension(300, 400));

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	
    }

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}