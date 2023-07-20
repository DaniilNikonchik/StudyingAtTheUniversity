using System;
using System.Collections.Generic;
using System.IO;
using System.Linq;
using System.Text;
namespace BinaryTree
{
    public class BinaryTree
    {
        public class Item
        {
            public int high;
            public int info;
            public Item lSon, rSon, father;
            public Item(int x)
            {
                info = x;
                lSon = rSon = father = null;
            }
        }

        private StreamWriter streamWriter = new StreamWriter("output.txt");

        private Item root = null;

        
        public BinaryTree()
        {
            root = null;
        }

        public BinaryTree(int value)
        {
            root = new Item(value);
        }

        private bool Find(int x, out Item p)
        {
            p = root;
            Item q = p;
            while (q != null)
            {
                p = q;
                if (q.info == x)
                    return true;
                if (q.info < x)
                    q = q.rSon;
                else
                    q = q.lSon;
            }
            return false;
        }

        public void High(Item node)
        {
            if (node.lSon == null && node.rSon == null) { return; }
            if (node.lSon != null) 
            {
                node.high = node.lSon.high + 1;
            }
            if (node.rSon != null)
            {
                node.high = node.rSon.high + 1;
            }
            if (node.lSon != null && node.rSon != null) 
            {
                node.high = Math.Max(node.lSon.high, node.rSon.high) + 1; // нашли все высоты
            }


            preOrder(node.lSon);
            preOrder(node.rSon);

            streamWriter.WriteLine(node.info);
        }
        public bool Find(int x)
        {
            Item p;
            return Find(x, out p);
        }
        public bool Insert(int x)
        {
            Item r, p;
            if (root == null)
            {
                r = new Item(x);
                root = r;
                return true;
            }
            if (Find(x, out r))
                return false;
            p = new Item(x);
            p.father = r;
            if (r.info < x)
                r.rSon = p;
            else
                r.lSon = p;
            return true;
        }
       /* private void deleteItem(Item x)
        {
            if (x.father == null)
                if (x.lSon != null)
                {
                    root = x.lSon;
                    x.lSon.father = null;
                }
                else
                {
                    root = x.rSon;
                    if (x.rSon != null)
                        x.rSon.father = null;
                }
            else
            if (x.father.lSon == x)
                if (x.lSon != null)
                {
                    x.father.lSon = x.lSon;
                    x.lSon.father = x.father;
                }
                else
                {
                    x.father.lSon = x.rSon;
                    if (x.rSon != null)
                        x.rSon.father = x.father;
                }
            else
                if (x.lSon != null)
            {
                x.father.rSon = x.lSon;
                x.lSon.father = x.father;
            }
            else
            {
                x.father.rSon = x.rSon;
                if (x.rSon != null)
                    x.rSon.father = x.father;
            }
            x.father = x.lSon = x.rSon = null;
        }
        public bool Delete(int x)
        {
            Item r, p;
            if (!Find(x, out r))
                return false;
            if ((r.lSon == null) || (r.rSon == null))
            {
                deleteItem(r);
                return true;
            }
            p = r.lSon;
            while (p.rSon != null)
                p = p.rSon;
            r.info = p.info;
            deleteItem(p);
            return true;
        }*/

        public void leftOrder(BinaryTree tree)
        {
            tree.preOrder(root);
        }

        private void preOrder(Item node)
        {
            if (node == null) { return; }

            streamWriter.WriteLine(node.info);

            preOrder(node.lSon);
            preOrder(node.rSon);
        }
    }
    class Program
    {
        static void Main(string[] args)
        {
            BinaryTree tree = new BinaryTree();
            HashSet<long> numbers = new HashSet<long>();
            int num = 0;

            using (var sr = new StreamReader("input.txt"))
            {
                string ch;
                while (!sr.EndOfStream)
                {
                    ch = sr.ReadLine();
                    num = int.Parse(ch);
                    numbers.Add(num);
                }
            }

            tree.leftOrder(tree);
           // tree.finalize();
        }
    }
}
