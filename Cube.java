import java.awt.*;
import java.awt.geom.*;
public class Cube
{
	int x;
	int y;
	int totalWidth;
	int totalHeight;
	Point2D.Double[] points;


	public Cube()
	{

	}


//-----------------------------------------------------------------------------


	public Cube(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.totalWidth = width;
		this.totalHeight = height;
		points = new Point2D.Double[8];
		initialPoints();
	}


//-------------------------------------------------------------------------------

	private void initialPoints()
	{
		int fronty = y + (totalHeight >> 2);
		int backx = x + (totalWidth >> 2);
		int width = (totalWidth >> 2) * 3;
		int height = (totalHeight >> 2) * 3;

		points[0] = new Point2D.Double(x, fronty);
		points[1] = new Point2D.Double(x + width, fronty);
		points[2] = new Point2D.Double(x + width, fronty + height);
		points[3] = new Point2D.Double(x, fronty + height);
		points[4] = new Point2D.Double(backx, y);
		points[5] = new Point2D.Double(backx + width, y);
		points[6] = new Point2D.Double(backx + width, y + height);
		points[7] = new Point2D.Double(backx, y + height);
	}


	////////////////////////////////////////////////////////////////////////


	public Point2D.Double closePoint(int x, int y)
	{
		Point2D.Double min = points[0];
		double minDistance = Math.sqrt(Math.pow(min.getX() - x ,2) + Math.pow(min.getY() - y, 2));
		double deltax;
		double deltay;
		double distance;
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