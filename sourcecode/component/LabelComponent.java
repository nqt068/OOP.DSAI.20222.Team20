package component;

import javax.swing.*;
import java.awt.*;

public class LabelComponent extends JLabel {
    
    public LabelComponent(String text) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, 14));
        setForeground(Color.BLACK);
        setHorizontalAlignment(JLabel.LEFT);
        setVerticalAlignment(JLabel.CENTER);
        setPreferredSize(new Dimension(100, 30));
        setOpaque(false);
    }
    
    public LabelComponent(String text, int size) {
        super(text);
        setFont(new Font("Arial", Font.PLAIN, size));
        setForeground(Color.BLACK);
        setHorizontalAlignment(JLabel.LEFT);
        setVerticalAlignment(JLabel.CENTER);
        setPreferredSize(new Dimension(100, 30));
        setOpaque(false);
    }
    
    public void setFontStyle(Font font) {
        setFont(font);
    }
    
    public void setLabelColor(Color color) {
        setForeground(color);
    }
    
    public void setLabelText(String text) {
        setText(text);
    }
    
    public void setAlignment(int horizontalAlignment, int verticalAlignment) {
        setHorizontalAlignment(horizontalAlignment);
        setVerticalAlignment(verticalAlignment);
    }
    
    public void setLabelSize(int width, int height) {
        setPreferredSize(new Dimension(width, height));
    }
    
    public void setOpaqueBackground(Color color) {
        setOpaque(true);
        setBackground(color);
    }
}
