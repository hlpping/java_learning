package chap08.Event;

import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;
import javax.swing.JScrollPane;
import javax.swing.JTextArea;

class MyKeyHandle01 extends JFrame implements KeyListener{
	private JTextArea text = new JTextArea() ;
	public MyKeyHandle01(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;
		text.addKeyListener(this) ;
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	// 加入事件
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
	public void keyPressed(KeyEvent e){
		text.append("键盘“" + KeyEvent.getKeyText(e.getKeyCode())+ "”键按下\n") ;
	}

	public void keyReleased(KeyEvent e){
		text.append("键盘“" + KeyEvent.getKeyText(e.getKeyCode())+ "”键松开\n") ;
	}

	public void keyTyped(KeyEvent e){
		text.append("输入的内容是：" + e.getKeyChar() + "\n") ;
	} 
};

class MyKeyHandle02 extends JFrame{
	private JTextArea text = new JTextArea() ;
	public MyKeyHandle02(){
		super.setTitle("Welcome To MLDN") ;
		JScrollPane scr = new JScrollPane(text) ;
		scr.setBounds(5,5,300,200) ;
		super.add(scr) ;
		text.addKeyListener(new KeyAdapter(){
			public void keyTyped(KeyEvent e){
				text.append("输入的内容是：" + e.getKeyChar() + "\n") ;
			} 
		}) ;
		super.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e){
				System.exit(1) ;
			}
		}) ;	// 加入事件
		super.setSize(310,210) ;
		super.setVisible(true) ;
	}
	
};


public class MyKeyEvent_demo{
	public static void main(String args[]){
		new MyKeyHandle01() ;
		new MyKeyHandle02() ;
	}
};