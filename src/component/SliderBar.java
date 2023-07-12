package component;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.geom.Rectangle2D;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.SwingConstants;
import javax.swing.plaf.basic.BasicSliderUI;

public class SliderBar extends JSlider {

    private static final long serialVersionUID = 1L;
    private Color thumbColor;
    private Color trackColor;
    private boolean showMinMaxValues;

    public SliderBar(int min, int max, int value) {
        super(min, max, value);
        this.thumbColor = new Color(0, 128, 255);
        this.trackColor = Color.LIGHT_GRAY;
        this.showMinMaxValues = true;
        this.setUI(new BasicSliderUI(this) {
            @Override
            public void paintThumb(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(thumbColor);
                Rectangle2D thumbRectangle = new Rectangle2D.Double(thumbRect.x + 1, thumbRect.y + 1,
                        thumbRect.width - 2, thumbRect.height - 2);
                g2.fill(thumbRectangle);
            }

            @Override
            public void paintTrack(Graphics g) {
                Graphics2D g2 = (Graphics2D) g;
                g2.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                g2.setColor(trackColor);
                g2.fillRoundRect(trackRect.x, trackRect.y + trackRect.height / 2 - 3, trackRect.width, 6, 6, 6);
            }
        });
        this.setPreferredSize(new Dimension(300, 20));
        this.setOrientation(SwingConstants.HORIZONTAL);
    }

    public void setThumbColor(Color color) {
        this.thumbColor = color;
    }
    public void setTrackColor(Color color) {
        this.trackColor = color;
    }
    public void setShowMinMaxValues(boolean show) {
        this.showMinMaxValues = show;
    }
    public double getRelativeValue() {
        int min = getMinimum();
        int max = getMaximum();
        int value = getValue();
        double range = max - min;
        double relativeValue = (value - min) / range;
        return relativeValue;
    }
}