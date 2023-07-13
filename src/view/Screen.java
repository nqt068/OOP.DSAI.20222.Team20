package view;

import javax.swing.JPanel;

public abstract class Screen extends JPanel {
    private int width;
    private int height;
    

    public Screen(int width, int height) {
        this.width = width;
        this.height = height;
    }
    public Screen() {
    	this.width = 800;
    	this.height = 600;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public abstract void onEntry();
    public abstract void onExit();
}
