package chap07.JTextComponent;

import java.awt.GridLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;
import javax.swing.JTextField;

public class JTextComponent_demo {
	public static void main(String[] args) {
		
		test_JText01();
		
		test_JText02();
		
		test_JTextArea01();
		
		test_JTextArea02();
		
		test_JPassword();
	}

	private static void test_JPassword() {
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JPasswordField jpf1 = new JPasswordField() ;
		JPasswordField jpf2 = new JPasswordField() ;
		jpf2.setEchoChar('#') ;	// 设置回显
		JLabel lab1 = new JLabel("默认的回显：") ;
		JLabel lab2 = new JLabel("回显设置“#”：") ;

		lab1.setBounds(10,10,100,20) ;
		lab2.setBounds(10,40,100,20) ;
		jpf1.setBounds(110,10,80,20) ;
		jpf2.setBounds(110,40,50,20) ;

		frame.setLayout(null) ;
		frame.add(lab1) ;
		frame.add(jpf1) ;
		frame.add(lab2) ;
		frame.add(jpf2) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test_JTextArea02() {
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JTextArea jta = new JTextArea(3,10) ;	// 设置大小
		JLabel lab = new JLabel("多行文本域：") ;
		JScrollPane scr = new JScrollPane(jta,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS ) ;
		frame.setLayout(new GridLayout(2,1)) ;	// 取消布局管理器
		frame.add(lab) ;
		frame.add(scr) ;
		frame.setSize(300,150) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test_JTextArea01() {
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JTextArea jta = new JTextArea(3,10) ;	// 设置大小
		JLabel lab = new JLabel("多行文本域：") ;
		lab.setBounds(10,10,120,20) ; 
		jta.setBounds(130,10,150,100) ; 
		frame.setLayout(null) ;	// 取消布局管理器
		frame.add(lab) ;
		frame.add(jta) ;
		frame.setSize(300,150) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test_JText02() {
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JTextField name = new JTextField(30) ;
		JTextField noed = new JTextField("MLDN",10) ;
		JLabel nameLab = new JLabel("输入用户姓名：") ;
		JLabel noedLab = new JLabel("不可编辑文本：") ;
		name.setColumns(30) ;
		noed.setColumns(10) ;
		noed.setEnabled(false) ;	// 表示不可编辑

		nameLab.setBounds(10,10,100,20) ;
		noedLab.setBounds(10,40,100,20) ;
		name.setBounds(110,10,80,20) ;
		noed.setBounds(110,40,50,20) ;

		frame.setLayout(null) ;
		frame.add(nameLab) ;
		frame.add(name) ;
		frame.add(noedLab) ;
		frame.add(noed) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test_JText01() {
		JFrame frame = new JFrame("Welcome To MLDN") ;
		JTextField name = new JTextField(30) ;
		JTextField noed = new JTextField("MLDN",10) ;
		JLabel nameLab = new JLabel("输入用户姓名：") ;
		JLabel noedLab = new JLabel("不可编辑文本：") ;
		name.setColumns(30) ;
		noed.setColumns(10) ;
		noed.setEnabled(false) ;	// 表示不可编辑
		frame.setLayout(new GridLayout(2,2)) ;
		frame.add(nameLab) ;
		frame.add(name) ;
		frame.add(noedLab) ;
		frame.add(noed) ;
		frame.setSize(300,100) ;
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
}
