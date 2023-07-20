package УПLab6v6;

import java.awt.BasicStroke;
import java.awt.Shape;
import java.awt.Stroke;
import java.awt.geom.FlatteningPathIterator;
import java.awt.geom.GeneralPath;
import java.awt.geom.PathIterator;

public class MyStroke implements Stroke {
	private final float amplitude;
    private final float wavelength;
	private final BasicStroke stroke = new BasicStroke(1);

	public MyStroke(float amplitude, float wavelength) {
		this.amplitude = amplitude;
        this.wavelength = wavelength;
	}

	public Shape createStrokedShape(Shape shape) {
		GeneralPath shape1 = new GeneralPath(); 
		PathIterator it = new FlatteningPathIterator(shape.getPathIterator(null), 1);

		float[] points = new float[2];
        float moveX = 0, moveY = 0;
        float lastX = 0, lastY = 0;
        float thisX, thisY;
        int type;
        float next = 0;
        int phase = 0;
        
        while (!it.isDone()) {
            type = it.currentSegment(points);
            switch (type) {
                case PathIterator.SEG_MOVETO:
                    moveX = lastX = points[0];
                    moveY = lastY = points[1];
                    shape1.moveTo(moveX, moveY);
                    next = wavelength / 2;
                    break;

                case PathIterator.SEG_CLOSE:
                    points[0] = moveX;
                    points[1] = moveY;
                case PathIterator.SEG_LINETO:
                    thisX = points[0];
                    thisY = points[1];
                    float dx = thisX - lastX;
                    float dy = thisY - lastY;
                    float distance = (float) Math.sqrt(dx * dx + dy * dy);
                    if (distance >= next) {
                        float r = 1.0f / distance;
                        while (distance >= next) {
                            float x = lastX + next * dx * r;
                            float y = lastY + next * dy * r;
                            if ((phase % 2) == 1)
                            {
                            	//shape1.lineTo(x + amplitude * dy * r, y - amplitude * dx * r); 
                            	shape1.quadTo(x + amplitude * dy ,y - amplitude * dx , x, y);
                            }
                            else
                            	shape1.lineTo(x,y); 
                            next += wavelength;
                            phase++;
                        }
                    }
                    next -= distance;
                    lastX = thisX;
                    lastY = thisY;
                    if (type == PathIterator.SEG_CLOSE) {
                        shape1.closePath();
                    }
                    break;
            }
            it.next();
        }
		return stroke.createStrokedShape(shape1);
	}
}