package hust.OjPractice.JzOffer;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class JzOffer1 {
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
	 * 中序遍历的根节点位置在中间p，在p左边的肯定是node的左子树的中序数组，p右边的肯定是node的右子树的中序数组 递归可解 注：中序+前序可重建
	 * 中序+后续可重建，但是前序+后续不可重建
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
				// 中序遍历的左边为父节点的左子树，右边为右子树
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

	// =====================================================================================
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
		if (stack1.empty() && stack2.empty()) {
			throw new RuntimeException("The Queue Is Empty!");
		}
		if (stack2.empty()) {
			while (!stack1.isEmpty()) {
				stack2.push(stack1.pop());
			}
		}
		return stack2.pop();
	}

	// ================================================================================================
	/**
	 * 题目五：大家都知道斐波那契数列，现在要求输入一个整数n，请你输出斐波那契数列的第n项。
	 * 
	 * 解法：可以用递归，但是递归比较耗空间，可直接使用循环
	 */
	public static int Fibonacci(int n) {
		if (n <= 0) {
			return 0;
		} else if (n <= 1) {
			return 1;
		} else {
			int f0 = 0;
			int f1 = 1;
			int fn = 1;
			for (int i = 2; i <= n; i++) {
				fn = f0 + f1;
				f0 = f1;
				f1 = fn;
			}
			return fn;
		}
	}

	// ================================================================================================
	/**
	 * 题目六：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 解析：对于第n个台阶来说，只能从n-1或者n-2的台阶跳上来，所以 F(n) = F(n-1) + F(n-2) 转换为斐波拉契数序列了，
	 * 初始条件 n=1:只能一种方法 n=2:两种
	 * 
	 * 注：对于一个复杂问题要想办法将复杂问题分解为简单的子问题
	 */
	public int JumpFloor(int target) {
		if (target <= 0) {
			return 0;
		}
		if (target == 1) {
			return 1;
		}
		if (target == 2) {
			return 2;
		}
		int first = 1, second = 2, third = 3;
		for (int i = 3; i <= target; i++) {
			third = first + second;
			first = second;
			second = third;
		}
		return third;
	}

	// ================================================================================================
	/**
	 * 题目七：一只青蛙一次可以跳上1级台阶，也可以跳上2级……它也可以跳上n级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
	 * 
	 * 解法一：思路同常规青蛙跳，所以 F(n) = F(1) + F(2)+。。。+F(n-1)+1 转换为斐波拉契数序列了， 初始条件
	 * n=1:只能一种方法 n=2:两种
	 * 
	 * 注：对于一个复杂问题要想办法将复杂问题分解为简单的子问题
	 */
	public static int JumpFloorII(int target) {
		int[] f = new int[target];
		f[0] = 1;
		for (int i = 1; i < f.length; i++) {
			f[i] = 1;
			for (int j = 0; j < i; j++) {
				f[i] += f[j];
			}
		}
		return f[target - 1];
	}

	/**
	 * 解法二：对于每阶台阶青蛙可以选择跳或者不跳(最后一阶必须跳)，台阶之间不会有相互影响，所以总跳法应该是2^n-1
	 */
	public static int JumpFloorII2(int target) {
		if (target < 1)
			return 0;
		else
			return 1 << (target - 1);
	}

	// ===================================================================================================
	/**
	 * 题目八：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
	 * 
	 * 解法：依旧是斐波那契数列
	 */
	public int RectCover(int target) {
		return 0;
	}

	// ===================================================================================================
	/**
	 * 题目九：输入一个整数，输出该数二进制表示中1的个数。其中负数用补码表示。
	 * 
	 * 解法一：位运算 如果一个整数不为0，那么这个整数至少有一位是1。如果我们把这个整数减1，那么原来处在整数最右边的1就会变为0，
	 * 原来在1后面的所有的0都会变成1(如果最右边的1后面还有0的话)。 其余所有位将不会受到影响。 举个例子：
	 * 一个二进制数1100，从右边数起第三位是处于最右边的一个1。减去1后，第三位变成0，它后面的两位0变成了1，而前面的1保持不变，
	 * 因此得到的结果是1011.我们发现减1的结果是把最右边的一个1开始的所有位都取反了。这个时候如果我们再把原来的整数和减去1之后的结果做与运算，
	 * 从原来整数最右边一个1那一位开始所有位都会变成0
	 * 。如1100&1011=1000.也就是说，把一个整数减去1，再和原整数做与运算，会把该整数最右边一个1变成0.
	 * 那么一个整数的二进制有多少个1，就可以进行多少次这样的操作。
	 */
	public int NumberOf1(int n) {
		int count = 0;
		while (n != 0) {
			count++;
			n = n & (n - 1);
		}
		return count;
	}

	// ===================================================================================================
	/**
	 * 题目十：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有的奇数位于数组的前半部分，所有的偶数位于位于数组的后半部分，
	 * 并保证奇数和奇数，偶数和偶数之间的相对位置不变。
	 * 
	 * 解法1：冒泡排序的思路，将所有奇数依次冒泡到数组前半部分，不需要另外开辟存储空间
	 */
	public static void reOrderArray(int[] array) {
		int temp;
		for (int i = 0; i < array.length; i++) {
			// 若array[i]为奇数，则向前冒泡 ,偶数跳过
			if (array[i] % 2 == 0) continue;
			for (int j = i; j >= 1; j--) {
				//遇到偶数则交换，否则说明已经冒泡到最上面
				if (array[j-1] % 2 == 0) {
					temp = array[j];
					array[j] = array[j-1];
					array[j-1] = temp;					
				}
			}
		}
	}
	/**
	 * 解法二：空间换时间：依次将奇数和偶数分别放到不同的队列中去，然后合并到原数组
	 */
	public static void reOrderArray1(int[] array) {
		Queue<Integer> a=new LinkedList<Integer>();
		Queue<Integer> b=new LinkedList<Integer>();
		for (int i = 0; i < array.length; i++) {			
			if (array[i] % 2 == 0) b.add(array[i]);
			else a.add(array[i]);			
		}
		int i=0;
		for (Integer integer : a) {
			array[i++]=integer;
		}
		for (Integer integer : b) {
			array[i++]=integer;
		}
	}
}
