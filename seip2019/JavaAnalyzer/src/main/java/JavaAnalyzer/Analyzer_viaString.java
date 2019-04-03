package JavaAnalyzer;

import java.util.ArrayList;

/***
 * The purpose of this class is calculate each metric with regex analyze type
 * 
 * @author PANAGIOTIS
 *
 */

public class Analyzer_viaString implements Analyzer {

	/***
	 * 
	 * @return the number of lines of code
	 */
	public int loc(ArrayList<String> code) {
		int codelines = 0;
		int semicolons = 1;
		for (String s : code) {
			semicolons = s.length() - s.replaceAll(";", "").length();
			if (semicolons > 1) {
				codelines = codelines + 1;
			} else if (s.contains("imports") || s.contains("package")) {
				codelines = codelines + 1;
			} else {
				codelines = codelines + 1;
			}
		}
		return codelines;
	}

	/***
	 * @return the number of classes
	 */
	public int noc(ArrayList<String> code) {

		int i = 0;
		for (String s : code) {
			if (s.contains("class")) {
				i = i + 1;
			}
		}
		return i;
	}

	/**
	 * @return the number of methods
	 */
	public int nom(ArrayList<String> code) {
		int i = 0;
		boolean visibility = false;
		boolean character;
		boolean structure;
		for (String s : code) {
			visibility = s.contains("public") || s.contains("private") || s.contains("protected");
			character = s.contains("{") && s.contains("(") && s.contains(")");
			structure = s.contains("if") || s.contains("while") || s.contains("else if") || s.contains("for");
			if (((visibility == true) && (character == true) && (structure == false))
					|| ((visibility == false) && (character == true) && (structure == false))) {
				i = i + 1;
			}
		}
		return i;
	}

}
