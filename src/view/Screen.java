package view;

import java.awt.BorderLayout;
import javax.swing.JPanel;

public abstract class Screen extends JPanel {
    private int width;
    private int height;
    private JPanel north;
    private JPanel south;
    private JPanel west;
    private JPanel east;
    private JPanel center;

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;

        setLayout(new BorderLayout());

        north = createNorth();
        south = createSouth();
        west = createWest();
        east = createEast();
        center = createCenter();

        add(north, BorderLayout.NORTH);
        add(south, BorderLayout.SOUTH);
        add(west, BorderLayout.WEST);
        add(east, BorderLayout.EAST);
        add(center, BorderLayout.CENTER);
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public JPanel getNorth() {
        return north;
    }

    public JPanel getSouth() {
        return south;
    }

    public JPanel getWest() {
        return west;
    }

    public JPanel getEast() {
        return east;
    }

    public JPanel getCenter() {
        return center;
    }

    public abstract void onEntry();
    public abstract void onExit();
    public abstract JPanel createNorth();
    public abstract JPanel createSouth();
    public abstract JPanel createWest();
    public abstract JPanel createEast();
    public abstract JPanel createCenter();
}
