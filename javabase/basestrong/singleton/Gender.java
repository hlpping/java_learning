package basestrong.singleton;

public class Gender {
	
	private Gender(){}
	private static Gender MALE; 
	private static Gender FEMALE; 
	
	public static Gender getMale(){
		if(MALE==null)
			MALE=new Gender();
		return MALE;
	}
	
	public static Gender getFemale(){
		if(FEMALE==null)
			FEMALE=new Gender();
		return FEMALE;
	}
	
	
}
