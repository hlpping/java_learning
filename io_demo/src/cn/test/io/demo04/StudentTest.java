package cn.test.io.demo04;

import java.io.BufferedReader;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.TreeSet;

public class StudentTest {
	public static void main(String[] args) throws IOException {
		System.out.println("请输入学生信息:");

		BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));

		TreeSet<Student> set = new TreeSet<Student>();

		for (int i = 0; i < 3; i++) {
			String line = reader.readLine(); // 获取用户输入
			String[] info = line.split(",");
			Student stu = new Student(info[0], Integer.parseInt(info[1]), Integer.parseInt(info[2]), Integer.parseInt(info[3]));
			set.add(stu);
		}

		PrintWriter pw = new PrintWriter(new FileOutputStream("stu.txt"), true); // 每调用一次print方法, 调用一次flush()刷出
		for (Student s : set)
			pw.println(s); // 输出s的toString()返回值, 并且加上\r\n
		pw.close(); // 调用flush()刷出
	}
}
