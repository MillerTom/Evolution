/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma2.model;

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
public class XMA2XmzResponse {

	
	/*
	 * NAME: XMWSOA EN1                        TAG: EN1
	 * 
	 * This RPC calls the XMZ^XMA2 API to create a message stub.  If this
	 * fails, the RPC returns an error message.  If the call was successful,
	 * the RPC then calls the API, EN1^XMD to add text and recipients and send
	 * the message.
	 * 
	 * Returns:
	 *   0^Successful
	 *   -1^Error in required input
	 *   -1^Failed to create message stub
	 *   -1^DUZ not found
	 *   -1^Subject names of this format (1"R"1.N) are RESERVED
	 *   -1^SUBJECT must be at least 3 characters long.
	 *   -1^Entered SUBJECT too long, <number> characters longer than 65.
	 *   -1^Subject cannot contain control characters.
	 *   
	 *   Input Parameters:
	 *   
	 *   DUZ	(Required String) Sender's DUZ.
	 *   MSG	(Required List) An array containing the text to be added to the message.
	 *   XMY    (Required List) Addressee array, XMY(x)="", where x can be:
	 *     			User's DUZ or enough of the user's name for a positive ID. For example:
	 *     	         XMY(1301)="" OR XMY("lastname,first")=""
	 *     		     G.group name (enough for positive ID). For example:
	 *         		 XMY("G.group name")=""
	 *         		 S.server name (enough for positive ID).
	 *         		 D.device name (enough for positive ID).
	 *              Prefix the above (except devices and servers) by:
	 *              	I: for "Information Only" recipient (cannot reply). For example:
	 *                        XMY("I:1301")="" or XMY("I:lastname,first")=""
	 *                  C: for "Copy" recipient (not expected to reply). For example:
	 *                        XMY("C:1301")="" or XMY("C:lastname,first")=""
	 *                  L@datetime: for when (in future) to send to this recipient (datetime
	 *                  	can be anything accepted by VA FileMan). For example:
	 *                  	    XMY("L@25 DEC@0500:1301")="" or XMY("L@1 JAN:lastname,first")="" or
	 *                            XMY("L@2981225.05:1301")=""
	 *                            (Can combine IL@datetime: or CL@datetime:)
	 *             To delete any recipient (including users, groups, devices, and
	 *              	servers, prefix with a hyphen/dash ("-"). For example:
	 *                        XMY(-1301)="" or XMY("-lastname,first")=""
	 *             To address any recipient (including users, groups, devices, and
	 *             		servers) at a remote site, just add the @site name. For example:
	 *             			  XMY(recipient@site name)=""
	 *  XMSUB	(Required String)Subject of the message.  It should be from 3 to 65 characters 
	 *  		in length. If it is less than 3 characters,then three dots ("...") will be appended
	 *  		to it.  If it is more than 65 characters, then it will be truncated.
	 *  		Subject 'Rnnn' is reserved.
	 *  XMSTRIP (Optional String) String containing characters that should be removed from 
	 *  		the message text. The default is none.
	 *  XMDF    (Optional String)If XMDF is defined, addressing restrictions are waived.
	 *  		Addressing restrictions are:
	 *  			> Restrict  "domain closed"
	 *  			> Restrict  "keys required for domain"
	 *  			> Restrict  "may not forward to domain"
	 *  			> Restrict  "may not forward priority mail to groups"
	 *  			> Restrict  "message length restrictions to remote addresses"
	 * 
	 */
	@XmlElement(name = "results", required = true)
	private String results;

	/**
	 * Constructor from fields
	 * @param results
	 */
	public XMA2XmzResponse(String results) {
		this.setResults(results);
	}
	
	/**
	 * Default no arg constructor
	 */
	public XMA2XmzResponse() {
		this.setResults(null);
	}

	public String getResults() {
		return this.results;
	}

	private void setResults(String results) {
		this.results = results;
	}
}
