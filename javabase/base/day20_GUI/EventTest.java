package base.day20_GUI;

import java.awt.Frame;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class EventTest {
	public static void main(String[] args) {
		Frame frame =new Frame();
		frame.setSize(400, 300);
		
		frame.addWindowListener(new WindowAdapter(){
			public void windowClosing(WindowEvent e) {
//				super.windowClosing(e);
//				main(new String[] {});
				e.getWindow().dispose(); // 获取事件源, 调用关闭方法.
			}
		});
		// 窗体显示
		frame.setVisible(true);		
	}
}
