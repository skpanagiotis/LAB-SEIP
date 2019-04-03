package JavaAnalyzer;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/***
 * 
 * @author PANAGIOTIS The purpose of this class is to read a file, to calculate
 *         the metrics and write data to CSV file This class is Facade class
 */

public class Analyzer_OPS {

	/***
	 * This method takes the java file and returns an ArrayList that include every
	 * line of the java code
	 * 
	 * @param path : the path of the java file
	 * @return the content of the path in an ArrayList
	 */

	public static ArrayList<String> readSourceCode(String path) {
		ArrayList<String> code = new ArrayList<String>();
		try {
			code = Re_Wr_Ops.readFile(path);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}
		return code;
	}

	/***
	 * This method calculate the necessary metrics with given analyze type
	 * 
	 * @param analyze_type : the type of analyze (string or regex)
	 * @param code         : the ArrayList that contains the java code line by line
	 * @return an int array which includes the metrics
	 */

	public static int[] calculateMetrics(String analyze_type, ArrayList<String> code) {
		AnalyzerIO AIO = new AnalyzerIO();
		int[] metrics = new int[3];
		if (analyze_type.equals("string")) {
			metrics = AIO.string_analyze(code);
		} else {
			metrics = AIO.regex_analyze(code);
		}

		return metrics;
	}

	/***
	 * This method write the three metrics into a CSV file
	 * 
	 * @param metrics : the array that includes the metrics
	 * 
	 */
	public static void writeCSV(int[] metrics) {

		int loc = metrics[0];
		int nom = metrics[1];
		int noc = metrics[2];

		Re_Wr_Ops.insertCSV(loc, noc, nom);

	}

}
