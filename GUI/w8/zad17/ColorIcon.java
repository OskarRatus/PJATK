package w8.zad17;

import javax.swing.*;
import java.awt.*;

public class ColorIcon implements Icon {
    Color color;

    public ColorIcon(Color color){
        this.color = color;
    }
    @Override
    public void paintIcon(Component c, Graphics g, int x, int y) {
        g.setColor(color);
        g.fillOval (x, y, getIconWidth(), getIconHeight());
    }

    @Override
    public int getIconWidth() {
        return 10;
    }

    @Override
    public int getIconHeight() {
        return 10;
    }
}
