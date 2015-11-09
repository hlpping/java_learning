package base.day08_exception;
/*
	自定义一个偶数过滤器, 打印出所有偶数
	使用匿名内部类形式, 打印出所有大于100的数
*/
public class NumberPrinterDemo {
	public static void main(String[] args) {
		int[] arr = new int[]{12,34,34,57,6586,87,4321,123,5634,78,12};
		Printer printer=new Printer(arr);
		printer.print();
		
		printer.print(new OddFilter());
		printer.print(new EvenFilter());
		
		printer.print(new Filter(){
			public boolean accept(int i) {
				return i>100;
			}			
		});
	}
}
class Printer{
	private int[] arr;
	
	public Printer(int[] arr){
		this.arr=arr;
	}
	
	public void print(){
		for(int i=0;i<arr.length;i++)
			System.out.print(arr[i]+" ");
		System.out.println();
	}
	public void print(Filter filter ){
		for(int i=0;i<arr.length;i++){
			if(filter.accept(arr[i]))
				System.out.print(arr[i]+" ");
		}
		System.out.println();
	}	
}
interface Filter{
	boolean accept(int i);	
}
class OddFilter implements Filter{
	public boolean accept(int i) {		
		return i%2==1;
	}	
}
class EvenFilter implements Filter{	
	public boolean accept(int i) {		
		return i%2==0;
	}	
}