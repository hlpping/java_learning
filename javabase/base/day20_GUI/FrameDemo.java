package base.day20_GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.awt.Toolkit;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;

public class FrameDemo {
public static void main(String[] args) throws InterruptedException {
		
		final Frame frame = new Frame("这是标题"); // 创建一个窗体, 最初不可见, 默认是BorderLayout
		frame.setSize(400, 300); // 设置尺寸
		frame.setLocation(200, 100); // 设置位置
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/day20_GUI/300png016.png")); // 设置图标
		frame.setLayout(new FlowLayout()); // 设置为流式布局

		Button button1 = new Button("关闭"); // 创建一个按钮
		frame.add(button1); // 在frame上添加一个按钮

		Button button2 = new Button("第二个按钮");
		frame.add(button2);

		frame.addWindowListener(new MyWindowListener()); // 添加窗体监听器
		//		button1.addMouseListener(new MyMouseListener()); // 添加鼠标事件
		//		button1.addKeyListener(new MyKeyListener());
		button1.addActionListener(new MyActionListener()); // 添加高级事件监听器, 如果添加到按钮上, 那么只要按钮被点击, 就执行事件处理器

		MenuBar menuBar = new MenuBar(); // 创建一个菜单栏
		Menu menu = new Menu("File"); // 创建一个菜单
		MenuItem newMenuItem = new MenuItem("New"); // 创建菜单项
		MenuItem exitMenuItem = new MenuItem("Exit");

		menu.add(newMenuItem); // 将菜单项添加到菜单中
		menu.add(exitMenuItem);
		menuBar.add(menu); // 将菜单添加到菜单栏中

		frame.setMenuBar(menuBar); // 为窗体设置菜单栏

		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.setVisible(true);
	}

}

class MyActionListener implements ActionListener {

	public void actionPerformed(ActionEvent e) {
		Button button = (Button) e.getSource();
		Frame frame = (Frame) button.getParent();
		frame.dispose();
	}

}

class MyKeyListener implements KeyListener {

	public void keyPressed(KeyEvent e) {
	}
	public void keyReleased(KeyEvent e) {
		if (e.getKeyCode() == KeyEvent.VK_SPACE) { // 判断按下的按钮如果是空格
			Button button = (Button) e.getSource();
			Frame frame = (Frame) button.getParent();
			frame.dispose();
		}
	}
	public void keyTyped(KeyEvent e) {
	}
}

class MyMouseListener implements MouseListener {

	public void mouseClicked(MouseEvent e) {
		System.out.println("点击");
		Button button = (Button) e.getSource(); // 获取事件源
		Frame frame = (Frame) button.getParent(); // 获取Button所在的容器
		frame.dispose();
	}
	public void mouseEntered(MouseEvent e) {
		System.out.println("进入");
	}
	public void mouseExited(MouseEvent e) {
		System.out.println("移出");
	}
	public void mousePressed(MouseEvent e) {
		System.out.println("按下");
	}
	public void mouseReleased(MouseEvent e) {
		System.out.println("抬起");
	}
}

class MyWindowListener implements WindowListener { // 自定义监听器, 实现WindowListener接口.

	public void windowActivated(WindowEvent e) {
		System.out.println("激活");
	}

	public void windowClosed(WindowEvent e) {
		System.out.println("已经关闭");
	}

	public void windowClosing(WindowEvent e) { // 当窗体上发生想要关闭事件的时候, 会执行此方法
		System.out.println("正在关闭");
		e.getWindow().dispose(); // 获取事件源, 调用关闭方法.
	}

	public void windowDeactivated(WindowEvent e) {
		System.out.println("后台");
	}

	public void windowDeiconified(WindowEvent e) {
		System.out.println("从最小化恢复");
	}

	public void windowIconified(WindowEvent e) {
		System.out.println("最小化");
	}

	public void windowOpened(WindowEvent e) {
		System.out.println("打开");
	}

}