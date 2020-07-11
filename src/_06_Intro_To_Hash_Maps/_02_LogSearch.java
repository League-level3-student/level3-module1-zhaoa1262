package _06_Intro_To_Hash_Maps;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JOptionPane;
import javax.swing.JPanel;

public class _02_LogSearch implements ActionListener {
	HashMap<Integer, String> values = new HashMap<>();
	JFrame frame = new JFrame();
	JPanel panel = new JPanel();
	JButton entry = new JButton("Add Entry");
	JButton search = new JButton("Search by ID");
	JButton view = new JButton("View List");
	JButton remove = new JButton("Remove Entry");

	void run() {
		frame.setVisible(true);
		entry.addActionListener(this);
		search.addActionListener(this);
		view.addActionListener(this);
		remove.addActionListener(this);
		panel.add(entry);
		panel.add(search);
		panel.add(view);
		panel.add(remove);
		frame.add(panel);
		frame.pack();
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
	}

	@Override
	public void actionPerformed(ActionEvent e) {
		// TODO Auto-generated method stub
		if (e.getSource() == entry) {
			String enteredIDString = JOptionPane.showInputDialog("Enter an ID NUmber");
			int enteredID = Integer.parseInt(enteredIDString);
			String enteredName = JOptionPane.showInputDialog("Enter a name");
			values.put(enteredID, enteredName);
		} 
		else if (e.getSource() == search) {
			String enteredIDString = JOptionPane.showInputDialog("Enter an ID NUmber");
			int enteredID = Integer.parseInt(enteredIDString);
			int count = 0;
			for (int i = 0; i < values.size(); i++) {
				if (values.containsKey(enteredID)) {
					JOptionPane.showMessageDialog(null, values.get(enteredID));
					count++;
				}
			}
			if (count == 0) {
				JOptionPane.showMessageDialog(null, "The entry does not exist");
			}

		} 
		else if (e.getSource() == view) {
			Set<Integer> keyss = values.keySet();
			ArrayList<Integer> keysss = new ArrayList <Integer> ();
			keysss.addAll(keyss);
			for (int i = 0; i < values.size(); i++) {
				System.out.println("ID: " + keysss.get(i) +" Name: " + values.get(keysss.get(i)));
			}
		}
		else if(e.getSource() == remove) {
			String enteredIDString = JOptionPane.showInputDialog("Enter an ID NUmber");
			int enteredID = Integer.parseInt(enteredIDString);
			int count = 0;
			for(int i = 0; i<values.size(); i++) {
				if(values.containsKey(enteredID)) {
					count++;
					values.remove(enteredID);
				}
			}
			if(count == 0) {
				JOptionPane.showMessageDialog(null, "ID is not in the list");
			}
		}
	}

  /* 
	 * Crate a HashMap of Integers for the keys and Strings for the values.
	 * Create a GUI with three buttons. 
	 * Button 1: Add Entry
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				After an ID is entered, use another input dialog to ask the user to enter a name.
	 * 				Add this information as a new entry to your HashMap.
	 * 
	 * Button 2: Search by ID
	 * 				When this button is clicked, use an input dialog to ask the user to enter an ID number.
	 * 				If that ID exists, display that name to the user.
	 * 				Otherwise, tell the user that that entry does not exist.
	 * 
	 * Button 3: View List
	 * 				When this button is clicked, display the entire list in a message dialog in the following format:
	 * 				ID: 123  Name: Harry Howard
	 * 				ID: 245  Name: Polly Powers
	 * 				ID: 433  Name: Oliver Ortega
	 * 				etc...
	 * 
	 * When this is complete, add a fourth button to your window.
	 * Button 4: Remove Entry
	 * 				When this button is clicked, prompt the user to enter an ID using an input dialog.
	 * 				If this ID exists in the HashMap, remove it. Otherwise, notify the user that the ID
	 * 				is not in the list. 
	 *
	 * */
	
}
