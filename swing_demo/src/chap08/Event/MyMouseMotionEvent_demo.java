package chap08.Event;

import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionAdapter;
import java.awt.event.MouseMotionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

class MyMouseMotionHandle01 extends JFrame{
	public MyMouseMotionHandle01(){
		super.setTitle("Welcome To MLDN") ;
		super.addMouseMotionListener(new MouseMotionListener(){
			public void mouseDragged(MouseEvent e){
				System.out.println("鼠标拖拽到：X = " + e.getX() + "，Y = " + e.getY()) ;
			}
			public void mouseMoved(MouseEvent e){
				System.out.println("鼠标移动到窗体。") ;
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

class MyMouseMotionHandle02 extends JFrame{
	public MyMouseMotionHandle02(){
		super.setTitle("Welcome To MLDN") ;
		super.addMouseMotionListener(new MouseMotionAdapter(){
			public void mouseDragged(MouseEvent e){
				System.out.println("鼠标拖拽到：X = " + e.getX() + "，Y = " + e.getY()) ;
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


public class MyMouseMotionEvent_demo{
	public static void main(String args[]){
		new MyMouseMotionHandle01() ;
		new MyMouseMotionHandle02() ;
	}
};