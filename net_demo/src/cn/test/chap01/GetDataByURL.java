package cn.test.chap01;

import java.awt.Color;
import java.awt.Event;
import java.awt.Font;
import java.awt.Frame;
import java.awt.Graphics;
import java.awt.Menu;
import java.awt.MenuBar;
import java.awt.MenuItem;
import java.io.DataInputStream;
import java.io.IOException;
import java.net.URL;

@SuppressWarnings("serial")
public class GetDataByURL extends Frame{
	
	MenuBar menuBar;
	boolean drawImage = false;
	DataInputStream dataInputStream;
	int i=0;
	String line_str;
	boolean first = true;
	Font font;
	
	public GetDataByURL() {
		// TODO Auto-generated constructor stub
		menuBar = new MenuBar();
		setMenuBar(menuBar);
		Menu display = new Menu("display");
		menuBar.add(display);
		
		MenuItem beauty_display = new MenuItem("display Beauty");
		MenuItem text_display = new MenuItem("display text");
		display.add(beauty_display);
		display.add(text_display);
		
		setBackground(Color.WHITE);
		font = new Font("System",Font.BOLD,20);
		
		setTitle("sample:use URL get DATA");
		setSize(400,200);
		
		show();
	
	}
	
	@Override
	public boolean action(Event evt, Object what) {
		// TODO Auto-generated method stub
		if(evt.target instanceof MenuItem){
			String message = (String) what;
			if(message=="display Beauty"){
				drawImage = true;
				doDrawImage();
			}else{
				drawImage = false;
				first = true;
				if(message =="display text"){
					doWrite("file:///e://a.txt");
				}
			}
		}
		return true;
	}
	
	private void doDrawImage() {
		// TODO Auto-generated method stub
		drawImage = true;
		repaint();
	}

	private void doWrite(String url_str) {
		// TODO Auto-generated method stub
		try {
			URL url = new URL(url_str);
			dataInputStream = new DataInputStream(url.openStream());
			
			i=1;
			line_str=dataInputStream.readLine();
			while(line_str !=null){
				paint(getGraphics());
				line_str = dataInputStream.readLine();
			}
			dataInputStream.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@Override
	public boolean handleEvent(Event evt) {
		// TODO Auto-generated method stub
		switch(evt.id){
		case Event.WINDOW_DESTROY:dispose();System.exit(0);
		default: return super.handleEvent(evt);
		}
	}
	
	public static void main(String[] args) {
		new GetDataByURL();
	}
	
	@Override
	public void paint(Graphics g) {
		// TODO Auto-generated method stub
		super.paint(g);
	}
	
}
