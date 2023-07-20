package УПLab2v11;

import javax.swing.*;
import java.awt.*;

public class Paints extends JComponent {
    private final GraphShape example;
    private final Dimension size;

    public Paints(GraphShape example) {
        this.example = example;
        size = new Dimension(example.getWidth(), example.getHeight());
        setMaximumSize(size);
    }

    public void paintComponent(Graphics g) {
        g.setColor(Color.white);
        g.fillRect(0, 0, size.width, size.height);
        g.setColor(Color.black);
        example.draw((Graphics2D) g, this);
    }

    public Dimension getPreferredSize() {
        return size;
    }
    public Dimension getMinimumSize() {
        return size;
    }
}

