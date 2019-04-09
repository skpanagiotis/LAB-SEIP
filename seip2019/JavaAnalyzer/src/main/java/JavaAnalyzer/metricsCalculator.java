package JavaAnalyzer;

import java.util.ArrayList;
/***
 * 
 * @author PANAGIOTIS This class is the Singleton class and contains the main
 *         method The purpose of this class is to read a java file and count the
 *         lines of code, number of methods and number of classes with two
 *         Techniques with regex and string. The metrics that this class counts,
 *         save in a csv file.
 */

public class metricsCalculator {
	/***
	 * This method is the base of the program
	 * 
	 * @param args args[0]: The path of the java file. args[1]: The type to analyze
	 *             the code.
	 */
	public static void main(String[] args) {
		String file = args[0];
		String analyze_type = args[1];

		ArrayList<String> code = AnalyzerOps.readSourceCode(file);

		int[] metrics = AnalyzerOps.calculateMetrics(analyze_type, code);

		AnalyzerOps.writeCSV(metrics);
	}

}
