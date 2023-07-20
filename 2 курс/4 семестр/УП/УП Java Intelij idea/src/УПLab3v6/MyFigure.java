package УПLab3v6;

import java.awt.Rectangle;
import java.awt.Shape;
import java.awt.geom.AffineTransform;
import java.awt.geom.PathIterator;
import java.awt.geom.Point2D;
import java.awt.geom.Rectangle2D;

public class MyFigure implements Shape {

    private final int param;
    private final double startAngle = 0.01;
    private final double endAngle = startAngle + 2 * Math.PI - 2 * 0.01;
    private final float centerX;
    private final float centerY;

    public MyFigure(int param, int centerX, int centerY) {
        this.param = param;
        this.centerX = centerX;
        this.centerY = centerY;
    }

    class MyFigureIterator implements PathIterator {
        AffineTransform at;
        double flatness;
        double angle = startAngle;
        double step = 10;
        boolean done = false;

        public MyFigureIterator(AffineTransform at) {
            this.at = at;
            this.flatness = 0;
        }

        @Override
        public void next() {
            if (done) {
                return;
            }
            if (flatness == 0) {
                step = 0.05;
            } else {
                step = flatness;
            }
            angle += step;
            if (angle >= endAngle) {
                done = true;
            }
        }

        @Override
        public int currentSegment(float[] coords) {
            coords[0] = (float) (param * Math.pow(Math.cos(angle), 2) / Math.sin(angle)) + centerX;
            coords[1] = -(float) (param * Math.cos(angle)) + centerY;
            if (angle >= endAngle) done = true;
            if (angle == startAngle) return SEG_MOVETO;
            else return SEG_LINETO;
        }

        @Override
        public int currentSegment(double[] coords) {
            coords[0] = (float) (param * Math.pow(Math.cos(angle), 2) / Math.sin(angle)) + centerX;
            coords[1] = -(float) (param * Math.cos(angle)) + centerY;
            if (angle >= endAngle) done = true;
            if (angle == startAngle) return SEG_MOVETO;
            else return SEG_LINETO;
        }

        @Override
        public int getWindingRule() {
            // TODO Auto-generated method stub
            return WIND_NON_ZERO;
        }

        @Override
        public boolean isDone() {
            return done;
        }

    }

    @Override
    public Rectangle getBounds() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public Rectangle2D getBounds2D() {
        // TODO Auto-generated method stub
        return null;
    }

    @Override
    public boolean contains(double x, double y) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Point2D p) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean intersects(double x, double y, double w, double h) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean intersects(Rectangle2D r) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(double x, double y, double w, double h) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public boolean contains(Rectangle2D r) {
        // TODO Auto-generated method stub
        return false;
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at) {
        // TODO Auto-generated method stub
        return new MyFigureIterator(at);
    }

    @Override
    public PathIterator getPathIterator(AffineTransform at, double flatness) {
        // TODO Auto-generated method stub
        return new MyFigureIterator(at);
    }
}
