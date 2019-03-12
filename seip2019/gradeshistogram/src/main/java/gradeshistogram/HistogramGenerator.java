package gradeshistogram;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;

public class HistogramGenerator {

	public static void main(String[] args) {
		System.out.println("Please insert the file with the grades");
		Scanner input = new Scanner(System.in);
		String path = input.next();
		try {
			int grades[] = readFile(path);
			JFreeChartXYLineChartDemo demo = new JFreeChartXYLineChartDemo();
			demo.generateChart(grades);
		} catch (FileNotFoundException e) {
			e.printStackTrace();
		}

	}

	// The method readFile takes a file with grades and return an array with
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
