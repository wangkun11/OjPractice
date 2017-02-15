package hust.OjPractice.JzOffer;

public class JzOffer {
	/**
	 *一、 题目描述:
	 * 在一个二维数组中，每一行都按照从左到右递增的顺序排序，每一列都按照从上到下递增的顺序排序。
	 * 请完成一个函数，输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
	 * 
	 * 解法：
	 * 1、直接双重for循环、循环每一行，行内二分查找、先对整个数组排序，然后二分查找
	 * 2、高效的解法：利用到数组本身的递增逻辑，直接查找，从左下或者右上开始，
	 * 右上思路：比当前值小，则向左移动，比当前值大，则向下移动
	 */	
	public static boolean Find(int target, int [][] array) {
		int row=0;
		int col=array[0].length-1;
		while (row<array.length&&col>=0) {
			if (target>array[row][col]) row++;
			else if (target<array[row][col]) col--;
			else return true;
		}
		return false;
    }
}
