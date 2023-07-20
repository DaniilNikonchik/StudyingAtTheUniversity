package bsu.fpmi.edupract;

import java.awt.*;

public class Ellipse extends Canvas {
    private int height;
    private int width;
    private Color leftColor;
    private Color rightColor;


    public Ellipse(int height, int diameter, Color leftColor, Color rightColor) {
        this.height = height;
        this.height = diameter;
        this.leftColor = leftColor;
        this.rightColor = rightColor;
    }

    public Ellipse() {
        width = 150;
        height = 50;
        leftColor = Color.getHSBColor(70, 130, 180);
        rightColor = Color.getHSBColor(70, 130, 100);
    }

    public void setDiameter(int diameter) {
        this.height = diameter;
        repaint();
    }

    public void setLeftColor(Color leftColor) {
        this.leftColor = leftColor;
        repaint();
    }

    public void setRightColor(Color rightColor) {
        this.rightColor = rightColor;
        repaint();
    }

    public int getWidth() {
        return width;
    }
	
    public void setWidth(int width) {
        this.width = width;
    }
    
    public int getHeight(){
        return height;
    }
	
    public void setHeight(int height){
        this.height = height;
    }

    public Dimension getPreferredSize() {
        return new Dimension(width, height);
    }

    public Dimension getMinimumSize() {
        return getPreferredSize();
    }

    public Dimension getMaximumSize() {
        return new Dimension(1500, 1500);
    }

    public void paint(Graphics g) {
        Graphics2D g2d = (Graphics2D) g;
        g2d.setPaint(new GradientPaint(0, 0, rightColor, width/2, 0, leftColor));
        g2d.fillOval(0, 0, width, height);
    }

    public Color getLeftColor() {
        return leftColor;
    }

    public Color getRightColor() {
        return rightColor;
    }
}
