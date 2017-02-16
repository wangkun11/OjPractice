package hust.OjPractice.JzOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class JzOffer {
	/**
	 * 一、 题目描述: 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * 
	 * 解法： 1、直接双重for循环、循环每一行，行内二分查找、先对整个数组排序，然后二分查找
	 * 2、高效的解法：利用到数组本身的递增逻辑，直接查找，从左下或者右上开始， 右上思路：比当前值小，则向左移动，比当前值大，则向下移动
	 */
	public static boolean Find(int target, int[][] array) {
		int row = 0;
		int col = array[0].length - 1;
		while (row < array.length && col >= 0) {
			if (target > array[row][col])
				row++;
			else if (target < array[row][col])
				col--;
			else
				return true;
		}
		return false;
	}

	// ====================================================================================================
	/**
	 * 二：题目描述：输入一个链表，从尾到头打印链表每个节点的值。
	 * 
	 * 解法1：利用递归实现从尾到头的打印输出
	 */

	public class ListNode {
		int val;
		ListNode next = null;

		ListNode(int val) {
			this.val = val;
		}
	}

	public ArrayList<Integer> printListFromTailToHead(ListNode listNode) {
		ArrayList<Integer> arrayList = new ArrayList<Integer>();
		convert(arrayList, listNode);
		return arrayList;
	}

	public void convert(ArrayList<Integer> arrayList, ListNode listNode) {
		if (listNode != null) {
			convert(arrayList, listNode.next);
			arrayList.add(listNode.val);
		}
	}

	/**
	 * 解法2：利用栈先进后出的原理
	 */
	public void convert2(ArrayList<Integer> arrayList, ListNode listNode) {
		Stack<Integer> stack = new Stack<Integer>();
		while (listNode != null) {
			stack.push(listNode.val);
			listNode = listNode.next;
		}
		while (!stack.isEmpty()) {
			arrayList.add(stack.pop());
		}
	}

	// ================================================================================
	/**
	 * 题目三:输入某二叉树的前序遍历和中序遍历的结果，请重建出该二叉树。假设输入的前序遍历和中序遍历的结果中都不含重复的数字。
	 * 例如输入前序遍历序列{1,2,4,7,3,5,6,8}和中序遍历序列{4,7,2,1,5,3,8,6}，则重建二叉树并返回。
	 * 
	 * 解法：根据二叉树的遍历规则：先序遍历第一个位置肯定是根节点node
	 * 中序遍历的根节点位置在中间p，在p左边的肯定是node的左子树的中序数组，p右边的肯定是node的右子树的中序数组
	 * 递归可解
	 * 注：中序+前序可重建   中序+后续可重建，但是前序+后续不可重建
	 */
	public class TreeNode {
		int val;
		TreeNode left;
		TreeNode right;

		TreeNode(int x) {
			val = x;
		}
	}

	public TreeNode reConstructBinaryTree(int[] pre, int[] in) {
		if (pre.length == 0 || in.length == 0) {
			return null;
		}
		TreeNode node = new TreeNode(pre[0]);
		for (int i = 0; i < in.length; i++) {
			if (pre[0] == in[i]) {
				//中序遍历的左边为父节点的左子树，右边为右子树
				node.left = reConstructBinaryTree(
						Arrays.copyOfRange(pre, 1, i + 1),
						Arrays.copyOfRange(in, 0, i));
				node.right = reConstructBinaryTree(
						Arrays.copyOfRange(pre, i + 1, pre.length),
						Arrays.copyOfRange(in, i + 1, in.length));
			}
		}
		return node;
	}

//=====================================================================================
	/**
	 * 题目四：用两个栈来实现一个队列，完成队列的Push和Pop操作。 队列中的元素为int类型
	 * 
	 * 解法思路：stack2中始终存放最早进去队列的值，当stack2中的值被pop完，才将stack1中目前的全部值弹如stack2,
	 * 而不是每次都要讲stack1中的值弹入stack2，显然这样做效率更高
	 */
	Stack<Integer> stack1 = new Stack<Integer>();
    Stack<Integer> stack2 = new Stack<Integer>();
    
    public void push(int node) {
        stack1.push(node);
    }
    
    public int pop() {
    	if(stack1.empty()&&stack2.empty()){
            throw new RuntimeException("The Queue Is Empty!");
        }    
    	if (stack2.empty()) {
    		while (!stack1.isEmpty()) {
    			stack2.push(stack1.pop());			
    		}
		}    	
    	return stack2.pop();    	
    }

//================================================================================================
    /**
     * 题目五：把一个数组最开始的若干个元素搬到数组的末尾，我们称之为数组的旋转。输入一个非递减排序的数组的一个旋转，输出旋转数组的最小元素。
     * 例如数组{3,4,5,1,2}为{1,2,3,4,5}的一个旋转，该数组的最小值为1。NOTE：给出的所有元素都大于0，若数组大小为0，请返回0。
     */
    
}
