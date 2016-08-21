package chap02.JLable;

import java.awt.Color;
import java.awt.Dimension;
import java.awt.Font;
import java.awt.Point;
import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class JLable_demo {
	public static void main(String[] args) {
		
//		test1();
		
//		test2();
		
//		test3();
		
//		test4();
		
	}

	private static void test4() {
		JFrame frame = new JFrame("Welcome To MLDN") ;

		String picPath = "d:" + File.separator + "hua.jpg" ;

		Icon icon = new ImageIcon(picPath) ;
		JLabel lab = new JLabel("MLDN",icon,JLabel.CENTER) ;	// 实例化标签对象
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,28) ;
		lab.setFont(fnt) ;
		lab.setForeground(Color.RED) ;
		lab.setBackground(Color.YELLOW) ;//设置窗体的背景颜色
		frame.add(lab) ;	// 将组件件入到面板之中
		Dimension dim = new Dimension() ;
		frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色
		dim.setSize(300,160) ;
		frame.setSize(dim) ;
		Point point = new Point(300,200) ;	// 设置坐标
		frame.setLocation(point) ;
		frame.setVisible(true) ;
	}

	private static void test3() {
		JFrame frame = new JFrame("Welcome To MLDN") ;

		String picPath = "d:" + File.separator + "hua.jpg" ;
		File file = new File(picPath) ;	// 实例化File类的对象
		InputStream input = null ;
		byte b[] = new byte[(int)file.length()] ;
		try{
			input = new FileInputStream(file) ;
			input.read(b) ;
			input.close() ;
		}catch(Exception e){
			e.printStackTrace() ;
		}
		Icon icon = new ImageIcon(b) ;
		JLabel lab = new JLabel("MLDN",icon,JLabel.CENTER) ;	// 实例化标签对象
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,28) ;
		lab.setFont(fnt) ;
		lab.setForeground(Color.RED) ;
		lab.setBackground(Color.YELLOW) ;//设置窗体的背景颜色
		frame.add(lab) ;	// 将组件件入到面板之中
		Dimension dim = new Dimension() ;
		frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色
		dim.setSize(300,160) ;
		frame.setSize(dim) ;
		Point point = new Point(300,200) ;	// 设置坐标
		frame.setLocation(point) ;
		frame.setVisible(true) ;
	}

	private static void test2() {
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JLabel lab = new JLabel("MLDN",JLabel.CENTER) ;	// 实例化标签对象
		Font fnt = new Font("Serief",Font.ITALIC + Font.BOLD,28) ;
		lab.setFont(fnt) ;
		frame.add(lab) ;	// 将组件件入到面板之中
		Dimension dim = new Dimension() ;
		frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色
		dim.setSize(200,70) ;
		frame.setSize(dim) ;
		Point point = new Point(300,200) ;	// 设置坐标
		frame.setLocation(point) ;
		frame.setVisible(true) ;
	}

	private static void test1() {
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JLabel lab = new JLabel("MLDN",JLabel.CENTER) ;	// 实例化标签对象
		frame.add(lab) ;	// 将组件件入到面板之中
		Dimension dim = new Dimension() ;
		frame.setBackground(Color.WHITE) ;//设置窗体的背景颜色
		dim.setSize(200,70) ;
		frame.setSize(dim) ;
		Point point = new Point(300,200) ;	// 设置坐标
		frame.setLocation(point) ;
		frame.setVisible(true) ;
	}
}
