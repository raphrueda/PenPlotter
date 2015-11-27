import java.awt.Point;

/**
 * Defines one action for the pen plotter. An action consists of three points, initial pen position, line start and line end points.
 * @author Raph
 *
 */
public class Action {
	
	/**
	 * Constructs an action object given three points
	 * @param p1 The initial pen position
	 * @param p2 The start of the line to be drawn
	 * @param p3 The end of the line to be drawn
	 */
	public Action(Point p1, Point p2, Point p3){
		this.start = p1;
		this.drawStart = p2;
		this.drawEnd = p3;
		this.actionCost = p1.distance(p2) + p2.distance(p3);
	}
	
	/**
	 * Gets the start point of the action
	 * @return the start point of the action
	 */
	public Point getStart(){return start;}
	
	/**
	 * Gets the second point of the action (start of line)
	 * @return the start point of the line that was drawn
	 */
	public Point getDrawStart(){return drawStart;}
	
	/**
	 * Gets the last point of the action (end of line)
	 * @return the end point of the line that was drawn
	 */
	public Point getDrawEnd(){return drawEnd;}
	
	/**
	 * Gets the cost of this action
	 * @return distance pen has moved during action 
	 */
	public double getCost(){return actionCost;}

	/**
	 * Prints actions in the required format
	 */
	public void print(){
		if(!start.equals(drawStart)){
			System.out.println("Move from "+start.x+" "+start.y+" to "+drawStart.x+" "+drawStart.y);
		}
		System.out.println("Draw from "+drawStart.x+" "+drawStart.y+" to "+drawEnd.x+" "+drawEnd.y);
	}

	//Fields
	private Point start;
	private Point drawStart;
	private Point drawEnd;
	private double actionCost;
}
