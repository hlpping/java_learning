package chap03.JButton;

import java.awt.Font;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;

public class JButton_demo {
	public static void main(String[] args) {
		
		test1();
		
		test2();
		
	}

	private static void test2() {
		JFrame frame = new JFrame("Welcome To MLDN") ;	// 实例化窗体对象
		
		String picPath = "d:" + File.separator + "hua.jpg" ;
		Icon icon = new ImageIcon(picPath) ;
		JButton but = new JButton(icon) ;
		
		frame.add(but) ;
		frame.setSize(300,160) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test1() {
		JFrame frame = new JFrame("Welcome To MLDN") ;	// 实例化窗体对象
		
		JButton but = new JButton("按我") ;	 
		Font fnt = new Font("Serief",Font.BOLD,28);
		but.setFont(fnt) ;
		
		frame.add(but) ;
		frame.setSize(200,70) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
}
