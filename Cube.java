import java.awt.*;
import java.awt.geom.*;
public class Cube
{
	int x;
	int y;
	int totalWidth;
	int totalHeight;


	public Cube()
	{

	}


	///////////////////////////////////////////////////////////////////////


	public Cube(int x, int y, int width, int height)
	{
		this.x = x;
		this.y = y;
		this.totalWidth = width;
		this.totalHeight = height;
	}


	public void draw(Graphics2D g2)
	{
		int fronty = y + (totalHeight >> 2);
		int backx = x + (totalWidth >> 2);
		int width = (totalWidth >> 2) * 3;
		int height = (totalHeight >> 2) * 3;
       Rectangle front = new Rectangle(x, fronty, width, height);
       Rectangle back = new Rectangle(backx, y, width, height);

       Point2D.Double p1 = new Point2D.Double(x, fronty);
       Point2D.Double p2 = new Point2D.Double(x + width, fronty);
       Point2D.Double p3 = new Point2D.Double(x + width, fronty + height);
       Point2D.Double p4 = new Point2D.Double(x, fronty + height);
       Point2D.Double p5 = new Point2D.Double(backx, y);
       Point2D.Double p6 = new Point2D.Double(backx + width, y);
       Point2D.Double p7 = new Point2D.Double(backx + width, y + height);
       Point2D.Double p8 = new Point2D.Double(backx, y + height);

       Line2D.Double l1 = new Line2D.Double(p1,p5);
       Line2D.Double l2 = new Line2D.Double(p2,p6);
       Line2D.Double l3 = new Line2D.Double(p3,p7);
       Line2D.Double l4 = new Line2D.Double(p4,p8);

       
       g2.draw(front);
       g2.draw(back);
       g2.draw(l1);
       g2.draw(l2);
       g2.draw(l3);
       g2.draw(l4);  

	}
}