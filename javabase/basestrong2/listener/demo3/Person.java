package basestrong2.listener.demo3;

public class Person {
	private PersonListener pl;
	
	public void eat(){
		if(pl!=null){		
			pl.eating(new PersonEvent(this));		
		}
		System.out.println("eat..........");
	}
	
	public void addPersonListener(PersonListener pl){
		this.pl=pl;
	}
}
//监听器
interface PersonListener{
	
	public void eating(PersonEvent e);
}


//事件源对象
class PersonEvent{
	private Object o;
	
	public PersonEvent(Object o){
		this.o=o;
	}
	
	public Object getSource(){
		return o;
	}
}
