package view;

import java.awt.Color;
import java.awt.Font;
import java.net.URL;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;
import javax.swing.JSeparator;
import javax.swing.JTextField;
import javax.swing.border.EtchedBorder;

public class gameOptionPanel extends JPanel {

	/**
	 * 
	 */
	MainFrame mainframe;
	private static final long serialVersionUID = 1L;
	URL imageURL = gameOptionPanel.class.getResource("/1234.png");
	private ImageIcon ourIcon = imageURL != null ? new ImageIcon(imageURL)
			: null;
	private JButton newGameButton = new JButton();
	private JButton stopGameButton = new JButton();
	private JButton pauseButton = new JButton();
	private  JTextField mark = new JTextField();
	private  JTextField grade = new JTextField();
	private PreviewPanel previewpanel = new PreviewPanel();
	public gameOptionPanel() {
		super();
		setSize(280, 380);
		setLayout(null);
		setBorder(new EtchedBorder(EtchedBorder.LOWERED));// set boundary
		setFocusable(false);

		final JLabel label_logo = ourIcon == null ? new JLabel() : new JLabel(
				ourIcon);
		label_logo.setBounds(0, 0, 278, 200);
		add(label_logo);

		final JSeparator separator = new JSeparator();// 创建分割线
		separator.setBounds(12, 210, 130, 30);
		add(separator);
		final JLabel lable_1 = new JLabel();
		separator.add(lable_1);
		lable_1.setBounds(88, 8, 110, 15);
		lable_1.setFont(new Font("宋体", Font.PLAIN, 18));
		lable_1.setForeground(Color.BLACK);// 设置颜色
		lable_1.setFocusable(false);
		lable_1.setText("NEXT:");

	
		
		this.add(previewpanel);
		previewpanel.setLocation(160, 200);
		

		final JSeparator separator_1 = new JSeparator();// 创建分割线
		separator_1.setBounds(12, 240, 130, 30);
		add(separator_1);
		final JLabel lable_2 = new JLabel();
		separator_1.add(lable_2);
		lable_2.setBounds(10, 10, 48, 15);
		lable_2.setFont(new Font("宋体", Font.PLAIN, 12));
		// lable_1.setForeground(new Color.)//设置颜色
		lable_2.setFocusable(false);
		lable_2.setText("Rank:");

		grade.setFont(new Font("宋体", Font.PLAIN, 12));
		grade.setBounds(40, 10, 30, 15);
		grade.setEditable(false);
		separator_1.add(grade);
		//grade.setText(ground.getGrade());
		grade.setText(" ");

		final JSeparator separator_2 = new JSeparator();// 创建分割线
		separator_2.setBounds(12, 270, 130, 30);
		add(separator_2);
		final JLabel lable_3 = new JLabel();
		separator_2.add(lable_3);
		lable_3.setBounds(10, 10, 60, 15);
		lable_3.setFont(new Font("宋体", Font.PLAIN, 12));
		// lable_1.setForeground(new Color.)//设置颜色
		lable_3.setFocusable(true);
		lable_3.setText("Score:");

		mark.setFont(new Font("宋体", Font.PLAIN, 12));
		mark.setBounds(50, 10, 60, 15);
		mark.setEditable(false);
		separator_2.add(mark);
		//mark.setText(ground.getMARK());
		mark.setText("  ");

		final JSeparator separator_3 = new JSeparator();// 创建分割线
		separator_3.setBounds(12, 300, 255, 30);
		add(separator_3);

		newGameButton = new JButton();
		newGameButton.setFont(new Font("宋体", Font.PLAIN, 12));
		// newGameButton.setFocusable(false);
		newGameButton.setText("Start Game");
		newGameButton.setBounds(85, 345, 96, 23);
		separator_3.add(newGameButton);

		stopGameButton = new JButton();
		stopGameButton.setBounds(15, 310, 96, 23);
		separator_3.add(stopGameButton);

		pauseButton = new JButton();
		pauseButton.setBounds(160, 310, 96, 23);
		separator_3.add(pauseButton);

		stopGameButton.setFont(new Font("宋体", Font.PLAIN, 12));
		stopGameButton.setFocusable(false);
		stopGameButton.setText("Game over");

		pauseButton.setFont(new Font("宋体", Font.PLAIN, 12));
		pauseButton.setFocusable(false);
		pauseButton.setText("Pause/Continue");
		add(pauseButton);
		add(stopGameButton);
		add(newGameButton);
		this.repaint();
		// newGameButton.setVisible(true);
		// stopGameButton.setVisible(true);
		// pauseButton.setVisible(true);
		setVisible(true);
		validate();

	}
	public void display(){
		System.out.println("Refresh control panel");
		previewpanel.repaint();
		this.repaint();
	}

	public JButton getNewGameButton() {
		return newGameButton;
	}

	public JButton getStopGameButton() {
		return stopGameButton;
	}

	public JButton getPauseButton() {
		return pauseButton;
	}
	public PreviewPanel getPreviewpanel() {
		return previewpanel;
	}
	public JTextField getMark() {
		return mark;
	}
	public JTextField getGrade() {
		return grade;
	}

}