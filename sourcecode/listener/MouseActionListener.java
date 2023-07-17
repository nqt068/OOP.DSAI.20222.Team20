package listener;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public abstract class MouseActionListener extends MouseAdapter {
    private int startX;
    private int startY;

    @Override
    public void mouseClicked(MouseEvent e) {}

    @Override
    public void mousePressed(MouseEvent e) {
        startX = e.getX();
        startY = e.getY();
    }

    @Override
    public void mouseReleased(MouseEvent e) {}

    @Override
    public void mouseEntered(MouseEvent e) {}

    @Override
    public void mouseExited(MouseEvent e) {}

    public void mouseDragged(MouseEvent e, int dx, int dy) {}

    @Override
    public void mouseDragged(MouseEvent e) {
        int currentX = e.getX();
        int currentY = e.getY();
        int dx = currentX - startX;
        int dy = currentY - startY;
        mouseDragged(e, dx, dy);
        startX = currentX;
        startY = currentY;
    }
}
