
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.*;

import javax.swing.JPanel;
import javax.swing.event.MouseInputListener;

public class MainPanel extends JPanel implements MouseMotionListener, MouseInputListener, ActionListener{
/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
//Member Variables
	ArrayList<lines> gridLinesArray = new ArrayList<>();
	ArrayList<tile> tileArray= new ArrayList<>();
	int xPosition;
	int yPosition;
	int xClick;
	int yClick;
	boolean stall = true;
	int a = 0;
	
	
	public boolean notRandomized = true;
	
	
//paintComponent
	public void paintComponent (Graphics g)
	{
		int [] x = {500,100,220,300};
		int [] y = {400,200,190,300};
		g.fillPolygon(x, y, 20);
		
	//Initial Grid
		if(notRandomized)
		{
			for( int i=0; i<2500; i++)
			{
				//New Row
				if(xPosition==500)
				{
					xPosition=0;
					yPosition+=10;
				}
				
				//Tiles
				tileArray.add(new tile(xPosition,yPosition,stall));
				tileArray.get(i).paint(g);
				
				//Grid Lines
				gridLinesArray.add(i, new lines(xPosition,yPosition));
				gridLinesArray.get(i).paint(g);
				
				//Increase X
				xPosition+=10;
			}
			
			//notRandomized is true
			notRandomized = false;
		}
		
		
		
	//Adding Colors
		for( int i=0; i<2500; i++)
		{
			//Tile Click
			if (tileArray.get(i).getcolorNumber() !=1 &&(tileArray.get(i).getX()<xClick && tileArray.get(i).getX()+10>xClick) &&(tileArray.get(i).getY()<yClick && tileArray.get(i).getY()+10>yClick))
				{
					//Color Chooser
					tileArray.get(i).setcolorNumber((int)(Math.random()*6)+2);
					tileArray.get(i).setLeader(true);
					tileArray.get(i).paint(g);
				}
			
			if(!tileArray.get(i).isLeader())
			{
				//Spreading to tiles Below
					 if
						(		
							tileArray.get(i).getY() >= 10
							&& tileArray.get(i).getcolorNumber()!=1
							&& tileArray.get(i-50).getcolorNumber() >1
							&& tileArray.get(i-50).getcolorNumber() != tileArray.get(i).getcolorNumber()
						)
							{
								//One Tile at a Time
								if(!tileArray.get(i).isStall())
								{
									tileArray.get(i).setcolorNumber(tileArray.get(i-50).getcolorNumber());
									tileArray.get(i).paint(g);
									tileArray.get(i).setStall(true);	
								}
								else
								{
									tileArray.get(i).setStall(false);
								}
							}
				
			//Spreading to the Left
					else if( i%50<49 && tileArray.get(i).getcolorNumber()!=1 && tileArray.get(i+1).getcolorNumber()>1 )
					{
						if(!tileArray.get(i).isStall())
						{
							if(tileArray.get(i).getcolorNumber()!=tileArray.get(i+1).getcolorNumber())
							{
							tileArray.get(i).setcolorNumber(tileArray.get(i+1).getcolorNumber());
							tileArray.get(i).paint(g);
							tileArray.get(i).setStall(true);
							}
							
							
						}
						
						else
						{
							tileArray.get(i).setStall(false);
							
						}
					}
					
			//Spreading to the Right
					else if((i%50)>0 &&  tileArray.get(i).getcolorNumber()!=1 && tileArray.get(i-1).getcolorNumber()>1)
					{
						if(!tileArray.get(i).isStall())
						{
							if(tileArray.get(i).getcolorNumber()!=tileArray.get(i-1).getcolorNumber())
							{
							tileArray.get(i).setcolorNumber(tileArray.get(i-1).getcolorNumber());
							tileArray.get(i).paint(g);
							tileArray.get(i).setStall(true);
							}
							
							
						}
						
						else
						{
							tileArray.get(i).setStall(false);
							
						}
					}
				
			//Spreading to tiles Above
					else if
						(		
							tileArray.get(i).getY() < 490
							&& tileArray.get(i).getcolorNumber()!=1
							&& tileArray.get(i+50).getcolorNumber() >1
							&& tileArray.get(i+50).getcolorNumber() != tileArray.get(i).getcolorNumber()
						)
							{
								//One Tile at a Time
								if(!tileArray.get(i).isStall())
								{
									tileArray.get(i).setcolorNumber(tileArray.get(i+50).getcolorNumber());
									tileArray.get(i).paint(g);
									tileArray.get(i).setStall(true);	
								}
								else
								{
									tileArray.get(i).setStall(false);
								}
							}
			}
			//Refresh Lines
			gridLinesArray.get(i).paint(g);
		}
		
		if( a%2500==0)
		{
		for (int i=0; i<2500; i++)
		{
			if
			(
				i%50>0 && i%50<49 && tileArray.get(i).getY()<490 && tileArray.get(i).getY()>0
				&& tileArray.get(i).getcolorNumber() == tileArray.get(i-50).getcolorNumber() 
				&& tileArray.get(i).getcolorNumber() == tileArray.get(i+50).getcolorNumber() 
				&& tileArray.get(i).getcolorNumber() == tileArray.get(i-1).getcolorNumber() 
				&& tileArray.get(i).getcolorNumber() == tileArray.get(i+1).getcolorNumber()
				&& tileArray.get(i).isLeader()
				
			)
			tileArray.get(i).setLeader(false);
		}
		}
		
		
	
			
		
		a++;
		//Resetting X and Y
		xClick=0;
		yClick=0;
		
	}
	
	
	
	@Override
	public void mouseClicked(MouseEvent e) {
		//Test repent
		repaint();
		
		//Click Position
		xClick = e.getX();
		yClick = e.getY();
		
		//Test click
		System.out.println("click");
		
		
		
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

//Timer Actions
	public void actionPerformed(ActionEvent e) {
		repaint();
		
		
	}

	@Override
	public void mouseDragged(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public void mouseMoved(MouseEvent e) {
		// TODO Auto-generated method stub
		
	}

}
