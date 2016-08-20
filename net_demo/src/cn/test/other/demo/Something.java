package cn.test.other.demo;

public abstract class Something {
	void printString(){
//		private String s ="ok";
//		System.out.println(s);
	}
	public abstract String donotPrintString();
	
	final int i=20;
	  
	public void printInt(){
		System.out.println("i= "+i);
	}
	
	public int addInt(int x){
		return ++x;
	}
	
	public Object addObject (final MyInteger o){
		return o.i++;
	}
	
	class MyInteger{
		public int i;
	}
}

