/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xm.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */

@XmlRootElement(name="XMNewResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMNewResponse {

	
	/**
	 * Input Parameters
	 * 	xmz:	(optional)  If you wish to prevent the user from seeing messages
	 *  created before a certain date, then set XMZ to a message number
	 *  in the MESSAGE file (#3.9). The user will not be able to access
	 *  any messages created earlier than this one, unless the message is
	 *  already in the user's mailbox or is forwarded to the user. This
	 *  really only applies to users who left the organization and then
	 *  returned, or if (heaven forbid) you are re-using a DUZ. This
	 *  prevents the user from accessing old messages that may have
	 *  been addressed to the user.
	 *   
	 * 	xmDuz:	(required) The User's DUZ
	 * 
	 * Returns:
	 *    0^Successful
	 *   -1^Error in required input
	 *   -1^Mailbox already exists
	 *   -1^Failed to create mailbox
	 *  
	 */
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMNewResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMNewResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}

	@Override
	public String toString() {
		return "XMNewResponse [toString()=" + super.toString() + "]";
	}
	
	
}
