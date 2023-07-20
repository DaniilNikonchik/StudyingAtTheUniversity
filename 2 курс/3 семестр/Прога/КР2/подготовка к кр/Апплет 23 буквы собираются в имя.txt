import java.applet.Applet;
import java.awt.*;

class Point_1
{
	int x;
	int y;
	public void setx(int xo)
	{
		x=xo;
	}
	public void sety(int yo)
	{
		y=yo;
	}
	public Point_1() {}
	public Point_1(int xi,int yi)
	{
		x=xi;
		y=yi;
	}
}

public class task_23 extends Applet {

	private static final long serialVersionUID = 1L;
	
	static final int CX = 400, CY = 400;
    static String str = "Alexa";
    static int pose1 = 10;
    static int pose2 = 10;
    static int pose3 = 10;
    static int pose4 = 10;
    static int next =0;
    static String our="";
    static int point=0;
    static char cur1=str.charAt(point);
    static char cur2=str.charAt(++point);
    static char cur3=str.charAt(++point);
    static char cur4=str.charAt(++point);    
    public Color getHtmlColor( String strRGB, Color def )
    {
        // in form #RRGGBB
        if ( strRGB != null && strRGB.charAt(0)== '#' )
        {
            try
            {
                return new Color(
                    Integer.parseInt( strRGB.substring( 1 ), 16 ) );
            }
            catch ( NumberFormatException e ) 
            {
                return def;
            }
        }
        return def;
    }

    public void init()
    {
        setSize( CX, CY );
        setLayout( null );
        Color col = getHtmlColor(getParameter( "AppBkColor" ), new Color( 90, 90, 160 ));
        setBackground( col );
        Color colx = getHtmlColor(getParameter( "DrawBkColor" ), new Color( 64, 64, 64 ));
        col = getHtmlColor(	getParameter( "DrawColor" ), Color.WHITE );
        
    }
    public void paint(Graphics g) 
    {
    	g.drawString(cur1+" ",pose1,pose1);
    	g.drawString(cur2+" ",400-pose2,pose2);
    	g.drawString(cur3+" ",400-pose3,400-pose3);
    	g.drawString(cur4+" ",pose4,400-pose4);
    	g.drawString(our,100,200);
    	
    }

    public void start() {
    	startThread();
    }

    public void stop() {
    	stopThread();
    }

    public void destroy() {
    	stopThread();
    }

    private AppletThread t = null;
    private void createThread() {
        if ( t == null ) {
            t = new AppletThread( this );
        }
    }

    private void startThread() {
    	createThread();
        t.start();
    }

    private void stopThread() {
        if ( t != null ) {
            t.interrupt();
            t = null;
        }
    }
}

class AppletThread extends Thread {
    task_23 pa = null;
  	boolean stFlag  = false;
    public AppletThread( task_23 pa ) {
    	super();
    	this.pa = pa;
    }

    public void run()
    {
    	while ( true ) {
            try
            {
            	
                Thread.sleep( 100 );
                if(!stFlag)
                doMove();
            } catch ( InterruptedException e ) {
                break;
            }
        }
    }

    public synchronized void doMove()
    {    	
    	if(pa.next==0)
    	{
    		pa.pose1+=10;
    		pa.repaint();
    		if(pa.pose1==200)
    		{
    			pa.pose1=10;
    			pa.next+=1;
    			pa.our+=pa.cur1;
    			pa.point++;
    			if(pa.point>=pa.str.length())
    			{	
    				pa.cur1=' ';
    			}
    			else
    			{
    				pa.cur1=pa.str.charAt(pa.point);
    			}
    			if ( pa.cur1 == ' ' && pa.cur2 == ' ' &&pa.cur3 == ' ' && pa.cur4 == ' ')
    			{
    				stFlag = true;
    			}
    			
    		}    		
    	}
    	else if(pa.next==1)
    	{
    		pa.pose2+=10;
    		pa.repaint();
    		if(pa.pose2==200)
    		{
    			pa.pose2=10;
    			pa.next+=1;
    			pa.our+=pa.cur2;
    			pa.point++;
    			if(pa.point>=pa.str.length())
    			{
    				pa.cur2=' ';
    			}
    			else
    			{
    				pa.cur2=pa.str.charAt(pa.point);
    			}
    			if ( pa.cur1 == ' ' && pa.cur2 == ' ' &&pa.cur3 == ' ' && pa.cur4 == ' ')
    			{
    				stFlag = true;
    			}
    		}
    	}
    	else if(pa.next==2)
    	{
    		pa.pose3+=10;
    		pa.repaint();
    		if(pa.pose3==200)
    		{
    			pa.pose3=10;
    			pa.next+=1;
    			pa.our+=pa.cur3;
    			pa.point++;
    			if(pa.point>=pa.str.length())
    			{
    				pa.cur3=' ';
    			}
    			else
    			{
    				pa.cur3=pa.str.charAt(pa.point);
   				}
    			if ( pa.cur1 == ' ' && pa.cur2 == ' ' &&pa.cur3 == ' ' && pa.cur4 == ' ')
    			{
    				stFlag = true;
    			}
    		}
    	}
    	else
    	{
    		pa.pose4+=10;
    		pa.repaint();
    		if(pa.pose4==200)
    		{
    			pa.pose4=10;
    			pa.next=0;
    			pa.our+=pa.cur4;
    			pa.point++;
    			if(pa.point>=pa.str.length())
    			{
    				pa.cur4=' ';
    			}
    			else
    			{
    				pa.cur4=pa.str.charAt(pa.point);
    			}
    			if ( pa.cur1 == ' ' && pa.cur2 == ' ' &&pa.cur3 == ' ' && pa.cur4 == ' ')
    			{
    				stFlag = true;
    			}
    		}
    	}   	
    	
    }
}