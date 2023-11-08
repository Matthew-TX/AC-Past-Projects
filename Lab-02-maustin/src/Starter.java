import java.awt.*;

import javax.swing.*;

public class Starter {

	public static void main(String[] args) {
		JFrame frame = new JFrame("Forest Fire");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setVisible(true);


        MainPanel mainPanel = new MainPanel();
        mainPanel.setPreferredSize(new Dimension(500,500));
        mainPanel.setBackground(Color.white);
        frame.getContentPane().add(mainPanel);
        frame.pack();

        mainPanel.addMouseListener(mainPanel);
        mainPanel.addMouseMotionListener(mainPanel);
        
        Timer t1 = new Timer(30,mainPanel);
        t1.start();
		

	}

}
