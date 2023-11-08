import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MainPanel extends JPanel implements MouseMotionListener, MouseInputListener, ActionListener{

	//Member Variables
	ArrayList <Squares> squareArray = new ArrayList<>();	
	boolean randomized=false;
	boolean clicked=false;
	int windowWidth=1024;
	int windowHeight=768;
	int xclick;
	int yclick;

	//Plots
	int plotSize = 4;
	int plotsOfLand=(windowHeight/plotSize)*(windowWidth/plotSize);
	int plotsPerRow = windowWidth/plotSize;
	int plotsPerColumn = windowHeight/plotSize;
	int xPosition=0;
	int yPosition=0;

	//Colors
	int green = 4;
	int yellow = 3;
	int orange = 2;
	int gray = 1;
	int white = 0;

	public MainPanel() {
		super();
		//Grid
		if (randomized==false)
		{
			//Grid Making
			for( int i=0; i<plotsOfLand; i++)
			{
				if(xPosition>windowWidth)
				{
					xPosition=0;
					yPosition+=plotSize;
				}

				squareArray.add(i,new Squares(xPosition,yPosition));
				xPosition+=plotSize;
			}	


			for( int i=0; i<plotsOfLand; i++)
			{
				squareArray.get(i).setRandomized(true);	

			}

			//Stop Grid Making
			randomized=true;
		}
	}


	//Paint Component
	public void paintComponent(Graphics g)
	{	
		super.paintComponent(g);
		for( int i=0; i<squareArray.size(); i++) {
			squareArray.get(i).paint(g);
		}

		//Changing Colors
		


	}

	//Mouse Clicked Functions	
	public void mouseClicked(MouseEvent e) 
	{
		//Mouse Click
		xclick=e.getX();
		yclick=e.getY();


		//Repaint
		repaint();

		//Click True/False
		clicked=true;

		//Test
		System.out.println("The x is " + e.getX() + "the y is" + e.getY());




	}

	//Timer Functions
	public void actionPerformed(ActionEvent e) 
	{
		for( int i=0; i<plotsOfLand; i++) {



			//Continue Burning
			if(squareArray.get(i).getColorNumber()>1&&squareArray.get(i).getColorNumber()<=3)
			{
				squareArray.get(i).setColorNumber(squareArray.get(i).getColorNumber()-1);
			}




			//Burn by Clicking
			if
			(
					squareArray.get(i).getColorNumber()==4
					&&((squareArray.get(i).getxPosition()<xclick && squareArray.get(i).getxPosition()+4>xclick)
							&&(squareArray.get(i).getyPosition()<yclick && squareArray.get(i).getyPosition()+4>yclick)
							)
					) 
			{
				clicked=false;
				squareArray.get(i).setColorNumber(squareArray.get(i).getColorNumber()-1);
			}

			//Adjacent Burning
			if
			(

					squareArray.get(i).getColorNumber()==4&&
					(
							//Squares to the right 
							(i%plotsPerRow>=0&&i%plotsPerRow<=255)
							&&(i+1<squareArray.size()&& squareArray.get(i+1).getColorNumber()<green && squareArray.get(i+1).getColorNumber()>gray)

							//Squares to the left [problem]
							||(i%plotsPerRow>=1 && i%plotsPerRow<=255)
							&&(i-1>=0&&squareArray.get(i-1).getColorNumber()<green &&squareArray.get(i-1).getColorNumber()>gray)

							//Fire Below to Above
							||(squareArray.get(i).getyPosition()<756) 
							&&(i+plotsPerRow<squareArray.size() && squareArray.get(i+plotsPerRow).getColorNumber()<green && squareArray.get(i+plotsPerRow).getColorNumber()>gray)

							//Squares above to below [problem]
							||(squareArray.get(i).getyPosition()>0)
							&&(i-plotsPerRow>=0&&squareArray.get(i-plotsPerRow).getColorNumber()<green && squareArray.get(i-plotsPerRow).getColorNumber()>gray)
							)
					)
			{
				squareArray.get(i).setColorNumber(squareArray.get(i).getColorNumber()-1);
			}



		}
		repaint();
	
	}






	@Override
	public void mousePressed(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseReleased(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseEntered(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseExited(MouseEvent e) {
		// TODO Auto-generated method stub

	}


	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub

	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub

	}
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
