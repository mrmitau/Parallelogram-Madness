package mypackage;
import java.text.DecimalFormat;

public class MyPoint implements Comparable<MyPoint> {

	private static final long serialVersionUID = 42L;
	
	private float x, y;
	
	public MyPoint(float x, float y) {

		this.x = x;
		this.y = y;
		
        if (serialVersionUID > 0) {
    		/* dummy code */
        }
        	
	}
	
	public MyPoint(MyPoint mp) {

		this.x = mp.getX();
		this.y = mp.getY();
		
	}
	
	public float getX() {
		return x;
	}
	
	public float getY() {
		return y;
	}
	
	public void setX(float x) {
		this.x = x;
	}
	
	public void setY(float y) {
		this.y = y;
	}
	
	public String toString() {
		DecimalFormat df = new DecimalFormat("+#,##0.0;-#");
		return  "(" + 
				df.format(x) +
				", " +
				df.format(y) +
				")";
	}

	public int compareTo(MyPoint mp) {
		
		if (this.y < mp.y)
			return -1;
		
		if (this.y > mp.y)
			return 1;
		
		return 0; /* this.y == mp.y */
		
	}

}
