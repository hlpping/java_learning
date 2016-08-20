package cn.test.datastructure.chap03;

/**
 * 冒泡排序
 * @author shuang
 *
 */
public class ArrayBubble {

	private long[] arr;
	private int n;

	public ArrayBubble(int size) {
		arr = new long[size];
		n = 0;
	}

	public void insert(long value) {
		arr[n] = value;
		n++;
	}

	public void display() {
		for (int j = 0; j < n; j++) {
			System.out.print(arr[j] + " ");
		}
		System.out.println();
	}

	private void swap(int one, int two) {
		long temp = arr[one];
		arr[one] = arr[two];
		arr[two] = temp;
	}
	
	/**
	 * 冒泡排序
	 * 从左至右,比较相邻的两个元素
	 * 如果左边的元素大,则交换两个元素的位置
	 * 向右移动一个位置
	 * 
	 * 最后将最大的元素放到最后
	 * 在循环剩下的N-1个元素
	 */
	public void bubbleSort() {
		for (int out = n - 1; out > 1; out--) {
			for (int in = 0; in < out; in++)
				if (arr[in] > arr[in + 1])
					swap(in, in + 1);
		}
	}
	
	/**
	 * 选择排序
	 * 从左至右,从第二个元素开始寻找最小得元素
	 * 交换第一元素和最小元素的位置
	 * 
	 * 从第三个开始寻找
	 */
	public void selectionSort(){
		int out,in,min;
		
		for(out =0;out<n-1; out++){
			min = out;//定义第一个元素为最小
			
			//寻找最小的元素
			for(in = out+1;in<n;in++){
				if(arr[in]<arr[min])
					min = in;
			}
//			System.out.println(arr[min]);
			swap(out, min);
			
//			display();
		}
	}
	
	/**
	 * 插入排序
	 * 
	 * 
	 * 
	 * 
	 */
	public void insertSort() {
		int out, in;
		for (out = 1; out < n; out++) {
			long temp = arr[out];
			in = out;
			System.out.println("fore: "+in);
			while (in > 0 && arr[in - 1] >= temp) {
				arr[in] = arr[in - 1];
				--in;
				System.out.println("in : "+in);
			}
			arr[in] = temp;
			display();
		}
	}
	
	public static void main(String[] args) {

		int maxSize = 100; // array size
		ArrayBubble arr; // reference to array
		arr = new ArrayBubble(maxSize); // create the array

		arr.insert(77); // insert 10 items
		arr.insert(99);
		arr.insert(44);
		arr.insert(55);
		arr.insert(22);
		arr.insert(88);
		arr.insert(11);
		arr.insert(00);
		arr.insert(66);
		arr.insert(33);

		arr.display(); // display items

//		arr.bubbleSort(); // bubble sort them
		
//		arr.selectionSort();
		
		arr.insertSort();
		
		arr.display(); // display them again
	}
	
}
