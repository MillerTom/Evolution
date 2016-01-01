/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xlfdt3.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XLFDT3LeapResponse {

	
	/**
	 * XU SOA LEAP
	 * 
	 * This RPC function checks to see if the year passed in is a leap year or not. 
	 * The function returns a one if the year is a leap year otherwise it returns a zero.
	 * 
	 * Input Variables	
	 * 		Year:	(required) Year being tested to confirm if it is a leap year or not.
	 * 
	 * Response
	 * 		Returns 1 for a leap year, otherwise 0.
	 *   
	 */
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XLFDT3LeapResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XLFDT3LeapResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
