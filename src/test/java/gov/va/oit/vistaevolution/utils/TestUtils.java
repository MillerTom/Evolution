package gov.va.oit.vistaevolution.utils;

public class TestUtils {

	// pass in semi-colon delimited string, 
	//will get new line formatted string back
	public static String createFormattedTestResponse(String s) { 
		StringBuffer sb = new StringBuffer();
		for(String ss : s.split(";") ) { 
			sb.append(ss + "\n");
		}
		return sb.toString();
	}
}
