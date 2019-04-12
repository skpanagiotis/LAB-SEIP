package JavaAnalyzer;

import java.io.FileNotFoundException;
import java.util.ArrayList;

/***
 * 
 * @author PANAGIOTIS The purpose of this class is to read a file, to calculate
 *         the metrics and write data to CSV file This class is Facade class
 */

public class AnalyzerOps {
	

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
			code = ReWrOps.readFile(path);
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
		Analyzer analyzer = AIO.GetAnalyzer(analyze_type);
		int nom = analyzer.nom(code);
		int noc = analyzer.noc(code);
		code = remove_comments(code);
		int loc = analyzer.loc(code);
		int[] analytics = new int[3];
		metrics[0] = loc;
		metrics[1] = nom;
		metrics[2] = noc;

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

		ReWrOps.insertCSV(loc, noc, nom);

	}
	

	/***
	 * This method finds all the lines of the code which are comments
	 * 
	 * @param code : An ArrayList which includes every line of the java code
	 * @return an ArrayList that includes the location of comments
	 */
	public static ArrayList<String> comments_location(ArrayList<String> code) {
		ArrayList<String> comments_loc = new ArrayList<String>();
		int j;

		for (int i = 0; i < code.size(); i++) {
			if (code.get(i).startsWith("/*") || code.get(i).startsWith("/**")) {
				String pos = String.valueOf(i) + ",";
				j = i + 1;
				while (j < code.size()) {
					if (code.get(j).startsWith("*/")) {
						pos = pos + String.valueOf(j);
						break;
					}
					if (code.get(j).startsWith("*")) {
						j++;
					} else {
						j++;
					}
				}
				comments_loc.add(pos);
				i = j;
			} else if (code.get(i).startsWith("/*") && code.get(i).endsWith("*/")) {
				comments_loc.add(String.valueOf(i));
			} else if (code.get(i).startsWith("//")) {
				comments_loc.add(String.valueOf(i));
			}
		}

		return comments_loc;
		
	}

	/***
	 * This method deletes from the ArrayList, which includes the java code, all the
	 * comments
	 * 
	 * @param code : An ArrayList which includes every line of the java code
	 * @return an ArrayList with the updated code
	 */
	public static ArrayList<String> remove_comments(ArrayList<String> code) {

		ArrayList<String> comments_loc = comments_location(code);

		while (!comments_loc.isEmpty()) {
			String s = comments_loc.get(0);
			if (s.contains(",")) {
				int comma = s.indexOf(',');
				int start = Integer.parseInt(s.substring(0, comma));
				int end = Integer.parseInt(s.substring(comma + 1, s.length()));
				for (int i = end; i >= start; i--) {
					code.remove(i);
				}
			} else {
				code.remove(Integer.parseInt(s));
			}
			comments_loc = comments_location(code);
		}
		return code;
	}

}
