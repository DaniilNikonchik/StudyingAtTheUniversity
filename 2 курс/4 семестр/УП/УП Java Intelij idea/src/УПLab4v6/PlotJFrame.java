package УПLab4v6;

import java.awt.BasicStroke;
import java.awt.Color;
import java.awt.Font;
import java.awt.FontMetrics;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Image;
import java.awt.RenderingHints;
import java.awt.Shape;
import java.awt.geom.Line2D;
import java.awt.image.BufferedImage;
import java.awt.print.PageFormat;
import java.awt.print.Printable;
import java.awt.print.PrinterException;
import java.awt.print.PrinterJob;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

import javax.print.attribute.HashPrintRequestAttributeSet;
import javax.print.attribute.PrintRequestAttributeSet;
import javax.print.attribute.standard.OrientationRequested;
import javax.print.attribute.standard.Sides;
import javax.swing.*;


@SuppressWarnings("serial")
public class PlotJFrame extends javax.swing.JFrame implements Printable {

    private static final int width = 440;
    private static final int height = 370;
    protected static final double ox = 220;
    protected static final double oy = 185;

    private int centerY;

    private Shape plot;

    public PlotJFrame() {
        super("Kappa");
        this.setSize(width, height);
        initComponents();

        setResizable(false);

        File f = new File("src");
        if (f.exists()) {
            System.out.println(f.getAbsolutePath());
        }
        textLines = initTextLines(new File("C:\\Users\\dmin\\Desktop\\2 курс\\4 семестр\\УП\\УП Java Intelij idea\\src\\УПLab4v6\\MyFigure.java"));
    }

    private void initComponents() {
        int centerX = getWidth() / 2;
        centerY = getHeight() / 2;
        int paramA = 130;
        plot = new MyFigure(paramA, centerX, centerY);

        // рисуем сетку
        // рисуем оси
        JPanel jPanel1 = new JPanel() {
            private static final long serialVersionUID = 1L;

            @Override
            public void paintComponent(Graphics g) {
                g.setColor(Color.WHITE);
                g.fillRect(0, 0, this.getWidth(), this.getHeight());
                Graphics2D g2d = (Graphics2D) g;

                g2d.setRenderingHint(RenderingHints.KEY_ANTIALIASING, RenderingHints.VALUE_ANTIALIAS_ON);

                //–исуем сетку
                g2d.setPaint(Color.LIGHT_GRAY);
                g2d.setStroke(new BasicStroke((float) 0.2));
                for (centerY = 0; centerY <= this.getWidth(); centerY += 10) {
                    g2d.draw(new Line2D.Double(0, centerY, this.getWidth(), centerY));
                    g2d.draw(new Line2D.Double(centerY, 0, centerY, this.getHeight()));
                }
                //–исуем оси
                g2d.setPaint(Color.GRAY);
                g2d.setStroke(new BasicStroke((float) 1));
                g2d.draw(new Line2D.Double(ox, 0, ox, this.getHeight()));
                g2d.draw(new Line2D.Double(0, oy, this.getWidth(), oy));

                g2d.setStroke(new BasicStroke(5));
                g2d.setColor(new Color(171, 3, 96));
                g2d.setStroke(new MyStroke(4, 4));
                g2d.draw(plot);
            }
        };

        JMenuBar jMenuBar1 = new JMenuBar();
        JMenu jMenu2 = new JMenu();
        JMenuItem jMenuItem1 = new JMenuItem();

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

        ////////////////////////////
        jMenu2.setText("Options");

        jMenuItem1.setText("Print");
        jMenuItem1.addActionListener(this::jMenuItem1ActionPerformed);
        jMenu2.add(jMenuItem1);

        jMenuBar1.add(jMenu2);

        setJMenuBar(jMenuBar1);
        ///////////////////////////

        javax.swing.GroupLayout layout = new javax.swing.GroupLayout(getContentPane());
        getContentPane().setLayout(layout);
        layout.setHorizontalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );
        layout.setVerticalGroup(layout.createParallelGroup(javax.swing.GroupLayout.Alignment.LEADING)
                .addComponent(jPanel1, javax.swing.GroupLayout.DEFAULT_SIZE, javax.swing.GroupLayout.DEFAULT_SIZE, Short.MAX_VALUE)
        );

    }

    ////////////
    private void jMenuItem1ActionPerformed(java.awt.event.ActionEvent evt) {
        PrinterJob job = PrinterJob.getPrinterJob();
        PrintRequestAttributeSet printRequestAttributeSet = new HashPrintRequestAttributeSet();
        printRequestAttributeSet.add(Sides.DUPLEX);
        printRequestAttributeSet.add(OrientationRequested.LANDSCAPE);

        job.setPrintable(this);
        boolean ok = job.printDialog(printRequestAttributeSet);
        if (ok) {
            try {
                job.print(printRequestAttributeSet);
            } catch (PrinterException ex) {
                System.err.print(ex);
            }
        }
    }
    ////////////


    public static void main(String[] args) {
        try {
            for (javax.swing.UIManager.LookAndFeelInfo info : javax.swing.UIManager.getInstalledLookAndFeels()) {
                if ("Windows".equals(info.getName())) {
                    javax.swing.UIManager.setLookAndFeel(info.getClassName());
                    break;
                }
            }
        } catch (ClassNotFoundException | InstantiationException | IllegalAccessException | UnsupportedLookAndFeelException ex) {
            java.util.logging.Logger.getLogger(PlotJFrame.class.getName()).log(java.util.logging.Level.SEVERE, null, ex);
        }

        java.awt.EventQueue.invokeLater(() -> new PlotJFrame().setVisible(true));
    }

    private final String[] textLines;//new
    private int[] pageBreaks;//new

    @Override//new
    public int print(Graphics graphics, PageFormat pageFormat, int pageIndex) {
        int y = 0;
        Font font = new Font("Times New Roman", Font.PLAIN, 14);
        FontMetrics metrics = graphics.getFontMetrics(font);
        int lineHeight = metrics.getHeight();
        if (pageIndex == 0) {
            BufferedImage bufferedImageAll = new BufferedImage(this.getWidth(), this.getHeight(),
                    BufferedImage.TYPE_INT_RGB);
            Graphics2D graphics2DForImage = bufferedImageAll.createGraphics();
            this.printAll(graphics2DForImage);

            double scale = pageFormat.getWidth() / this.getWidth();
            int newWidth = (int) (this.getWidth() * scale / 3);
            int newHeight = (int) (this.getHeight() * scale / 3);
            graphics.drawString("Kappa Curve", getX() + getWidth() / 2 - 30, getY() + getHeight() / 2 + 30);


            Image scaledImage = bufferedImageAll.getScaledInstance(newWidth, newHeight, Image.SCALE_SMOOTH);
            graphics.drawImage(scaledImage,
                    (int) (pageFormat.getImageableWidth() / 2 - 75),
                    (int) (pageFormat.getImageableHeight() / 60), null);

            return PAGE_EXISTS;
        }

        if (pageBreaks == null) {
            int linesPerPage = (int) (pageFormat.getImageableHeight() / lineHeight);
            int numBreaks = (textLines.length - 1) / linesPerPage + 1;
            pageBreaks = new int[numBreaks];
            for (int b = 0; b < numBreaks; b++) {
                pageBreaks[b] = b * linesPerPage;
            }
        }

        if (pageIndex > pageBreaks.length) {
            return NO_SUCH_PAGE;
        }

        Graphics2D g2D = (Graphics2D) graphics;
        g2D.translate(pageFormat.getImageableX(), pageFormat.getImageableY());
        int start = pageBreaks[pageIndex - 1];
        int end = (pageIndex == pageBreaks.length) ? textLines.length : pageBreaks[pageIndex];
        for (int line = start; line < end; line++) {
            y += lineHeight;
            graphics.drawString(textLines[line], 0, y);
        }
        return PAGE_EXISTS;
    }

    //new
    private String[] initTextLines(File file) {
        ArrayList<String> result = new ArrayList<>();

        try (BufferedReader reader = new BufferedReader(new FileReader(file))) {
            String line;
            while ((line = reader.readLine()) != null) {
                result.add(line);
            }
        } catch (FileNotFoundException ex) {
            return null;
        } catch (IOException e) {
            System.err.println(e.getMessage());
        }
        return result.toArray(new String[0]);
    }
}

