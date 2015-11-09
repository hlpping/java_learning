package basestrong2.listener.demo2;

public class Person {
	private PersonListener pl;
	
	public void eat(){
		if(pl!=null){		
			pl.eating();		
		}
		System.out.println("eat..........");
	}
	
	public void addPersonListener(PersonListener pl){
		this.pl=pl;
	}
}
interface PersonListener{
	
	public void eating();
}
