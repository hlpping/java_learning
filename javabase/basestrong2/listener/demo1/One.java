package basestrong2.listener.demo1;

import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.JFrame;

public class One extends JFrame{
	public static void main(String[] args) {		
		new One();
	}
	One(){
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent e) {				
				System.out.println(">>>"+e.getSource());
				//super.windowClosing(e);
				System.exit(0);
				//System.out.println("over");
			}
		});		
		setSize(200,200);
		setVisible(true);
		System.out.println("<<<"+this);
	}
}
