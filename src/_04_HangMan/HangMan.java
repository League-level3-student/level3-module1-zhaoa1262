package _04_HangMan;

import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan implements KeyListener {

	static String numOfWordsQuestion = JOptionPane.showInputDialog("How many words?");
	static int numOfWords = Integer.parseInt(numOfWordsQuestion);
	static Stack<String> words = new Stack<String>();
	// static int count = 0;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();
	String lines = "";
	int lives = 10;
	String word;
	String showup;

	void run() {
		
		for (int i = 0; i < numOfWords; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
		}
		frame.setSize(200, 100);
		frame.setVisible(true);
		frame.add(panel);
		frame.add(label);
		frame.addKeyListener(this);

		word = words.pop();
		
		for (int j = 0; j < word.length(); j++) {
			lines += "_";

		}
		label.setText("    " + lines + "       " + "lives: " + lives);
		
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void keyTyped(KeyEvent e) {
		// TODO Auto-generated method stub
		int count = 0;
		for (int i = 0; i < word.length(); i++) {

			if (e.getKeyChar() == word.charAt(i)) {
				char line = lines.charAt(i);
				line = e.getKeyChar();
				lines = lines.substring(0, i) + line + lines.substring(i + 1);
				count += 1;
			}
			
		 	
		}
		
		if(count == 0) {
			lives--;
		}
		if(lives == 0) {
			JOptionPane.showMessageDialog(null, "You lose!");
		}
		if(word.equals(lines)) {
			if(words.isEmpty() == false) {
			word = words.pop();
			lines = "";
			for (int j = 0; j < word.length(); j++) {
				lines += "_";
			}
		}
			else {
				JOptionPane.showMessageDialog(null, "You win!");
			}
		}
		
			
		label.setText("    " + lines + "       " + "lives: " + lives);
	}

	@Override
	public void keyPressed(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void keyReleased(KeyEvent e) {
		// TODO Auto-generated method stub

	}

	/*
	 * for( int i = 0; i < numOfWords; i++) { for(int j = 0 ; j < numOfWords; j++) {
	 * count++; if(words.get(j).equals(words.get(i))) {
	 * 
	 * } } }
	 */
}
