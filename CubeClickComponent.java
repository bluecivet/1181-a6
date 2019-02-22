import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

public class CubeClickComponent extends JComponent
{
	class Listener extends MouseAdapter
	{
		Point2D.Double closestPoint;
		public void mousePressed(MouseEvent e)
		{
			closestPoint = cube.closePoint(e.getX(), e.getY());
			drawRubberBand = true;
			rubberBand = new Line2D.Double(e.getX(), e.getY(), closestPoint.getX(), closestPoint.getY());
			repaint();
		}


		public void mouseReleased(MouseEvent e)
		{
			rubberBand = null;
			drawRubberBand = false;
			cube = null;     // garbage collect the previous cube
			int detalx = (int)closestPoint.getX() - cubex;
			int detaly = (int)closestPoint.getY() - cubey;
			cubex = e.getX() - detalx;
			cubey = e.getY() - detaly;

			repaint();
		}
	}

//-------------------------------------------------------------------

	int cubex;
	int cubey;
	Cube cube;
	Line2D.Double rubberBand;
	boolean drawRubberBand;
	final static int CUBE_WIDTH = 60;
    final static int  CUBE_HEIGHT = 60;


//--------------------------------------------------------------------


    public CubeClickComponent()
    {
    	super.addMouseListener(new Listener());
    }


//--------------------------------------------------------------------


    public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

	    cube = new Cube(cubex,cubey,CUBE_WIDTH, CUBE_HEIGHT);
		cube.draw(g2);

		if(drawRubberBand)
		{
			g2.draw(rubberBand);
		}
	}

}