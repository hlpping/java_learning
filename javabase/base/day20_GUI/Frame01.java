package base.day20_GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.Toolkit;

public class Frame01 {
	public static void main(String[] args) {
		
		Frame frame =new Frame();
		frame.setSize(400, 200);
		frame.setLocation(200, 100);
		frame.setIconImage(Toolkit.getDefaultToolkit().createImage("src/day20_GUI/png-0015.png"));
		frame.setTitle("这是标题"); // 设置标题

		frame.setLayout(new FlowLayout()); // 将Frame布局设置为流式布局
		
		Button button = new Button("这是一个按钮");
		frame.add(button); // Frame默认布局是BorderLayout边界布局, 我们未指定放在哪个位置, 默认是Center

		frame.setVisible(true); // 设置窗口可见
				
	}
}
