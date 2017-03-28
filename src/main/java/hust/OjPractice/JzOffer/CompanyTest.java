package hust.OjPractice.JzOffer;

public class CompanyTest {
	/**
	 * 题目 有一个直方图，用一个整数数组表示，其中每列的宽度为1，求所给直方图包含的最大矩形面积。比如，对于直方图[2,7,9,4],
	 * 它所包含的最大矩形的面积为14(即[7,9]包涵的7x2的矩形)。
	 * 给定一个直方图A及它的总宽度n，请返回最大矩形面积。保证直方图宽度小于等于500。保证结果在int范围内。 测试样例： [2,7,9,4,1],5
	 * 返回：14
	 * 
	 * 解法思路：动态规划，做一次for循环，每次都保存包含该值的最大面积；
	 */

	public int countArea(int[] a, int n){
		int maxArea=0;
		int min;
		for (int i = 0; i < a.length; i++) {
			min=Integer.MAX_VALUE;
			for (int j = i; j >=0; j--) {
				min=Math.min(min, a[j]);
				maxArea=Math.max(maxArea, (i-j+1)*min);
			}
		}
		return maxArea;
	}
	public static void main(String[] args) {
		
	}
}
