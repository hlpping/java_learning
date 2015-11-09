package base.day03;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.junit.Test;

public class Test4ArrayPrintMax {
	@Test
	public void test1() throws IOException {
		BufferedReader reader =new BufferedReader(new InputStreamReader(System.in));
		
		
		int[] arr =new int[3];
		for(int i=0;i<3;i++){
			String line=reader.readLine();
			arr[i] = Integer.parseInt(line);
		}
		int max=arr[0]>arr[1]? arr[0]:arr[1];
		System.out.println(arr[2]>max ? arr[2]:max);
	}
}
