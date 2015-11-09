package base.day20_GUI;

import java.awt.Button;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class AddButtonDemo {
	/*
	 * 创建一个窗体, 窗体上有一个按钮.
	 * 点击这个按钮时, 可以添加新按钮.
	 * 点击新按钮时, 删除新按钮.
	 * 提示: 如果窗体已经显示, 这时再向上添加或删除按钮, 需要刷新, 再次调用 frame.setVisible(true);
	 */
	public static void main(String[] args) {
		// 创建窗体
		final Frame frame = new Frame();
		frame.setLayout(new FlowLayout());
		frame.setSize(400, 300);
		frame.setLocation(200, 100);
		
		Button button=new Button("Add Button");
		frame.add(button);
		button.addActionListener(new ActionListener(){
			private int i;
			public void actionPerformed(ActionEvent e) {
				final Button newButton=new Button("Add Button");
				frame.add(newButton);
				frame.setVisible(true);
				
				newButton.addActionListener(new ActionListener(){
					public void actionPerformed(ActionEvent e) {
						// 在新按钮的监听器中处理按钮的事件, 如果点击, 那么删除. Frame.remove(Component com). 刷新
						frame.remove(newButton);
						frame.setVisible(true);
					}});
			}});
		// 显示
		frame.setVisible(true);
	}
}
