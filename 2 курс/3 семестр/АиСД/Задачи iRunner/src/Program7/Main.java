package Program7;

import java.io.*;
import java.util.*;

class BST {
    class Node {
        int value;
        Node left, right;
        Node(int value) {
            this.value = value;
            left = right = null;
        }
        int height = 0;
    }

    Node root;

    List<Integer> list = new ArrayList<>();

    BST() {
        root = null;
    }

    private Node add(Node current, int value) {
        if (current == null)
            return new Node(value);

        if (value < current.value)
            current.left = add(current.left, value);
        else if (value > current.value)
            current.right = add(current.right, value);
        return current;

    }

    public void add(int value) {
        root = add(root, value);
    }

    private Node delete(Node current, int value) {
        if (current == null)
            return null;
        if (value == current.value) {
            if (current.height != root.height / 2)
                return current;

            if (current.left == null && current.right == null)
                return null;

            if (current.left == null)
                return current.right;

            if (current.right == null)
                return current.left;

            int smallestValue = findSmallestValue(current.right);
            current.value = smallestValue;
            current.right = delete(current.right, smallestValue);
            return current;

        }

        if (value < current.value) {
            current.left = delete(current.left, value);
            return current;
        }
        current.right = delete(current.right, value);
        return current;
    }

    private int findSmallestValue(Node root) {
        return root.left == null ? root.value : findSmallestValue(root.left);
    }

    public void delete(int value) {
        root = delete(root, value);
    }

    private void traversePreOrder(Node node, FileWriter myWriter) {
        if (node == null)
            return;

        try {
            if (node != root)
                myWriter.write("\n");
            myWriter.write(String.valueOf(node.value));

        } catch (IOException e) {
        }
        traversePreOrder(node.left, myWriter);
        traversePreOrder(node.right, myWriter);

    }

    public void traversePreOrder(FileWriter myWriter) {
        traversePreOrder(root, myWriter);
    }


    private void traversePostOrder(Node node) {
        if (node == null)
            return;
        traversePostOrder(node.left);
        traversePostOrder(node.right);
        if (node.left == null && node.right != null)
            node.height = node.right.height + 1;
        else if (node.left != null && node.right == null)
            node.height = node.left.height + 1;
        else if (node.left != null && node.right != null)
            node.height = Math.max(node.left.height, node.right.height) + 1;


    }

    public void traversePostOrder() {
        traversePostOrder(root);
    }

    private void specialTraverse(Node node) {
        if (node == null)
            return;
        specialTraverse(node.left);
        specialTraverse(node.right);

        if (node.height == root.height / 2) {
            if (node.left == null && node.right == null)
                list.add(node.value);
            else if (node.left == null || node.right == null)
                return;
            else if (node.left.height == node.right.height)
                list.add(node.value);
        }
    }

    public void specialTraverse() {
        specialTraverse(root);
    }
}

public class Main implements Runnable {
    public static void main(String[] args) {
        new Thread(null, new Main(), "", 64 * 1024 * 1024).start();
    }

    public void run() {
        BST t = new BST();
        int x = 0;
        try {
            File file = new File("input.txt");
            FileReader fr = new FileReader(file);   //reads the file
            BufferedReader br = new BufferedReader(fr);  //creates a buffering character input stream
            String line;
            while ((line = br.readLine()) != null) {
                int l = 0;
                try {
                    l = Integer.parseInt(line);
                } catch (Exception e) {
                }
                t.add(l);
            }
            br.close();
            fr.close();
        } catch (IOException e) {
        }
        t.traversePostOrder();
        t.specialTraverse();
        int average = 0;
        for (int i = 0; i < t.list.size(); i++)
            average += t.list.get(i);
        if (t.list.size() != 0) {
            average /= t.list.size();
            t.delete(average);
        }
        try {
            FileWriter myWriter = new FileWriter("output.txt");
            t.traversePreOrder(myWriter);
            myWriter.close();
        } catch (IOException e) {
        }
    }
}
