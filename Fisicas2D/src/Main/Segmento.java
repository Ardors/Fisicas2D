package Main;

import java.awt.Graphics;

public class Segmento {
	Punto a;
	Punto b;
	
	public Segmento(Punto a, Punto b){
		this.a= a;
		this.b= b;
	}
	
	public void dibujar(Graphics g){
		g.drawLine((int)a.x,(int)a.y,(int)b.x,(int)b.y);
	}
	
	public Punto getPuntoCorte (Segmento s){
		float A1= b.y-a.y;
		float A2= s.b.y-s.a.y;
		float B1= a.x-b.x;
		float B2= s.a.x-s.b.x;
		float C1= b.x*a.y-a.x*b.y;
		float C2= s.b.x*s.a.y-s.a.x*s.b.y;
		
		float x= (B1*C2-B2*C1)/(A1*B2-A2*B1);
		float y= (A2*C1-A1*C2)/(A1*B2-A2*B1);
		
		if(x>Math.max(Math.min(a.x, b.x), Math.min(s.a.x, s.b.x)) && x<Math.min(Math.max(a.x, b.x), Math.max(s.a.x, s.b.x))){
			return new Punto(x,y);
		}else{
			return null;
		}
		
	}
}
