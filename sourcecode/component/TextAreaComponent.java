package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTextArea;

public class TextAreaComponent extends JTextArea{
	public TextAreaComponent(Dimension dimension, Color color, String info) {
		super(info);
    setPreferredSize(dimension);
    setOpaque(true);
    setBackground(color);
    setForeground(Color.WHITE);
    setEditable(false);
    setLineWrap(true);
    setWrapStyleWord(true);
    setBorder(BorderFactory.createEmptyBorder(15, 15, 15, 15));
    setVisible(false);
    Font boldFont = getFont().deriveFont(Font.BOLD);
    setFont(boldFont);
	}
}
