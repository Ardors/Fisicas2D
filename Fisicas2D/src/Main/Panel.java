package Main;

import java.awt.Graphics;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

import javax.swing.JPanel;

public class Panel extends JPanel {
	private static final long serialVersionUID = 1L;
	
	Ventana ventana;
	Segmento s1 = new Segmento(new Punto(100,100), new Punto(600,300));
	Segmento s2 = new Segmento(new Punto(100,200), new Punto(600,200));
	public boolean suj1a = false;
	public boolean suj1b = false;
	public boolean suj2a = false;
	public boolean suj2b = false;
	
	public Panel(Ventana v) {
		ventana=v;
		
		addMouseListener(new MouseAdapter(){
			public void mousePressed (MouseEvent e){
				if(e.getButton()== MouseEvent.BUTTON1){
					if (e.getX()<s1.a.x+7 && e.getX()>s1.a.x-7 && e.getY()<s1.a.y+7 && e.getY()>s1.a.y-7){
						suj1a = true;		
					}
					if (e.getX()<s1.b.x+7 && e.getX()>s1.b.x-7 && e.getY()<s1.b.y+7 && e.getY()>s1.b.y-7){
						suj1b = true;		
					}
					if (e.getX()<s2.a.x+7 && e.getX()>s2.a.x-7 && e.getY()<s2.a.y+7 && e.getY()>s2.a.y-7){
						suj2a = true;		
					}
					if (e.getX()<s2.b.x+7 && e.getX()>s2.b.x-7 && e.getY()<s2.b.y+7 && e.getY()>s2.b.y-7){
						suj2b = true;		
					}
				};
			}
			public void mouseReleased (MouseEvent e){
				if(e.getButton()== MouseEvent.BUTTON1){
					suj1a = false;
					suj1b = false;
					suj2a = false;
					suj2b = false;
				};
			}
		});
		addMouseMotionListener(new MouseAdapter(){
			public void mouseDragged (MouseEvent e){
				if (suj1a){
					s1.a.x=e.getX();
					s1.a.y=e.getY();	
				}
				if (suj1b){
					s1.b.x=e.getX();
					s1.b.y=e.getY();	
				}
				if (suj2a){
					s2.a.x=e.getX();
					s2.a.y=e.getY();	
				}
				if (suj2b){
					s2.b.x=e.getX();
					s2.b.y=e.getY();	
				}
			}
		});
	}
	
	@Override 
	public void paint(Graphics g){
		super.paint(g);
		
		s1.dibujar(g);
		g.drawRect((int)s1.a.x-7, (int)s1.a.y-7, 14, 14);
		g.drawRect((int)s1.b.x-7, (int)s1.b.y-7, 14, 14);
		
		s2.dibujar(g);
		g.drawRect((int)s2.a.x-7, (int)s2.a.y-7, 14, 14);
		g.drawRect((int)s2.b.x-7, (int)s2.b.y-7, 14, 14);
		
		if (s1.getPuntoCorte(s2)!=null){
			g.drawOval((int)(s1.getPuntoCorte(s2).x-7), (int)(s1.getPuntoCorte(s2).y-7), 14, 14);
		}	
		
		repaint();
	}

}