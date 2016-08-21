package chap03;

import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.AbstractAction;
import javax.swing.Action;
import javax.swing.ButtonGroup;
import javax.swing.ImageIcon;
import javax.swing.JCheckBoxMenuItem;
import javax.swing.JFrame;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JPanel;
import javax.swing.JPopupMenu;
import javax.swing.JRadioButtonMenuItem;
import javax.swing.KeyStroke;

public class MenuTest {
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				MenuFrame frame = new MenuFrame();
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setVisible(true);
			}
		});
	}
}

@SuppressWarnings("serial")
class MenuFrame extends JFrame {
	public static final int DEFAULT_WIDTH = 300;
	public static final int DEFAULT_HEITH = 200;
	public static final int FONTSIZE = 12;
	
	private Action saveAction;
	private Action saveAsAction;;
	private JCheckBoxMenuItem readonlyItem;
	private JPopupMenu popup;
	
	public MenuFrame() {
		setTitle("Menu");
		setSize(DEFAULT_WIDTH, DEFAULT_HEITH);

		JMenu fileMenu = new JMenu("file");
		fileMenu.add(new TestAction("new"));
		
		JMenuItem openItem = fileMenu.add(new TestAction("open"));
		openItem.setAccelerator(KeyStroke.getKeyStroke("ctrl 0"));
		
		fileMenu.addSeparator();
		saveAction = new TestAction("save");
		JMenuItem saveItem = fileMenu.add(saveAction);
		saveItem.setAccelerator(KeyStroke.getKeyStroke("ctrl s"));
		
		saveAsAction = new TestAction("save as");
		fileMenu.add(saveAsAction);
		fileMenu.addSeparator();
		
		fileMenu.add(new AbstractAction("exit") {
			public void actionPerformed(ActionEvent e) {
				System.exit(0);
			}
		});
		
		readonlyItem = new JCheckBoxMenuItem();
		readonlyItem.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				boolean saveOK = !readonlyItem.isSelected();
				saveAction.setEnabled(saveOK);
				saveAsAction.setEnabled(saveOK);
			}
		});
		
		ButtonGroup group = new ButtonGroup();
		JRadioButtonMenuItem insertItem = new JRadioButtonMenuItem("insert");
		insertItem.setSelected(true);
		JRadioButtonMenuItem overtypeItem = new JRadioButtonMenuItem("overtype");
		group.add(insertItem);
		group.add(overtypeItem);
		
		JMenu optionsMenu = new JMenu("options");
		optionsMenu.add(readonlyItem);
		optionsMenu.addSeparator();
		optionsMenu.add(insertItem);
		optionsMenu.add(overtypeItem);
		
		Action cutAction = new TestAction("cut");
		cutAction.putValue(Action.SMALL_ICON, new ImageIcon("cut.gif"));
		Action copyAction = new TestAction("copy");
		copyAction.putValue(Action.SMALL_ICON, new ImageIcon("copy.gif"));
		Action pasteAction = new TestAction("paste");
		pasteAction.putValue(Action.SMALL_ICON, new ImageIcon("paste.gif"));
		
		JMenu editMenu = new JMenu("edit");
		editMenu.add(cutAction);
		editMenu.add(copyAction);
		editMenu.add(pasteAction);
		
		editMenu.addSeparator();
		editMenu.add(optionsMenu);
		
		JMenu helpMenu = new JMenu("help");
		helpMenu.setMnemonic('H');
		
		JMenuItem indexItem = new JMenuItem("index");
		indexItem.setMnemonic('I');
		helpMenu.add(indexItem);
		
		Action aboutAction = new TestAction("About");
		aboutAction.putValue(Action.MNEMONIC_KEY, new Integer('A'));
		helpMenu.add(aboutAction);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		menuBar.add(fileMenu);
		menuBar.add(editMenu);
		menuBar.add(helpMenu);
		
		popup = new JPopupMenu();
		popup.add(cutAction);
		popup.add(copyAction);
		popup.add(pasteAction);
		
		JPanel panel = new JPanel();
		panel.setComponentPopupMenu(popup);
		add(panel);
	}
	
}
@SuppressWarnings("serial")
class TestAction extends AbstractAction{
	public TestAction(String name){
		super(name);
	}
	public void actionPerformed(ActionEvent e) {
		System.out.println(getValue(Action.NAME)+" selected.");
		
	}
}