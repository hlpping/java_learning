package base.day17_IO4_other;

public class Student implements Comparable<Student> {

	private String name;
	private int chinese;
	private int math;
	private int english;
	private int sum; 

	public Student(String name, int chinese, int math, int english) {
		this.name = name;
		this.chinese = chinese;
		this.math = math;
		this.english = english;
		this.sum = chinese + math + english;
	}

	public String toString() {
		return name + ", " + chinese + ", " + math + ", " + english + ", " + sum;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public int getChinese() {
		return chinese;
	}

	public void setChinese(int chinese) {
		this.chinese = chinese;
	}

	public int getMath() {
		return math;
	}

	public void setMath(int math) {
		this.math = math;
	}

	public int getEnglish() {
		return english;
	}

	public void setEnglish(int english) {
		this.english = english;
	}

	public int getSum() {
		return sum;
	}

	public void setSum(int sum) {
		this.sum = sum;
	}

	public int compareTo(Student o) {
		int sumGap = o.sum - this.sum;
		return sumGap != 0 ? sumGap : 1; 
		// 如果总分相同, 那么就返回1, 返回1就是存右边
	}

}
