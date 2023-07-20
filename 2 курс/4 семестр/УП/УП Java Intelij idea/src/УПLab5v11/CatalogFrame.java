package УПLab5v11;

import javax.swing.*;
import javax.swing.tree.DefaultMutableTreeNode;
import javax.swing.tree.TreePath;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Scanner;

public class CatalogFrame extends JFrame {
    private static final long serialVersionUID = 1L;

    static GameNode addResult = null;

    private JTable infoPanel;
    private JMenuBar menuBar;
    private JMenu fileMenu;
    private JMenuItem saveItem;
    private JTree tree;
    private CatalogTableModel tableModel;
    private CatalogTreeModel treeModel;

    private CatalogFrame() {
        JButton addButton = new JButton("Добавить");
        addButton.addActionListener(e -> openAddDialog());

        JButton removeButton = new JButton("Удалить");
        removeButton.addActionListener(e -> removeItem());


        tableModel = new CatalogTableModel();
        infoPanel = new JTable(tableModel);
        treeModel = new CatalogTreeModel(new GameTreeNode("Библиотека игр"));
        tree = new JTree(treeModel);
        tree.addTreeSelectionListener(e -> {
            GameTreeNode node = (GameTreeNode) tree.getLastSelectedPathComponent();
            if (node == null) {
                return;
            }

            List<GameNode> gameNodes = node.getAllLeaves();
            tableModel = new CatalogTableModel(gameNodes);
            infoPanel.setModel(tableModel);
        });

        JButton saveButton = new JButton("Сохранить");
        saveButton.addActionListener(e -> {
            try {
                SaveInFile(treeModel.getRoot());
            } catch (IOException ioException) {
                ioException.printStackTrace();
            }
        });

        JSplitPane splitPane = new JSplitPane(JSplitPane.VERTICAL_SPLIT,
                true,
                new JScrollPane(tree),
                new JScrollPane(infoPanel));
        splitPane.setDividerLocation(250);

        getContentPane().add(splitPane);
        getContentPane().add("North", addButton);
        getContentPane().add("South", removeButton);
        getContentPane().add("East", saveButton);
        setBounds(100, 100, 640, 480);
        setTitle("Библиотека игр");
        setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        setVisible(true);
        GameNode[] nodes = LoadFile().toArray(new GameNode[0]);
        for (GameNode n : nodes) {
            GameTreeNode where, insert, root = treeModel.getRoot();
            try {
                insert = new GameTreeNode(n.getName(), n);
                if ((where = findNode(root, n.getType())) == null) {
                    treeModel.insertNodeInto(new GameTreeNode(n.getType()),
                            root,
                            root.getChildCount(),
                            false);
                    where = findNode(root, n.getType());
                    assert where != null;
                }
                treeModel.insertNodeInto(insert, where, where.getChildCount(), false);
            } catch (Exception e) {
                return;
            }
        }
    }

    private void openAddDialog() {
        AddDialog addForm = new AddDialog(this);
        addForm.setVisible(true);
    }

    void addNewItem() {
        GameTreeNode where, insert, root = treeModel.getRoot();

        if (addResult != null) {
            try {
                insert = new GameTreeNode(addResult.getName(), addResult);
                if ((where = findNode(root, addResult.getType())) != null) {
                    treeModel.insertNodeInto(insert, where, where.getChildCount(), false);
                } else {
                    treeModel.insertNodeInto(new GameTreeNode(addResult.getType()),
                            root,
                            root.getChildCount(),
                            false);
                    where = findNode(root, addResult.getType());
                    treeModel.insertNodeInto(insert, where, where.getChildCount(), false);
                }
            } catch (Exception e) {
                addResult = null;
                return;
            }
        }
        addResult = null;
    }

    private void removeItem() {
        TreePath currentSelection = tree.getSelectionPath();
        if (currentSelection != null) {
            GameTreeNode currentNode = (GameTreeNode) (currentSelection.getLastPathComponent());
            GameTreeNode parent = (GameTreeNode) (currentNode.getParent());
            if (parent != null) {
                treeModel.removeNodeFromParent(currentNode);
                parent.deleteNode(currentNode);
                List<GameNode> gameNodes = parent.getAllLeaves();
                tableModel = new CatalogTableModel(gameNodes);
                infoPanel.setModel(tableModel);
            }
        }
    }

    private GameTreeNode findNode(GameTreeNode root, String i) {
        Enumeration e = root.depthFirstEnumeration();
        while (e.hasMoreElements()) {
            GameTreeNode node = (GameTreeNode) e.nextElement();
            if (node.toString().equalsIgnoreCase(i)) {
                return node;
            }
        }
        return null;
    }

    public static void main(String[] args) {
        CatalogFrame mainClass = new CatalogFrame();
        mainClass.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE);
        mainClass.setVisible(true);
    }

    public void SaveInFile(GameTreeNode root) throws IOException {
        FileWriter fileWriter = new FileWriter("games.txt", false);

        for (Enumeration e = root.depthFirstEnumeration(); e.hasMoreElements(); ) {
            DefaultMutableTreeNode node = (DefaultMutableTreeNode) e.nextElement();
            if (node.isLeaf()) {
                GameTreeNode c = (GameTreeNode) node;
                fileWriter.write(c.getNodeValue().toString());
                fileWriter.write('\n');
            }
        }


        fileWriter.close();
    }

    public ArrayList<GameNode> LoadFile() {
        ArrayList nodes = new ArrayList();
        try {
            FileReader fr = new FileReader("games.txt");
            Scanner scanner = new Scanner(fr);
            while (scanner.hasNext()) {
                String record = scanner.nextLine();
                nodes.add(new GameNode(record));
            }


            fr.close();
        } catch (Exception ex) {
            JDialog dialog = new JDialog(this, "Неправельный формат файла");
            dialog.setVisible(true);
        } finally {
            return nodes;
        }
    }
}
