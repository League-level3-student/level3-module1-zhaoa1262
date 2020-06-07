package _03_IntroToStacks;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

public class _02_TextUndoRedo implements KeyListener {
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	String things = "";
	Stack<Character> removed = new Stack<Character>();

	void run() {
		frame.setVisible(true);
		panel.add(label);
		frame.add(panel);
		frame.addKeyListener(this);
		frame.setSize(200, 75);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub
		if (e.getKeyChar() != KeyEvent.VK_1 && e.getKeyChar() != KeyEvent.VK_BACK_SPACE) {
			things = things + e.getKeyChar();
		}

		if (e.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
			removed.push(things.charAt(things.length() - 1));
			things = things.substring(0, things.length() - 1);

		}

		if (e.getKeyCode() == KeyEvent.VK_1) {
			if (removed.isEmpty() == false) {
				char thing = removed.pop();
				things = things + thing;

			}
		}

		System.out.println(removed);
		label.setText(things);
	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * Create a JFrame with a JPanel and a JLabel
	 * 
	 * Every time a key is pressed, add that character to the JLabel. It should look
	 * like a basic text editor.
	 * 
	 * Make it so that every time the BACKSPACE key is pressed, the last character
	 * is erased from the JLabel. Save that deleted character onto a Stack of
	 * Characters.
	 * 
	 * Choose a key to be the Undo key. Make it so that when that key is pressed,
	 * the top Character is popped off the Stack and added back to the JLabel.
	 * 
	 */

}
