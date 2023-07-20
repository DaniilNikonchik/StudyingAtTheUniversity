package УПLab2v11;

import java.awt.*;
import java.awt.font.GlyphVector;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;
import java.awt.image.*;

public class GoSign implements GraphShape {
    private static final int WIDTH = 1500;
    private static final int HEIGHT = 500;

    public String getName() {
        return "GoSign";
    }

    public int getWidth() {
        return WIDTH;
    }

    public int getHeight() {
        return HEIGHT;
    }

    public void draw(Graphics2D graphics, Component component) {

        BufferedImage image = new BufferedImage(WIDTH / 2, HEIGHT, BufferedImage.TYPE_INT_RGB);
        Graphics2D imageGraphics = image.createGraphics();

        imageGraphics.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

        Color upColor = new Color(200, 200, 200);
        Color downColor = new Color(100, 100, 100);

        imageGraphics.setPaint(new GradientPaint(0, 0, upColor, 0, 250, downColor));
        imageGraphics.fillRect(0, 0, WIDTH / 2, HEIGHT);


        imageGraphics.setColor(new Color(0, 0, 200));
        imageGraphics.setStroke(new BasicStroke(40));
        imageGraphics.drawRect(50, 50, WIDTH / 2 - 100, HEIGHT - 110);


        imageGraphics.setColor(Color.white);
        imageGraphics.fillRect(70, 70, WIDTH / 2 - 140, HEIGHT - 150);

        Font font = new Font("Serif", Font.BOLD, 10);
        Font signFont = font.deriveFont(AffineTransform.getScaleInstance(28.0, 28.0));
        GlyphVector glyphVector = signFont.createGlyphVector(imageGraphics.getFontRenderContext(), "GO");

        Shape letterG = glyphVector.getGlyphOutline(0);
        Shape letterO = glyphVector.getGlyphOutline(1);

        Paint shadowPaint = new Color(0, 0, 0, 100);
        AffineTransform shadowTransform = AffineTransform.getShearInstance(-0.75, 0.0);
        shadowTransform.scale(1, 0.5);

        imageGraphics.translate(150, 360);
        imageGraphics.setPaint(shadowPaint);
        imageGraphics.translate(0, 30);
        imageGraphics.fill(shadowTransform.createTransformedShape(letterG));
        imageGraphics.fill(shadowTransform.createTransformedShape(letterO));
        imageGraphics.translate(0, -30);
        imageGraphics.setPaint(new Color(0, 0, 200));
        imageGraphics.fill(letterG);
        imageGraphics.fill(letterO);

        graphics.drawImage(image, 0, 0, component);

        int yMessage = 15;
        int xMessage = 15;
        graphics.drawString("No filters", xMessage, yMessage);

        graphics.drawImage(new RescaleOp(1.5f, 0, null).filter(image, null), WIDTH / 2, 0, component);

        graphics.drawString("Brighten", WIDTH - 80, yMessage);
    }

    @Override
    public Rectangle getBounds() {
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        return null;
    }

    @Override
    public boolean contains(double x, double y) {
        return false;
    }

    @Override
    public boolean contains(Point2D p) {
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        return false;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        return null;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        return null;
    }
}


