import java.awt.Point;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.Scanner;

/**
 * Takes input from the file specified in the first argument and converts it into a series of lines. 
 * These are passed into a StateSearch object.
 * @author Raph
 *
 */
public class PenPlotter {
	/**
	 * Pen plotter system, in charge of taking input from args and converting them into a series of lines to draw 
	 * @param args The argument line
	 */
	public static void main(String[] args){
		Scanner sc = null;
		try {
			sc = new Scanner(new FileReader(args[0]));
		} catch (FileNotFoundException e){
			System.out.println("File not found.");
			System.exit(0);
		}
		
		ArrayList<Line> lines = new ArrayList<Line>();
		while(sc.hasNextLine()){
			String string = sc.nextLine();
			String[] parts = string.split(" ");
			Line line = new Line(new Point(Integer.parseInt(parts[2]), Integer.parseInt(parts[3])),
								 new Point(Integer.parseInt(parts[5]), Integer.parseInt(parts[6])));
			lines.add(line);
		}
		StateSearch search = new StateSearch(lines);
		search.aStarSearch();
	}
}
