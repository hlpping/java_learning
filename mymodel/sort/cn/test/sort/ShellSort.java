package cn.test.sort;

public class ShellSort {
	public static void main(String[] args) {

		int a[] = { 1, 54, 6, 3, 78, 34, 12, 45, 56, 100 };
		sort(a);
	}
	/**
	 *   希尔排序（最小增量排序）
	 * @param a
	 */
	public static void sort(int[] a) {
		double d1 = a.length;
		int temp = 0;
		while (true) {
			d1 = Math.ceil(d1 / 2);
			int d = (int) d1;
			for (int x = 0; x < d; x++) {
				for (int i = x + d; i < a.length; i += d) {
					for (int j = i - d; j >= 0 && a[i] < a[j]; j -= d) {
						temp = a[i];
						a[i] = a[j];
						a[j] = temp;
					}
				}
			}
			if (d == 1)
				break;
		}
		for (int i = 0; i < a.length; i++)
			System.out.println(a[i]);
	}
}
