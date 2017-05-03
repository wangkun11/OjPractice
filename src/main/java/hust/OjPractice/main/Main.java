package hust.OjPractice.main;

import java.util.Scanner;

public class Main {
	private static int change(String string) {
		int result = 0;
		int p = 0;
		for (int i = string.length() - 1; i >= 2; i--) {
			int x = 0;
			switch (string.charAt(i)) {
			case 'A':
				x = 10;
				break;
			case 'B':
				x = 11;
				break;
			case 'C':
				x = 12;
				break;
			case 'D':
				x = 13;
				break;
			case 'E':
				x = 14;
				break;
			case 'F':
				x = 15;
				break;
			default:
				x = string.charAt(i)-'0';
			}

			System.out.println(x);
			result += x * Math.pow(16, p++);
		}
		return result;
	}

	public static void main(String[] args) {
		Scanner scanner = new Scanner(System.in);
		while (scanner.hasNext()) {
			String string = scanner.nextLine();
			System.out.println(change(string));
		}
		scanner.close();
	}
}
