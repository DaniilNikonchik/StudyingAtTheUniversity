package УПLab1v6;

import java.awt.*;
import java.awt.event.*;
import java.awt.geom.*;
import javax.swing.*;

public class УПLab1 {
    public static void main(String[] args) {
        JFrame jFrame = new JFrame("The rotation of a triangle around it's center of gravity");
        jFrame.setPreferredSize(new Dimension(1200, 810)); // размеры окна
        final JPanel jPanel = new JPanel(); // сюда можно поместить кнопки и формы

        jFrame.add(jPanel);
        jFrame.setVisible(true); // отображение окна на экране
        jFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        jFrame.pack();

        Color color1 = Color.yellow;
        Color color2 = Color.black;
        float flot = 2f;

        Timer tm = new Timer(100, new ActionListener() { // это уведомляемый о некотором событии объект
            int i = 0;
            @Override
            public void actionPerformed(ActionEvent arg0) {
                Graphics2D graphics2D = (Graphics2D) jPanel.getRootPane().getGraphics();
                jPanel.update(graphics2D);

                GeneralPath path = new GeneralPath(); // геометрический путь

                path.append(new Polygon(new int[]{270, -80, -280}, new int[]{-230, 250, -120}, 3), true);
                int x = (270 - 80 - 280) / 3, y = (-230 + 250 - 120) / 3;

                graphics2D.translate(600, 405);
                AffineTransform transform = AffineTransform.getRotateInstance((i++) * 0.07, x, y);
                graphics2D.transform(transform);
                graphics2D.setPaint(color1);
                graphics2D.fill(path);
                graphics2D.setPaint(color2);
                graphics2D.setStroke(new BasicStroke(flot));
                graphics2D.draw(path);
            }
        });
        tm.start();
    }
}


































/*
      // try {
      //     if (args.length == 6) {
      //       //  color1 = new Color(Integer.parseInt(args[0]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
      //       //  color2 = new Color(Integer.parseInt(args[3]), Integer.parseInt(args[1]), Integer.parseInt(args[2]));
      //       //  flot = Float.parseFloat(args[5]);
      //     }
      // } catch (Exception ex) {
      //     System.out.println(ex.getMessage());
      // }

      // Color finalColor1 = color1;
      // Color finalColor2 = color2;
      // Float finalFlot = flot;
 */