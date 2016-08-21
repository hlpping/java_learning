package chap05.Panel;

import java.awt.BorderLayout;
import java.awt.Container;
import java.io.File;

import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JDesktopPane;
import javax.swing.JFrame;
import javax.swing.JInternalFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JScrollPane;
import javax.swing.JSplitPane;
import javax.swing.JTabbedPane;

public class JPanel_demo {
	public static void main(String[] args) {
		
//		test_jpanel();
		
//		test_jscrollpane();
		
//		test_JSplitPane();
		
//		test_JTabbedPane();
		
//		test_JDesktopPane();
		
	}

	private static void test_JDesktopPane() {
		JFrame frame = new JFrame("Welcome TO MLDN") ; // 实例化窗体对象
		Container cont = frame.getContentPane() ;
		JDesktopPane desk = new JDesktopPane() ;	// 定义窗体的容器
		cont.add(desk,BorderLayout.CENTER) ;	// 设置显示样式
		cont.add(new JLabel("内部窗体"),BorderLayout.SOUTH) ;
		JInternalFrame jif = null ;
		String picPath = "d:" + File.separator + "mldn.gif" ;
		Icon icon = new ImageIcon(picPath) ;	// 实例化Icon对象
		JPanel pan = null ;
		for(int i=0;i<3;i++){
			jif = new JInternalFrame("MLDN-" + i,true,true,true,true) ;
			pan = new JPanel() ;
			pan.add(new JLabel(icon)) ;	// 加入标签
			jif.setLocation(35 - i * 10 , 35 - i * 10) ; // 设置显示位置
			jif.add(pan) ;
			jif.pack() ;
			jif.setVisible(true) ;
			desk.add(jif) ;
		}

		frame.setSize(230,120) ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test_JTabbedPane() {
		JFrame frame = new JFrame("Welcome TO MLDN") ; // 实例化窗体对象
		Container cont = frame.getContentPane() ;
		JTabbedPane tab = null ;
		tab = new JTabbedPane(JTabbedPane.TOP) ;// 设置标签在顶部显示
		JPanel pan1 = new JPanel() ;
		JPanel pan2 = new JPanel() ;
		JButton but = new JButton("按钮") ;
		JLabel lab = new JLabel("标签") ;
		pan1.add(but) ;
		pan2.add(lab) ;
		String picPath = "d:" + File.separator + "logo.gif" ;
		tab.addTab("图片选项",new ImageIcon(picPath),pan1,"图象") ;
		tab.addTab("文字选项",pan2) ;	
		cont.add(tab) ;
		frame.setSize(330,120) ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test_JSplitPane() {
		JFrame frame = new JFrame("Welcome TO MLDN") ; // 实例化窗体对象
		Container cont = frame.getContentPane() ;
		JPanel pan = new JPanel() ;	// 准备好了一个面板
		JSplitPane lfsplit = null ;	// 左右分割
		JSplitPane tpsplit = null ;	// 上下分割

		lfsplit = new JSplitPane(JSplitPane.HORIZONTAL_SPLIT,new JLabel("左标签"),new JLabel("右标签")) ;
		lfsplit.setDividerSize(3) ;	// 设置左右分割条的分割线大小
		tpsplit = new JSplitPane(JSplitPane.VERTICAL_SPLIT,lfsplit,new JLabel("下标签")) ;
		tpsplit.setDividerSize(10) ;	// 设置左右分割条的分割线大小
		tpsplit.setOneTouchExpandable(true) ;
		cont.add(tpsplit) ;
		frame.pack() ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test_jscrollpane() {
		JFrame frame = new JFrame("Welcome TO MLDN") ; // 实例化窗体对象
		Container cont = frame.getContentPane() ;
		String picPath = "d:" + File.separator + "mldn.gif" ;
		Icon icon = new ImageIcon(picPath) ;	// 实例化Icon对象
		JPanel pan = new JPanel() ;
		JLabel lab = new JLabel(icon) ;
		JScrollPane scr1 = null ;
		// 设置垂直和水平的滚动条一直显示
		scr1 = new JScrollPane(pan,JScrollPane.VERTICAL_SCROLLBAR_ALWAYS ,
				JScrollPane.HORIZONTAL_SCROLLBAR_ALWAYS) ;
		pan.add(lab) ;
		cont.add(scr1) ;
		frame.setSize(230,120) ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}

	private static void test_jpanel() {
		JFrame frame = new JFrame("Welcome TO MLDN") ; // 实例化窗体对象
		JPanel pan = new JPanel() ;	// 准备好了一个面板
		// 现在所有的内容都加入到了JPanel之中
		pan.add(new JLabel("标签-A")) ;
		pan.add(new JLabel("标签-B")) ;
		pan.add(new JLabel("标签-C")) ;
		pan.add(new JButton("按钮-X")) ;
		pan.add(new JButton("按钮-Y")) ;
		pan.add(new JButton("按钮-Z")) ;
		frame.add(pan) ;// 将面板加入到窗体之上
		frame.pack() ;// 根据组件自动调整大小
		frame.setLocation(300,200) ;
		frame.setVisible(true) ;
	}
}
