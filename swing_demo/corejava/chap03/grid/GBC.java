package chap03.grid;

import java.awt.GridBagConstraints;
import java.awt.Insets;

@SuppressWarnings("serial")
public class GBC extends GridBagConstraints {
	
	public GBC(int gridx,int gridy){
		this.gridx = gridx;
		this.gridy = gridy;
	}
	public GBC(int gridx,int gridy,int gridwidth,int gridheight){
		this.gridx = gridx;
		this.gridy = gridy;
		this.gridwidth =gridwidth;
		this.gridheight = gridheight;
	}
	
	public GBC setAnchor(int anchor) {
		// TODO Auto-generated method stub
		this.anchor =anchor;
		return this;
	}
	public GBC setFill(int fill) {
		// TODO Auto-generated method stub
		this.fill = fill ;
		return this;
	}
	public GBC setWeight(double weightx,double weighty) {
		// TODO Auto-generated method stub
		this.weightx = weightx;
		this.weighty = weighty;
		return this;
	}
	public GBC setInsets(int insets) {
		// TODO Auto-generated method stub
		this.insets = new Insets(insets, insets, insets, insets);
		return this;
	}
	public GBC setInsets(int top, int left, int bottom, int right) {
		// TODO Auto-generated method stub
		this.insets = new Insets(top, left, bottom, right);
		return this;
	}
	public GBC setIpad(int ipadx,int ipady) {
		// TODO Auto-generated method stub
		this.ipadx = ipadx;
		this.ipady = ipady;
		return this;
	}
}
