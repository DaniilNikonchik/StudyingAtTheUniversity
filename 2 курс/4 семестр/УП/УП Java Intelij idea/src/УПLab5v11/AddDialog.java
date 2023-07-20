package УПLab5v11;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddDialog extends JFrame {
    private final CatalogFrame catalog;
    private final JLabel type = new JLabel("Тип");
    private final JLabel name = new JLabel("Имя");
    private final JLabel producer = new JLabel("Создатель");
    private final JLabel number = new JLabel("Стоимость");
    private final JTextField text_type = new JTextField();
    private final JTextField text_name = new JTextField();
    private final JTextField text_producer = new JTextField();
    private final JTextField text_number = new JTextField();
    private final JButton ok_Btn = new JButton("ОК");

    public AddDialog(CatalogFrame catalog) throws HeadlessException {
        Container c = getContentPane();
        this.catalog = catalog;
        ok_Btn.addActionListener(new ok_Listner());
        this.setTitle("Добавление игр");
        this.setBounds(400, 200, 400, 150);
        this.setSize(350, 250);
        this.setDefaultCloseOperation(WindowConstants.DO_NOTHING_ON_CLOSE);
        JPanel panel = new JPanel();
        panel.setLayout(new BoxLayout(panel, BoxLayout.Y_AXIS));
        panel.add(type);
        panel.add(text_type);
        panel.add(name);
        panel.add(text_name);
        panel.add(producer);
        panel.add(text_producer);
        panel.add(number);
        panel.add(text_number);
        panel.add(ok_Btn);
        c.add(panel);
    }

    private class ok_Listner implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            if (text_type.equals("") || text_name.equals("") || text_producer.equals("") || text_number.equals("")) {
                JOptionPane.showMessageDialog(null, "Нужно заполнить все поля!", "Внимание", JOptionPane.WARNING_MESSAGE);
            } else {
                    GameNode mn = new GameNode(text_type.getText(), text_name.getText(), text_producer.getText(), text_number.getText());
                    CatalogFrame.addResult = mn;
                    catalog.addNewItem();
            }
            dispose();
        }
    }
}
