package УПLab2v11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class MainFrame extends JFrame {
    public MainFrame(final GraphShape[] shapes) {
        super("GraphSampleFrame");
        Container pane = getContentPane();
        pane.setLayout(new BorderLayout());
        final JTabbedPane tabbedPane = new JTabbedPane();
        pane.add(tabbedPane, BorderLayout.CENTER);

        this.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        for (GraphShape e : shapes) {
            tabbedPane.addTab(e.getName(), new Paints(e));
        }
    }

    public static void main(String[] args) {
        GraphShape[] examples = new GraphShape[1];
        examples[0] = new GoSign();
        MainFrame frame = new MainFrame(examples);
        frame.pack();
        frame.setVisible(true);
    }
}


