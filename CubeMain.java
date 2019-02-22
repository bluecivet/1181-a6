import javax.swing.*;

public class CubeMain
{
	public static void main(String[] args)
	{
		int userOption = askOption();
		JComponent jc = null;

		switch(userOption)
		{
			case 0: jc = new CubeBounceComponent(); break;

			case 1: jc = new CubeClickComponent(); break;

			default: break;
		}

		JFrame jf = new JFrame("cube");
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(jc);
		jf.setVisible(true);
	}

    
    ////////////////////////////////////////////////////////////////////////


	public static int askOption()
	{
		String[] options = {"Bouncing the cube", "click and move the cube"};

       int answer = JOptionPane.showOptionDialog
       (
       	 null,
       	 "which program do you want?",
       	 "asking for option",
       	 JOptionPane.YES_NO_CANCEL_OPTION,
       	 JOptionPane.QUESTION_MESSAGE,
       	 null,
       	 options,
       	 options[0]
       	);

       return answer;
	}


	//////////////////////////////////////////////////////////////////////////////////////////////

}