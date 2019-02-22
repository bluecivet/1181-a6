/**

 * File:        CubeClickComponent.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.21

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        cube

 * Compiler:    java JDK 10.2

 */

import javax.swing.*;
import java.awt.event.*;
import java.awt.*;
import java.awt.geom.*;

/**
 * this class is the second subprogram 
 * first it will draw a cube on the window
 * then if the user press down in the window a line which connect to a point that is the cloest to the mouse position
 * if the user release the mouse the cube will move to that position but the closest point the located at the position
 */

public class CubeClickComponent extends JComponent
{

	int cubex;
	int cubey;
	Cube cube;
	Line2D.Double rubberBand; // the line
	boolean drawRubberBand;    // determine to draw the line or not once the mouse press it become true else false
	final static int CUBE_WIDTH = 60;
    final static int  CUBE_HEIGHT = 60;


//--------------------------------------------------------------------
    
    /**
     * this is a inner class
     * the class extends the MouseAdapter 
     * in the class it override two method mousepress and mouserelease
     */

	class Listener extends MouseAdapter 
	{
		Point2D.Double closestPoint;  // the is the closest point from the cube to the mouse
             
		/**
		 * it override the method 
		 * once the mouse is press it will find the closest point in the cube to the mouse
		 * draw a line between them
		 * @param e the is the mouse event
		 */
		@Override
		public void mousePressed(MouseEvent e)
		{
			closestPoint = cube.closePoint(e.getX(), e.getY());   // find the cloest point 
			drawRubberBand = true;  // allow the draw the line
			rubberBand = new Line2D.Double(e.getX(), e.getY(), closestPoint.getX(), closestPoint.getY()); // the line
			repaint();
		}

        /////////////////////////////////////////////////////////////////////////////////////////////////
        
        /**
         * it override the method
         * once the mouse release 
         * the cube but the closest point will move the the mouse position 
         * then the line between will gone 
         * @param e this is the mouse event
         */
        @Override
		public void mouseReleased(MouseEvent e)
		{
			rubberBand = null;    // garbage collect the line
			drawRubberBand = false;   // not allow to draw the line
			cube = null;     // garbage collect the previous cube

			//calculating the new cube position
			int detalx = (int)closestPoint.getX() - cubex;
			int detaly = (int)closestPoint.getY() - cubey;
			cubex = e.getX() - detalx;
			cubey = e.getY() - detaly;

			repaint();
		}
	}


//-------------------------------------------------------------------

    /**
     * this is the constructor for the class
     * it add the listener which override the method for the mouse 
     */
    public CubeClickComponent()
    {
    	super.addMouseListener(new Listener());
    }


//--------------------------------------------------------------------
    
    /**
     * the method override the method in the JComponent class
     * it draw the picture in the window
     * @param g a Graphics which represent the drawing pen 
     */
    @Override
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