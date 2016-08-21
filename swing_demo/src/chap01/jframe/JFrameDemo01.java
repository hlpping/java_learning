package chap01.jframe;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Point;

import javax.swing.JFrame;


public class JFrameDemo01 {
	public static void main(String args[]) {
//		test1();
		
//		test2();
		
	}

	private static void test2() {
		JFrame f = new JFrame("第一个Swing窗体") ;
		Dimension d = new Dimension() ;
		d.setSize(230,80) ;
		f.setSize(d) ;	// 设置组件的大小
		f.setBackground(Color.WHITE) ;	// 将背景设置成白色
		Point p = new Point(300,200) ;	// 指定组件的显示位置
		f.setLocation(p) ;	// 设置组件的显示位置
		f.setVisible(true) ;	// 让组件可见
	}

	private static void test1() {
		JFrame f = new JFrame("第一个Swing窗体");
		f.setSize(230, 80); // 设置组件的大小
		f.setBackground(Color.WHITE); // 将背景设置成白色
		f.setLocation(300, 200); // 设置组件的显示位置
		f.setVisible(true); // 让组件可见
	}
};