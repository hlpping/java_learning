package db;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.io.InputStreamReader;


/**
 * 计算KB转M
 * @author SKS
 *
 */
public class comM {

	/**
	 * @param args
	 * @return 
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		for(int i=0;i<100;i++){
			System.out.println("请输入一个十进制的数:");	
			BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
			String str = br.readLine();
			long num = Long.parseLong(str);
			float result = (float)(num/1024.0)/1024;
			System.out.println("M:");	
			System.out.println(result);
			
		}
	}

}
