import javax.swing.*;
import javax.swing.event.MouseInputListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseMotionListener;
import java.util.ArrayList;

public class MainPanel extends JPanel implements MouseMotionListener, MouseInputListener, ActionListener {
    public int deltaX;
    public int deltaY;
    public int randomStart = (int) (Math.random()*700);
    public int mouseX;
    public int mouseY;
    public int i = 0;
    public int turkey1X;
    public int turkey1Y;
    Background background = new Background();
    TurkeyFile turkey1 = new TurkeyFile();
    ArrayList<TurkeyFile> turkeyFileArrayList = new ArrayList<>();
    public TurkeyFile turkeyClone;





//Panel Painter
    protected void paintComponent(Graphics g)
    {

        super.paintComponent(g);

        background.paint(g);

        turkey1.drawTurkey(g);

        System.out.println("paint" + i);
        turkeyFileArrayList.add(i,new TurkeyFile());
        turkeyFileArrayList.get(i).drawTurkey(g);

    }




//Timer Functions
        public void actionPerformed(ActionEvent e)
        {
            turkey1X=turkey1.getX();
            turkey1Y=turkey1.getY();

        //Turkey   1


            //Set X
                if(mouseX-turkey1X+20>0)
                {
                    deltaX=15;
                    if(turkey1X>=mouseX)
                    {
                        deltaX=0;
                    }

                }
                else
                {
                    deltaX=-15;
                    if (turkey1X<=mouseX)
                    {
                        deltaX=0;
                    }

                }
                    //Result
                        turkey1.setX(turkey1.getX()+ deltaX);





            //Set Y
                if(mouseY-turkey1Y+20>0)
                {
                    deltaY=15;
                    if(turkey1Y>=mouseY)
                    {
                        deltaY=0;
                    }

                }
                else
                {
                    deltaY=-15;
                    if (turkey1Y<=mouseY)
                    {
                        deltaY=0;
                    }

                }
                    //Result
                        turkey1.setY(turkey1.getY()+ deltaY);


//        //Turkey Clones
//                    int cloneDistanceX = mouseX - turkeyFileArrayList.get(i).getX();
//                    int cloneDistanceY = mouseY - turkeyFileArrayList.get(i).getY();
//                    int cloneDeltaX;
//                    int cloneDeltaY;
//
//
//
//                    //Set X
//                        if(turkeyFileArrayList.get(i).getX()==mouseX)
//                        {
//                            cloneDeltaX=0;
//                        }
//                        else
//                        {
//                            cloneDeltaX = cloneDistanceX/distanceIntervals;
//                        }
//                        turkeyFileArrayList.get(i).setX(turkeyFileArrayList.get(i).getX()+cloneDeltaX);
//
//
//                    //Set Y
//                        if(turkeyFileArrayList.get(i).getY()==mouseY)
//                        {
//                            cloneDeltaY=0;
//                        }
//                        else
//                        {
//                            cloneDeltaY = cloneDistanceY/distanceIntervals;
//                        }
//                        turkeyFileArrayList.get(i).setY(turkeyFileArrayList.get(i).getY()+cloneDeltaY);


            repaint();


        }




//Mouse Clicked Actions
        public void mouseClicked(MouseEvent e)
        {
            //Turkey 1
            System.out.println(e.getX());

        //    Mouse Inputs
            mouseX=e.getX();
            mouseY=e.getY();

            System.out.println("mouse x is " + mouseX);
            System.out.println("mouse y is " + mouseY);

//        //    Turkey Clones
//                turkeyFileArrayList.add(i,new TurkeyFile());
//                i++;
//                System.out.println(i);

        //  turkey1.playTurkeyNoise();


        }

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {

    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    @Override
    public void mouseExited(MouseEvent e) {

    }




    //Mouse Move Actions
    @Override
    public void mouseDragged(MouseEvent e) {

    }

    @Override
    public void mouseMoved(MouseEvent e) {

    }


}
