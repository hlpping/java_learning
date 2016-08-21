package chap03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 * JCheckBox JLabel
 * 
 */
public class CheckboxTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CheckboxFrame frame = new CheckboxFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class CheckboxFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEITH = 200;
	public static final int FONTSIZE = 12;
	
	private JLabel label;
	private JCheckBox bold;
	private JCheckBox italic;
	
	public CheckboxFrame() {
		setTitle("Checkbox");
		setSize(DEFAULT_WIDTH, DEFAULT_HEITH);

		label = new JLabel("xxxxxxxxxxxxxxxxxx");
		label.setFont(new Font("Serif",Font.PLAIN,FONTSIZE));
		add(label,BorderLayout.CENTER);
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int mode = 0;
				if(bold.isSelected()) mode +=Font.BOLD;
				if(italic.isSelected()) mode +=Font.ITALIC;
				label.setFont(new Font("Serif",mode,FONTSIZE));
			}
		};
		
		JPanel buttonPanel = new JPanel();
		bold = new JCheckBox("Bold");
		italic = new JCheckBox("Italic");
		bold.addActionListener(listener);
		italic.addActionListener(listener);
		
		buttonPanel.add(bold);
		buttonPanel.add(italic);
		
		add(buttonPanel,BorderLayout.SOUTH);
		
	}
}