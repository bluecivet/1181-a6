import javax.swing.*;

public class CubeTest
{
	public static void main(String[] args)
	{
		JFrame jf = new JFrame("Title");
		jf.setSize(100,100);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		CubeComponent viewer = new CubeComponent();
		jf.add(viewer);
        jf.setVisible(true);

	}
}