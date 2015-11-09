package basestrong.unchangedparam;


public class UnChangeTest {
	public static void main(String[] args) {
		String[] str=new String[]{"jone","bama","haha","sina"};
		Grade g=new Grade(str);
		
		str[0]="aassaaa";
		str[1]=null;
		g.call();
	}
}
