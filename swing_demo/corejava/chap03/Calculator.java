package chap03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JPanel;

public class Calculator {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				CalculatorFrame frame = new CalculatorFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class CalculatorFrame extends JFrame {

	public CalculatorFrame() {
		setTitle("calculator");
		CalculatorPanel panel = new CalculatorPanel();
		add(panel);
		pack();
	}

}

@SuppressWarnings("serial")
class CalculatorPanel extends JPanel {

	private JButton display;
	private JPanel panel;
	private double result;
	private String lastCommand;
	private boolean start;

	public CalculatorPanel() {
		// 初始化
		setLayout(new BorderLayout());
		result = 0;
		lastCommand = "=";
		start = true;

		display = new JButton("0");
		display.setEnabled(false);
		add(display, BorderLayout.NORTH);

		ActionListener insert = new InsertAction();
		ActionListener command = new CommandAction();

		panel = new JPanel();
		panel.setLayout(new GridLayout(4, 4));

		addButton("7", insert);
		addButton("8", insert);
		addButton("9", insert);
		addButton("/", command);

		addButton("4", insert);
		addButton("5", insert);
		addButton("6", insert);
		addButton("*", command);

		addButton("1", insert);
		addButton("2", insert);
		addButton("3", insert);
		addButton("-", command);

		addButton("0", insert);
		addButton(".", insert);
		addButton("=", command);
		addButton("+", command);

		add(panel, BorderLayout.CENTER);

	}

	/**
	 * 添加按钮,并为按钮设置监听事件
	 * 
	 * @param label
	 * @param listener
	 */
	private void addButton(String label, ActionListener listener) {
		JButton button = new JButton(label);
		button.addActionListener(listener);
		panel.add(button);
	}

	/**
	 * 计算
	 * 
	 * @param x
	 */
	private void calculate(double x) {
		if (lastCommand.equals("+"))
			result += x;
		else if (lastCommand.equals("-"))
			result -= x;
		else if (lastCommand.equals("*"))
			result *= x;
		else if (lastCommand.equals("/"))
			result /= x;
		else if (lastCommand.equals("="))
			result = x;
		display.setText("" + result);
	}

	private class InsertAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String input = e.getActionCommand();
			if (start) {
				display.setText("");
				start = false;
			}
			display.setText(display.getText() + input);
		}

	}

	private class CommandAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			String command = e.getActionCommand();
			if (start) {
				if (command.equals("-")) {
					display.setText(command);
					start = false;
				} else
					lastCommand = command;
			} else {
				calculate(Double.parseDouble(display.getText()));
				lastCommand = command;
				start = true;
			}
		}

	}

}