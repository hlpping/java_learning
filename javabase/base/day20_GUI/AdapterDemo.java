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
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AdapterDemo {
	public static void main(String[] args) {
		final Frame frame = new Frame("这是标题"); // 创建一个窗体, 最初不可见,
												// 默认是BorderLayout
		frame.setSize(400, 300); // 设置尺寸
		frame.setLocation(200, 100); // 设置位置
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage(
				"src/day20_GUI/300png016.png")); // 设置图标
		frame.setLayout(new FlowLayout()); // 设置为流式布局

		Button button1 = new Button("关闭"); // 创建一个按钮
		frame.add(button1); // 在frame上添加一个按钮
		Button button2 = new Button("第二个按钮");
		frame.add(button2);

		MenuBar menuBar = new MenuBar(); // 创建一个菜单栏
		Menu menu = new Menu("File"); // 创建一个菜单
		MenuItem newMenuItem = new MenuItem("New"); // 创建菜单项
		MenuItem exitMenuItem = new MenuItem("Exit");

		menu.add(newMenuItem); // 将菜单项添加到菜单中
		menu.add(exitMenuItem);
		menuBar.add(menu); // 将菜单添加到菜单栏中

		frame.setMenuBar(menuBar); // 为窗体设置菜单栏

		frame.addWindowListener(new WindowAdapter() { // 这是一个抽象类, 但没有抽象方法,
														// 所有的方法全是空的实现,
														// 子类需要哪个再重写就可以.
					public void windowClosing(WindowEvent e) {
						e.getWindow().dispose();
					}
				});

		button1.addMouseListener(new MouseAdapter() {
			public void mouseClicked(MouseEvent e) {
				frame.dispose();
			}
		});

		button1.addKeyListener(new KeyAdapter() {
			public void keyReleased(KeyEvent e) {
				if (e.getKeyCode() == KeyEvent.VK_SPACE)
					frame.dispose();
			}
		});

		exitMenuItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				frame.dispose();
			}
		});

		frame.setVisible(true);

	}
}
