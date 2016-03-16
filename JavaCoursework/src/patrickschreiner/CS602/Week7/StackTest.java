//StackTest class is a JUnit Test Case which ensures the
//methods of StackImp class are implemented properly and
//run as expected.

package patrickschreiner.CS602.Week7;

import junit.framework.TestCase;

/**
 * 
 * @author Patrick Schreiner
 * @version 1.0
 */
public class StackTest extends TestCase
{
	/**
	 * Test Case for push() method of StackImp class
	 */
	public void testPush()
	{
		StackImp stack = new StackImp();
		stack.push(44);
		stack.push("Pat");
		stack.push(true);
		stack.push(132);
		stack.push(false);
		assertTrue(stack.size() == 5);
		stack.push("Pat");
		assertFalse(stack.size() == 6);
	}
	/**
	 * Test Case for pop() method of StackImp class
	 */
	public void testPop()
	{
		StackImp stack = new StackImp();
		stack.push("Pat");
		stack.push("Tom");
		Object test = stack.pop();
		assertTrue(test.equals("Tom")); 
		assertTrue(stack.size() == 1);
	}
	/**
	 * Test case for size() method of StackImp class
	 */
	public void testSize()
	{
		StackImp stack = new StackImp();
		assertTrue(stack.isEmpty());
		assertTrue(stack.size() == 0);
		stack.push("Pat");
		stack.push(44);
		assertTrue(stack.size() == 2);
		stack.pop();
		assertTrue(stack.size() == 1);
	}
	/**
	 * Test case for top() method of StackImp class
	 */
	public void testTop()
	{
		StackImp stack = new StackImp();
		stack.push("Pat");
		stack.push(44);
		Object test1 = stack.top();
		assertTrue(test1.equals(44));
		stack.pop();
		Object test2 = stack.top();
		assertTrue(test2.equals("Pat"));
	}
	/**
	 * Test Case for isEmpty() method of StackImp class
	 */
	public void testisEmpty()
	{
		StackImp stack = new StackImp();
		assertTrue(stack.isEmpty());
		stack.push("Pat");
		assertFalse(stack.isEmpty());
		stack.pop();
		assertTrue(stack.isEmpty());
	}
	/**
	 * Test case for isFull() method of StackImp class
	 */
	public void testisFull()
	{
		StackImp stack = new StackImp();
		stack.push("Pat");
		stack.push(44);
		stack.push(true);
		stack.push(3.2);
		assertFalse(stack.isFull());
		stack.push("Tom");
		assertTrue(stack.isFull());
	}
	
}
