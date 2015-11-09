package base.day11_API;

import org.junit.Test;

public class ArraySort {
	@Test
	public void test(){
		
	}
	// 选择排序, 每次选择一个最大的, 放在最前面
	static void selectSort(int[] arr){
		for(int j=0; j<arr.length-1; j++){
			int maxPos=j;
			
			
			
			
			
		}
	}
	
	
	
	
	
	
	static void exchange(int[] arr, int pos1, int pos2){
		int temp = arr[pos1];		// 定义一个中间变量, 记住其中一个
		arr[pos1] = arr[pos2];		// 然后让这个位置上记住另一个
		arr[pos2] = temp;			// 再让另一个位置记住中间变量中保存的值
	}
	
	static String toString(int[] arr){
		StringBuffer sb = new StringBuffer();	// 定义一个容器, 用来存放结果
		sb.append("{");							// 添加一个开始大括号
		for(int i=0; i<arr.length; i++){		// 定义循环遍历数组
			sb.append(arr[i]);					// 将每一个元素都添加到容器
			sb.append(",");						// 每添加一个元素, 都添一个逗号
		}
		sb.deleteCharAt(sb.length() - 1);		// 将最后的一个逗号删除.
		sb.append("}");							// 添加结束大括号
		// System.out.println(sb);					// 将容器中的内容打印
		return sb.toString();					// 将容器中的内容转成字符串返回
	}
}
