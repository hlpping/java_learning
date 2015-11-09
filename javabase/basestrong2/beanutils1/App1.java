package basestrong2.beanutils1;

public class App1 {

	public static void main(String[] args) {

		//vo对象 接收jsp页面表单的数据,模拟
		EmpForm empForm=new EmpForm();
		empForm.setId("1");
		empForm.setName("zhang");
		empForm.setSex("男");
		empForm.setTel("13467897666");
		
		//po对象
		Emp emp=new Emp();
		
		//vo对象的值复制到po中
		emp.setId(Integer.parseInt(empForm.getId()));
		emp.setName(empForm.getName());
		emp.setSex(empForm.getSex());
		emp.setTel(empForm.getTel());
		
		
	   //测试,输出emp对象的数据
  	   System.out.println(emp.getId());
  	   System.out.println(emp.getName());
		
	}

}
