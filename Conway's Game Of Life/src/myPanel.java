import java.awt.Color;
import java.awt.Dimension;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JPanel;
import javax.swing.Timer;

public class myPanel extends JPanel implements ActionListener{
	private Grid test;
	private int delay = 20;
	private Timer tm;
	myPanel(int width,int height){
		this.setPreferredSize(new Dimension(width,height));
		this.setBounds(0, 0, width, height);
		this.setBackground(Color.WHITE);
		this.setLayout(null);
		test = new Grid(width,height,10);
		tm = new Timer(delay,this);
		tm.start();
	}
	
	
	public void paint(Graphics g) {
		this.paintComponent(g);	

		test.drawGrid(g);
	
		test.setFutureGrid();
	}


	@Override
	public void actionPerformed(ActionEvent e) {
		
		
		// TODO Auto-generated method stub
		
		
		
		repaint();
	}
}
