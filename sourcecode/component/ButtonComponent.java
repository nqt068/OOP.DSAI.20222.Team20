package component;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.BorderFactory;
import javax.swing.Icon;
import javax.swing.JButton;
import javax.swing.border.Border;

public class ButtonComponent extends JButton implements MouseListener {
    
    private static final long serialVersionUID = 1L;
    
    private Color backgroundColor = new Color(51,153,255);
    private Color foregroundColor = Color.WHITE;
    private Color hoverColor = new Color(102,204,255);
    private Border border = BorderFactory.createEmptyBorder(5, 15, 5, 15);
    private Font font = new Font("Arial", Font.BOLD, 16);
    
    public ButtonComponent(String text,Color foregroundColor, Color backgroundColor, Color hoverColor) {
        super(text);
        this.foregroundColor = foregroundColor;
        this.backgroundColor = backgroundColor;
        this.hoverColor = hoverColor;
        setFont(font);
        setForeground(foregroundColor);
        setBackground(backgroundColor);
        setBorder(border);
        setFocusPainted(false);
        addMouseListener(this);
    }
    public ButtonComponent(String text) {
        super(text);
        setFont(font);
        setForeground(foregroundColor);
        setBackground(backgroundColor);
        setBorder(border);
        setFocusPainted(false);
        addMouseListener(this);
    }
    public ButtonComponent(Icon icon) {
    	super(icon);
        setFont(font);
        setForeground(foregroundColor);
        setBackground(backgroundColor);
        setBorder(border);
        setFocusPainted(false);
        addMouseListener(this);
    }
    
    @Override
    public void mouseClicked(MouseEvent e) {
    }

    @Override
    public void mouseEntered(MouseEvent e) {
        setBackground(this.hoverColor);
    }

    @Override
    public void mouseExited(MouseEvent e) {
        setBackground(this.backgroundColor);
    }

    @Override
    public void mousePressed(MouseEvent e) {
    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }
    
}
