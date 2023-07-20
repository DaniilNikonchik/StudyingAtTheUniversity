
import javax.swing.*;
import javax.swing.event.TreeSelectionEvent;
import javax.swing.tree.TreePath;
import javax.swing.tree.TreeSelectionModel;

import java.awt.*;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import java.util.ArrayList;
import java.util.List;

public class GameAppInterface {
    JMenuBar menu;
    TreeCulinaryGuideNode root;
    JLabel msgLine;
    JFrame frame;
    JScrollPane treeScrollPane;
    JScrollPane tableScrollPane;
    JTree tree;
    GameTable table;
    Box boxTreeTable;

    TreeCulinaryGuideNode selection;

    public GameAppInterface(TreeCulinaryGuideNode root) {
        this.root = root;
    }

    public JFrame createTreeFrame() {
        msgLine = new JLabel(" h");

        MenuActions menuActions = new MenuActions(this);
        menu = menuActions.initMenu();

        frame = initFrame();
        treeScrollPane = new JScrollPane();
        tableScrollPane = new JScrollPane();

        tree = initTree();
        treeScrollPane.setViewportView(tree);

        table = new GameTable();
        tableScrollPane.setViewportView(table);

        createTreeTableBox();


        Font font = new Font("SegoeUI", Font.PLAIN, 14);
        tree.setFont(font);
        table.setFont(font);

        frame.getContentPane().add(menu, BorderLayout.NORTH);
        frame.getContentPane().add(boxTreeTable);
        frame.getContentPane().add(msgLine, BorderLayout.SOUTH);


        return frame;
    }

    void createTreeTableBox() {
        boxTreeTable = Box.createHorizontalBox();
        boxTreeTable.add(treeScrollPane);
        boxTreeTable.add(tableScrollPane);
    }

    private JTree initTree() {
        JTree tree = new GameTree(root);
        tree.getSelectionModel().setSelectionMode(TreeSelectionModel.SINGLE_TREE_SELECTION);
        tree.addTreeSelectionListener(this::listenTreeSelection);
        return tree;
    }

    private void listenTreeSelection(TreeSelectionEvent e) {
        TreePath path = e.getPath();
        TreeCulinaryGuideNode node = (TreeCulinaryGuideNode) path.getLastPathComponent();
        msgLine.setText(node.getName());

        selection = node;
        if (node.getClass() == Game.class) {
            List<Game> dishs = new ArrayList<>();
            dishs.add((Game) node);
            table.setDishs(dishs);
        } else if (node.getClass() == GameType.class) {
            table.setDishs(((GameType) node).getDishsCopy());
        } else {
            table.setDishs(null);
        }
    }

    private static JFrame initFrame() {
        JFrame frame = new JFrame("Game library");
        frame.addWindowListener(new WindowAdapter() {
            public void windowClosing(WindowEvent e) {
                System.exit(0);
            }
        });
        return frame;
    }

    public void reload() {
        frame.setVisible(false);
        frame.dispose();
        show();
        frame.repaint();
    }

    public void show() {
        frame = createTreeFrame();
        frame.setSize(1024, 768);
        frame.setVisible(true);
    }
}
