package listener;

import game.Shape;

public interface ShapeListener {

	void shapeMoveDown(Shape shape);//向下移动方块
	boolean isShapeMoveDownable(Shape shape);

}
