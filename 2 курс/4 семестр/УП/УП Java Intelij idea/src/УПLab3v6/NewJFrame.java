package УПLab3v6;

import javax.swing.*;
import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;

@SuppressWarnings("serial")
public class NewJFrame extends JFrame {
    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(NewJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new NewJFrame().setVisible(true));
    }

    private static final int width = 300;
    private static final int height = 254;
    protected static final double ox = width >> 1;
    protected static final double oy = height >> 1;

    private int centerY;

    private Shape plot;

    public NewJFrame() {
        super("Kappa");

        this.setSize(width, height);
        initComponents();

        setResizable(false);
    }

    private void initComponents() {
        int centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        int paramA = 100;
        plot = new MyFigure(paramA, centerX, centerY);

        // рисую сетку
        // рисую оси
        // рисую строку
        JPanel jPanel1 = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                // рисую сетку
                g2d.setPaint(Color.LIGHT_GRAY);
                g2d.setStroke(new BasicStroke((float) 0.2));
                for (centerY = 0; centerY <= this.getWidth(); centerY += 10) {
                    g2d.draw(new Line2D.Double(0, centerY, this.getWidth(), centerY));
                    g2d.draw(new Line2D.Double(centerY, 0, centerY, this.getHeight()));
                }
                // рисую оси
                g2d.setPaint(Color.GRAY);
                g2d.setStroke(new BasicStroke((float) 1));
                g2d.draw(new Line2D.Double(ox, 0, ox, this.getHeight()));
                g2d.draw(new Line2D.Double(0, oy, this.getWidth(), oy));

                // рисую строку
                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(new Color(171, 3, 96));
                g2d.setStroke(new MyStroke(4, 4));
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
                        .addGap(0, 0, Short.MAX_VALUE)
        );

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
    }
}
