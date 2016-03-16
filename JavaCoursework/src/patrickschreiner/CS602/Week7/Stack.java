package patrickschreiner.CS602.Week7;

/**
 * 
 * @author Patrick Schreiner
 * @version 1.0
 *
 */
public interface Stack 
{
	public void push(Object x);
	public Object pop();
	public int size();
	public Object top();
	public boolean isEmpty();
	public boolean isFull();

}
