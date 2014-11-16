package br.ufal.ic.sheetCreator.decorator;

import java.util.List;
import java.util.Hashtable;

import javax.swing.ImageIcon;
import javax.swing.JLabel;

public abstract class Clefs extends Decorator {
	
	private Hashtable<Flag, Integer> types;
	protected int width;
	protected int height;
	protected int position_cx;
	protected int position_cy;
	
	public Clefs(IComponent component, int position_x, int position_y, List<Flag> flag) {
		super(component, position_x, position_y, flag);
		this.types = new Hashtable<Flag, Integer>();
		
		this.draw();
	}
	
	public int getMyPositionX() {
		return this.myPosition_x;
	}
	public int getMyPositionY() {
		return this.myPosition_y;
	}
	
	public abstract int getWidth();
	public abstract int getHeight();
	public abstract String getPathImage();
	public abstract int getPosisionCX();
	public abstract int getPositionCY();
	
	@Override
	protected void draw() {
		this.icon = new ImageIcon(this.getPathImage());
		this.label = new JLabel();
		
		icon.setImage(resize(icon.getImage(), this.getWidth(), this.getHeight()));
		label.setIcon(icon);
		
		this.myPosition_y = this.position_x + this.getPosisionCX();
		this.myPosition_x = this.position_y + this.getPositionCY();
		
		label.setBounds(this.myPosition_y, this.myPosition_x ,this.getWidth(), this.getWidth());
	}	
}
