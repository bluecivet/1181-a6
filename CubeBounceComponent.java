import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class CubeBounceComponent extends JComponent
{

    Timer timer;
    private static int DELAY = 10;
    int speed;
    int cubex;
    int cubey;
    final static int CUBE_WIDTH = 60;
    final static int  CUBE_HEIGHT = 60;
    double angle;


//--------------------------------------------------------------------------------------------


	class BounceListener implements ActionListener
	{
       public void actionPerformed(ActionEvent e)
       {
       	  cubex += speed * Math.cos(angle);
       	  cubey += speed * Math.sin(angle);

       	  angle = (cubex + CUBE_WIDTH >= getWidth()  || cubex <= 0) ? Math.PI - angle : angle;
       	  angle = (cubey + CUBE_HEIGHT >= getHeight() || cubey <= 0) ? -angle : angle;

       	  repaint();
       }
	}


//------------------------------------------------------------------------------------------------


	CubeBounceComponent()
	{
        BounceListener listener = new BounceListener();
        timer = new Timer(DELAY, listener);
        speed = 20;
        cubex = 0;
        cubey = 0;
        angle = 60 * Math.PI / 180;
        timer.start();
	}


//------------------------------------------------------------------------------------------------


	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		Cube cube = new Cube(cubex,cubey,CUBE_WIDTH, CUBE_HEIGHT);
		cube.draw(g2);
	}
}