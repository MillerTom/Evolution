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
 * XMWSOA FM2MM DT
 * 
 * This RPC takes a VA FileMan Date/Time input string and returns it as a
 * reformatted string:
 *     mm/dd/yy@hh:mm
 *     
 * If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 		XMDT		(Required) VA FileMan Date/Time input string.
 * 
 * Response:
 * 		Returns a reformatted VA FileMan Date/Time string:
 * 			mm/dd/yy@hh:mm
 * 		Example
 * 			XMDT=2940629.105744
 * 			Return:  06/29/94@10:57
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1MmdtResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXUTIL1MmdtResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXUTIL1MmdtResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
