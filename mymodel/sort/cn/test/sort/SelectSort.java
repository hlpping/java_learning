package cn.test.sort;

public class SelectSort {
	public static void main(String[] args) {

		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45 };
		sort(a);
	}

	/**
	 * 简单选择排序
	 * 
	 * @param a
	 */
	public static void sort(int[] a) {
		
		int temp =0;
		for (int i = 0; i < a.length; i++) {
			for (int j = i + 1; j < a.length; j++) {
				if (a[j] < a[i]) {
					temp = a[i];
					a[i] = a[j];
					a[j] = temp;
				}
			}
		}
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
