using System;
using System.Collections.Generic;
using System.Linq;
using System.Text;
namespace BinaryTree
{
    /// <summary>
    /// Класс "Бинарное поисковое дерево"
    /// </summary>
    public class Tree
    {
        /// <summary>
        /// Класс "узел БПД"
        /// </summary>
        private class Item
        {
            /// <summary>
            /// info - значение, хранящееся в узле
            /// lSon, rSon, father - ссылки на левого, правого сына и отца
            /// </summary>
            public int info;
            public Item lSon, rSon, father;
            /// <summary>
            /// Конструктор узла БПД
            /// </summary>
            /// <param name="x">значение, хранящееся в узле</param>
            public Item(int x)
            {
                info = x;
                lSon = rSon = father = null;
            }
        }

        /// <summary>
        /// ссылка на корень дерева
        /// </summary>
        private Item root;

        /// <summary>
        /// конструктор дерева
        /// </summary>
        public Tree()
        {
            root = null;
        }

        /// <summary>
        /// внутренняя процедура поиска
        /// </summary>
        /// <param name="x">искомое значение</param>
        /// <param name="p">ели найдено - ссылка на соответствующий узел, иначе - ссылка на то место, где остановились</param>
        /// <returns>нашли или нет</returns>
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

        /// <summary>
        /// внешняя процедура поиска
        /// </summary>
        /// <param name="x">искомое значение</param>
        /// <returns>нашли или нет</returns>
        public bool Find(int x)
        {
            Item p;
            return Find(x, out p);
        }

        /// <summary>
        /// втавка в БПД
        /// </summary>
        /// <param name="x">вставляемое значение</param>
        /// <returns>смогли вставить или нет</returns>
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

        /// <summary>
        /// удалить вершину (оборвать все ссылки)
        /// </summary>
        /// <param name="x">удаляемая вершина</param>
        private void deleteItem(Item x)
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

        /// <summary>
        /// Удалить вершину по значению
        /// </summary>
        /// <param name="x">удаляемое значение</param>
        /// <returns>смогли удалить или нет</returns>
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
        }

        public bool Palindrome()
        {
            if (root != null)
            {
                Stack<KeyValuePair<Item, int>> nodes = new Stack<KeyValuePair<Item, int>>();
                KeyValuePair<Item, int> kvp = new KeyValuePair<Item, int>(root, 1);
                nodes.Push(kvp);
                while (nodes.Count != 0)
                {
                    if (is_Palindrome(nodes.Peek().Key.info))
                        Console.WriteLine("Значение узла:{1}, Номер уровня:{0}", nodes.Peek().Value, nodes.Peek().Key.info);
                    nodes.Pop();
                    if (kvp.Key.lSon != null)
                        nodes.Push(new KeyValuePair<Item, int>(kvp.Key.lSon, kvp.Value + 1));
                    if (kvp.Key.rSon != null)
                        nodes.Push(new KeyValuePair<Item, int>(kvp.Key.rSon, kvp.Value + 1));
                    if (nodes.Count != 0)
                        kvp = nodes.Peek();
                }
            }
            return false;
        }

        private bool is_Palindrome(int x)
        {
            string word = x.ToString();
            int len = word.Length;
            for (int i = 0; i < len / 2; ++i)
            {
                if (word[i] != word[len - i - 1])
                {
                    return false;
                }
            }
            return true;
        }


    }
}