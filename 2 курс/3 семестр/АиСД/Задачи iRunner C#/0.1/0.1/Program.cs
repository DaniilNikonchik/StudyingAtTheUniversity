using System;
using System.Collections.Generic;
using System.Security;
using System.IO;

namespace BinaryTree {
    public class BinaryTree {
        public class TreeNode {
            public TreeNode left;
            public TreeNode right; 

            int m_data = 0;
            public int data { get { return m_data; } }
            public TreeNode(int data) {
                m_data = data;
                left = null;
                right = null;
            }
        }

        public TreeNode root = null;
        private StreamWriter sw = new StreamWriter("output.txt");

        public BinaryTree() { }

        public BinaryTree(int value) {
            root = new TreeNode(value);
        }

        public void finalize() {
            sw.Close();
        }

        public void Add(int data) {
            if (root == null) {
                root = new TreeNode(data);
                return;
            }

            TreeNode currentNode = root;

            while (currentNode != null) {
                if (data >= currentNode.data){
                    if (currentNode.right == null) {
                        currentNode.right = new TreeNode(data);
                        return;
                    }
                    else {
                        currentNode = currentNode.right;
                        continue;
                    }
                }

                if (currentNode.left == null) {
                    currentNode.left = new TreeNode(data);
                    return;
                }
                else {
                    currentNode = currentNode.left;
                }
            }
        }

        public void leftOrder(BinaryTree tree) {
            tree.preOrder(root);
        }

        private void preOrder(TreeNode node) {
            if (node == null) { return; }

            sw.WriteLine(node.data);

            preOrder(node.left);
            preOrder(node.right);
        }
    }

    class Program {
        static void Main(string[] args) {
            BinaryTree tree = new BinaryTree();
            HashSet<long> numbers = new HashSet<long>();
            int num = 0;

            using (var sr = new StreamReader("input.txt")) {
                string ch;
                while (!sr.EndOfStream) {
                    ch = sr.ReadLine();
                    num = int.Parse(ch);
                    numbers.Add(num);
                }
            }

            foreach (int n in numbers) {
                tree.Add(n);
            }


            tree.leftOrder(tree);
            tree.finalize();
        }
    }
}
