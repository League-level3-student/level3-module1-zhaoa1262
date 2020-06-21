package _04_HangMan;

import java.util.Stack;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class HangMan {
	static String numOfWordsQuestion = JOptionPane.showInputDialog("How many words?");
	static int numOfWords = Integer.parseInt(numOfWordsQuestion);
	static Stack<String> words = new Stack<String>();
	//static int count = 0;
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JLabel label = new JLabel();

	public static void main(String[] args) {
		for (int i = 0; i < numOfWords; i++) {
			words.push(Utilities.readRandomLineFromFile("dictionary.txt"));
			words.pop();
	}
	}
	void run() {
		frame.setVisible(true);
		frame.add(panel);
		frame.add(label);
		
		for(int i = 0; i<words.pop().length(); i++) {
			label.add("_", label);
		
		}
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}
	
	/*for( int i = 0; i < numOfWords; i++) {
	for(int j = 0 ; j < numOfWords; j++) {
		count++;
		if(words.get(j).equals(words.get(i)))
		{
			
		}	
	}
}*/
}
