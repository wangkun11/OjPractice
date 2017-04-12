package hust.OjPractice.interest;

import java.util.Scanner;

public class Main1 {
	private static void function(char[] string) {
		for (int i = string.length - 1; i >= 0; i--) {
			if (string[i] >= 'A' && string[i] <= 'Z') {
				int k = i;
				while (k + 1 < string.length && (string[k + 1] <= 'z'&&string[k+1]>='a')) {					
					swap(string, k, k + 1);
					k++;
				}
			}
		}
	}

	private static void swap(char[] string, int i, int j) {
		char temp = string[i];
		string[i] = string[j];
		string[j] = temp;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			char[] a = string.toCharArray();
			function(a);
			System.out.println(a);
		}
		scanner.close();
	}
}
