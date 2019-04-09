package JavaAnalyzer;


/***
 * The purpose of this class is to create analyzers
 * 
 * @author PANAGIOTIS
 *
 */

public class AnalyzerIO {
	/***
	 * 
	 * @param antype : the type of analyzer
	 * @return one Analyzer
	 */
	public Analyzer GetAnalyzer(String antype) {
		if (antype.equals("string")) {
			return new AnalyzerViaString();
		} else {
			return new AnalyzerViaRegex();
		}
		
	}

}
