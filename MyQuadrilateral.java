package mypackage;

public class MyQuadrilateral {
	
	private MyPoint a, b, c, d;
	
	private float lengthAB, lengthBC, lengthCD, lengthDA;
	
	public MyQuadrilateral(MyPoint[] points) {
		
		a = new MyPoint(points[0]);
		b = new MyPoint(points[1]);
		c = new MyPoint(points[2]);
		d = new MyPoint(points[3]);
		
		lengthAB = (float) Math.sqrt(Math.pow((b.getY() - a.getY()), 2) + Math.pow((b.getX() - a.getX()), 2));
		lengthBC = (float) Math.sqrt(Math.pow((c.getY() - b.getY()), 2) + Math.pow((c.getX() - b.getX()), 2));
		lengthCD = (float) Math.sqrt(Math.pow((d.getY() - c.getY()), 2) + Math.pow((d.getX() - c.getX()), 2));
		lengthDA = (float) Math.sqrt(Math.pow((a.getY() - d.getY()), 2) + Math.pow((a.getX() - d.getX()), 2));
		
	}
	
	public boolean isParallelogram() {
		
		if (this.lengthAB == this.lengthCD)
			if (this.lengthBC == this.lengthDA)
				return true;
		
		return false;
	}

}
