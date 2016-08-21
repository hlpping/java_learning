package chap03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.ButtonGroup;
import javax.swing.JCheckBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JRadioButton;

/**
 * 
 * 
 */
public class RadioButtonTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				RadioButtonFrame frame = new RadioButtonFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class RadioButtonFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEITH = 200;
	public static final int FONTSIZE = 12;
	
//	private JLabel label;
//	private JCheckBox bold;
//	private JCheckBox italic;
	
	private JPanel buttonPanel;
	private ButtonGroup group;
	private JLabel label;
	
	public RadioButtonFrame() {
		setTitle("RadioButton");
		setSize(DEFAULT_WIDTH, DEFAULT_HEITH);

		label = new JLabel("xxxxxxxxxxxxxxxxxx");
		label.setFont(new Font("Serif",Font.PLAIN,FONTSIZE));
		add(label,BorderLayout.CENTER);
		
		buttonPanel = new JPanel();
		group = new ButtonGroup();
		
		addRadioButton("small",8);
		addRadioButton("medium",12);
		addRadioButton("large",18);
		addRadioButton("extra large",36);
		
		add(buttonPanel,BorderLayout.SOUTH);
		
	}
	
	private void addRadioButton(String name,final int size){
		
		boolean selected = size == 12;
		JRadioButton button = new JRadioButton(name,selected);
		group.add(button);
		buttonPanel.add(button);
		
		
		ActionListener listener = new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				label.setFont(new Font("Serif",Font.PLAIN,size));
			}
		};
		
		button.addActionListener(listener);
	}
}