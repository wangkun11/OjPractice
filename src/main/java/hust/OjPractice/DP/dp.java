package hust.OjPractice.DP;  

import java.util.Scanner;

/**
 * 动态规划问题
 * @author Administrator
 *
 */
public class DP {
	//最长公共子序列问题:公共子序列可以不连续
	private static int function(char[] str1,char[] str2) {
		int[][] len=new int[str1.length+1][str2.length+1];//new int数组时默认初始化为0		
		for (int i = 0; i < str1.length; i++) {
			for (int j = 0; j < str2.length; j++) {
				if (str1[i]==str2[j]) {
					len[i+1][j+1]=len[i][j]+1;
				}else {
					len[i+1][j+1]=Math.max(len[i][j+1], len[i+1][j]);
				}
				System.out.print("("+(i+1)+","+(j+1)+","+len[i+1][j+1]+")"+" ");
			}
			System.out.println();
		}
		return len[str1.length][str2.length];
	}
	//最长公共子串问题：公共子串必须连续
	public static String function2(char[] str1, char[] str2) {
        int[][] len = new int[str1.length+1][str2.length+1];        
        int maxlen = 0;      // 存储当前最长公共子串长度        
        int end = 0;        //存储当前最长公共子串的终止点        
        for (int i = 0; i < str1.length; i++) {
            for (int j = 0; j < str2.length; j++) {
                if (str1[i] == str2[j]) {
                	len[i+1][j+1] = len[i][j] + 1;//状态转移方程
                    if (len[i+1][j+1] > maxlen) {
                    	maxlen = len[i+1][j+1];
                        end = j;
                    }
                } else
                    len[i+1][j+1] = 0;
            }
        }
        //求出最长公共子串的起始点
        int start=end-maxlen+1;
        char[] a=new char[maxlen];
        for (int j = start; j < end+1; j++) {
            a[j-start]=str2[j];
        }
        //System.out.println(start+" "+end+" "+maxlen);
        return new String(a);
    }
	public static void main(String[] args) {
		char[] str1="acbbsdef".toCharArray();
		char[] str2="abbsced".toCharArray();
		System.out.println(function2(str2, str1));
	}
}
