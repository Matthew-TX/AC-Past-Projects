import java.awt.Graphics;
import java.awt.Image;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.io.File;

import javax.imageio.ImageIO;
import javax.sound.sampled.Clip;
import javax.swing.JPanel;

public class ImageFiles extends JPanel implements MouseListener{
	//Member Variables
		private Image puzzle = null;
		private Image adventure = null;
		private Image action = null;
		
		
		public ImageFiles() {
			//Action
			try{
				action  = ImageIO.read(new File("action.png"));
			} catch (Exception e){
				action  = null;
				System.out.println("UH OH, no file found");
			}
			
			//Puzzle
			try{
				puzzle  = ImageIO.read(new File("puzzle.png"));
			} catch (Exception e){
				puzzle  = null;
				System.out.println("UH OH, no file found");
			}
			
			//Adventure
			try{
				adventure  = ImageIO.read(new File("adventure.png"));
			} catch (Exception e){
				adventure  = null;
				System.out.println("UH OH, no file found");
			}
		}
		
		public void paintComponent(Graphics g)
		{
		
			int pictureWidth = 200;
			int pictureLength = 150;
			int pictureX = 50;
			int pictureY = 0;
			g.drawImage(action.getScaledInstance(pictureWidth, pictureLength, 0), pictureX, pictureY, null);
			g.drawImage(adventure.getScaledInstance(pictureWidth, pictureLength, 0), pictureX+250, pictureY, null);
			g.drawImage(puzzle.getScaledInstance(pictureWidth, pictureLength, ABORT), pictureX+500, pictureY, null);
			
		}

		
		@Override
		public void mouseClicked(MouseEvent e) {
			System.out.println("Clicked");
			
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
}
