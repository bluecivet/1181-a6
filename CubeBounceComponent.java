/**

 * File:        CubeBounceComponent.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.21

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        cube

 * Compiler:    java JDK 10.2

 */


import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

/**
 * this class is the first subprogram 
 * it will draw a cube in the window
 * the cube is moving and once it move to the boundary the cube will bounce back 
 */

public class CubeBounceComponent extends JComponent
{

    Timer timer;
    private static int DELAY = 10;
    int speed;  // speed of the cube
    int cubex;
    int cubey;
    final static int CUBE_WIDTH = 60;
    final static int  CUBE_HEIGHT = 60;
    double angle;  // and angle of the direction 


//--------------------------------------------------------------------------------------------
    
    /**
     * this is a inner class
     * this class implement the ActionListener interface 
     * it over ride the actionperformed method 
     * the listener is alknowledage by the timer once it reach to delate 
     * the overrided method will rerun
     */
	class BounceListener implements ActionListener
	{
		@Override
		/**
		 * the method will set the x and y for the cube by calculating the angle and the speed 
		 * every time when the timer reach to current pattern it will recalculate the x and y 
		 * adn also it will paint the screen again
		 * @param e an event 
		 */
       public void actionPerformed(ActionEvent e)
       {
       	  // recalculate the x and y for the cube
       	  cubex += speed * Math.cos(angle);
       	  cubey += speed * Math.sin(angle);
          
          // check if the cube touch the boundary
       	  angle = (cubex + CUBE_WIDTH >= getWidth()  || cubex <= 0) ? Math.PI - angle : angle;
       	  angle = (cubey + CUBE_HEIGHT >= getHeight() || cubey <= 0) ? -angle : angle;

       	  repaint();
       }
	}


//------------------------------------------------------------------------------------------------

    /**
     * this is a constructor for the class
     * it initial all the field in the class 
     */
    
	CubeBounceComponent()
	{
        BounceListener listener = new BounceListener();  // create listener
        timer = new Timer(DELAY, listener);  // create a timer
        speed = 20;
        cubex = 0;
        cubey = 0;
        angle = 60 * Math.PI / 180;
        timer.start();
	}


//------------------------------------------------------------------------------------------------
    
    @Override
    /**
     * the method override the method in the JComponent 
     * it draw a picture in the screen
     * @param g the Graphics type which represent a drawing pen
     */

	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		Cube cube = new Cube(cubex,cubey,CUBE_WIDTH, CUBE_HEIGHT);
		cube.draw(g2);
	}
}