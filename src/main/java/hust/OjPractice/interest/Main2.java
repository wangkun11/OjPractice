package hust.OjPractice.interest;

import java.util.Arrays;
import java.util.Scanner;

public class Main2 {
	//差最大的对数
	private static int function1(int[] a) {
		Arrays.sort(a);		
		int max=1;
		int min=1;
		for (int i = 1; i < a.length; i++) {
			if (a[i]==a[0]) min++;
			else break;
		}
		for (int i = a.length-2; i >=0; i--) {
			if (a[i]==a[a.length-1]) max++;
			else break;
		}
		return max*min;
	}
	//差最小的对数
	private static int function2(int[] a) {
		Arrays.sort(a);		
		int k=1;
		int min=0;
		for (int i = 1; i < a.length; i++) {
			if (a[i]-a[i-1]<min) min=a[i]-a[i-1];
		}
		for (int i = 1; i < a.length; i++) {
			if (a[i]-a[i-1]==min) k++;
		}
		return k;
	}
	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			scanner.nextLine();
			String string = scanner.nextLine();
			String[] strings=string.split(" ");
			int[] a=new int[strings.length];
			for (int i = 0; i < a.length; i++) {
				a[i]=Integer.valueOf(strings[i]);
			}
			System.out.println(function2(a)+" "+function1(a));
		}
		scanner.close();
	}
}
