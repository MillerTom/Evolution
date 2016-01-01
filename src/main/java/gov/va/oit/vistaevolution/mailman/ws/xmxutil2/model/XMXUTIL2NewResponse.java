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
 * XMWSOA NEW MSG INDICATOR

 * This extrinsic function returns a value indicating whether or not a
 * message is new for this user in this basket.  If there's an error, it
 * returns an error message.
 * 
 * Input Parameters:
 *   XMDUZ	(Required) DUZ of user
 *   XMK	(Required) Internal Entry Number (IEN) of basket.
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *   0-No
 *   1-Yes
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL2NewResponse {
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMXUTIL2NewResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMXUTIL2NewResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
