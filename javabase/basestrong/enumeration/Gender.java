package basestrong.enumeration;

public class Gender {
	
	private String sexName;
	private Gender(String na){
		sexName=na;
	}
	public static final Gender MALE=new Gender("男");
	public static final Gender FEMALE=new Gender("女");
	
	public String toString(){
		return "性别:"+sexName;
	}
}
