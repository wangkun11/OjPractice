package hust.OjPractice.Sort;

import java.util.Arrays;

public class MySort {
	/**
	 * 1、冒泡排序 i指向每次冒泡冒上去的位置，都是当前最大的数 内层for循环对相连的两个数做判断，每次都把大一些的数往后移 时间复杂度：O(n*n)
	 */
	public static void bubbleSort(int[] a) {
		// int a[]={49,38,65,97,76,13,27,49,78,34,12,64,5,4};
		for (int i = a.length - 1; i > 0; i--) {
			for (int j = 0; j < i; j++) {
				if (a[j] > a[j + 1])
					switchIJ(a, j, j + 1);
			}
		}
	}

	/*
	 * 2、快速排序： 快速排序 两个过程： 1、找一个数作为中间数P（中间数可以随便选，为了方便直接选第一个）
	 * 将数组中所有比P小的放到P的左边，比P大的放到P的右边 然后然后再对左右两边重复执行这个过程
	 * 
	 * 因此可以理解为，快排的每一次操作都是将数组划分为两部分，左边是前minddle小元素的子数组，右边是前minddle大元素的子数组
	 */
	public static void quickSort(int[] a, int low, int high) {
		// 当low=high时，子数组中只有一个元素，表示递归结束
		// 此处的递归结束条件可以优化，当子数组比较小的时候可以改用其它排序算法(if(low<high-k){插入排序})
		if (low < high) {
			int minddle = getMiddle(a, low, high);// 找到中间点的同时，将数组进行了粗略的排序
			quickSort(a, low, minddle - 1);// 对左半部分递归快排
			quickSort(a, minddle + 1, high);// 对右半部分递归快排
		}
	}

	public static int getMiddle(int[] a, int low, int high) {
		int key = a[low]; // 取中间数
		while (low < high) {
			// 从high开始往前遍历，遇到值小于key的，就放到a[low]中去
			while (low < high && a[high] >= key) {
				high--;
			}
			a[low] = a[high];
			// 从low开始往后遍历，遇到值大于key的，就放到a[high]中去
			while (low < high && a[low] <= key) {
				low++;
			}
			a[high] = a[low];
		}
		a[low] = key;// 此时low=high,并且位置为切分的基准位置，左边的都比它小，右边的都比它大
		return low;
	}

	/*
	 * 3、选择排序: 每次从未排序部分选择当前最小的元素添加到已排序元素末尾
	 */
	public static void selectSort(int[] a) {
		for (int i = 0; i < a.length; i++) {
			int k = i;
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[k]) {
					k = j;// 记录当前未排序部分的最小值位置即可
				}
			}
			switchIJ(a, i, k);
		}
	}

	/*
	 * 4、堆排序 堆排序是对直接选择排序的改进，
	 */
	public static void heapSort(int[] a) {
		buildMaxHeap(a, a.length);// 建堆:初始化最大堆
		for (int i = a.length - 1; i > 0; i--) {
			switchIJ(a, i, 0); // 交换堆顶和最后一个元素:堆顶保存当前最大元素(第0个元素永远是堆顶)
			adjustHeap(a, 0, i); // 调整堆：每次交换了之后都要重新建堆
		}
	}
	public static void buildMaxHeap(int[] a, int size) {
		for (int i = (size - 2) / 2; i >= 0; i--) {// 最后一个节点的父节点开始依次调整
			adjustHeap(a, i, size);
		}
	}
	public static void adjustHeap(int[] a, int i, int size) {
		// 即每次调整都是从父节点、左孩子节点、右孩子节点三者中选择最大者跟父节点进行交换
		// 交换之后可能造成被交换的孩子节点不满足堆的性质，因此每次交换之后要对被交换的孩子节点进行递归处理			
		if (i<=(size-2)/2) {//非叶子结点才需要调整
			int left=2*i+1;//左子节点下标
			int right=2*i+2;//右子节点下标
			int max=i;//初始化父节点、左右子节点三者中的最大值的索引
			if(left<size&&a[left]>a[max]) max=left;
			if(right<size&&a[right]>a[max]) max=right;
			if(max!=i){
				switchIJ(a, max, i);
				adjustHeap(a, max, size);
			}
		}
	}
	/*
	 * 5、插入排序 跟整理扑克一样，按照顺序依次将未排序值插入到已排序值的合适位置 插入的时候是从后往前移动
	 */
	public static void insertSort(int[] a) {
		int temp = 0;
		int j = 0;
		for (int i = 1; i < a.length; i++) {
			temp = a[i];
			// 将前面的值依次往后移动
			for (j = i; j > 0 && a[j - 1] > temp; j--) {
				a[j] = a[j - 1];
			}
			a[j] = temp;
		}
	}

	/*
	 * 6、希尔排序 希尔排序（插入排序的升级版）：对插入排序的优化，
	 * 使数组中任意间隔h的元素都是有序，避免了插入排序只能相邻交换的弊端，当h为1时即排序结束 时间复杂度：O(N的3/2次方) （由h序列来决定）
	 * 空间复杂度：不需要额外空间
	 */
	public static void shellSort(int[] a) {
		int N = a.length;
		int h = 1;
		while (h < N / 3) {
			h = 3 * h + 1; // 1,4,13,40,121,364,1093
		}
		while (h >= 1) {
			for (int i = h; i < N; i++) {
				// 隔着h个元素进行交换，保证排序完后为h有序，当h递减为1时，则整体有序了
				for (int j = i; j >= h && a[j] < a[j - h]; j -= h) {
					switchIJ(a, j, j - h);
				}

			}
			h = h / 3; // h会由最初值（假设为40）逐步递减到1，那么40、13、4、1被称为h序列
		}
	}

	public static void main(String[] args) {
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4 };
		// bubbleSort(a);
		// quickSort(a,0,a.length-1);
		// selectSort(a);
		// insertSort(a);
		heapSort(a);
		System.out.println(Arrays.toString(a));
	}

	public static void switchIJ(int[] a, int i, int j) {
		int k = a[i];
		a[i] = a[j];
		a[j] = k;
	}
}
