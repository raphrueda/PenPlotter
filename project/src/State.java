import java.awt.Point;
import java.util.ArrayList;
import java.util.LinkedList;

/**
 * Stores the properties of a single state, including the lines not yet drawn, 
 * the actions taken to get to the state, pen position and the cost. In charge 
 * of generating the states accessible from this state.
 * @author Raph
 *
 */
public class State implements Comparable<State>{
	/**
	 * Constructs a state
	 * @param toDraw List of the lines left to draw in this state
	 * @param actions List of actions taken to get to this state
	 * @param penPos Current position of the pen at this state
	 * @param penDist Total cost to get to this state
	 */
	public State(ArrayList<Line> toDraw, LinkedList<Action> actions, 
				 Point penPos, double penDist){
		this.toDraw = toDraw;
		this.actions = actions;
		this.penPos = penPos;
		this.penDist = penDist;
	}

	/**
	 * Gets the total cost/distance moved of the pen to get to this state
	 * @return A double holding the distance
	 */
	public double getDist(){return penDist;}
	
	/**
	 * Gets a list of lines left to draw
	 * @return A list of lines to draw
	 */
	public ArrayList<Line> getLines(){return this.toDraw;}
	
	
	/**
	 * Compares two state for equality
	 * @param other The state to compare against
	 * @return True if they are equal, false otherwise
	 */
	public boolean equals(State other){
		if(this.toDraw.containsAll(other.toDraw) && other.toDraw.containsAll(this.toDraw)){ //order not important
			return true;
		}
		return false;
	}

	@Override
	public int compareTo(State other){
		LinesLeftStrategy comThis = new LinesLeftStrategy(this);
		LinesLeftStrategy comOther = new LinesLeftStrategy(other);
		double thisF = this.penDist + comThis.getH();
		double otherF = other.penDist + comOther.getH();
		if(thisF == otherF) return 0;
		else if(thisF < otherF) return -1;
		else return 1;
	}

	/**
	 * Generates possible state reachable after one action from this state(one move followed by a draw)
	 * @return A list of states reachable from this state
	 */
	public ArrayList<State> genStates(){
		ArrayList<State> generatedStates = new ArrayList<State>();
		for(Line i: toDraw){
			ArrayList<Line> newToDraw = new ArrayList<Line>();	
			newToDraw.addAll(toDraw);				//copy the current states toDraw list
			newToDraw.remove(i);					//remove the line we intend to draw
			//State 1
			LinkedList<Action> newActions = new LinkedList<Action>();
			newActions.addAll(actions);				//copy the actions made to get to this current state
			Action newAction = new Action(penPos, i.getP1(), i.getP2()); 	//create the intended action
			newActions.add(newAction);										//append it to the existing actions (as to keep order)
			Point newPenPos = i.getP2();							//pen position after the action
			double newPenDist = (penDist + newAction.getCost());	//add the new distance to the current
			State toAdd = new State(newToDraw, newActions, newPenPos, newPenDist);	//create the state
			generatedStates.add(toAdd);												//add it to the list of generated states
			
			//State 2 (mirror of State 1)
			//no need to re-make newToDraw as we are drawing the same line for the mirror
			newActions = new LinkedList<Action>();						//clear newActions
			newActions.addAll(actions);										//get a clean copy of the past actions
			newAction = new Action(penPos, i.getP2(), i.getP1());	//append the mirrored action (i.e. reverse end points)
			newActions.add(newAction);									 
			newPenPos = i.getP1();										//position is at other end point
			newPenDist = (penDist + newAction.getCost());				//get the sum of the old and new distance for this state
			toAdd = new State(newToDraw, newActions, newPenPos, newPenDist);
			generatedStates.add(toAdd);
		}
		return generatedStates;
	}
	
	/**
	 * Checks if this state is a goal state
	 * @return True if is a goal state, false otherwise
	 */
	public boolean isFinalState(){
		if(toDraw.isEmpty()) return true;
		return false;
	}
	
	/**
	 * Prints out the actions taken to get to this state
	 */
	public void printActions(){
		for(Action a : actions){
			a.print();
		}
	}
	
	//Fields
	private ArrayList<Line> toDraw;
	private LinkedList<Action> actions;
	private Point penPos;
	private double penDist;
}
