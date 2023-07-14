package component;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.ArrayList;

public class ToggleMenuComponent extends JPanel implements ActionListener {
    private String label;
    private JToggleButton button;
    private JPopupMenu popupMenu;
    private ArrayList<String> items = new ArrayList<>();

    public ToggleMenuComponent(String label) {
        this.label = label;
        this.setLayout(new BoxLayout(this, BoxLayout.X_AXIS));
        this.setBorder(BorderFactory.createEmptyBorder(5, 5, 5, 5));
        this.add(Box.createHorizontalGlue());

        button = new JToggleButton(label);
        button.setFocusable(false);
        button.addActionListener(this);

        popupMenu = new JPopupMenu();

        this.add(button);
        this.add(Box.createRigidArea(new Dimension(5, 0)));
    }

    public void addItem(String item) {
        JMenuItem menuItem = new JMenuItem(item);
        menuItem.addActionListener(e -> {
            button.setText(item);
            setSelected(false);
        });
        popupMenu.add(menuItem);
        items.add(item);
    }

    public void removeItem(String item) {
        for (int i = 0; i < popupMenu.getComponentCount(); i++) {
            Component component = popupMenu.getComponent(i);
            if (component instanceof JMenuItem) {
                JMenuItem menuItem = (JMenuItem) component;
                if (menuItem.getText().equals(item)) {
                    popupMenu.remove(menuItem);
                    break;
                }
            }
        }
        items.remove(item);
    }

    public void clearItems() {
        popupMenu.removeAll();
        items.clear();
    }

    public boolean isSelected() {
        return button.isSelected();
    }

    public void setSelected(boolean selected) {
        button.setSelected(selected);
        if (selected) {
            popupMenu.show(button, 0, button.getHeight());
        } else {
            popupMenu.setVisible(false);
        }
    }

    public String getText() {
        return button.getText();
    }

    public void actionPerformed(ActionEvent e) {
        setSelected(button.isSelected());
    }
}