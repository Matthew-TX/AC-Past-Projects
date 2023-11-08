import javax.imageio.ImageIO;
import javax.sound.sampled.AudioInputStream;
import javax.sound.sampled.AudioSystem;
import javax.sound.sampled.Clip;
import javax.sound.sampled.LineUnavailableException;
import javax.sound.sampled.UnsupportedAudioFileException;
import java.io.File;
import java.io.IOException;
import java.nio.file.Paths;
import java.awt.Graphics;
import java.awt.Image;


public class TurkeyFile {
	
	//Member Variables
	private Image background=null;
	private Image turkey = null;
	private Clip clip = null;
	
	public TurkeyFile() {

		//Loading an Image
		try{
			turkey  = ImageIO.read(new File("Turkey.png"));
		} catch (Exception e){
			turkey  = null;
			System.out.println("UH OH, no file found");
		}
		
		
		
		
		
		File soundFile = Paths.get("Turkey.aif").toFile();
		AudioInputStream as=null;
		try{
			as=AudioSystem.getAudioInputStream(soundFile);
			clip = AudioSystem.getClip();
			clip.open(as);
		} catch (IOException e){
			System.err.println("Could not find sound file :"+soundFile.getAbsolutePath());
		} catch (UnsupportedAudioFileException e){
			System.err.println("The file is NOT an audio file :"+soundFile.getAbsolutePath());
		} catch (LineUnavailableException e){
			System.err.println("The audio line is not available, probably used elsewhere");
		}
	}

	
	public void playTurkeyNoise() {
		clip.stop();
		clip.setMicrosecondPosition(0);
		clip.start();
	}
	
	//This centers on the x and y value
	public void drawTurkey(int x, int y, Graphics page) {
		if(turkey!=null){
			page.drawImage(turkey, x-50,y-122/2, null);
			
		}
	}
	
	
	
	

}
