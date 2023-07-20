package Laba9;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.File;
import java.io.RandomAccessFile;
import java.util.ArrayList;
import java.util.Comparator;

import static javax.swing.JOptionPane.showMessageDialog;

public class SimpleGUI {
    private JFrame frame, inputFrame;
    private final JTextArea textArea = new JTextArea();
    private JTextArea clientChoice, brandArea, modelArea, colorArea, priceArea, registrationNumberArea, yearArea;

    static final String filename = "Cars.dat";
    static ArrayList<Car> array;

    public void go() {
        frame = new JFrame("Lab 9");
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        frame.addWindowListener(new closeListener());
        JLabel clientLabel = new JLabel("Enter the value of the search key");
        clientChoice = new JTextArea();
        clientChoice.setRows(1);
        clientChoice.setColumns(20);

        JPanel clientChoicePanel = new JPanel();
        clientChoicePanel.add(clientLabel);
        clientChoicePanel.add(clientChoice);

        JMenuBar menuBar = new JMenuBar();
        //////////////////////////////////////////////////////////////////////////////////
        JMenu printMenu = new JMenu("Conclusion");
        //////////////////////////////////////////////////////////////////////////////////
        JMenu printAllRecords = new JMenu("Output all entries");
        /////////////////////////////////////////////////////////////////////////////////
        JMenuItem printUnsorted = new JMenuItem("Without sorting");
        printUnsorted.addActionListener(new printDefaultListener());

        JMenu printSorted = new JMenu("Sort");
        JMenuItem printSortedByBrand = new JMenuItem("On the brand");
        printSortedByBrand.addActionListener(new printSortedByBrandListener());

        JMenuItem printSortedByModel = new JMenuItem("On the model");
        printSortedByModel.addActionListener(new printSortedByModel());

        JMenuItem printSortedByRegistrationNumber = new JMenuItem("On the registration number");

        printSorted.add(printSortedByBrand);
        printSorted.add(printSortedByModel);
        printSorted.add(printSortedByRegistrationNumber);

        printAllRecords.add(printSorted);
        printAllRecords.add(printUnsorted);
        ///////////////////////////////////////////////////////////////////////////////////

        JMenu Search = new JMenu("Search");

        JMenuItem searchByBrand = new JMenuItem("On the brand");
        searchByBrand.addActionListener(new searchByBrandListener());

        JMenuItem searchByModel = new JMenuItem("On the model");
        searchByModel.addActionListener(new searchByModelListener());

        Search.add(searchByBrand);
        Search.add(searchByModel);
        printMenu.add(printAllRecords);
        printMenu.add(Search);

        JMenu addMenu = new JMenu("Add");

        JMenuItem addNew = new JMenuItem("Add a new entry");
        addNew.addActionListener(new appendItemListener());

        addMenu.add(addNew);

        JMenu deleteMenu = new JMenu("Delete record");

        JMenuItem deleteByFirm = new JMenuItem("Delete the entry of the brand");
        deleteByFirm.addActionListener(new deleteByBrandListener());
        JMenuItem deleteAll = new JMenuItem("Delete all entries");
        deleteAll.addActionListener(new deleteAllListener());

        deleteMenu.add(deleteByFirm);
        deleteMenu.add(deleteAll);

        menuBar.add(addMenu);
        menuBar.add(printMenu);
        menuBar.add(deleteMenu);

        JScrollPane scroller = new JScrollPane(textArea);

        frame.getContentPane().add(BorderLayout.CENTER, scroller);
        frame.getContentPane().add(BorderLayout.NORTH, clientChoicePanel);

        frame.setLocation(300, 300);
        frame.setJMenuBar(menuBar);
        frame.setSize(600, 600);
        frame.setVisible(true);

        readArray();
    }

    private void readArray() {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            long pos;
            array = new ArrayList<>();
            while ((pos = raf.getFilePointer()) < raf.length()) {
                Car car = (Car) Buffer.readObject(raf, pos);
                array.add(car);
            }
        } catch (Exception ignored) { }
    }

    private void removeFile() {
        File file = new File(filename);
        file.delete();
    }

    void saveAfterRemove(ArrayList<Car> array) {
        try (RandomAccessFile raf = new RandomAccessFile(filename, "rw")) {
            for (Car car : array) {
                Buffer.writeObject(raf, car);
            }
        } catch (Exception ignored) { }
    }

    class closeListener implements WindowListener {

        @Override
        public void windowOpened(WindowEvent e) { }

        @Override
        public void windowClosing(WindowEvent e) {
            removeFile();
            saveAfterRemove(array);
        }

        @Override
        public void windowClosed(WindowEvent e) { }

        @Override
        public void windowIconified(WindowEvent e) { }

        @Override
        public void windowDeiconified(WindowEvent e) { }

        @Override
        public void windowActivated(WindowEvent e) { }

        @Override
        public void windowDeactivated(WindowEvent e) { }
    }

    private void createInputFrame() {
        inputFrame = new JFrame("Enter data");
        inputFrame.setVisible(true);
        inputFrame.setSize(80, 450);
        JPanel inputPanel = new JPanel();

        JLabel brandLabel = new JLabel("Brand");
        brandArea = new JTextArea();
        brandArea.setColumns(15);

        JLabel modelLabel = new JLabel("Model");
        modelArea = new JTextArea();
        modelArea.setColumns(15);

        JLabel colorLabel = new JLabel("Color");
        colorArea = new JTextArea();
        colorArea.setColumns(15);

        JLabel priceLabel = new JLabel("Price");
        priceArea = new JTextArea();
        priceArea.setColumns(15);

        JLabel registrationNumberLabel = new JLabel("Registration number");
        registrationNumberArea = new JTextArea();
        registrationNumberArea.setColumns(15);

        JLabel yearLabel = new JLabel("Year of manufacture");
        yearArea = new JTextArea();
        yearArea.setColumns(15);

        JButton appendItemBtn = new JButton("Add record");
        appendItemBtn.addActionListener(new appendItemBtnListener());

        inputPanel.add(brandLabel);
        inputPanel.add(brandArea);

        inputPanel.add(modelLabel);
        inputPanel.add(modelArea);

        inputPanel.add(colorLabel);
        inputPanel.add(colorArea);

        inputPanel.add(priceLabel);
        inputPanel.add(priceArea);

        inputPanel.add(registrationNumberLabel);
        inputPanel.add(registrationNumberArea);

        inputPanel.add(yearLabel);
        inputPanel.add(yearArea);

        inputPanel.add(appendItemBtn);

        inputFrame.getContentPane().add(BorderLayout.CENTER, inputPanel);
    }

    class printDefaultListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            textArea.setText(null);
            for (Car car : array) {
                textArea.append(car.toString() + "\n");
            }
        }
    }

    class printSortedByBrandListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Comparator<Car> comp;
            comp = Comparator.comparing(o -> o.brand);
            array.sort(comp);
            textArea.setText(null);
            for (Car car : array) {
                textArea.append(car.toString() + "\n");
            }
        }
    }

    class printSortedByModel implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            Comparator<Car> comp;
            comp = Comparator.comparing(o -> o.model);
            array.sort(comp);
            textArea.setText(null);
            for (Car car : array) {
                textArea.append(car.toString() + "\n");
            }
        }
    }

    class searchByBrandListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String value = clientChoice.getText();
            textArea.setText(null);
            if (value.equals("Default") || value.equals("")) {
                showMessageDialog(frame, "Please enter value");
                return;
            }
            for (int i = array.size() - 1; i >= 0; i--) {
                if (value.compareTo(array.get(i).brand) == 0) {
                    textArea.append(array.get(i).toString() + "\n");
                }
            }
        }
    }

    class searchByModelListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String value = clientChoice.getText();
            textArea.setText(null);
            if (value.equals("Default") || value.equals("")) {
                showMessageDialog(frame, "Please enter value");
                return;
            }
            for (int i = array.size() - 1; i >= 0; i--) {
                if (value.compareTo(array.get(i).model) == 0) {
                    textArea.append(array.get(i).toString() + "\n");
                }
            }
        }
    }

    class deleteAllListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            array.clear();
            textArea.setText("");
        }
    }

    class deleteByBrandListener implements ActionListener {
        @Override
        public void actionPerformed(ActionEvent e) {
            String value = clientChoice.getText();
            textArea.setText(null);
            if (value.equals("Default") || value.equals("")) {
                showMessageDialog(frame, "Please enter value");
                return;
            }
            for (int i = array.size() - 1; i >= 0; i--) {
                if (value.compareTo(array.get(i).brand) == 0) {
                    array.remove(i);
                }
            }
        }
    }

    class appendItemListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            createInputFrame();
        }
    }

    class appendItemBtnListener implements ActionListener {

        @Override
        public void actionPerformed(ActionEvent e) {
            String brand, model, color, price, registrationNumber, year;
            brand = brandArea.getText();
            model = modelArea.getText();
            color = colorArea.getText();
            price = priceArea.getText();
            registrationNumber = registrationNumberArea.getText(); // unit
            year = yearArea.getText();
            if (brand.equals("") || model.equals("") || color.equals("") || price.equals("")
                    || registrationNumber.equals("") || year.equals("")) {
                showMessageDialog(inputFrame, "All fields must be filled in!");
                return;
            }
            try (RandomAccessFile ignored1 = new RandomAccessFile(filename, "rw")) {
                Car newCar = new Car();
                newCar.brand = brand;
                newCar.model = model;
                newCar.color = color;
                newCar.price = Double.parseDouble(price);
                newCar.registrationNumber = registrationNumber;
                newCar.year = Integer.parseInt(year);
                array.add(newCar);
            } catch (Exception ignored) {
            }
            inputFrame.setVisible(false);
        }
    }
}