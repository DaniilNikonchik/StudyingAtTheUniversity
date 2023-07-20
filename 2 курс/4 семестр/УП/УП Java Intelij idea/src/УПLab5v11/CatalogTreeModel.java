package УПLab5v11;

import javax.swing.tree.DefaultTreeModel;

class CatalogTreeModel extends DefaultTreeModel {
    private static final long serialVersionUID = 1L;

    private final GameTreeNode root;

    CatalogTreeModel(GameTreeNode root) {
        super(root);
        this.root = root;
    }

    @Override
    public GameTreeNode getRoot() {
        return root;
    }

    void insertNodeInto(GameTreeNode child, GameTreeNode parent, int i, boolean flag) {
        insertNodeInto(child, parent, i);
        parent.addNode(child);
    }
}
