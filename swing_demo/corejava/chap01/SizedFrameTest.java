package chap01;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Image;
import java.awt.Toolkit;

import javax.swing.JFrame;

public class SizedFrameTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SizedFrame frame = new SizedFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}
class SizedFrame extends JFrame{
	public SizedFrame(){
		Toolkit kit = Toolkit.getDefaultToolkit();
		Dimension screenSize = kit.getScreenSize();
		int screenHeigth =screenSize.height;
		int screenWidth =screenSize.width;
		
		setSize(screenWidth/2,screenHeigth/2);
		setLocationByPlatform(true);
		Image image = kit.getImage("icon.gif");
		setIconImage(image);
		setTitle("sizedFrame");
	}
	
}
