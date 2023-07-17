package component;

import javax.swing.*;
import java.awt.*;

import java.awt.datatransfer.StringSelection;
import java.awt.datatransfer.Clipboard;

public class InfoWindowComponent extends JFrame {

    public InfoWindowComponent(String title, String infoString) {
        super(title);
        setSize(400, 300);
        setLocationRelativeTo(null);
        setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);

        JPanel mainPanel = new JPanel(new BorderLayout());
        mainPanel.setBorder(BorderFactory.createEmptyBorder(10, 10, 10, 10));
        setContentPane(mainPanel);

        JLabel infoLabel = new JLabel("Information:");
        infoLabel.setFont(new Font("Arial", Font.BOLD, 16));
        mainPanel.add(infoLabel, BorderLayout.NORTH);

        JTextArea infoTextArea = new JTextArea(infoString);
        infoTextArea.setLineWrap(true);
        infoTextArea.setWrapStyleWord(true);
        infoTextArea.setEditable(false);
        infoTextArea.setFont(new Font("Arial", Font.ITALIC, 14));
        JScrollPane scrollPane = new JScrollPane(infoTextArea);
        mainPanel.add(scrollPane, BorderLayout.CENTER);

        JPanel buttonPanel = new JPanel(new GridLayout(1, 2, 10, 10));
        mainPanel.add(buttonPanel, BorderLayout.SOUTH);

        /*JButton closeButton = new JButton("Close");
        closeButton.addActionListener(e -> dispose());
        buttonPanel.add(closeButton); */

        JButton copyButton = new JButton("Copy to Clipboard");
        copyButton.addActionListener(e -> {
            StringSelection stringSelection = new StringSelection(infoString);
            Clipboard clipboard = Toolkit.getDefaultToolkit().getSystemClipboard();
            clipboard.setContents(stringSelection, null);
            JOptionPane.showMessageDialog(this, "Copied to clipboard!", "Info", JOptionPane.INFORMATION_MESSAGE);
        });
        buttonPanel.add(copyButton);

        setVisible(true);
    }

}
