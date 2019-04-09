package JavaAnalyzer;

import java.util.ArrayList;

/***
 * The purpose of this class is to make all the necessary calculation for the
 * metrics
 * 
 * @author PANAGIOTIS
 *
 */

public class AnalyzerIO {
	private int loc = 0;
	private int nom = 0;
	private int noc = 0;

	/***
	 * This method calculates the metrics using as analyze type the string
	 * 
	 * @param code : An ArrayList which includes every line of the java code
	 * @return an array with size three which include the metrics
	 */
	public int[] string_analyze(ArrayList<String> code) {
		AnalyzerViaString AVS = new AnalyzerViaString();
		nom = AVS.nom(code);
		noc = AVS.noc(code);
		code = remove_comments(code);
		loc = AVS.loc(code);
		int[] analytics = new int[3];
		analytics[0] = loc;
		analytics[1] = nom;
		analytics[2] = noc;
		return analytics;
	}

	/***
	 * This method calculates the metrics using as analyze type the regex
	 * 
	 * @param code : An ArrayList which includes every line of the java code
	 * @return an array with size three which include the metrics
	 */
	public int[] regex_analyze(ArrayList<String> code) {
		AnalyzerViaRegex AVR = new AnalyzerViaRegex();
		nom = AVR.nom(code);
		noc = AVR.noc(code);
		code = remove_comments(code);
		loc = AVR.loc(code);
		int[] analytics = new int[3];
		analytics[0] = loc;
		analytics[1] = nom;
		analytics[2] = noc;
		return analytics;
	}

	/***
	 * This method finds all the lines of the code which are comments
	 * 
	 * @param code : An ArrayList which includes every line of the java code
	 * @return an ArrayList that includes the location of comments
	 */
	public ArrayList<String> comments_location(ArrayList<String> code) {
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
	public ArrayList<String> remove_comments(ArrayList<String> code) {

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
