/**
 * Interface for a heuristic to be provided to a State object
 * @author Raph
 *
 */
public interface HeuristicStrategy {
	/**
	 * Returns the heuristic of a given state
	 * @return A double containing the heuristic to the goal state
	 */
	public double getH();
}
