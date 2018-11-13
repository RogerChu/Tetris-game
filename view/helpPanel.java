package view;
import java.awt.Font;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.border.EtchedBorder;

public class helpPanel extends JPanel{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	public helpPanel(){
		this.setSize(280, 155);
		this.setBorder(new EtchedBorder(EtchedBorder.LOWERED));
		this.setFocusable(false);
		
		final JTextArea InfoTextArea = new JTextArea();
		InfoTextArea.setFont(new Font("ËÎÌå", Font.PLAIN, 12));
		InfoTextArea.setText("Game rule£º\n\n    ¢Ù¡¢\n\n    ¢Ú¡¢Enter control pause/continue\n\n(*^__^*) ErsBlocks By Kavilee (*^__^*)");
		InfoTextArea.setFocusable(false);
		InfoTextArea.setBackground(this.getBackground());
		InfoTextArea.setBounds(10, 10, 200,
				320);

		add(InfoTextArea);
		//add();
	}
}
	