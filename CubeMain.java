/**

 * File:        CubeMain.java

 * Author:      Zhilong Gan

 * ID:          100331942

 * Date:        2019.02.21

 * class:       CPSC 1181-03

 * instructor:  Hengameh Hamavand

 * title        cube

 * Compiler:    java JDK 10.2

 */


/**
  this program is the main program for the assignment
  the program has tow subprogram
  1, draw a moving cube in the window once the cube touch the bounard the cube will change direction
  2, draw a static cube in the window once the user click the cube will move to that place
  the program will let user choose which subprogram they want to performence 
*/

import javax.swing.*;

public class CubeMain
{
	public static void main(String[] args)
	{
		int userOption = askOption();  
		JComponent jc = null;

		switch(userOption)   // the subprograms 
		{
			case 0: jc = new CubeBounceComponent(); break;  // the first subprogram 

			case 1: jc = new CubeClickComponent(); break;   // the second subprogram

			default: break;  // in case nothing will happen
		}

		JFrame jf = new JFrame("cube");   // create window
		jf.setSize(500,500);
		jf.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		jf.add(jc);  // add the JComponent which is the subprogram
		jf.setVisible(true);

	}

    
    ////////////////////////////////////////////////////////////////////////
    
    /**
     * the method will ask user to choose the option for subprogram 
     * @return a integer type which represent the option of the user
     */
  
	public static int askOption()
	{
		String[] options = {"Bouncing the cube", "click and move the cube"};  // decripting user options

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