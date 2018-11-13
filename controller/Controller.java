package controller;

import java.awt.event.*;
import java.util.Random;

import view.GamePanel;
import view.gameOptionPanel;
import game.Ground;
import game.Shape;
import game.ShapeFactory;
import listener.*;


public class Controller extends KeyAdapter implements ShapeListener,ShapeFactoryListener,GroundListener{
	
	private Shape shape;
	private ShapeFactory shapefactory;
	private GamePanel gamepanel;
	private Ground ground;
	private gameOptionPanel optionpanel;
	protected Random random = new Random();

	
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		switch(e.getKeyCode()){
		case KeyEvent.VK_UP:
			if(ground.isMoveable(shape, Shape.ROTATE)) {
				shape.rotate();
			}
			break;
		case KeyEvent.VK_LEFT:
			if(ground.isMoveable(shape, Shape.LEFT)) {
				shape.moveLeft();
			}
			break;
		case KeyEvent.VK_RIGHT:
			if(ground.isMoveable(shape, Shape.RIGHT)) {
				shape.moveRight();
			}
			break;
		case KeyEvent.VK_DOWN:
			if(this.isShapeMoveDownable(shape)) {
				shape.moveDown();
			}
			break;
		}
		gamepanel.display(shape, ground);
		
	}
	public void shapeMoveDown(Shape shape) {
		// TODO Auto-generated method stub
		gamepanel.display(shape, ground);
		
	}

	public Controller(ShapeFactory shapefactory,Ground ground,GamePanel gamepanel,gameOptionPanel optionpanel){
		this.gamepanel=gamepanel;
		this.ground=ground;
		this.shapefactory=shapefactory;
		this.optionpanel=optionpanel;
		//this.shape=shapefactory.getShape(this);
	}
	public boolean isShapeMoveDownable(Shape shape) {
		if(this.shape!=shape){
			return true;
		}
		if(ground.isMoveable(shape, Shape.DOWN))
		return true;
		ground.accept(shape);
		if(!ground.isGameOver())
		this.shape=shapefactory.getShape(this);
		return false;
	}
	
	public void CreateShape(){
		shapeMoveDown(shape);
		optionpanel.getPreviewpanel().setBody(ShapeFactory.getShapes()[shapefactory.getType()][shapefactory.getStatus()]);
		optionpanel.getMark().setText(ground.getMARK());
		optionpanel.getGrade().setText(ground.getGrade());
		optionpanel.getPreviewpanel().repaint();
		optionpanel.repaint();
		
	}
	public void newGame(){
		int type=random.nextInt(ShapeFactory.getShapes().length);
		int status=random.nextInt(ShapeFactory.getShapes()[type].length);
		shape=shapefactory.getShape(ShapeFactory.getShapes()[type],status,this);
		
	}
	public gameOptionPanel getOptionpanel() {
		return optionpanel;
	}
	public void deleteFullLine() {
		// TODO Auto-generated method stub
		
	}

	
}
