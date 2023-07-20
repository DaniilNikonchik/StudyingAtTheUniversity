import javax.swing.tree.TreeNode;
import java.io.Serializable;
import java.util.*;
import java.util.function.Consumer;

public class GameType implements Serializable, TreeCulinaryGuideNode, Iterable<Game> {
    private final String name;
    private final ArrayList<Game> dishs;
    private GameLibrary culinaryGuide;

    public GameType(String name, GameLibrary culinaryGuide) {
        this.name = name;
        this.culinaryGuide = culinaryGuide;
        this.dishs = new ArrayList<>();
    }

    public GameType(String name) {
        this.name = name;
        this.dishs = new ArrayList<>();
    }

    @Override
    public String getName() {
        return name;
    }

    public List<Game> getDishsCopy(){
        return new ArrayList<>(dishs);
    }

    public void add(Game e){
        dishs.add(e);
        e.setDishType(this);
    }

    @Override
    public Iterator<Game> iterator() {
        return dishs.iterator();
    }

    @Override
    public void forEach(Consumer<? super Game> action) {
        dishs.forEach(action);
    }

    @Override
    public Spliterator<Game> spliterator() {
        return dishs.spliterator();
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return dishs.get(childIndex);
    }

    @Override
    public int getChildCount() {
        return dishs.size();
    }

    @Override
    public TreeNode getParent() {
        return culinaryGuide;
    }

    @Override
    public int getIndex(TreeNode node) {
        int size = this.getChildCount();
        String childName = ((TreeCulinaryGuideNode) node).getName();
        for (int i = 0; i < size; i++) {
            if (dishs.get(i).getName().equals(childName)) {
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
        return dishs.size() == 0;
    }

    @Override
    public Enumeration children() {
        return null;
    }

    public void setCulinaryGuide(GameLibrary culinaryGuide) {
        this.culinaryGuide = culinaryGuide;
    }

    public GameLibrary getCulinaryGuide() {
        return culinaryGuide;
    }
}
