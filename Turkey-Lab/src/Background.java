import javax.imageio.ImageIO;
import java.awt.*;
import java.io.File;

public class Background {

    Image background = null;
    public Background(){
        try{
            background = ImageIO.read(new File("Thanksgiving.jpg"));
        } catch (Exception e){
            background = null;
            System.out.println("UH OH, no file found");
        }

    }
    public void paint(Graphics g){
        try{
            background = ImageIO.read(new File("Thanksgiving.jpg"));
        } catch (Exception e){
            background = null;
            System.out.println("UH OH, no file found");
        }
        if(background!=null){
            g.drawImage(background, 0,0, null);
        }
    }
}
