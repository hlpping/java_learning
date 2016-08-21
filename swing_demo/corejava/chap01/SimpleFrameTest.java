package chap01;

import javax.swing.JFrame;

public class SimpleFrameTest {
	public static void main(String[] args) {
		SimpleFrame frame = new SimpleFrame();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setVisible(true);
	}
	
}

class SimpleFrame extends JFrame{
	public SimpleFrame(){
		setSize(DEFAULT_WIDTH, DEFAULT_HEITH);
	}
	public static final int DEFAULT_WIDTH =300;
	public static final int DEFAULT_HEITH =200;
}
