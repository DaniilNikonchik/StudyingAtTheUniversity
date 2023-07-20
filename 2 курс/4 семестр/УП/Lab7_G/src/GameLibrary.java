import javax.swing.tree.TreeNode;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.Enumeration;
import java.util.Iterator;
import java.util.Spliterator;
import java.util.function.Consumer;


public class GameLibrary implements Serializable, TreeCulinaryGuideNode, Iterable<GameType> {
    private final String name;
    private final ArrayList<GameType> gameTypes;

    @Override
    public String getName() {
        return name;
    }

    public GameLibrary(String name) {
        this.name = name;
        this.gameTypes = new ArrayList<>();
    }

    public void add(GameType e){
        gameTypes.add(e);
        e.setCulinaryGuide(this);
    }

    @Override
    public Iterator<GameType> iterator() {
        return gameTypes.iterator();
    }

    @Override
    public void forEach(Consumer<? super GameType> action) {
        gameTypes.forEach(action);
    }

    @Override
    public Spliterator<GameType> spliterator() {
        return gameTypes.spliterator();
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return gameTypes.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return gameTypes.size();
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        int size = this.getChildCount();
        String childName = ((TreeCulinaryGuideNode) node).getName();
        for (int i = 0; i < size; i++) {
            if (gameTypes.get(i).getName().equals(childName)) {
                return i;
            }
        }
        return -1;
    }

    @Override
    public boolean getAllowsChildren() {
        return true;
    }

    @Override
    public boolean isLeaf() {
        return gameTypes.size() == 0;
    }

    @Override
    public Enumeration children() {
        return null;
    }
}
