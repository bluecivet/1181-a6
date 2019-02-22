/**

 * File:        Cube.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.21

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        cube

 * Compiler:    java JDK 10.2

 */


import java.awt.*;
import java.awt.geom.*;

/**
 * this class is a 3D cube class
 * a cube has x and y 
 * also the total width and height 
 * a cube has 8 points 
 */
public class Cube
{

	int x;
	int y;
	int totalWidth;
	int totalHeight;
	Point2D.Double[] points;


//-----------------------------------------------------------------------------

    /**
     * this is a empty constructor
     * incase if crease the class with no parameter
     */
    public Cube()
	{

	}


    ///////////////////////////////////////////////////////////////

    /**
     * the constructor will initial the field in the class
     * @param x int type set the x position
     * @param y int type set the y position
     * @param width int type set the width for the cube
     * @param height int type set the height for the cube
     */
	public Cube(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.totalWidth = width;
		this.totalHeight = height;
		points = new Point2D.Double[8]; // create space for the 8 point in the cube
		initialPoints(); // set the point position
	}


//-------------------------------------------------------------------------------

    /**
     * the method set the the position for the points in the cube through the calculation
     */
	private void initialPoints()
	{
		int fronty = y + (totalHeight >> 2);
		int backx = x + (totalWidth >> 2);
		int width = (totalWidth >> 2) * 3;
		int height = (totalHeight >> 2) * 3;
 
		points[0] = new Point2D.Double(x, fronty);                        // front left top conern
		points[1] = new Point2D.Double(x + width, fronty);               // front right top conern
		points[2] = new Point2D.Double(x + width, fronty + height);      // front left bottom conern 
		points[3] = new Point2D.Double(x, fronty + height);             // front right bottom conern
		points[4] = new Point2D.Double(backx, y);                       // back left top conern
		points[5] = new Point2D.Double(backx + width, y);              // back right top conern
		points[6] = new Point2D.Double(backx + width, y + height);     // back left bottom conern 
		points[7] = new Point2D.Double(backx, y + height);             // back right bottom conern
	}


	////////////////////////////////////////////////////////////////////////

    /**
     * the mehtod will find the closest point by given x and y position
     * it check every point in the cube and compare them to give the answer
     * @param x a int type which represent the x position
     * @param y a int type which represent the y position
     * @return the Point2D.Double type represent the closest point
     */
	public Point2D.Double closePoint(int x, int y)
	{
		Point2D.Double min = points[0];
		double minDistance = Math.sqrt(Math.pow(min.getX() - x ,2) + Math.pow(min.getY() - y, 2));
		double deltax;
		double deltay;
		double distance;

		// check every point 
		for(int i = 1; i < points.length; i++)
		{
			deltax = x - points[i].getX();
			deltay = y - points[i].getY();
			distance = Math.sqrt(deltax * deltax + deltay * deltay);

			if(distance < minDistance)
			{
				min = points[i];
				minDistance = distance;
			}
		}

		return min;
	}


	/////////////////////////////////////////////////////////////////////////////////

    /**
     * the method will draw the cube in the window
     * @param Graphics2D type which represent the drawing pen
     */
	public void draw(Graphics2D g2)
	{
		int fronty = y + (totalHeight >> 2);
		int backx = x + (totalWidth >> 2);
		int width = (totalWidth >> 2) * 3;
		int height = (totalHeight >> 2) * 3;
       Rectangle front = new Rectangle(x, fronty, width, height);
       Rectangle back = new Rectangle(backx, y, width, height);

       Line2D.Double l1 = new Line2D.Double(points[0], points[4]);
       Line2D.Double l2 = new Line2D.Double(points[1], points[5]);
       Line2D.Double l3 = new Line2D.Double(points[2], points[6]);
       Line2D.Double l4 = new Line2D.Double(points[3], points[7]);

       
       g2.draw(front);
       g2.draw(back);
       g2.draw(l1);
       g2.draw(l2);
       g2.draw(l3);
       g2.draw(l4);  

	}
}