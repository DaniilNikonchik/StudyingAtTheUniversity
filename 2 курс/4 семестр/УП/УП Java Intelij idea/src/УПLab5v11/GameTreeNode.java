package УПLab5v11;

import javax.swing.tree.DefaultMutableTreeNode;
import java.util.ArrayDeque;
import java.util.ArrayList;
import java.util.Deque;
import java.util.List;

class GameTreeNode extends DefaultMutableTreeNode {
    private static final long serialVersionUID = 1L;

    private String nodeName;
    private GameNode nodeValue = null;
    private List<GameTreeNode> nodes = new ArrayList<>();
    private boolean isLeafNode = false;

    GameTreeNode() {}

    GameTreeNode(String name) {
        nodeName = name;
    }

    GameTreeNode(String name, GameNode value) {
        nodeName = name;
        nodeValue = value;
        isLeafNode = true;
    }

    void addNode(GameTreeNode node) {
        nodes.add(node);
    }

    boolean deleteNode(GameTreeNode node) {
        boolean isExist = false;
        for (int i = 0; i < nodes.size(); ++i)
            if (nodes.get(i).toString().compareToIgnoreCase(node.toString()) == 0) {
                nodes.remove(i);
                isExist = true;
            }
        return isExist;
    }

    List<GameNode> getAllLeaves() {
        List<GameNode> leaves = new ArrayList<>();
        Deque<GameTreeNode> deque = new ArrayDeque<>();

        deque.push(this);
        GameTreeNode temp;
        while (!deque.isEmpty()) {
            temp = deque.removeFirst();
            if (temp.isLeafNode) {
                leaves.add(temp.getNodeValue());
            } else {
                for (int i = 0; i < temp.nodes.size(); ++i) {
                    deque.push(temp.nodes.get(i));
                }
            }
        }

        return leaves;
    }

    public GameNode getNodeValue() {
        return nodeValue;
    }

    List<GameTreeNode> getNodes() {
        return nodes;
    }

    @Override
    public String toString() {
        return nodeName;
    }
}
