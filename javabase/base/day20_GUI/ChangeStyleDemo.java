package base.day20_GUI;

import java.awt.Button;
import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.Frame;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class ChangeStyleDemo {
	public static void main(String[] args) {
		final Frame frame = new Frame();
		frame.setLayout(new FlowLayout());
		frame.setSize(600, 400);
		frame.setLocation(200, 100);

		Button red = new Button("中国红");
		Button green = new Button("绿野仙踪");
		Button blue = new Button("蓝色妖姬");

		red.setBackground(Color.RED);
		green.setBackground(Color.GREEN);
		blue.setBackground(Color.BLUE);

		frame.add(red);
		frame.add(green);
		frame.add(blue);
/****************************************************/
		StyleListener sl = new StyleListener();
		KeyListener1 kl = new KeyListener1();

		red.addMouseListener(sl);
		green.addMouseListener(sl);
		blue.addMouseListener(sl);

		red.addKeyListener(kl);
		green.addKeyListener(kl);
		blue.addKeyListener(kl);

		frame.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				e.getWindow().dispose();
			}
		});

		frame.setVisible(true);
	}
}
class KeyListener1 extends KeyAdapter{
	public void keyReleased(KeyEvent e) {
		if(e.getKeyCode()==KeyEvent.VK_F5)
			((Button)e.getSource()).getParent().setBackground(Color.WHITE);
	}
}
class StyleListener extends MouseAdapter{
	private Color defaultColor =Color.WHITE;
	public void mouseClicked(MouseEvent e) {
		Button button =(Button) e.getSource();
		defaultColor=button.getBackground();
	}
	public void mouseEntered(MouseEvent e) {
		Button button =(Button) e.getSource();
		button.getParent().setBackground(button.getBackground());
	}
	public void mouseExited(MouseEvent e) {
		Button button =(Button) e.getSource();
		button.getParent().setBackground(defaultColor);	
	}
}



