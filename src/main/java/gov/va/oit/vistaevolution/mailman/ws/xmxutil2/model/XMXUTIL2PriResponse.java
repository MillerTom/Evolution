/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

/**
 * XMWSOA PRIORITY MSG IND
 * 
 * This RPC returns a value indicating whether the message is priority or
 * not.  If there's an error, it returns an error message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *  Is the message marked as priority?
 *   0-No
 *   1-Yes
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL2PriResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXUTIL2PriResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXUTIL2PriResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
