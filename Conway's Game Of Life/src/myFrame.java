import javax.swing.*;

public class myFrame extends JFrame{
	private myPanel panel;
	private final int WIDTH = 1200;
	private final int HEIGHT = 800;
	myFrame(){
		this.setTitle("Conway's Game of Life");
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setSize(WIDTH, HEIGHT);
		this.setResizable(false);
		panel = new myPanel(WIDTH,HEIGHT);
		this.add(panel);
		this.pack();
		
		this.setLayout(null);
		this.setVisible(true);
		this.setLocationRelativeTo(null);
	}
}
