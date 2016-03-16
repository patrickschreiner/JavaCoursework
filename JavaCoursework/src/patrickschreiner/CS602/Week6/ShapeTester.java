//ShapeTester class reads text notation information about shapes
//and creates objects based on their classification, then
//stores them in an array of type Shape and prints them.

package patrickschreiner.CS602.Week6;

import java.io.*;   
import java.util.*;
/**
 * 
 * @author Patrick Schreiner
 * @version 1.0
 */

public class ShapeTester
{
	/**
	 * 
	 * @param args The Main Method,
	 * Parses lines from text file and places them into array of type "Shape"
	 */
	public static void main(String[] args)
	{
		
		try 
		{
			/**
			 * Setting up Scanner
			 */
			Scanner in = new Scanner(new FileReader("shapes.txt"));
			Shape shape[] = new Shape[4];
			int index = 0;
			
			while(in.hasNext())
			{
				/**
				 * Parse Text File into appropriate shapes
				 */
				String name = in.next();
				
				if (name.equals("LineSegment"))
				{
					String x1 = in.next();
					String y1 = in.next();
					String x2 = in.next();
					String y2 = in.next();
					int p1x = Integer.parseInt(x1);
					int p1y = Integer.parseInt(y1);
					int p2x = Integer.parseInt(x2);
					int p2y = Integer.parseInt(y2);
					Shape lineseg = new LineSegment(p1x, p1y, p2x, p2y);
					shape[index++] = lineseg;
				}
				else if (name.equals("Rectangle"))
				{
					String x = in.next();
					String y = in.next();
					String width = in.next();
					String height = in.next();
					int px = Integer.parseInt(x);
					int py = Integer.parseInt(y);
					int wid = Integer.parseInt(width);
					int hgt = Integer.parseInt(height);
					Shape rectangle = new Rectangle(px, py, wid, hgt);
					shape[index++] = rectangle;
				}
				else if (name.equals("Circle"))
				{
					String x = in.next();
					String y = in.next();
					String radius = in.next();
					int px = Integer.parseInt(x);
					int py = Integer.parseInt(y);
					int rad = Integer.parseInt(radius);
					Shape circle = new Circle(px, py, rad);
					shape[index++] = circle;
				}
				else if(name.equals("Triangle"))
				{
					String a = in.next();
					String b = in.next();
					String c = in.next();
					int ai = Integer.parseInt(a);
					int bi = Integer.parseInt(b);
					int ci = Integer.parseInt(c);
					Shape triangle = new Triangle(ai, bi, ci);
					shape[index++] = triangle;
				}
			}
			for (int i = 0; i < shape.length; i++)
			{
				System.out.println(shape[i]);
			}
				

		}
		catch (IOException e)
		{
			
		}
	}
}

