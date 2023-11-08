import java.awt.*;

import javax.swing.JPanel;

public class Squares extends JPanel{
	//Member Variables
	int windowWidth=1024;
	int windowHeight=768;
	int plotSize = 4;
	int plotsOfLand=(windowHeight/plotSize)*(windowWidth/plotSize);
	int colorNumber;
	int xPosition;
	int yPosition;
	boolean randomized = false;


	//Color Array
	Color [] colorArray = new Color[5];{
		colorArray[0]=Color.white;
		colorArray[1]=Color.DARK_GRAY;
		colorArray[2]=Color.orange;
		colorArray[3]=Color.yellow;
		colorArray[4]=Color.green;

	}
	//Square Constructor
	public Squares(int xPosition, int yPosition) {
		super();
		this.xPosition = xPosition;
		this.yPosition = yPosition;
		int treesOrLand = (int)(Math.random()*2);
			if(treesOrLand==1)
			{
				colorNumber=4;
			} 

			else
			{
				colorNumber=0;
			}
	}

	//Square Functions
	public void paint(Graphics g)
	{


		//Shapes
		g.setColor(colorArray[colorNumber]);
		g.fillRect(xPosition, yPosition, plotSize, plotSize);
	}

	public boolean isRandomized() {
		return randomized;
	}

	public void setRandomized(boolean randomized) {
		this.randomized = randomized;
	}

	public int getColorNumber() {
		return colorNumber;
	}

	public void setColorNumber(int colorNumber) {
		this.colorNumber = colorNumber;
	}

	public int getxPosition() {
		return xPosition;
	}

	public void setxPosition(int xPosition) {
		this.xPosition = xPosition;
	}

	public int getyPosition() {
		return yPosition;
	}

	public void setyPosition(int yPosition) {
		this.yPosition = yPosition;
	}



	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
}
