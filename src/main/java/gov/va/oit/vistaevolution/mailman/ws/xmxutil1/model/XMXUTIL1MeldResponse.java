/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/*
 * XMWSOA MELD STRING
 * This RPC combines a string and a number to form a new string of a given
 * length. The string will be right justified; the number left-justified,
 * with at least two spaces separating the string and number. The string will
 * be truncated, if necessary.  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 		XMSTRING	(Required) The input string.
 * 		XMNUMBER	(Optional) The number.
 * 		XMLEN		(Required) The length of the new string to be formed.
 * 
 * Response:
 * 		Returns the newly formed string.
 * 
 * 			Example 1
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=10
 * 				Lotus 123
 * 			
 * 			Example 2
 * 				XMSTRING="Lotus blossom",XMNUM=123,XMLEN=15
 * 				Lotus blos 123
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1MeldResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXUTIL1MeldResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXUTIL1MeldResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
