using System;
using System.Collections.Generic;
using System.IO;

namespace bst
{
	public class BinarySearchTree
	{
		public static List<int> Nodes = new List<int>();
		class BinaryTree
		{
			public int Data;
			public BinaryTree Left, Right, Parent;
			public int Level = 0;
			public int Height;

			public BinaryTree(int data)
			{
				Data = data;
				Left = Right = Parent = null;
			}
		}
		BinaryTree _root;
		BinarySearchTree()
		{
			_root = null;
		}
		int minValue(BinaryTree root)
		{
			int minv = root.Data;
			while (root.Left != null)
			{
				minv = root.Left.Data;
				root = root.Left;
			}
			return minv;
		}
		void Insert(int data)
		{
			_root = Insert(_root, data);
		}
		BinaryTree Insert(BinaryTree root, int data)
		{
			if (root == null)
			{
				root = new BinaryTree(data);
				return root;
			}

			if (data < root.Data)
			{
				root.Left = Insert(root.Left, data, root);
			}
			else if (data > root.Data)
			{
				root.Right = Insert(root.Right, data, root);
			}
			return root;
		}
		BinaryTree Insert(BinaryTree root, int data, BinaryTree parent)
		{
			if (root == null)
			{
				root = new BinaryTree(data);
				root.Parent = parent;
				return root;
			}

			if (data < root.Data)
			{
				root.Left = Insert(root.Left, data, root);
			}
			else if (data > root.Data)
			{
				root.Right = Insert(root.Right, data, root);
			}
			return root;
		}
		void Remove(int key)
		{
			_root = Remove(_root, key);
		}
		BinaryTree Remove(BinaryTree root, int data)
		{
			if (root == null)
			{
				return root;
			}

			if (data < root.Data)
			{
				root.Left = Remove(root.Left, data);
			}
			else if (data > root.Data)
			{
				root.Right = Remove(root.Right, data);
			}
			else
			{
				if (root.Left == null)
				{
					return root.Right;
				}
				else if (root.Right == null)
				{
					return root.Left;
				}

				root.Data = minValue(root.Right);
				root.Right = Remove(root.Right, root.Data);
			}
			return root;
		}
		void ShowTree(BinaryTree node, StreamWriter sw)
		{
			if (node != null)
			{
				sw.WriteLine(node.Data);
				ShowTree(node.Left, sw);
				ShowTree(node.Right, sw);
			}
		}

		void FindHeight(BinaryTree node)
		{
			if (node != null)
			{
				FindHeight(node.Left);
				FindHeight(node.Right);
				BinaryTree left = node.Left;
				BinaryTree right = node.Right;
				if (right == null && left == null)
				{
					node.Height = 0;
				}
				else if (right != null && left == null)
				{
					node.Height = node.Right.Height + 1;
				}
				else if (right == null)
				{
					node.Height = node.Left.Height + 1;
				}
				else
				{
					node.Height = Math.Max(node.Right.Height, node.Left.Height) + 1;
				}
				/*Console.WriteLine("Node height: " + node.Height + "  Node: "+ node.Data + "  Parent: "+ (node.Parent != null?node.Parent.Data:0) + "  Sons: "+ (node.Left != null?node.Left.Data:0) + " " + (node.Right != null?node.Right.Data:0));*/
			}
		}
		List<BinaryTree> SetLevel(BinaryTree root, int middle)
		{
			List<BinaryTree> queue = new List<BinaryTree>();
			List<BinaryTree> list = new List<BinaryTree>();
			queue.Add(root);
			while (queue.Count != 0)
			{
				BinaryTree tempNode = queue[0];
				queue.RemoveAt(0);
				tempNode.Level = GetLevel(root, tempNode.Data, 0);
				if (tempNode.Level > middle)
				{
					return list;
				}
				if (tempNode.Level == middle)
				{
					if ((tempNode.Right == null && tempNode.Left == null) ||
						(tempNode.Left != null && tempNode.Right != null && (tempNode.Left.Height == tempNode.Right.Height)))
					{
						/*Console.WriteLine(tempNode.Data);*/
						list.Add(tempNode);
					}
				}
				if (tempNode.Left != null)
				{
					queue.Add(tempNode.Left);
				}
				if (tempNode.Right != null)
				{
					queue.Add(tempNode.Right);
				}
			}
			return list;
		}

		int GetLevel(BinaryTree node, int data, int level)
		{
			if (node == null)
				return 0;

			if (node.Data == data)
				return level;

			int downlevel = GetLevel(node.Left, data, level + 1);
			if (downlevel != 0)
				return downlevel;

			downlevel = GetLevel(node.Right, data, level + 1);
			return downlevel;
		}

		public static void Main(String[] args)
		{
			string line;
			StreamReader sr = new StreamReader("in.txt", System.Text.Encoding.Default);

			BinarySearchTree tree = new BinarySearchTree();
			while ((line = sr.ReadLine()) != null)
			{
				tree.Insert(int.Parse(line));
			}
			sr.Close();
			tree.FindHeight(tree._root);

			/*Console.WriteLine("HEIGHT: " + tree._root.Height);*/
			int middle = (tree._root.Height % 2 != 0) ? tree._root.Height / 2 + 1 : tree._root.Height / 2;
			/*Console.WriteLine("MIDDLE: " + middle);*/

			List<BinaryTree> list = tree.SetLevel(tree._root, middle);
			if (list.Count % 2 != 0)
			{
				/*Console.WriteLine("REMOVE node: " + list[list.Count / 2].Data);*/
				tree.Remove(tree._root, list[list.Count / 2].Data);
			}

			StreamWriter sw = new StreamWriter("out.txt", false);
			tree.ShowTree(tree._root, sw);
		}
	}
}