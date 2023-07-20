import java.applet.Applet;
import java.awt.*;
import java.util.*;

/* Cоздать апплет со строкой, которая движется горизонтально,
 * отражаясь от границ апплета и меняя при этом свой цвет на цвет.
 * Строка вводится через параметры апплета.
 */

class Stroka extends Canvas {

	private static final long serialVersionUID = 1L;
	
	String str;
	Color color;
	int x1, x2, y;
	Dimension dim;
	
	public Stroka (String str, Color color) {
		super();
		this.str = str;
		this.color = color;
		x1 = 0;
		y = task_24.CY / 2;
		dim = new Dimension(8*(str.length()+1), 15);
		x2 = x1 + dim.width;
		setBackground(Color.white);
		setMaximumSize(dim);
		setBounds(0, 0, dim.width, dim.height);
	}
	public void paint (Graphics g) {
		g.setFont(new Font("Times New Roman", Font.BOLD, 16));
		g.setColor(color);
		g.drawString(str, 0, dim.height);
	}	
	public Dimension getMinimumSize () { return dim; }
	public Dimension getPreferredSize () { return dim; }
	
	boolean toRight = true;
	public void doMove (int appWidth, int appHeight) {
		int dx = 10;
		if ( toRight ) {
			x1 += dx;
			x2 += dx;
			if ( x2 > appWidth ) {
				x2 = appWidth;
				x1 = x2 - dim.width;
				changeColor();
				toRight = false;
			}
		}
		else {
			x1 -= dx;
			x2 -= dx;
			if ( x1 < 0 ) {
				x1 = 0;
				x2 = dim.width;
				changeColor();
				toRight = true;
			}
		}
		y = appHeight / 2;
	}
	void changeColor () {
		int r = new Random().nextInt(256);
		int g = new Random().nextInt(256);
		int b = new Random().nextInt(256);
		color = new Color(r, g, b);
	}
	
}

public class task_24 extends Applet implements Runnable {

	private static final long serialVersionUID = 1L;
	
	static final int CX = 600, CY = 500;
	Canvas canv;
	Thread t = null;
	
	public void init () {
		setSize(CX, CY);
		setLayout(null);
		setBackground(Color.white);
		String str = getParameter("str");
		canv = new Stroka(((str == null)?"NEST":str), Color.BLACK);
		canv.setLocation(0, this.getHeight() / 2);
		add(canv);
		if ( t == null )
			t = new Thread(this);
		t.start();
	}
	
	public void doMove () {
		int w = this.getWidth(), h = this.getHeight();
		((Stroka)canv).doMove(w, h);
		canv.setLocation(((Stroka)canv).x1, ((Stroka)canv).y);
		canv.repaint();
	}
	public void run () {
		mySuspend();
		while (true) {
			try {
				Thread.sleep(100);
			} catch (Exception e) {
				break;
			}
			if ( !isSuspended() )
				doMove();
		}
	}
	public void start () {
		myResume();
	}
	public void stop () {
		mySuspend();
	}
	public void destroy () {
		if ( t != null ) {
			t.interrupt();
			t = null;
		}
	}
	
	volatile boolean f_suspend = false;
	boolean isSuspended () { return f_suspend; }
	void mySuspend () { f_suspend = true; }
	void myResume () { f_suspend = false; }

}