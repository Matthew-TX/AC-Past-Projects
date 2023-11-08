import java.awt.Color;
import java.awt.Graphics;

public class tile {

//Member Variables
		public int x;
		public int y;
		public int colorNumber;
		public boolean notRandomized = true;
		public boolean stall = true;
		public boolean colored;
		public boolean leader;
		



		

		//Color Array
		Color [] colorArray = new Color[8];{
			colorArray[0]=Color.white;
			colorArray[1]=Color.black;
			colorArray[2]=Color.blue;
			colorArray[3]=Color.red;
			colorArray[4]=Color.cyan;
			colorArray[5]=Color.orange;
			colorArray[6]=Color.green;
			colorArray[7]=Color.magenta;
		}
		
//Grid Constructor
		public tile(int x, int y, boolean stall)
		{
				super();
				this.x = x;
				this.y = y;
				this.stall = stall;
		}
		
public boolean isStall() {
			return stall;
		}

		public void setStall(boolean stall) {
			this.stall = stall;
		}

	//Grid Squares Painting
	public void paint(Graphics g)
	{
		//Free and Blocked 
		final int freeOrBlocked = (int)(Math.random()*2);
		
		//Randomizing 
		if(notRandomized)
			{
				if(freeOrBlocked==0)
				{
					colorNumber=0;
					g.setColor(colorArray[colorNumber]);
					
				}
				if(freeOrBlocked==1)
				{
					colorNumber=1;
					g.setColor(colorArray[colorNumber]);
				}
				notRandomized=false;
			}
				
		//Changing Colors
				else
				{
					g.setColor(colorArray[colorNumber]);
				}
				g.fillRect(x,y,10,10);
	}


//Color Number Getters and Setters
		public int getcolorNumber() {
			return colorNumber;
		}

		public void setcolorNumber(int colorNumber) {
			this.colorNumber = colorNumber;
		}
		
		public int getX() {
				return x;
			}


		public void setX(int x) {
			this.x = x;
		}


		public int getY() {
			return y;
		}


		public void setY(int y) {
			this.y = y;
		}
		public boolean isColored() {
			return colored;
		}

		public void setColored(boolean colored) {
			this.colored = colored;
		}
		public boolean isLeader() {
			return leader;
		}

		public void setLeader(boolean leader) {
			this.leader = leader;
		}

}
