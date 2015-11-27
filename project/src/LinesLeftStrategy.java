import java.util.ArrayList;
/**
 * Implementation of a HeuristicStrategy Interface that calculates an appropriate heuristic for a state.
 * @author Raph
 *
 */
public class LinesLeftStrategy implements HeuristicStrategy {

	/**
	 * Constructs the strategy object with a given state.
	 * @param state The State to find the heuristic of.
	 */
	public LinesLeftStrategy(State state){
		this.lines = state.getLines(); 
	}
	
	/**
	 * Takes the sum of the distances of the lines that have not yet been drawn
	 */
	public double getH() {
		double h = 0;
		for(Line i: lines){
			h += i.length();
		}
		return h;
	}
	
	private ArrayList<Line> lines;
	
}
