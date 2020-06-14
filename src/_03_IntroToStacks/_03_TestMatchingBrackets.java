package _03_IntroToStacks;

import static org.junit.Assert.assertFalse;
import static org.junit.Assert.assertTrue;

import java.util.Stack;

import org.junit.Test;

public class _03_TestMatchingBrackets {

	@Test
	public void testMatchingBrackets() {
		assertTrue(doBracketsMatch("{}"));
		assertTrue(doBracketsMatch("{{}}"));
		assertTrue(doBracketsMatch("{}{}{{}}"));
		assertFalse(doBracketsMatch("{{}"));
		assertFalse(doBracketsMatch("}{"));
	}

	// USE A STACK TO COMPLETE THE METHOD FOR CHECKING IF EVERY OPENING BRACKET HAS
	// A MATCHING CLOSING BRACKET
	private boolean doBracketsMatch(String b) {
		Stack<Character> brackets = new Stack<Character>();
		if (b.isEmpty() == true) {
			return true;
		}
		 
		for (int i = 0; i < b.length(); i++) {
			char aChar = b.charAt(i);

			if (aChar == '{') {
				brackets.push(aChar);
				 
				 
			}
			else if (aChar == '}') {
				  
				if (brackets.isEmpty() == true) {

					return false;

				}
				brackets.pop();
				
			}
			 
		}
		 
		return brackets.isEmpty();
	}

}