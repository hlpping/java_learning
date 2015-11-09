package basestrong2.model;

/**
 * 模板
 */
public class TemplatePattern {
	public static void main(String[] args) {
		// 想请假: 写一个子类, 创建对象, 调用run()方法.
		
//		new MyLeave().run();
		
		new LeaveTemplate(){	// 匿名内部类, 先定指定类的子类, 然后根据这个类创建对象.
			public void apply(){
				System.out.println("我要请婚嫁, 请一个月.");
			}
			public void approve(){
				System.out.println("找副总审批.");	
			}
			public void leave(){
				System.out.println("我要去渡蜜月.");	
			}
		}.run();
	}
}

// 创建模板
abstract class LeaveTemplate {
	abstract public void apply(); // 提交申请

	abstract public void approve(); // 经理审批

	abstract public void leave(); // 离开

	final public void run() {
		apply();
		approve();
		leave();
	}
}

class MyLeave extends LeaveTemplate {
	
	public void apply(){
		System.out.println("我要请病假, 休息三天");
	}
	
	public void approve(){
		System.out.println("找部门经理审批");	
	}
	
	public void leave(){
		System.out.println("去医院看病");	
	}

}