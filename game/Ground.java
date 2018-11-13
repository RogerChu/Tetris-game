package game;

import java.awt.Graphics;

import util.Global;

public class Ground {
	private int[][] gamescr = new int[Global.WIDTH][Global.HEIGHT];
	private int Delete_Line_Number=0;
	private int MARK=0;
	private int Grade=1;


	public void accept(Shape shape) {
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				if (shape.isMember(x, y, false))
					gamescr[shape.getLeft() + x][shape.getTop() + y] = 1;		
		deleteFullLine();
	}

	public void drawMe(Graphics g) {
		System.out.println("this is Ground's drawMe!");
		for (int x = 0; x < Global.WIDTH; x++)
			for (int y = 0; y < Global.HEIGHT; y++)
				if (gamescr[x][y] == 1) {
					g.fill3DRect(x * Global.CELL_HEIGHT, y * Global.CELL_WIDTH,
							Global.CELL_HEIGHT, Global.CELL_WIDTH, true);
				}
	}

	private void deleteFullLine() {
		for (int y = Global.HEIGHT - 1; y >= 0; y--) {
			boolean isFull = true;
			for (int x = 0; x < Global.WIDTH; x++) {
				if (gamescr[x][y] == 0)
					isFull = false;
			}
			if (isFull) {
				
				deleteLine(y++);
				
			}
		}
		
	}

	private void deleteLine(int lineNum) {
		
		for (int y = lineNum; y > 0; y--)
			for (int x = 0; x < Global.WIDTH; x++)
				gamescr[x][y] = gamescr[x][y - 1];
		for (int x = 0; x < Global.WIDTH; x++)
			gamescr[x][0] = 0;
		this.Delete_Line_Number++;

	}

	public boolean isGameOver() {
		for (int x = 0; x < Global.WIDTH; x++)
			if (gamescr[x][0] == 1)
				return true;
		return false;
	}

	public boolean isMoveable(Shape shape, int action) {
		int left = shape.getLeft();
		int top = shape.getTop();
		switch (action) {
		case Shape.DOWN:
			top++;
			break;
		case Shape.LEFT:
			left--;
			break;
		case Shape.RIGHT:
			left++;
			break;
		}
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				if (shape.isMember(x, y, action == Shape.ROTATE)) {
					if (top + y >= Global.HEIGHT || left + x < 0
							|| left + x >= Global.WIDTH
							|| gamescr[left + x][top + y] == 1) {
						return false;
					}
				}

		return true;

	}

	public String getMARK() {
			;
		switch(this.Delete_Line_Number){
		case 0:
			MARK=MARK+0;
			break;
		case 1:
			MARK=MARK+100;
			break;
		case 2:
			MARK=MARK+300;
			break;
		case 3:
			MARK=MARK+500;
			break;
		case 4:
			MARK=MARK+800;
			break;
			
		}
		this.Delete_Line_Number=0;
		String mark=String.valueOf(MARK);
		return mark;
	}

	public String getGrade() {
		if(this.MARK%2000==0&&this.MARK!=0){
			this.Grade++;
			if(this.Grade>10){
				this.Grade=1;
			}
		}
		//shape.setSPEED(1100-100*this.Grade);
		String grade=String.valueOf(Grade);
		return grade;
	}

}
