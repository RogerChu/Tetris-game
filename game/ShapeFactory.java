package game;

import java.util.Random;

import game.Shape;

import listener.ShapeFactoryListener;
import listener.ShapeListener;

public class ShapeFactory {
	protected static int shapes[][][] = new int[][][] {//28�ֲ�ͬ״̬�ķ���
	/* ��һ�� */{ /** ***** */
	{ 1, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 } },

	/* �ڶ��� */
	{ /** ********* */
	{ 1, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 0, 1, 0, 0, 0, 1, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 1, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 } },
	/* ������ */
	{ /** ******* */
	{ 1, 1, 1, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 },

	{ 0, 0, 1, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0 } },
	/* ������ */
	{ /** ******** */
	{ 1, 1, 0, 0, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 0, 1, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, } },
	/* ������ */
	{ /** ******** */
	{ 0, 1, 1, 0, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },
	/* ������ */
	{ /** *********** */
	{ 0, 1, 0, 0, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 0, 0, 0, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0 },

	{ 1, 1, 1, 0, 0, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 0, 1, 0, 0, 1, 1, 0, 0, 0, 1, 0, 0, 0, 0, 0, 0 } },

	/* ������ */
	{ /** ********** */
	{ 1, 1, 1, 1, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0 },

	{ 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0, 0, 1, 0, 0 } }, };
	
	protected Random random = new Random();
	private ShapeFactoryListener l;
	private int type=0,status=0;

	public Shape getShape(int[][] body,int status,ShapeListener listener) {		
		Shape shape = new Shape(body,status);
		System.out.println("First time");
		
		shape.addShapeListener(listener);
		this.type=random.nextInt(shapes.length);
		this.status=random.nextInt(shapes[type].length);
		l.CreateShape();
		return shape;
	}
	public Shape getShape(ShapeListener listener) {		
		Shape shape = new Shape(shapes[type],status);
		System.out.println("this is shapefactory's getshape!");
		shape.addShapeListener(listener);
		this.type=random.nextInt(shapes.length);
		this.status=random.nextInt(shapes[type].length);
		l.CreateShape();

		return shape;
	}
	public static int[][][] getShapes() {
		return shapes;
	}
	public void addShapeFactoryListener(ShapeFactoryListener l){
		if(l!=null){
			this.l=l;
		}
	}
	public int getType() {
		return type;
	}
	public int getStatus() {
		return status;
	}
	
	
	

}
