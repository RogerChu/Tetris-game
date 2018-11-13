package game;

import java.awt.Color;
import java.awt.Graphics;

import util.Global;

import listener.ShapeListener;

public class Shape {
	public static final int ROTATE = 0;
	public static final int LEFT = 1;
	public static final int RIGHT = 2;
	public static final int DOWN = 3;
	private int left;
	private int top;
	protected int[][] body;
	protected int status;
	protected int height;
	private int SPEED=300;
	private ShapeListener listener;
	protected Thread shapeThread;

	public int getTop() {
		return top;
	}

	public int getLeft() {
		return left;
	}

	public void moveDown() {
		System.out.println("this is shape's movedown!");
		top++;
	}

	public void moveLeft() {
		System.out.println("this is moveleft!");
		left--;
	}

	public void moveRight() {
		System.out.println("this is moveright!");
		left++;
	}

	public void rotate() {
		System.out.println("this is rotate!");
		status = (status + 1) % body.length;
	}

	public void drawMe(Graphics g) {
		System.out.println("这是图形的显示方法！！");
		g.setColor(Color.blue);
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				if (getFlagByPoint(status, x, y))
					g.fill3DRect((left + x) * Global.CELL_WIDTH, (top + y)
							* Global.CELL_HEIGHT, Global.CELL_WIDTH,
							Global.CELL_HEIGHT,true);
	}

	protected class ShapeDriver implements Runnable {

		public void run() {
			// TODO Auto-generated method stub
			System.out.println("***************Before Fall Down*****************");
			while (listener.isShapeMoveDownable(Shape.this)) {
				moveDown();
				System.out.println("***************After Fall Down*****************");
				listener.shapeMoveDown(Shape.this);
				
				try {
					Thread.sleep(1000);
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					//e.printStackTrace();
					System.out.println("线程出现异常！！！！！！！！！！！！");
				}
			}
		}

	}

	public Shape(int body[][], int status) {
		this.body = body;
		this.status = status;
		for (int x = 0; x < 4; x++)
			for (int y = 0; y < 4; y++)
				if (isMember(x, y, false))
					height = y + 1;
	    init();
	}

	public void init() {
		left = Global.WIDTH / 2 - 2;
		top = -1 ;//- height;
	}

	protected boolean getFlagByPoint(int status, int x, int y) {
		return body[status][y * 4 + x] == 1;
	}

	public boolean isMember(int x, int y, boolean isRotate) {
		return getFlagByPoint(isRotate ? (status + 1) % body.length : status,
				x, y);
	}

	public void addShapeListener(ShapeListener l) {
		if (l != null&&this.listener!=l)
			this.listener = l;
		start();
	}
	protected void start() {
		shapeThread = new Thread(new ShapeDriver());
		shapeThread.start();
	}

}
