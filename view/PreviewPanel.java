package view;

import java.awt.Color;
import java.awt.Graphics;

import util.Global;
import javax.swing.JPanel;
import javax.swing.border.EtchedBorder;

public class PreviewPanel extends JPanel{
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
    private int[] body=null;
    public void setBody(int[] body) {
		this.body = body;
	}
  
	
	public PreviewPanel(){
		this.setSize(100,100);//设置游戏预览窗口的大小
		this.setFocusable(false);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));	
		
		//this.text();
		//this.repaint();
	}


	
	protected void paintComponent(Graphics g) {

		// TODO Auto-generated method stub
		g.setColor(Color.LIGHT_GRAY);
		g.fill3DRect(0,0,this.getWidth(),this.getHeight(), true);
		this.Paint(g);
	}
	public void Paint(Graphics g){
		g.setColor(Color.GREEN);
		if(body!=null)
		for(int x=0;x<4;x++)
			for(int y=0;y<4;y++)
				if(this.body[y * 4 + x] == 1){
				g.fill3DRect(x*Global.CELL_WIDTH, y*Global.CELL_HEIGHT,Global.CELL_HEIGHT , Global.CELL_WIDTH, true);
				}
	}


	

}
