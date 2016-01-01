/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma03.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

@XmlRootElement(name="XMA03RenResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMA03RenResponse {

	
	/**
	 * XMWSOA REN
	 * 
	 * REN^XMWSOA01
	 * 
	 * This RPC performs an integrity check on a user's basket,
	 * resequences messages in a user's basket, and returns a string,
	 * "Resequenced from 1 to n", where n is the number of messages in the
	 * basket. This message is only returned if the user has a mailbox with the
	 * selected basket and the basket has messages in it.
	 * if the user has a mailbox and the selected basket and has messages
	 * 
	 * 
	 * Input Parameters:
	 *   XMDUZ	DUZ of user
	 *   XMK	Internal Entry Number (IEN) of basket in sub-file 3.701.
	 * 
	 * Returns:
	 *  -1^Error in required input
	 *   0^Resequenced from 1 to n
	 *   0^No Action Taken
	 *   
	 */
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMA03RenResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMA03RenResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
