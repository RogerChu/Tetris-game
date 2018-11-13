package view;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import game.Ground;
import game.ShapeFactory;
import javax.swing.JFrame;

import controller.Controller;

public class MainFrame {
	static helpPanel helppanel = new helpPanel();
	static gameOptionPanel optionpanel = new gameOptionPanel();
	static GamePanel gamepanel = new GamePanel();
	static ShapeFactory shapefactory = new ShapeFactory();
	static Ground ground = new Ground();
	static JFrame frame = new JFrame();
	static Controller controller = new Controller(shapefactory, ground,
			gamepanel,optionpanel);
	
	

	public static void main(String args[]) {

		frame.setTitle("Tetris Game");
		frame.setFocusable(true);
		frame.setLayout(null);
		frame.setResizable(false);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setBounds(100, 100, 675, 540);
		frame.add(optionpanel);
		optionpanel.setLocation(5, 5);
		helppanel.setLocation(5, 390);
		gamepanel.setLocation(290, 5);
		frame.add(helppanel);
		frame.add(gamepanel);
		gamepanel.addKeyListener(controller);
		frame.addKeyListener(controller);
		frame.setVisible(true);
		frame.validate();
		shapefactory.addShapeFactoryListener(controller);
		optionpanel.getNewGameButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				
				controller.newGame();
				gamepanel.setFocusable(true);
			}

		});
		optionpanel.getStopGameButton().addActionListener(new ActionListener() {

			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				System.exit(0);
			}

		});
		controller.newGame();
		

	}

}
