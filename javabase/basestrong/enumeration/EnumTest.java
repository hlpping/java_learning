package basestrong.enumeration;

public class EnumTest {
	public static void main(String[] args) {
		// TODO Auto-generated method stub
//		Sex s1 =Sex.MALE;
//		Sex s2 =Sex.FEMALE;
//		System.out.println(s1.name());
//		System.out.println(s1);
//		System.out.println(s1.toString());
//		System.out.println(s1.ordinal());
//		System.out.println();
		
		//valueOf
//		String sex="MALE";
//		Sex s =Enum.valueOf(Sex.class,sex);
//		System.out.println(s);
		
		//values
		String sex = "MALE";		
		Sex[] gs = Sex.values();
		for(Sex g :gs){
			if(sex.equals(g.name())){
				System.err.println(g);
			}
		}
		
		
		
		
//		Gender g1=Gender.MALE;
//		Gender g2=Gender.FEMALE;
//		System.out.println(g1);
//		System.out.println(g2);
		
		
		
		
	}

}
