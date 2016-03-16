//Triangle class implements the Shape class and applies
//the necessary parameters of a triangle.

package patrickschreiner.CS602.Week6;

/**
 * 
 * @author Patrick Schreiner
 * @version 1.0
 */
public class Triangle implements Shape 
{
	private int a;
	private int b;
	private int c;
	/**
	 * 
	 * @param a Side 1 of the Triangle
	 * @param b Side 2 of the Triangle
	 * @param c Side 3 of the Triangle
	 */
	
	public Triangle(int a, int b, int c)
	{
		this.a = a; this.b = b; this.c = c;
	}
	/**
	 * toString() Method for Triangle Class
	 */
	public String toString()
	{
		return "Triangle: Side 1 = " + a + ", Side 2 = " + b +
				", Side 3 = " + c;
	}
	

}
