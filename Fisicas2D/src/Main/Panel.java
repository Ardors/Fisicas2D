package Main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Ventana ventana;
	
	float xmouse;
	float ymouse;
	
	public boolean suj1a = false;
	public boolean suj1b = false;
	public boolean suj2a = false;
	public boolean suj2b = false;
	
	public Panel(Ventana v) {
		ventana=v;
		
		addMouseMotionListener(new MouseAdapter(){
			public void mouseMoved (MouseEvent e){
				xmouse=e.getX();
				ymouse=e.getY();
			}
		});
	}	
		
	
	@Override 
	public void paint(Graphics g){
		super.paint(g);
		
	
		
		Segmento s1 = new Segmento(new Punto(600,100),new Punto(100,450));
		Punto p1 = new Punto(50,50,new Vector(0,0));
		Punto pf = new Punto(50,50,new Vector(0,0));
		p1.v.x=xmouse-p1.x;
		p1.v.y=ymouse-p1.y;
		pf.v.x=xmouse-pf.x;
		pf.v.y=ymouse-pf.y;
		System.out.println("vx: "+p1.v.x+" vy: "+p1.v.y);
		Punto pc = s1.getPuntoCorte(new Segmento(p1,new Punto(p1.v.x+p1.x,p1.v.y+p1.y)));
		
		s1.dibujar(g);
		
		g.drawLine((int)p1.x, (int)p1.y, (int)(p1.x+p1.v.x), (int)(p1.y+p1.v.y));
		
		if (s1.getPuntoCorte(new Segmento(p1,new Punto(p1.v.x+p1.x,p1.v.y+p1.y)))!=null){
			g.drawOval((int)pc.x-5, (int)pc.y-5, 10, 10);
			pf.reflejar(s1);
			g.drawOval((int)pf.x-5, (int)pf.y-5, 10, 10);
		}
		
		repaint();
	}

}
