package Main;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public class Vector {
	float x;
	float y;
	
	public Vector(float x, float y){
		this.x=x;
		this.y=y;
	}
	
	public Vector rotar(float ang){
		float new_x = (float) (x * cos(ang) - y * sin(ang));
		float new_y = (float) (x * sin(ang) + y * cos(ang));
		return new Vector(new_x,new_y);
	}
}
