package Main;

import java.awt.Dimension;
import java.awt.Toolkit;
import java.awt.event.KeyAdapter;
import java.awt.event.KeyEvent;

import javax.swing.JFrame;

public class Ventana extends JFrame{
	private static final long serialVersionUID = 1L;
	
	public static Dimension screenSize = Toolkit.getDefaultToolkit().getScreenSize();
	
	public Ventana(){
		setMinimumSize(new Dimension(800, 600)); 
		setResizable(false);
		setContentPane(new Panel(this));
		setVisible(true);
		setDefaultCloseOperation(EXIT_ON_CLOSE);
		
		addKeyListener(new KeyAdapter(){
			public void keyPressed (KeyEvent e){
				if(e.getKeyCode() == KeyEvent.VK_ESCAPE){
					System.exit(0);
				}
			}
		});
	}
	
}
