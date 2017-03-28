package hust.OjPractice.JzOffer;

import java.util.Scanner;

public class JzOffer2 extends JzOffer1 {

	/**
	 * 题目11：输入一个链表，输出该链表中倒数第k个结点。
	 * 
	 * 解法：使用两个指针，让两个指针保持距离为K，那么当前一个移动到末尾时，后面那个就是倒数第K个了
	 */
	public ListNode FindKthToTail(ListNode head, int k) {
		if(k<=0||head==null) return null;
		ListNode p1 = head;
		ListNode p2 = head;
		//p2向前移动k个节点
		while (k-- != 1) {   //主意此处 k--!=1 是先做比较运算再做自减运算
			if (p2.next == null)
				return null;
			p2 = p2.next;
		}
		while (p2.next != null) {
			p1 = p1.next;
			p2 = p2.next;
		}
		return p1;
	}
	
	public static void main(String[] args) {
		Scanner scanner=new Scanner(System.in);
		String string=scanner.nextLine();
		
	}
}
