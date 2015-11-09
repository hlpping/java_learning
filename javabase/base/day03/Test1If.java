package base.day03;

import java.io.IOException;

import org.junit.Test;

public class Test1If {
	@Test
	public void readChar() throws IOException {
		int b = System.in.read();
		if (b >= 65 && b <= 90) {
			System.out.println("您输入的是一个大写字母");
		} else if (b >= 97 && b <= 122) {
			System.out.println("您输入的是小写字母.");
		} else {
			System.out.println("不是英文字母");
		}
	}

	@Test
	public void oddOrNot() {
		int x = 6;

		if (x % 2 == 0) { // 如果满足条件, 则执行
			System.out.println("这是一个偶数");
		} else { // 如果没满足上面的条件, 则执行
			System.out.println("这是一个奇数");
		}
		System.out.println("运行结束");
	}

	@Test
	public void Weekday() {
		int x = 4;

		switch (x) { // x满足哪一个case, 就从哪一个开始执行,
						// switch后的()中只能判断byte,short,char,int. 枚举
		default:
			System.out.println("出错了");
			break;
		case 1:
			System.out.println("星期一");
			break; // 中断, 不再执行下面的代码
		case 2:
			System.out.println("星期二");
			break;
		case 3:
			System.out.println("星期三");
			break;
		case 4:
			System.out.println("星期四");
			break;
		case 5:
			System.out.println("星期五");
			break;
		case 6:
			System.out.println("星期六");
			break;
		case 7:
			System.out.println("星期日");
			break;
		}

	}
}
