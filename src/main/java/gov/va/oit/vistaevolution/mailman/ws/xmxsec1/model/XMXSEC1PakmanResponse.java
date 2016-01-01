/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

/**
 * XMWSOA IS MSG PAKMAN
 * 
 * This RPC returns a value indicating whether a message is a PackMan message
 * or not (0 = No; 1 = Yes).  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *   0-No, the message is not a PackMan message.
 *   1-Yes, the message is a PackMan message.
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1PakmanResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXSEC1PakmanResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXSEC1PakmanResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
