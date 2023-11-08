import javax.swing.*;
import java.awt.*;



public class Starter  {
    public static void main(String[] args) throws InterruptedException {
        
        JFrame frame = new JFrame("Thanksgiving Attack");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        MainPanel mainPanel = new MainPanel();
        mainPanel.setPreferredSize(new Dimension(700,698));
        mainPanel.setBackground(Color.white);
        frame.getContentPane().add(mainPanel);
        frame.pack();

        mainPanel.addMouseListener(mainPanel);
        mainPanel.addMouseMotionListener(mainPanel);

        Timer t1 = new Timer(42,mainPanel);
        t1.start();










    }
}
