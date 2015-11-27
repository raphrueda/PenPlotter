import java.awt.Point;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.PriorityQueue;
/**
 * Sets up the initial state and performs an A* Search on it. 
 * Outputs the nodes expanded, total cost and actions taken to get to the most efficient state.
 * @author Raph
 *
 */
public class StateSearch {
	/**
	 * Constructor for the state search, fills in the input lines
	 * @param linesToDraw List of lines that are to be drawn
	 */
	public StateSearch(ArrayList<Line> linesToDraw){
		//read all lines into the ArrayList
		lines = new ArrayList<Line>();
		states = new PriorityQueue<State>();
		lines.addAll(linesToDraw);
		//Make initial state
		LinkedList<Action> actions = new LinkedList<Action>(); //no actions made
		Point penPos = new Point(0,0); //start at origin
		double penDist = 0; //pen hasn't moved
		states.add(new State(lines, actions, penPos, penDist)); //push the initial state to the pQueue
	}
	
	/**
	 * Performs an A* Search on the initial state and prints out nodes expanded, total movement cost and actions taken.
	 */
	public void aStarSearch(){
		int nodesExpanded = 0;
		State currState = states.remove();
		while(!currState.isFinalState()){
			states.addAll(currState.genStates());
			currState = states.remove();
			nodesExpanded ++;
		}
		System.out.println(nodesExpanded+" nodes expanded");
		DecimalFormat df = new DecimalFormat("#.##");
		System.out.println("cost = "+ df.format(currState.getDist()));
		currState.printActions();
	}
	
	private ArrayList<Line> lines;
	private PriorityQueue<State> states;
}
