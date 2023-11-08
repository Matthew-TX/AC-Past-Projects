import java.awt.Graphics;

import javax.swing.JPanel;

public class TestPanel extends JPanel{
	private static final long serialVersionUID = -3681844281808792594L;

	public void paintComponent(Graphics g)
	{
		g.drawRect(100, 25, 100, 100);
	}

}
