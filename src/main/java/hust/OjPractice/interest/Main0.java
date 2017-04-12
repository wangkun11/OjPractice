package hust.OjPractice.interest;

import java.util.Scanner;

/**
 * 最长回文子序列问题:动态规划解法
 * 
 * @author Administrator
 *
 */
public class Main0 {
	private static int lps(String string) {
		int legth = string.length();
		int[][] l = new int[legth][legth];// l[i][j]表示第i个字符到第j个字符之间最长的回文字符串的长度
		for (int i = 0; i < legth; i++) {
			l[i][i] = 1;
		}
		for (int i = 1; i < l.length; i++) {
			for (int j = 0; j < l.length - i; j++) {
				if (string.charAt(j) == string.charAt(j + i)) {
					l[j][j + i] = l[j + 1][j + i - 1] + 2;
				} else
					l[j][j + i] = Math.max(l[j][j + i - 1], l[j + 1][j + i]);
			}
		}
		return l[0][legth - 1];
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			System.out.println(string.length()-lps(string));
		}
		scanner.close();
	}
}
