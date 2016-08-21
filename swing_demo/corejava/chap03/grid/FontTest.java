package chap03.grid;

import java.awt.EventQueue;
import java.awt.Font;
import java.awt.GridBagLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.BorderFactory;
import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextArea;

public class FontTest {
	public static void main(String[] args) {

		EventQueue.invokeLater(new Runnable() {
			public void run() {
				FontFrame frame = new FontFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class FontFrame extends JFrame {

	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEITH = 200;

	private JComboBox face;
	private JComboBox size;
	private JCheckBox bold;
	private JCheckBox italic;
	private JTextArea sample;

	public FontFrame() {
		setTitle("calculator");
		setSize(DEFAULT_WIDTH, DEFAULT_HEITH);
		
		GridBagLayout layout = new GridBagLayout();
		setLayout(layout);
		
		ActionListener listener = new FontAction();
		
		JLabel faceLabel = new JLabel("Face:");
		face = new JComboBox(new String[]{"Serif","SansSerif","Monospaced","Dialog","DialogInput"});
		face.addActionListener(listener);
		
		JLabel sizeLabel = new JLabel("Size:");
		size = new JComboBox(new String[]{"8","10","12","24","48"});
		size.addActionListener(listener);
		
		bold = new JCheckBox("Bold");
		italic = new JCheckBox("Italic");
		bold.addActionListener(listener);
		italic.addActionListener(listener);
		
		sample = new JTextArea();
		sample.setText("sdjkhfsk fsd dijsdfdsj");
		sample.setEditable(false);
		sample.setLineWrap(true);
		sample.setBorder(BorderFactory.createEtchedBorder());
		
		add(faceLabel, new GBC(0, 0).setAnchor(GBC.EAST));
		add(face,new GBC(1,0).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		
		add(sizeLabel, new GBC(0, 1).setAnchor(GBC.EAST));
		add(size,new GBC(1,1).setFill(GBC.HORIZONTAL).setWeight(100, 0).setInsets(1));
		
		add(bold, new GBC(0, 2,2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		add(italic,new GBC(0,3,2,1).setAnchor(GBC.CENTER).setWeight(100, 100));
		
		add(sample,new GBC(2,0,1,4).setFill(GBC.BOTH).setWeight(100, 100));
	}

	@SuppressWarnings("unused")
	private class FontAction implements ActionListener {
		public void actionPerformed(ActionEvent e) {
			String fontFace = (String) face.getSelectedItem();
			int fontStyle = (bold.isSelected() ? Font.BOLD : 0)
					+ (italic.isSelected() ? Font.ITALIC : 0);

			int fontSize = Integer.parseInt((String) size.getSelectedItem());
			Font font = new Font(fontFace, fontStyle, fontSize);
			sample.setFont(font);
			sample.repaint();
		}
	}
}
