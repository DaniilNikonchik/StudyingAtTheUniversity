package УПLab6v6;

import java.awt.BasicStroke;
import java.awt.Graphics;
import java.awt.Graphics2D;

import javax.swing.*;
import javax.swing.border.BevelBorder;
import javax.swing.border.Border;
import java.awt.*;
import java.awt.datatransfer.DataFlavor;
import java.awt.datatransfer.Transferable;
import java.awt.dnd.*;
import java.awt.event.*;
import java.util.ArrayList;
@SuppressWarnings("serial")
public class NewJFrame extends JComponent implements
	DragGestureListener, 
    DragSourceListener,
    DropTargetListener, 
    MouseListener,      
    MouseMotionListener
    {
		private static final int width = 440;
		private static final int height = 330;

        private static final long serialVersionUID = 1L;
        private final ArrayList<MyFigure> witches = new ArrayList<>();
        private MyFigure beingDragged;
        private boolean dragMode;
        
        private static final int LINE_WIDTH = 2;
        private static final BasicStroke LINE_STYLE = new BasicStroke(LINE_WIDTH);
        private static final Border NORMAL_BORDER = new BevelBorder(BevelBorder.LOWERED);
        private static final Border DROP_BORDER = new BevelBorder(BevelBorder.RAISED);

        private NewJFrame() {
            setBorder(NORMAL_BORDER);
            addMouseListener(this);
            addMouseMotionListener(this);

            DragSource dragSource = DragSource.getDefaultDragSource();
            dragSource.createDefaultDragGestureRecognizer(this, DnDConstants.ACTION_COPY_OR_MOVE, this);
            DropTarget dropTarget = new DropTarget(this, this); 
            this.setDropTarget(dropTarget); 
        }

        public void paintComponent(Graphics g) {
            super.paintComponent(g);
            Graphics2D g2 = (Graphics2D) g;
            g2.setStroke(new MyStroke(2, 10)); //Zdes zadaem znachenia

            for (MyFigure witch : witches) {
                g2.draw(witch); // Draw the scribble
            }
            g2.setStroke(LINE_STYLE);
        }

        private void setDragMode(boolean dragMode) {
            this.dragMode = dragMode;
        }

        public void mousePressed(MouseEvent e) {
            if (dragMode)
                return;
            int param = 130;
            MyFigure currentScribble = new MyFigure(param, e.getX(), e.getY());
            witches.add(currentScribble);
            repaint();
        }

        public void mouseReleased(MouseEvent e) {}
        public void mouseClicked(MouseEvent e) {}
        public void mouseEntered(MouseEvent e) {}
        public void mouseExited(MouseEvent e) {}
        public void mouseDragged(MouseEvent e) {}
        public void mouseMoved(MouseEvent e) {}


        public void dragGestureRecognized(DragGestureEvent e) {
            if (!dragMode) {
                return;
            }

            MouseEvent inputEvent = (MouseEvent) e.getTriggerEvent();
            int x = inputEvent.getX();
            int y = inputEvent.getY();

            Rectangle rectangle = new Rectangle(x - LINE_WIDTH, y - LINE_WIDTH, LINE_WIDTH * 2, LINE_WIDTH * 2);

            for (MyFigure witch : witches) { 
                if (witch.intersects(rectangle)) {
                    beingDragged = witch;

                    MyFigure dragScribble = (MyFigure) witch.clone();
                    dragScribble.translate(-x, -y);

                    Cursor cursor;
                    switch (e.getDragAction()) {
                        case DnDConstants.ACTION_COPY:
                            cursor = DragSource.DefaultCopyDrop;
                            break;
                        case DnDConstants.ACTION_MOVE:
                            cursor = DragSource.DefaultMoveDrop;
                            break;
                        default:
                            return;
                    }
                    e.startDrag(cursor, dragScribble, this);
                    return;
                }
            }
        }

        public void dragDropEnd(DragSourceDropEvent e) {
            if (!e.getDropSuccess())
                return;
            int action = e.getDropAction();
            if (action == DnDConstants.ACTION_MOVE) {
                witches.remove(beingDragged);
                beingDragged = null;
                repaint();
            }
        }

        public void dragEnter(DragSourceDragEvent e) {}
        public void dragExit(DragSourceEvent e) {}
        public void dropActionChanged(DragSourceDragEvent e) {}
        public void dragOver(DragSourceDragEvent e) {}

        public void dragEnter(DropTargetDragEvent e) {
            if (e.isDataFlavorSupported(MyFigure.decDataFlavor) || e.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                e.acceptDrag(DnDConstants.ACTION_COPY_OR_MOVE);
                this.setBorder(DROP_BORDER);
            }
        }

        public void dragExit(DropTargetEvent e) {
            this.setBorder(NORMAL_BORDER);
        }

        public void drop(DropTargetDropEvent e) {
            this.setBorder(NORMAL_BORDER);
            if (e.isDataFlavorSupported(MyFigure.decDataFlavor) || e.isDataFlavorSupported(DataFlavor.stringFlavor)) {
                e.acceptDrop(DnDConstants.ACTION_COPY_OR_MOVE);
            } else {
                e.rejectDrop();
                return;
            }

            Transferable t = e.getTransferable(); 
            MyFigure droppedScribble;
            try {
                droppedScribble = (MyFigure) t.getTransferData(MyFigure.decDataFlavor);
            } catch (Exception ex) { 
                try {
                    String s = (String) t.getTransferData(DataFlavor.stringFlavor);
                    droppedScribble = MyFigure.getFromString(s);
                } catch (Exception ex2) {
                    e.dropComplete(false);
                    return;
                }
            }

            Point p = e.getLocation(); 
            droppedScribble.translate((int) p.getX(), (int) p.getY());
            witches.add(droppedScribble); 
            repaint(); 
            e.dropComplete(true);
        }

        public void dragOver(DropTargetDragEvent e) {}
        public void dropActionChanged(DropTargetDragEvent e) {}


        public static void main(String[] args) {
            try {
                UIManager.setLookAndFeel(UIManager.getSystemLookAndFeelClassName());
            } catch (ClassNotFoundException | UnsupportedLookAndFeelException | IllegalAccessException | InstantiationException e) {
                System.err.println(e.getMessage());
            }

            JFrame frame = new JFrame("ScribbleDragAndDrop");
            JFrame frame1 = new JFrame("ScribbleDragAndDrop");

            frame.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            frame1.addWindowListener(new WindowAdapter() {
                public void windowClosing(WindowEvent e) {
                    System.exit(0);
                }
            });
            final NewJFrame scribblePane = new NewJFrame();
            final NewJFrame scribblePane1 = new NewJFrame();

            frame.getContentPane().add(scribblePane, BorderLayout.CENTER);
            frame1.getContentPane().add(scribblePane1, BorderLayout.CENTER);

            JToolBar toolbar = new JToolBar();
            JToolBar toolbar1 = new JToolBar();

            ButtonGroup group = new ButtonGroup();
            ButtonGroup group1 = new ButtonGroup();

            JToggleButton draw = new JToggleButton("Draw");
            JToggleButton draw1 = new JToggleButton("Draw");

            JToggleButton drag = new JToggleButton("Drag");
            JToggleButton drag1 = new JToggleButton("Drag");


            draw.addActionListener(e -> scribblePane.setDragMode(false));
            draw1.addActionListener(e -> scribblePane1.setDragMode(false));

            drag.addActionListener(e -> scribblePane.setDragMode(true));
            drag1.addActionListener(e -> scribblePane1.setDragMode(true));

            group.add(draw);
            group1.add(draw1);

            group.add(drag);
            group1.add(drag1);

            toolbar.add(draw);
            toolbar1.add(draw1);

            toolbar.add(drag);
            toolbar1.add(drag1);

            frame.getContentPane().add(toolbar, BorderLayout.NORTH);
            frame1.getContentPane().add(toolbar1, BorderLayout.NORTH);

            draw.setSelected(true);
            draw1.setSelected(true);
            scribblePane.setDragMode(false);
            scribblePane1.setDragMode(false);

            frame.setSize(width, height);
            frame1.setSize(width, height);

            frame.setVisible(true);
            frame1.setVisible(true);

            frame.setResizable(false);
            frame1.setResizable(false);
        }
    }

/*
@SuppressWarnings("serial")
public class NewJFrame extends javax.swing.JFrame {
	private static final int width = 440;
	private static final int height = 330;
	protected static final double ox = width/2;
	protected static final double oy = height/2;
	
	private int centerX;
    private int centerY;
    private final int paramA = 130;

    private Shape plot;
	
    public NewJFrame() {
    	super("Kappa Curve");
    	   
    	this.setSize(width, height);
        initComponents();
        
        setResizable(false);
    }
    
    protected void update() {
        paint(getGraphics());
    }

    private void initComponents() {
    	centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        plot = new MyFigure(paramA, centerX, centerY);
    	
        jPanel1 = new javax.swing.JPanel()
        {
			private static final long serialVersionUID = 1L;

			@Override
            public void paintComponent(Graphics g) {
				g.setColor(java.awt.Color.WHITE);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                Graphics2D g2d = (Graphics2D) g;
                               
                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);
                                
                //������ �����
                g2d.setPaint(Color.LIGHT_GRAY);
                g2d.setStroke(new BasicStroke((float) 0.2));
                for(centerY=0; centerY<=this.getWidth(); centerY+=10){
                    g2d.draw(new Line2D.Double(0, centerY,this.getWidth(), centerY));
                    g2d.draw(new Line2D.Double(centerY, 0, centerY,this.getHeight()));
                }
                //������ ���
                g2d.setPaint(Color.GRAY);
                g2d.setStroke(new BasicStroke((float) 1));
                g2d.draw(new Line2D.Double(ox, 0, ox, this.getHeight()));
                g2d.draw(new Line2D.Double(0, oy, this.getWidth(), oy));
                
                g2d.setStroke(new BasicStroke(5));    
                g2d.setColor(new Color(171, 3, 96));
                g2d.setStroke(new MyStroke(2,10));//zdes zadaem znachenia
                g2d.draw(plot);                 
            }
        };

        setDefaultCloseOperation(javax.swing.WindowConstants.EXIT_ON_CLOSE);

        jPanel1.setBackground(new java.awt.Color(255, 255, 255));

        javax.swing.GroupLayout jPanel1Layout = new javax.swing.GroupLayout(jPanel1);
        jPanel1.setLayout(jPanel1Layout);
        jPanel1Layout.setHorizontalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0, 0, Short.MAX_VALUE)
        );
        jPanel1Layout.setVerticalGroup(
            jPanel1Layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addGap(0,0, Short.MAX_VALUE)
        );
        
        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup( layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
            .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }

    public static void main(String args[]) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (InstantiationException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (IllegalAccessException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        } catch (javax.swing.UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }
        
        java.awt.EventQueue.invokeLater(new Runnable() {
            public void run() {
                new NewJFrame().setVisible(true);
            }
        });
    }    
    private javax.swing.JPanel jPanel1;     
}
*/