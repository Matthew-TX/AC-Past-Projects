import java.awt.*;

public class lines {
//Member Variables
	public int x;
	public int y;

	
//Grid Constructor
	public lines(int x, int y) {
			super();
			this.x = x;
			this.y = y;
		}
	
//Grid Lines
	public void paint(Graphics g)
		{
			g.setColor(Color.gray);
			g.drawRect(x,y,10,10);
		}


//Getters and Setters
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



}
