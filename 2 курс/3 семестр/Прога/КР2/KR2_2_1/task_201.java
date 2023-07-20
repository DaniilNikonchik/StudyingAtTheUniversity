
/* ¬ окне апплета по горизонтали двигаетс€ окружность, отража€сь от границ апплета.
ƒа не просто отражаетс€, а происходит упругое столкновение. */


import java.applet.Applet;
import java.awt.*;

class Drawing extends Canvas {
	
	private static final long serialVersionUID = 1L;
	
	public int x;
	public int y;
	public int R;
	public int prs;
	public boolean way;
	public boolean refl;
	
	Color colEl;
    Dimension dim = new Dimension( 500, 500 );
	
    public Drawing( Color ElColor, Color BkColor, int x1, int y1, int Rad) {
        
    	super();
        colEl = ElColor;
        
        x = x1;
        y = y1;
        R = Rad;
        way = true;
        refl = false;
    	
        setBackground( BkColor );
        setMaximumSize( dim );
        setBounds( 0, 0, dim.width, dim.height );
    }
	
    public void paint(Graphics g) {
    	g.setColor(colEl);
    	g.fillOval(x, y, R - prs, R + prs);
    	g.drawOval(x, y, R - prs, R + prs);  
    	if (x + R == dim.width && way == true) refl = true;
    	if (x == 0 && way == false) refl = true;
    	if (prs > (R / 4) ) {
    		if (way == true) way = false;
    		else way = true;
    		refl = false;
    	}
    }
}

public class task_201 extends Applet implements Runnable {
	
	private static final long serialVersionUID = 1L;

	static final int CX = 500, CY = 500;
    
    Thread t = null;
    Drawing c;
	
    public void init() {   	

    	setSize( CX, CY );
        setLayout( null );
        Color colBk = new Color ( 255, 255, 255);
        
        setBackground( colBk );       
	    Color colEl = new Color( 0, 255, 0 );
  
        int x1 = 50;
        int y1 = 150;
        int R = 100;
       
        c = new Drawing( colEl, colBk, x1, y1, R);
        
        add(c);
       
        if ( t == null ) {
            t = new Thread( this );
        }
        t.start();
    }
    
    static volatile int ni = 0;
    
    public synchronized void doMove() {
    	if (c.way == true && c.refl == false) {
    		if (c.prs > 0) c.prs = c.prs - 5;
    		c.x = c.x + 5;
    	}
    	else if (c.way == true && c.refl == true) {
    		c.prs = c.prs + 5;
    		c.x = c.x + 5;
    	}
    	else if (c.way == false && c.refl == false) {
    		if (c.prs > 0) c.prs = c.prs - 5;
    		c.x = c.x - 5;
    	}
    	else if (c.way == false && c.refl == true) {
    		c.prs = c.prs + 5;
    		c.x = c.x - 5;
    	}
    	
    	c.colEl = new Color(c.prs * 5, 255 - (c.prs * 5), 0);
    	
    	c.repaint();
      	
    }
    
    public void start() { 
    	myResume();
    } 

    public void stop() {
    	mySuspend();
    } 
    
    public void destroy() {
        if ( t != null ) {
            t.interrupt();
            t = null;
        }
    }

    public void run() {
        mySuspend();
        while ( true ) {
            try {
                Thread.sleep( 100 );
            } catch ( Exception e ) {
                break;
            }
            if ( isSuspended()== false ) {
                doMove();
            }
        }
    }

    volatile boolean f_suspend = false;
    public synchronized boolean getFSuspend() {
    	return f_suspend;
    }
    public synchronized void setFSuspend( boolean value) { 
    	f_suspend = value;
    }
    
    void mySuspend() {
    	setFSuspend( true );
    }
    void myResume() {
    	setFSuspend( false );
    }
    boolean isSuspended() {
    	return getFSuspend();
    }   
}