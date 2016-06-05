package Main;
import static java.lang.Math.*;
public class Punto {

	float x;
	float y;
	Vector v;
	
	public Punto(float x, float y){
		this.x=x;
		this.y=y;
	}
	public Punto(float x, float y,Vector v){
		this.x=x;
		this.y=y;
		this.v=v;
	}
	
	public void rotar(Punto c, float angulo){
		x-=c.x;
		y-=c.y;
		float new_x = (float) (x * cos(angulo) - y * sin(angulo));
		float new_y = (float) (x * sin(angulo) + y * cos(angulo));
		y = new_y;
		x = new_x;
		x+=c.x;
		y+=c.y;
	}
	
	public void mover(){
		x += v.x;
		y += v.y;
	}
	
	public void reflejar(Segmento s){
		Punto pc = s.getPuntoCorte(new Segmento(new Punto(x,y),new Punto(x+v.x,y+v.y)));
		
		if(pc!=null){
			float sang = (float) Math.atan2(s.a.y-s.b.y, s.a.x-s.b.x);
			float vang = (float) Math.atan2(v.y, v.x);
			float dang = vang-sang;
			rotar(pc,2*dang);
			System.out.println(sang);
		}

	}
}
