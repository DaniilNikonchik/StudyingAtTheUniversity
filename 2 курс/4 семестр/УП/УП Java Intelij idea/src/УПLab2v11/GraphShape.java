package УПLab2v11;

import java.awt.*;

public interface GraphShape extends Shape {
    String getName();
    int getWidth();
    int getHeight();
    void draw(Graphics2D g, Component c);
}

