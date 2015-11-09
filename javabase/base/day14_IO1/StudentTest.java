package base.day14_IO1;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.TreeSet;

public class StudentTest {
	public static void main(String[] args) throws IOException {
		System.out.println("请输入学生信息:");

		BufferedReader reader = new BufferedReader(new InputStreamReader(
				System.in));
		TreeSet<Student> set =new TreeSet<Student>();
		for(int i=0;i<1;i++){
			String line =reader.readLine();
			String[] info =line.split(",");
			Student stu =new Student(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]));
			set.add(stu);
		}
		BufferedWriter writer =new BufferedWriter(new FileWriter("stu.txt"));
		for(Student s: set){
			writer.write(s.toString()+"\r\n");
		}
		
		writer.close();
	}
}
