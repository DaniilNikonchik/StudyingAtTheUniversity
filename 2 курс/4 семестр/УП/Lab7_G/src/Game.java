import javax.swing.tree.TreeNode;
import java.io.Serializable;
import java.util.Enumeration;

public class Game implements Serializable, TreeCulinaryGuideNode {
    private final String name;
    private final String complexity;
    private final String exotic;
    private GameType gameType;

    public Game(String name, String complexity) {
        this(name, complexity, "");
    }

    public Game(String name, String complexity, String exotic) {
        this.name = name;
        this.complexity = complexity;
        this.exotic = exotic;
    }

    public String getDishName() {
        return name;
    }

    public String getComplexity() {
        return complexity;
    }

    public String getExotic() {
        return exotic;
    }

    @Override
    public String getName() {
        return getDishName();
    }

    @Override
    public TreeNode getChildAt(int childIndex) {
        return null;
    }

    @Override
    public int getChildCount() {
        return 0;
    }

    @Override
    public TreeNode getParent() {
        return null;
    }

    @Override
    public int getIndex(TreeNode node) {
        return 0;
    }

    @Override
    public boolean getAllowsChildren() {
        return false;
    }

    @Override
    public boolean isLeaf() {
        return true;
    }

    @Override
    public Enumeration children() {
        return null;
    }

    public GameType getDishType() {
        return gameType;
    }

    public void setDishType(GameType gameType){
        this.gameType = gameType;
    }
}
