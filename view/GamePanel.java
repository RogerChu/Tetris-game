package view;

import java.awt.Color;
import java.awt.Graphics;

import game.Ground;
import game.Shape;

import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

import util.Global;

public class GamePanel extends JPanel {
	private Shape shape;
	private Ground ground;
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public GamePanel() {
		this.setSize(Global.CELL_WIDTH*Global.WIDTH, Global.CELL_HEIGHT*Global.HEIGHT);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setFocusable(true);
	}

	public void display(Shape shape, Ground ground) {
		System.out.println("this is GamePanel's display!");
		this.shape = shape;
		this.ground = ground;
		this.repaint();
	}


	protected void paintComponent(Graphics g) {
		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fill3DRect(0,0,this.getWidth(),this.getHeight(), true);
		g.setColor(Color.WHITE);
		for(int x=0;x<Global.WIDTH;x++)
			g.drawLine(x*Global.CELL_WIDTH, 0,x*Global.CELL_WIDTH, Global.HEIGHT*Global.CELL_HEIGHT);
		for(int y=0;y<Global.CELL_HEIGHT;y++)
			g.drawLine(0, y*Global.CELL_HEIGHT, Global.WIDTH*Global.CELL_WIDTH, y*Global.CELL_HEIGHT);
		if (shape != null && ground != null) {
			shape.drawMe(g);
			ground.drawMe(g);
			//optionpanel.repaint();
		}
	}

}
