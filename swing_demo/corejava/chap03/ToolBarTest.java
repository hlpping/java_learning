package chap03;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.Icon;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JPanel;
import javax.swing.JToolBar;

public class ToolBarTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				ToolBarFrame frame = new ToolBarFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class ToolBarFrame extends JFrame {
	
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEITH = 200;

	private JPanel panel;

	public ToolBarFrame() {
		setTitle("ToolBar");
		setSize(DEFAULT_WIDTH, DEFAULT_HEITH);

		panel = new JPanel();
		add(panel, BorderLayout.CENTER);

		Action blueAction = new ColorAction("Blue", new ImageIcon("blue-ball.gif"), Color.BLUE);
		Action yellowAction = new ColorAction("Yellow", new ImageIcon("yellow-ball.gif"), Color.YELLOW);
		Action redAction = new ColorAction("Red", new ImageIcon("red-ball.gif"), Color.RED);
		Action exitAction = new AbstractAction("Exit",new ImageIcon("exit.gif")) {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		};
		exitAction.putValue(Action.SHORT_DESCRIPTION, "Exit");
		
		JToolBar bar = new JToolBar();
		bar.add(blueAction);
		bar.add(yellowAction);
		bar.add(redAction);
		bar.addSeparator();
		bar.add(exitAction);
		add(bar,BorderLayout.NORTH);
		
		JMenu menu = new JMenu("Color");
		menu.add(blueAction);
		menu.add(yellowAction);
		menu.add(redAction);
//		menu.addSeparator();
		menu.add(exitAction);
		JMenuBar bar2 = new JMenuBar();
		bar2.add(menu);
		setJMenuBar(bar2);
		
	}

	class ColorAction extends AbstractAction {

		public ColorAction(String name, Icon icon, Color c) {
			putValue(Action.NAME, name);
			putValue(Action.SMALL_ICON, icon);
			putValue(Action.SHORT_DESCRIPTION, name + " background");
			putValue("Color", c);
		}

		public void actionPerformed(ActionEvent e) {
			Color c = (Color) getValue("Color");
			panel.setBackground(c);
		}
	}

}