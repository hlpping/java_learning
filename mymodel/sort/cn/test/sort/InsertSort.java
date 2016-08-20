package cn.test.sort;

public class InsertSort {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		// TODO Auto-generated method stub
		int a[] = { 49, 38, 65, 97, 76, 13, 27, 49, 78, 34, 12, 64, 5, 4, 62,
				99, 98, 54, 56, 17, 18, 23, 34, 15, 35, 25, 53, 51};
		long t1 = System.currentTimeMillis();
		sort(a);
		long t2 = System.currentTimeMillis();
		System.out.println(t2-t1);
	}
	
	/**
	 * 直接插入排序
	 * @param a
	 */
	public static void sort(int[] a) {

		int temp = 0;
		for (int i = 1; i < a.length; i++) {
			for (int j = 0; j < i-1 ; j++) {
				if (a[i] < a[j]) {
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
