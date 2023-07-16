package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;

import javax.swing.Icon;
import javax.swing.JButton;

public class ButtonComponent extends JButton implements MouseListener {

    private static final long serialVersionUID = 1L;
    private Color buttonColor;
    private Color hoverColor;
    private Color textColor;
    private String buttonText;

    public ButtonComponent(String text, Color textColor, Color buttonColor, Color buttonHoverColor) {
        super(text);
        this.buttonText = text;
        this.buttonColor = buttonColor;
        this.hoverColor = buttonHoverColor;
        this.textColor = textColor;
        this.setFont(new Font("Arial",Font.CENTER_BASELINE, 14));
        this.setPreferredSize(new Dimension(50, 40));
        this.addMouseListener(this);
    }
    public ButtonComponent(Icon icon) {
    	this.buttonColor = Color.BLACK;
        this.hoverColor = Color.black.brighter();
        this.textColor = Color.WHITE;
        this.setFont(new Font("Arial", Font.PLAIN, 16));
        this.setPreferredSize(new Dimension(100, 40));
        this.addMouseListener(this);
        setIcon(icon);
    }
	public void setButtonColor(Color color) {
        this.buttonColor = color;
    }

    public void setHoverColor(Color color) {
        this.hoverColor = color;
    }

    public void setTextColor(Color color) {
        this.textColor = color;
    }

    @Override
    protected void paintComponent(Graphics g) {
        Graphics2D g2 = (Graphics2D) g;
        g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        if (getModel().isPressed()) {
            g2.setColor(buttonColor.darker());
        } else if (getModel().isRollover()) {
            g2.setColor(hoverColor);
        } else {
            g2.setColor(buttonColor);
        }
        g2.fillRect(0, 0, getWidth(), getHeight());

        g2.setColor(textColor);
        g2.setFont(getFont());
        g2.drawString(buttonText, getWidth() / 2 - g2.getFontMetrics().stringWidth(buttonText) / 2,
                getHeight() / 2 + g2.getFontMetrics().getAscent() / 2 - 3);
    }

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {}

    @Override
    public void mouseReleased(MouseEvent e) {}
}
