package hust.OjPractice.main;

import java.util.LinkedList;
import java.util.Queue;

class BinaryTree {
	private class Node {
		int value;
		Node left;
		Node right;

		public Node(int value) {
			this.value = value;
			left = null;
			right = null;
		}
	}

	private Node root = null;

	// 构造方法，使用数组构造
	public BinaryTree(int[] a) {
		for (int i = 0; i < a.length; i++) {
			insert(a[i]);
		}
	}

	// 按顺序直接插入
	public void insert(int value) {
		if (root == null) {
			root = new Node(value);
			return;
		}
		Node p = root;
		while (p != null) {
			if (value < p.value) {
				if (p.left == null) {
					p.left = new Node(value);
					break;
				} else {
					p = p.left;
				}
			} else {
				if (p.right == null) {
					p.right = new Node(value);
					break;
				} else {
					p = p.right;
				}
			}
		}
	}

	// 获取根节点
	public Node getRoot() {
		return this.root;
	}

	// 深度优先->前序遍历(递归)
	public void preOrder(Node node) {
		System.out.print(node.value + " ");
		if (node.left != null)
			preOrder(node.left);
		if (node.right != null)
			preOrder(node.right);
	}

	// 深度优先->中序遍历（递归）
	public void inOrder(Node node) {
		if (node.left != null)
			inOrder(node.left);
		System.out.print(node.value + " ");
		if (node.right != null)
			inOrder(node.right);
	}

	// 深度优先->后序遍历（递归）
	public void postOrder(Node node) {
		if (node.left != null)
			postOrder(node.left);
		if (node.right != null)
			postOrder(node.right);
		System.out.print(node.value + " ");
	}

	// 广度优先（非递归）：用队列实现
	public void breadthFirst(Node root) {
		Queue<Node> queue = new LinkedList<Node>();
		queue.offer(root);
		Node p;
		while (!queue.isEmpty()) {
			p = queue.poll();
			System.out.print(p.value + " ");
			if (p.left != null)
				queue.offer(p.left);
			if (p.right != null)
				queue.offer(p.right);
		}
	}

	// 深度优先->前序遍历（非递归）
	public void preOrderNoRecursion(Node node) {
		LinkedList<Node> stack = new LinkedList<Node>();
		stack.push(node);
		Node p;
		while (!stack.isEmpty()) {
			p = stack.pop();
			System.out.print(p.value + " ");
			if (p.right != null)
				stack.push(p.right);
			if (p.left != null)
				stack.push(p.left);
		}
	}

	// 深度优先->中序遍历（非递归）
	public void inOrderNoRecursion(Node node) {
		LinkedList<Node> stack = new LinkedList<Node>();
		Node p=node;
		while (p!=null||!stack.isEmpty()) {
			while (p!=null) {
				stack.push(p);
				p=p.left;
			}
			p = stack.pop();
			System.out.print(p.value + " ");
			p=p.right;
		}
	}
	//深度优先->后序遍历
	public void postOrderNoRecursion(Node node) {
		LinkedList<Node> stack = new LinkedList<Node>();
		Node p=node;
		Node rightNode=null;
		while (p!=null||!stack.isEmpty()) {
			while (p!=null) {
				stack.push(p);
				p=p.left;
			}
			p = stack.pop();//先暂时弹出
            // 当前结点没有右结点或上一个结点（已经输出的结点）是当前结点的右结点，则输出当前结点  
            while (p.right == null || p.right == rightNode) {  
                System.out.print(p.value + " ");  
                rightNode = p;  
                if (stack.isEmpty()) {  
                    return; //root已输出，则遍历结束  
                }  
                p = stack.pop();
            }  
            stack.push(p); //跳出上面的While循环，说明还有右结点没有遍历 ，再次压栈
            p = p.right;  
		}
	}
}

public class MyBinaryTreeTraverse {

	public static void main(String[] args) {
		// 定义一个二叉树结构，并实现其元素插入方法
		int[] a = { 5, 2, 7, 4, 3, 6, 1, 8, 9 };
		BinaryTree binaryTree = new BinaryTree(a);
		//binaryTree.preOrder(binaryTree.getRoot());
		//binaryTree.inOrder(binaryTree.getRoot());
		//binaryTree.postOrder(binaryTree.getRoot());
		//binaryTree.breadthFirst(binaryTree.getRoot());
		//binaryTree.preOrderNoRecursion(binaryTree.getRoot());
		//binaryTree.inOrderNoRecursion(binaryTree.getRoot());
		binaryTree.postOrderNoRecursion(binaryTree.getRoot());
	}
}
