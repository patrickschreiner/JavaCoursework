package patrickschreiner.CS602.Week6;

/**
 * 
 * @author Patrick Schreiner
 * @version 1.0
 */
public class Circle implements Shape 
{
	public int x;
	public int y;
	public int radius;
	/**
	 * 
	 * @param x X coordinate for circle center
	 * @param y Y coordinate for circle center
	 * @param radius Radius of circle
	 */
	
	public Circle(int x, int y, int radius)
	{
		this.x = x; this.y = y; this.radius = radius;
	}
	/**
	 * toString() Method for Circle Class
	 */
	public String toString()
	{
		return "Circle: Center = (" + x + "," + y +
				"), Radius = " + radius;
	}
}
