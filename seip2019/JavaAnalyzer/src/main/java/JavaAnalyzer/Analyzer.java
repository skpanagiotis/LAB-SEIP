package JavaAnalyzer;

import java.util.ArrayList;

/**
 * The purpsose of this interface is to calculates lines of code, number of
 * classes and number of methods
 * 
 * @author PANAGIOTIS
 *
 */

public interface Analyzer {
	/***
	 * This method calculates every line of the java file
	 * 
	 * @param code : An ArrayList which includes every line of the java code
	 * @return the number of lines of code
	 */
	public int loc(ArrayList<String> code);

	/***
	 * This method calculates every class of the java file
	 * 
	 * @param code : An ArrayList which includes every line of the java code
	 * @return the number of classes
	 */

	public int noc(ArrayList<String> code);

	/***
	 * This method calculates every method of the java file
	 * 
	 * @param code : An ArrayList which includes every line of the java code
	 * @return the number of methods
	 */

	public int nom(ArrayList<String> code);

}
