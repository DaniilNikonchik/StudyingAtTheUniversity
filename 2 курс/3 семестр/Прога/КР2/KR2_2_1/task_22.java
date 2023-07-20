
import java.applet.Applet;
import java.awt.Canvas;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;

//Задача с параболой - одна из лабораторных по апплетам
// В окне апплета нарисовать параболу y=x^2-1 на промежутке [-1;2] с шагом 0.05

class Coordinates {
	int xP, yP;
	double x, y;
	double grToPix;
	
	public Coordinates (double x, double y) {
		int xP0 = Graphic.centerX;
		int yP0 = Graphic.centerY;
		grToPix = task_22.CY / 6;
		this.x = x;
		this.y = y;
		xP = xP0 + (int)(x * grToPix);
		yP = yP0 - (int)(y * grToPix);
	}
	
}

class Graphic extends Canvas {
	private static final long serialVersionUID = 1L;
	
	Dimension dim = new Dimension(task_22.CX, task_22.CY);
	static final int centerX = task_22.CX / 2, centerY = 2 * task_22.CY / 3;
	double dx = 0.05;//шаг
	
	double func (double x) { return x*x - 1; }//функция
	
	public Graphic () {
		super();
		setMaximumSize(dim);
		setBackground(Color.white);
		setBounds(0, 0, dim.width, dim.height);
	}
	public void paint (Graphics g) {
		drawGraph(g);
		drawCoord(g);
	}
	public void drawGraph (Graphics g) {
		g.setColor(Color.RED);
		for (double x = -1; x < 2; x += dx) {//промежуток
			Coordinates c1 = new Coordinates(x, func(x));
			Coordinates c2 = new Coordinates(x+dx, func(x+dx));
			g.drawLine(c1.xP, c1.yP, c2.xP, c2.yP);
		}
	}
	public void drawCoord (Graphics g) {
		g.setColor(Color.black);
		g.drawLine(0, centerY, task_22.CX, centerY);
		g.drawLine(centerX, 0, centerX, task_22.CY);
		
	}
	public Dimension getPreferredSize () { return dim; }
	public Dimension getMinimumSize () { return dim; }
}

public class task_22 extends Applet{
	private static final long serialVersionUID = 1L;
	static final int CX = 600, CY = 600;
	Canvas canv;
	
	public void init () {
		setSize(CX, CY);
		setLayout(null);
		setBackground(Color.WHITE);
		canv = new Graphic();
		add(canv);
	}
}


