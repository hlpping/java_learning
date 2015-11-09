package basestrong2.model;

public class LazySingleton {

	private static LazySingleton lazySingleton;	//null
	private LazySingleton(){}
	
	public static LazySingleton getInstance(){
		// 第一次调用时lazySingleton为空,对其初始化
		if(lazySingleton==null){
			lazySingleton=new LazySingleton();
		}
		return lazySingleton;
	}
}
