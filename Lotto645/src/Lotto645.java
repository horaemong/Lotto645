import java.awt.Color;
import java.awt.Container;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingUtilities;
import javax.swing.UIManager;

public class Lotto645 extends JFrame implements ActionListener {
	JLabel firstLabel;
	JLabel secondLabel;
	JLabel thirdLabel;
	JLabel fourthLabel;
	JLabel fifthLabel;
	JLabel sixthLabel;
	JLabel plusLabel;
	JLabel seventhLabel;
	JButton lottery;
	JButton reset;
	JButton close;

	public Lotto645() {
		super("Lotto 645 프로그램");
		this.addWindowListener(new WindowAdapter() {
			public void windowClosing(WindowEvent e) {
				System.exit(0);
			}
		});
		try {
			UIManager.setLookAndFeel("com.sun.java.swing." + "plaf.windows.WindowsLookAndFeel");
			SwingUtilities.updateComponentTreeUI(Lotto645.this);
		} catch (Exception e) {
		}
		makeGUI();
	}

	public void makeGUI() {
		Container c = getContentPane();
		c.setLayout(null);
		c.setBackground(new Color(255, 245, 235));

		firstLabel = new JLabel(new ImageIcon("res/1.jpg"));
		secondLabel = new JLabel(new ImageIcon("res/2.jpg"));
		thirdLabel = new JLabel(new ImageIcon("res/3.jpg"));
		fourthLabel = new JLabel(new ImageIcon("res/4.jpg"));
		fifthLabel = new JLabel(new ImageIcon("res/5.jpg"));
		sixthLabel = new JLabel(new ImageIcon("res/6.jpg"));
		plusLabel = new JLabel(new ImageIcon("res/plus.png"));
		seventhLabel = new JLabel(new ImageIcon("res/bonus.png"));
		lottery = new JButton("번호 추첨");
		reset = new JButton("초기화", new ImageIcon("res/reset.png"));
		close = new JButton("종료");

		firstLabel.setBounds(20, 20, 80,80);
		secondLabel.setBounds(110, 20, 80,80);
		thirdLabel.setBounds(200, 20, 80,80);
		fourthLabel.setBounds(290, 20, 80,80);
		fifthLabel.setBounds(380, 20, 80,80);
		sixthLabel.setBounds(470, 20, 80,80);
		plusLabel.setBounds(560, 20, 80,80);
		seventhLabel.setBounds(640, 20, 80,80);

		lottery.setBounds(150, 140, 120, 30);
		reset.setBounds(310, 140, 120, 30);
		close.setBounds(470, 140, 120, 30);

		c.add(firstLabel);
		c.add(secondLabel);
		c.add(thirdLabel);
		c.add(fourthLabel);
		c.add(fifthLabel);
		c.add(sixthLabel);
		c.add(plusLabel);
		c.add(seventhLabel);

		c.add(lottery);
		c.add(reset);
		c.add(close);

		lottery.addActionListener(this);
		reset.addActionListener(this);
		close.addActionListener(this);

	}

	public void actionPerformed(ActionEvent e) {
		if (e.getSource() == lottery) {
			int number[] = new int[45];
			for (int i = 0; i < number.length; i++) {
				number[i] = i + 1;
			}
			int temp = 0;
			int j = 0;
			for (int i = 0; i < 200; i++) {
				j = (int) (Math.random() * 45);
				temp = number[0];
				number[0] = number[j];
				number[j] = temp;
			}
			firstLabel.setIcon(new ImageIcon("res/" + number[0] + ".jpg"));
			secondLabel.setIcon(new ImageIcon("res/" + number[1] + ".jpg"));
			thirdLabel.setIcon(new ImageIcon("res/" + number[2] + ".jpg"));
			fourthLabel.setIcon(new ImageIcon("res/" + number[3] + ".jpg"));
			fifthLabel.setIcon(new ImageIcon("res/" + number[4] + ".jpg"));
			sixthLabel.setIcon(new ImageIcon("res/" + number[5] + ".jpg"));
			seventhLabel.setIcon(new ImageIcon("res/" + number[6] + ".jpg"));

		} else if (e.getSource() == reset) {
			firstLabel.setIcon(new ImageIcon("res/1.jpg"));
			secondLabel.setIcon(new ImageIcon("res/2.jpg"));
			thirdLabel.setIcon(new ImageIcon("res/3.jpg"));
			fourthLabel.setIcon(new ImageIcon("res/4.jpg"));
			fifthLabel.setIcon(new ImageIcon("res/5.jpg"));
			sixthLabel.setIcon(new ImageIcon("res/6.jpg"));
			seventhLabel.setIcon(new ImageIcon("res/bonus.png"));

		} else if (e.getSource() == close) {
			System.exit(0);
		}
	}

	public static void main(String args[]) {
		Lotto645 ee = new Lotto645();
		ee.setSize(760, 220);
		ee.setVisible(true);
	}
}
