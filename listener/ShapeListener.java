package listener;

import game.Shape;

public interface ShapeListener {

	void shapeMoveDown(Shape shape);//�����ƶ�����
	boolean isShapeMoveDownable(Shape shape);

}
