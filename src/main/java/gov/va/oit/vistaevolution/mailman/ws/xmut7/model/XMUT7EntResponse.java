/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmut7.model;

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
public class XMUT7EntResponse {

	
	/**
	 * TODO: Correct RPC name once broker is completed
	 * XMWSOA ENT
	 * 
	 * ENT^XMUT7(): Send a Test Message to a User's Forwarding Address
	 * 
	 * Reference Type	Supported
	 * Category	Utilities—General Development (Classic MailMan)
	 * IA #	1132
	 * 
	 * Description	This API sends a test message to a user's forwarding address.
	 * The message is also sent to the Postmaster. If the forwarding address is 
	 * no good, the Postmaster receives an error message.
	 * 
	 * Format	ENT^XMUT7(duz)
	 * 
	 * Input Parameters	
	 * 
	 * duz:	(required) DUZ of user, whose forwarding address you want to test.
	 * 
	 * Output	returns:	
	 * 
	 * Results:
	 * 
	 * Successful—Test message gets sent to the user's forwarding address and 
	 * the Postmaster.
	 * 
	 * Unsuccessful—An error message is sent to the Postmaster.
	 * 
	 *   
	 */
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMUT7EntResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMUT7EntResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
