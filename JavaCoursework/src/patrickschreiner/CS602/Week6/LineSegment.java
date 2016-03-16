//LineSegment class implements the Shape class and applies
//the necessary parameters of a line segment.

package patrickschreiner.CS602.Week6;

/**
 * 
 * @author Patrick Schreiner
 * @version 1.0
 */
public class LineSegment implements Shape
{
	private int x1;
	private int y1;
	private int x2;
	private int y2;
	/**
	 * 
	 * @param x1 One X coordinate for line segment point
	 * @param y1 One Y coordinate for line segment point
	 * @param x2 Second X coodinate for line segment point
	 * @param y2 Second y coordinate for line segment point
	 */

	public LineSegment(int x1, int y1, int x2, int y2)
	{
		this.x1 = x1; this.y1 = y1; this.x2 = x2; this.y2 = y2;
	}
	/**
	 * toString() Method for LineSegment Class
	 */
	public String toString()
	{
		return "Line Segment: Point 1 = (" + x1 + "," + y1 + 
				"), Point 2 = (" + x2 + "," + y2 + ")";
	}
	
	
}