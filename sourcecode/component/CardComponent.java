package component;

import javax.swing.*;

import view.*;

import java.awt.*;
import java.awt.event.*;

public class CardComponent extends JPanel implements MouseListener {
    private JLabel headingLabel;
    private JLabel imageLabel;
    //private JTextArea descriptionTextArea;

    public CardComponent(String heading, Image image) {
        setLayout(new BorderLayout());

        // Create the heading label and add it to the panel
        headingLabel = new JLabel(heading);
        headingLabel.setFont(new Font("Arial", Font.BOLD, 18));
//        add(headingLabel, BorderLayout.NORTH);
        headingLabel.setHorizontalAlignment(JLabel.CENTER);
        
        add(headingLabel, BorderLayout.NORTH);
        
        // Create the image label or blank box and add it to the panel
        JPanel imagePanel = new JPanel(new BorderLayout());
        if (image != null) {
            imageLabel = new JLabel(new ImageIcon(image.getScaledInstance(300, 200, Image.SCALE_SMOOTH)));
            imagePanel.add(imageLabel, BorderLayout.CENTER);
        } else {
            imagePanel.setPreferredSize(new Dimension(300, 200));
            imagePanel.setBackground(Color.WHITE);
        }
        add(imagePanel, BorderLayout.CENTER);

        setPreferredSize(new Dimension(300, 400)); 

        addMouseListener(this);
    }

    @Override
    public void mouseClicked(MouseEvent e) {
    	if (headingLabel.getText() == "Merge Sort") {
    		MergeSortScreen sortScreen = new MergeSortScreen();
    		SwingUtilities.getWindowAncestor(((JPanel)e.getSource())).dispose();	
    		revalidate();
    	}
    	else if (headingLabel.getText() == "Selection Sort") {
    		SelectionSortScreen sortScreen = new SelectionSortScreen();
    		SwingUtilities.getWindowAncestor(((JPanel)e.getSource())).dispose();	
    	}
    	else if (headingLabel.getText() == "Shell Sort") {
    		ShellSortScreen sortScreen = new ShellSortScreen();
    		SwingUtilities.getWindowAncestor(((JPanel)e.getSource())).dispose();	
    	}
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