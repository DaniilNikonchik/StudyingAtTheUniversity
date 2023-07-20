package Program7;

import java.io.*;
import java.util.*;

public class Main1 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new FileReader("input.txt"));
        BinarySearchTree tree = new BinarySearchTree();
        String line;
        while ((line = br.readLine()) != null) {
            tree.Insert(Integer.parseInt(line));
        }
        br.close();
        tree.FindHight(tree.root);
        int middle = (tree.root.hight % 2 != 0) ? tree.root.hight / 2 + 1 : tree.root.hight / 2;
        List<BinarySearchTree.BinaryTree> list = tree.SetLevel(tree.root, middle);
        if ((list.size() % 2) != 0) {
            tree.Remove(tree.root, list.get(list.size() / 2).data);
        }
        BufferedWriter bw = new BufferedWriter(new FileWriter("output.txt"));
        tree.ShowTree(tree.root, bw);
        bw.close();
    }
}
class BinarySearchTree {
    static class BinaryTree {
        public int data;
        public BinaryTree left, right, ancestor;
        public int level = 0;
        public int hight;

        public BinaryTree(int dat) {
            this.data = dat;
            left = right = ancestor = null;
        }
    }

    BinaryTree root;

    public BinarySearchTree() {
        root = null;
    }

    int minValue(BinaryTree root) {
        int minv = root.data;
        while (root.left != null) {
            minv = root.left.data;
            root = root.left;
        }
        return minv;
    }

    public void Insert(int data) {
        root = Insert(root, data);
    }

    BinaryTree Insert(BinaryTree root, int dat) {
        if (root == null) {
            root = new BinaryTree(dat);
            return root;
        }
        if (dat < root.data) {
            root.left = Insert(root.left, dat, root);
        } else if (dat > root.data) {
            root.right = Insert(root.right, dat, root);
        }
        return root;
    }

    BinaryTree Insert(BinaryTree root, int data, BinaryTree parent) {
        if (root == null) {
            root = new BinaryTree(data);
            root.ancestor = parent;
            return root;
        }
        if (data < root.data) {
            root.left = Insert(root.left, data, root);
        } else if (data > root.data) {
            root.right = Insert(root.right, data, root);
        }
        return root;
    }

    BinaryTree Remove(BinaryTree root, int dat) {
        if (root == null) {
            return null;
        }
        if (dat < root.data) {
            root.left = Remove(root.left, dat);
        } else if (dat > root.data) {
            root.right = Remove(root.right, dat);
        } else {
            if (root.left == null) {
                return root.right;
            } else if (root.right == null) {
                return root.left;
            }
            root.data = minValue(root.right);
            root.right = Remove(root.right, root.data);
        }
        return root;
    }

    void ShowTree(BinaryTree node, BufferedWriter fw) throws IOException {
        if (node != null) {
            fw.write((node.data) + "\n");
            ShowTree(node.left, fw);
            ShowTree(node.right, fw);
        }
    }

    void FindHight(BinaryTree node) {
        if (node != null) {
            FindHight(node.left);
            FindHight(node.right);
            BinaryTree left = node.left;
            BinaryTree right = node.right;
            if (right == null && left == null) {
                node.hight = 0;
            } else if (right != null && left == null) {
                node.hight = node.right.hight + 1;
            } else if (right == null) {
                node.hight = node.left.hight + 1;
            } else {
                node.hight = Math.max(node.right.hight, node.left.hight) + 1;
            }
        }
    }

    List<BinaryTree> SetLevel(BinaryTree root, int middle) {
        LinkedList<BinaryTree> queue = new LinkedList<>();
        List<BinaryTree> list = new ArrayList<>();
        queue.add(root);
        while (!queue.isEmpty()) {
            BinaryTree node = queue.get(0);
            queue.poll();
            node.level = GetLevel(root, node.data, 0);
            if (node.level > middle) {
                return list;
            }
            if (node.level == middle) {
                if ((node.right == null && node.left == null) ||
                        (node.left != null && node.right != null && (node.left.hight == node.right.hight))) {
                    list.add(node);
                }
            }
            if (node.left != null) {
                queue.add(node.left);
            }
            if (node.right != null) {
                queue.add(node.right);
            }
        }
        return list;
    }

    int GetLevel(BinaryTree node, int dat, int level) {
        if (node == null) {
            return 0;
        }
        if (node.data == dat) {
            return level;
        }
        int levelBelow = GetLevel(node.left, dat, level + 1);
        if (levelBelow != 0) {
            return levelBelow;
        }
        levelBelow = GetLevel(node.right, dat, level + 1);
        return levelBelow;
    }
}
