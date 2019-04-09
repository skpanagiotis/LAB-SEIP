package JavaAnalyzer;

import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.regex.*;

/***
 * The purpose of this class is calculate each metric with regex analyze type
 * 
 * @author PANAGIOTIS
 *
 */
public class AnalyzerViaRegex implements Analyzer {

	/***
	 *
	 * @return the number of lines of code
	 */
	public int loc(ArrayList<String> code) {
		int i = 0;
		Pattern p = Pattern.compile(
				"^(?![ \\s]*\\r?\\n|import|package|[ \\s]*}\\r?\\n|[ \\s]*//|[ \\s]*/\\*|[ \\s]*\\*).*\\r?\\n");
		Matcher m;
		for (String s : code) {
			m = p.matcher(s);
			if (!m.find()) {
				i = i + 1;
			}
		}
		return i;
	}

	/***
	 * @return the number of classes
	 */
	public int noc(ArrayList<String> code) {
		int i = 0;
		Pattern p = Pattern.compile(
				"(((|public|final|abstract|private|static|protected)(\\s+))?(class)(\\s+)(\\w+)(<.*>)?(\\s+extends\\s+\\w+)?(<.*>)?(\\s+implements\\s+)?(.*)?(<.*>)?(\\s*))\\{$");
		Matcher m;
		for (String s : code) {
			m = p.matcher(s);
			if (m.find()) {
				i = i + 1;
			}
		}
		return i;
	}

	/***
	 * 
	 * @return the number of methods
	 */

	public int nom(ArrayList<String> code) {
		int i = 0;
		Pattern p = Pattern.compile(
				"((public|protected|private|static|\\s)|[^if|while|else if|for])+?[\\w\\<\\>\\[\\]]+\\s+(\\w+) *\\([^\\)]*\\) *(\\{?|[^;])");
		Matcher m;
		for (String s : code) {
			m = p.matcher(s);
			if (m.find()) {
				i = i + 1;
			}
		}
		return i;
	}

}
