package chap03;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.FlowLayout;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSlider;
import javax.swing.JTextField;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;

public class SliderTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				SliderFrame frame = new SliderFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class SliderFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 350;
	public static final int DEFAULT_HEITH = 450;
	public static final int FONTSIZE = 12;
	
	private JPanel sliderPanel;
	private JTextField textField;
	private ChangeListener listener;
	
	public SliderFrame() {
		setTitle("Slider");
		setSize(DEFAULT_WIDTH, DEFAULT_HEITH);

		sliderPanel = new JPanel();
		sliderPanel.setLayout(new FlowLayout(FlowLayout.LEFT));
		
		listener = new ChangeListener() {
			public void stateChanged(ChangeEvent e) {
				JSlider source = (JSlider) e.getSource();
				textField.setText(""+source.getValue());
			}
		};
		
		JSlider slider = new JSlider();
		addSlider(slider,"plain");
		textField = new JTextField();
		add(sliderPanel,BorderLayout.CENTER);
		add(textField,BorderLayout.SOUTH);
		
	}
	
	private void addSlider(JSlider slider,String description){
		
		slider.addChangeListener(listener);
		JPanel panel = new JPanel();
		panel.add(slider);
		panel.add(new JLabel(description));
		sliderPanel.add(panel);
	}
}