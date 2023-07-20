package BuildATree;

import java.io.*;

/*
Условие:
По набору ключей постройте бинарное поисковое дерево и
выполните его прямой левый обход.

Формат входных данных:
Входной файл содержит последовательность чисел — ключи вершин
в порядке добавления в дерево. Ключи задаются в формате по одному в строке.
В поисковом дереве все ключи по определению уникальны, поэтому
при попытке добавить в дерево ключ, который там уже есть, он игнорируется.

Формат выходных данных:
Выходной файл должен содержать последовательность ключей вершин,
полученную прямым левым обходом дерева.

Примеры:
+---------------------------------------------------------+
|        input.txt           |        output.txt          |
+---------------------------------------------------------+
| 2                          | 5                          |
| 3                          |                            |
+---------------------------------------------------------+
| 5                          | 5                          |
| 2                          | 2                          |
| 4                          | 1                          |
| 1                          | 4                          |
| 8                          | 8                          |
| 7                          | 7                          |
+---------------------------------------------------------+
| 0                          | 0                          |
| 100                        | -100                       |
| -100                       | 100                        |
+---------------------------------------------------------+
 */

public class BuildRTree implements Runnable {
    public static void main(String[] args) {
        new Thread(null, new BuildRTree(), "", 64 * 1024 * 1024).start();
    }

    @Override
    public void run() {
        try {
            BufferedReader br = new BufferedReader(new FileReader("input.txt"));
            FileWriter fw = new FileWriter("output.txt");
            Tree test = new Tree();
            String st = br.readLine();
            while (st != null) {
                test.insert(Long.parseLong(st));
                st = br.readLine();
            }
            Tree.preOrder(fw, test.root);
            fw.close();
            br.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}

class Tree {
    public static class Node {
        public long key;
        public Node left;
        public Node right;

        public Node(long x) {
            key = x;
            left = null;
            right = null;
        }

    }

    public Node root;

    public Tree() { }

    public void insert(long x) {
        Node parent = null;
        Node v = this.root;
        while (v != null) {
            parent = v;
            if (x < v.key) {
                v = v.left;
            } else if (x > v.key) {
                v = v.right;
            } else {
                return;
            }
        }
        Node w = new Node(x);
        if (parent == null) {
            this.root = w;
        } else if (x < parent.key) {
            parent.left = w;
        } else {
            parent.right = w;
        }
    }

    public static void preOrder(FileWriter fw, Node l) throws IOException {
        if (l != null) {
            fw.write(String.valueOf(l.key) + '\n');
            preOrder(fw, l.left);
            preOrder(fw, l.right);
        }
    }
}