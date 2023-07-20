

import javax.swing.*;
import javax.swing.tree.DefaultTreeModel;
import javax.swing.tree.TreeCellRenderer;
import java.awt.*;

public class GameTree extends JTree {
    public GameTree(TreeCulinaryGuideNode node) {
        super(new DefaultTreeModel(node));
        setCellRenderer(new ComponentCellRenderer(getCellRenderer()));
    }


    static class ComponentCellRenderer implements TreeCellRenderer {
        TreeCellRenderer renderer;

        public ComponentCellRenderer(TreeCellRenderer renderer) {
            this.renderer = renderer;
        }

        @Override
        public Component getTreeCellRendererComponent(JTree tree, Object value, boolean selected,
                                                      boolean expanded, boolean leaf, int row, boolean hasFocus) {
            String name = ((TreeCulinaryGuideNode) value).getName();
            return renderer.getTreeCellRendererComponent(tree, name, selected, expanded, leaf, row, hasFocus);
        }
    }

}
