package Main;

import java.awt.Graphics;

public class Segmento {
	Punto a;
	Punto b;
	
	public Segmento(Punto a, Punto b){
		this.a=a;
		this.b=b;
	}
	
	public void dibujar(Graphics g){
		g.drawLine((int)a.x,(int)a.y,(int)b.x,(int)b.y);
	}
	public Punto getPuntoCorte (Segmento s){
		float m1 = (a.y-b.y)/(a.x-b.x);
		float m2 = (s.a.y-s.b.y)/(s.a.x-s.b.x);
		float n1 = a.y-a.x*m1;
		float n2 = s.a.y-s.a.x*m2;
		
		float x = (n1-n2)/(m2-m1);;
		if (0==(a.x-b.x)){
			x = a.x;
		}
		if (0==(s.a.x-s.b.x)){
			x = s.a.x;
		}
		float y = n1+m1*x;
		
		if (x >= Math.min(a.x, b.x) && x >= Math.min(s.a.x, s.b.x) && x <= Math.max(a.x, b.x) && x <= Math.max(s.a.x, s.b.x) &&
			y >= Math.min(a.y, b.y) && y >= Math.min(s.a.y, s.b.y) && y <= Math.max(a.y, b.y) && y <= Math.max(s.a.y, s.b.y)){
				return new Punto(x,y);
		}
		return null;
	}
}
