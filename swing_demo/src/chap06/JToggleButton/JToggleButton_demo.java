package chap06.JToggleButton;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JToggleButton;

public class JToggleButton_demo {
	public static void main(String[] args) {
		
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JToggleButton but1 = new JToggleButton("已选中",true) ;	 // 默认选中
		JToggleButton but2 = new JToggleButton("未选中") ;
		JToggleButton but3 = new JToggleButton("按我") ;
		frame.setLayout(new GridLayout(3,1)) ;	// 设置排版样式
		frame.add(but1) ;
		frame.add(but2) ;
		frame.add(but3) ;
		frame.setSize(200,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
		
	}
}
