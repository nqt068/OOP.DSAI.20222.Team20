package component;

import java.awt.Color;
import java.awt.event.FocusEvent;
import java.awt.event.FocusListener;

import javax.swing.JTextField;

public class TextFieldComponent extends JTextField implements FocusListener {
    
    private String placeholder;
    private boolean isPlaceholderActive;
    private Color placeholderColor = Color.GRAY;
    private Color defaultTextColor;

    public TextFieldComponent(int columns, String placeholder) {
        super(columns);
        this.placeholder = placeholder;
        addFocusListener(this);
        setPlaceholder();
    }
    
    private void setPlaceholder() {
        setText(placeholder);
        setForeground(placeholderColor);
        isPlaceholderActive = true;
    }
    
    private void removePlaceholder() {
        setText("");
        setForeground(defaultTextColor);
        isPlaceholderActive = false;
    }
    
    public boolean isPlaceholderActive() {
        return isPlaceholderActive;
    }

    @Override
    public void focusGained(FocusEvent e) {
        if (isPlaceholderActive()) {
            removePlaceholder();
        }
    }

    @Override
    public void focusLost(FocusEvent e) {
        if (getText().isEmpty()) {
            setPlaceholder();
        }
    }
    
}