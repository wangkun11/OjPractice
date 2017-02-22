package hust.OjPractice;

import hust.OjPractice.JzOffer.JzOffer;

public class Test{
	@org.junit.Test
	public void testJzOffer() {
		/*int[][] array={
				{1,2,8,9},
				{2,4,9,12},
				{4,7,10,13},
				{6,8,11,15}
		};
		System.out.println(JzOffer.Find(5, array));*/
		int[] n={1,2,3,4,5,6,7};
		JzOffer.reOrderArray1(n);
		for (int i = 0; i < n.length; i++) {
			System.out.print(n[i]);
		}
	} 
}
