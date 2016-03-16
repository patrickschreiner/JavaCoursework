package patrickschreiner.CS602.Week7;

/**
 * 
 * @author Patrick Schreiner
 * @version 1.0
 */
public class StackImp implements Stack
{
	/**
	 * no-argument Constructor
	 */
	public StackImp()
	{
		
	}
	Object[] array = new Object[5];
	int total = 0;
	/**
	 * Method to push object onto stack
	 */
	public void push(Object x)
	{
		if (total == array.length)
		{
			System.out.println("Stack full!");
		}
		else
		{
			array[total++] = x;
			System.out.println("Pushed: " + x);
		}
	}
	/**
	 * Method to pop object off stack
	 */
	public Object pop()
	{
		if (total == 0)
		{
			System.out.println("Stack empty!");
			return null;
		}
		else
		{
			Object popper = array[total -1];
			array[--total] = null;
			System.out.println("Popped: " + popper);
			return popper;
		}
	}
	/**
	 * Method to return size of stack
	 */
	public int size()
	{
		System.out.println("Total elements is: " + total);
		return total;
	}
	/**
	 * Method to show top of stack, but not pop
	 */
	public Object top()
	{
		if (total == 0)
		{
			System.out.println("Stack empty!");
			return null;
		}
		else
		{
			System.out.println("Top is: " + array[total -1]);
			return array[total - 1];
		}
	}
	/**
	 * Method to check is stack is empty
	 */
	public boolean isEmpty()
	{
		if (total == 0)
		{
			System.out.println("Stack is indeed empty!");
			return true;
		}
		else
		{
			System.out.println("Stack not empty!");
			return false;
		}
	}
	/**
	 * Method to check is stack is full
	 */
	public boolean isFull()
	{
		if (total == 5)
		{
			System.out.println("Stack is indeed full!");
			return true;
		}
		else
		{
			System.out.println("Stack not full!");
			return false;
		}
	}
	
		
	

}
