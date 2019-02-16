import java.awt.*;
import javax.swing.*;

public class CubeComponent extends JComponent
{
	public void paintComponent(Graphics g)
	{
		Graphics2D g2 = (Graphics2D) g;

		Cube cube = new Cube(10,10,60,60);
		cube.draw(g2);
	}
}