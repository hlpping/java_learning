package chap04.Layout;

import java.awt.BorderLayout;
import java.awt.CardLayout;
import java.awt.Container;
import java.awt.FlowLayout;
import java.awt.GridLayout;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;

public class Layout_demo {
	public static void main(String[] args) {
		
//		test_absoluteLayout();
		
//		test_borderLayout();
		
//		test_cardLayout();
		
//		test_flowLayout();
		
//		test_gridLayout();
		
	}

	private static void test_gridLayout() {
		JFrame frame = new JFrame("Welcome To MLDN") ; 
		frame.setLayout(new GridLayout(3,5,3,3)) ;
		JButton but = null ;
		for(int i=0;i<13;i++){
			but = new JButton("按钮-"+ i) ;
			frame.add(but) ;
		}
		frame.pack() ;
		frame.setVisible(true) ;
	}

	private static void test_flowLayout() {
		JFrame frame = new JFrame("Welcome To MLDN") ; 
		frame.setLayout(new FlowLayout(FlowLayout.CENTER,3,3)) ;
		JButton but = null ;
		for(int i=0;i<9;i++){
			but = new JButton("按钮-"+ i) ;
			frame.add(but) ;
		}
		frame.setSize(280,123) ;
		frame.setVisible(true) ;
	}

	private static void test_cardLayout() {
		JFrame frame = new JFrame("Welcome To MLDN") ; 
		CardLayout card = new CardLayout() ;
		frame.setLayout(card) ;
		Container con = frame.getContentPane() ;
		con.add(new JLabel("标签-A",JLabel.CENTER),"first") ;
		con.add(new JLabel("标签-B",JLabel.CENTER),"second") ;
		con.add(new JLabel("标签-C",JLabel.CENTER),"thrid") ;
		con.add(new JLabel("标签-D",JLabel.CENTER),"fourth") ;
		con.add(new JLabel("标签-E",JLabel.CENTER),"fifth") ;
		frame.pack() ;
		frame.setVisible(true) ;
		card.show(con,"thrid") ;
		for(int i=0;i<5;i++){
			try{
				Thread.sleep(3000) ;
			}catch(InterruptedException e){}
			card.next(con) ;
		}
	}

	private static void test_borderLayout() {
		JFrame frame = new JFrame("Welcome To MLDN") ; 
		frame.setLayout(new BorderLayout(3,3)) ;
		frame.add(new JButton("东（EAST）"),BorderLayout.EAST) ;
		frame.add(new JButton("西（WEST）"),BorderLayout.WEST) ;
		frame.add(new JButton("南（SOUTH）"),BorderLayout.SOUTH) ;
		frame.add(new JButton("北（NORTH）"),BorderLayout.NORTH) ;
		frame.add(new JButton("中（CENTER）"),BorderLayout.CENTER) ;
		frame.setSize(280,123) ;
		frame.setVisible(true) ;
	}

	private static void test_absoluteLayout() {
		JFrame frame = new JFrame("Welcome To MLDN") ; 
		frame.setLayout(null) ;
		JLabel title = new JLabel("www.mldnjava.cn") ;
		JButton enter = new JButton("进入") ;
		JButton help = new JButton("帮助") ;
		frame.setSize(280,123) ;
		title.setBounds(45,5,150,20) ;
		enter.setBounds(10,30,80,20) ;
		help.setBounds(100,30,80,20) ;
		frame.add(title) ;
		frame.add(enter) ;
		frame.add(help) ;
		frame.setVisible(true) ;
	}
}
