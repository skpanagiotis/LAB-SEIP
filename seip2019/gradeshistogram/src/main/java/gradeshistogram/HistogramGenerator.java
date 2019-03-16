package gradeshistogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

/***
 * 
 * @author PANAGIOTIS The purpose of this class is to generate a histogram by
 *         given students' grades
 * 
 *
 */

public class HistogramGenerator {
	/***
	 * Receives a .txt file with students' grades and make a 2 dimensions histogram.
	 * 
	 * @param args the command line arguments
	 */

	public static void main(String[] args) {
		try {
			int grades[] = readFile(args[0]);
			JFreeChartXYLineChartDemo demo = new JFreeChartXYLineChartDemo();
			demo.generateChart(grades);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	/***
	 * The method readFile takes a file with grades and return an array with grades
	 * 
	 * @param path the path of the .txt file
	 * @return grades an integer array
	 * @throws FileNotFoundException if the file does not exist
	 */
	// frequency of the grades
	public static int[] readFile(String path) throws FileNotFoundException {
		int[] grades = new int[11];
		File file = new File(path);
		Scanner sc = new Scanner(file);
		while (sc.hasNext()) {
			int marker = Integer.parseInt(sc.next());
			grades[marker] = grades[marker] + 1;
		}
		sc.close();
		return grades;
	}

}
