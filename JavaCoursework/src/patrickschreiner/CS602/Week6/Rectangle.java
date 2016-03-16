//Rectangle class implements the Shape class and applies
//the necessary parameters of a rectangle.

package patrickschreiner.CS602.Week6;

/**
 * 
 * @author Patrick Schreiner
 * @version 1.0
 */
public class Rectangle implements Shape
{
	private int x;
	private int y;
	private int width;
	private int height;
	/**
	 * 
	 * @param x Top-left corner x coordinate
	 * @param y Top-left corner y coordinate
	 * @param width Rectangle Width
	 * @param height Rectangle Height
	 */
	public Rectangle(int x, int y, int width, int height)
	{
		this.x = x; this.y = y; this.width = width; this.height = height;
	}
	/**
	* toString() Method for Rectangle Class
	*/
	public String toString()
	{
		return "Rectangle: Upperleft Corner = (" + x + "," + y +
				 "), Width = " + width + ", Height = " + height;
	}
}

