

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import java.awt.event.ActionEvent;
import java.io.File;
import java.io.IOException;

public class MenuActions {
    private final GameAppInterface parentInterface;
    private static GameSQLExecutor dao;

    public MenuActions(GameAppInterface parentInterface) {
        this.parentInterface = parentInterface;
    }

    public JMenuBar initMenu() {
        JMenuBar menuBar = new JMenuBar();

        JMenu menuFile = new JMenu("File");
        JMenuItem miCreate = new JMenuItem("Create new game library");
        miCreate.addActionListener(this::createListener);
        JMenuItem miOpen = new JMenuItem("Open...");
        miOpen.addActionListener(this::openListener);
        JMenuItem miSaveDb = new JMenuItem("Save the database...");
        miSaveDb.addActionListener(this::saveDbListener);
        menuFile.add(miCreate);
        menuFile.add(miOpen);
        menuFile.add(miSaveDb);
        menuBar.add(menuFile);

        JMenu menuEdit = new JMenu("Edit");

        JMenuItem miAddGameType = new JMenuItem("Add new game type");
        JMenuItem miAddGame = new JMenuItem("Add new game");

        miAddGameType.addActionListener(this::addNewDishTypeListener);
        miAddGame.addActionListener(this::addNewDishListener);

        menuEdit.add(miAddGameType);
        menuEdit.add(miAddGame);
        menuBar.add(menuEdit);

        return menuBar;
    }

    private void saveDbListener(ActionEvent actionEvent) {
        dao.executePending();
    }

    private void createListener(ActionEvent actionEvent) {
        String name = JOptionPane.showInputDialog("Enter new game name");
        parentInterface.root = new GameLibrary(name);
        dao = new GameSQLExecutor(name);
        dao.create();
        parentInterface.reload();
    }

    void addNewDishTypeListener(ActionEvent e) {
        GameLibrary culinaryGuide = (GameLibrary) parentInterface.root;
        if (culinaryGuide == null) {
            JOptionPane.showMessageDialog(parentInterface.frame, "Create or open a game first");
            return;
        }
        String dishTypeName = JOptionPane.showInputDialog("Enter new game creator company");
        GameType newGameType = new GameType(dishTypeName);
        culinaryGuide.add(newGameType);
        System.out.println(dao);
        dao.lazyAddSection(newGameType, 1);
        ((DefaultTreeModel) parentInterface.tree.getModel()).reload();
    }

    void addNewDishListener(ActionEvent e) {
        TreeCulinaryGuideNode selected = parentInterface.selection;
        if (parentInterface.selection instanceof GameLibrary || parentInterface.selection == null) {
            JOptionPane.showMessageDialog(parentInterface.frame, "No game type is selected");
            return;
        }
        GameType gameType = selected instanceof GameType ? (GameType) selected : ((Game) selected).getDishType();
        GameLibrary culinaryGuide = (GameLibrary) parentInterface.root;

        String name = JOptionPane.showInputDialog("Enter the game name");
        String complexity = JOptionPane.showInputDialog("Enter the game creator company");
        String exotic = JOptionPane.showInputDialog("Enter the game price");
        Game newGame = new Game(name, complexity, exotic);
        gameType.add(newGame);
        dao.lazyAddReport(newGame, culinaryGuide.getIndex(gameType) + 1);
        ((DefaultTreeModel) parentInterface.tree.getModel()).reload();
    }

    void saveAsListener(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setDialogTitle("Specify a file to save");

        int userSelection = fileChooser.showSaveDialog(parentInterface.frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToSave = fileChooser.getSelectedFile();
            try {
                new GameSerialization((GameLibrary) parentInterface.root).save(fileToSave);
            } catch (IOException ioException) {
                JOptionPane.showMessageDialog(parentInterface.frame, "Error while saving");
            }
        }
    }

    void openListener(ActionEvent e) {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setFileSelectionMode(JFileChooser.DIRECTORIES_ONLY);
        fileChooser.setDialogTitle("Choose a directory with the database");
        fileChooser.setCurrentDirectory(new File("C:\\Derby"));
        int userSelection = fileChooser.showOpenDialog(parentInterface.frame);

        if (userSelection == JFileChooser.APPROVE_OPTION) {
            File fileToOpen = fileChooser.getSelectedFile();
            try {
                System.out.println(fileToOpen.getName());
                dao = new GameSQLExecutor(fileToOpen.getName());
                parentInterface.root = dao.readCulinaryGuides().get(0);
                parentInterface.reload();
            } catch (Exception ioException) {
                ioException.printStackTrace();
                JOptionPane.showMessageDialog(parentInterface.frame, "Wrong file selected");
            }
        }
    }

}
