import java.awt.Point;

/**
 * Defines a line in the x-y plane given two endpoints.
 * @author Raph
 *
 */
public class Line {
	/**
	 * Constructs a line in the x-y plane given two Points
	 * @param p1 first end point
	 * @param p2 second end point
	 */
	public Line(Point p1, Point p2){
		this.p1 = p1;
		this.p2 = p2;
	}
	
	/**
	 * Gets first endpoint of the line
	 * @return A Point containing the first endpoint
	 * 
	 */
	public Point getP1(){return p1;}
	
	/**
	 * Gets the second endpoint of the line
	 * @return A Point containing the second endpoint
	 */
	public Point getP2(){return p2;}
	
	/**
	 * Gets the second endpoint of the line
	 * @return A Point containing the second endpoint
	 */
	public double length(){return p1.distance(p2);}
	
	/**
	 * Compares two lines for equality
	 * @param other The line to compare against
	 * @return True if they are equal, false otherwise
	 */
	public boolean equals(Line other){
		if(this.p1.equals(other.p1) && this.p2.equals(other.p2)){
			return true;
		} else if(this.p1.equals(other.p2) && this.p2.equals(other.p1)) {
			return true;
		}
		return false;
	}

	private Point p1;
	private Point p2;
}
