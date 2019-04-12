package JavaAnalyzer;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;
import java.util.Scanner;
import java.util.ArrayList;

/***
 * The purpose of this class is to read a java file and convert it to an
 * ArrayList and create a CSV file
 * 
 * @author PANAGIOTIS
 *
 */
public class ReWrOps {

	/***
	 * This method put every line of a file in every slot of an ArrayList of Strings
	 * excluding the lines with only whitespaces and delete for every line the front
	 * whitespaces and return the ArrayList
	 * 
	 * @param path : the path of the java file
	 * @throws FileNotFoundException
	 * @return an ArrayList of String that include the java code
	 */
	public static ArrayList<String> readFile(String path) throws FileNotFoundException {
		ArrayList<String> code = new ArrayList<String>();
		File file = new File(path);
		Scanner sc = new Scanner(file);

		while (sc.hasNext()) {
			String s = sc.nextLine();
			if (!(s.isEmpty()) && (s.trim().length() > 0)) {
				code.add(s.trim());
			}

		}
		sc.close();
		return code;

	}

	/***
	 * This method takes the three metrics and create a csv file which include the
	 * value of each metric
	 * 
	 * @param loc : Lines of Code
	 * @param noc : Number of Classes
	 * @param nom : Number of Methods
	 */

	public static void insertCSV(int loc, int noc, int nom) {
		PrintWriter writer;
		try {
			writer = new PrintWriter(new File("analytics.csv"));
			StringBuilder sb = new StringBuilder();
			sb.append("loc");
			sb.append(";");
			sb.append("nom");
			sb.append(";");
			sb.append("noc");
			sb.append('\n');

			sb.append(loc);
			sb.append(";");
			sb.append(nom);
			sb.append(";");
			sb.append(noc);
			

			writer.write(sb.toString());
			writer.flush();
			writer.close();
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

}
