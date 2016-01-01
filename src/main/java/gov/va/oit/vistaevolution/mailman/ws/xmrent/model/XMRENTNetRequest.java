/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmrent.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * XMWSOA NET
 * 
 * This RPC  returns an ^-delimited string of information about a message. If
 * message does not exist, returns null.
 * 
 * Input Parameters:
 *		XMZ		(Required) Message Internal Entry Number (IEN) in the MESSAGE file (#3.9).
 *
 * Response:
 * 		Piece 1: Message date, in the following format: MAY 25, 1999@08:16:00, if
 * 				 local, or as sent, if remote.
 * 		Piece 2: Scramble hint, if any; otherwise null.
 * 		Piece 3: Message from (external).
 * 		Piece 4: Message ID at originating site (XMZ@sitename, if local).
 * 		Piece 5: Message sender, usually surrogate (external).
 * 		Piece 6: Message subject (external).
 * 		Piece 7: Message ID of original message, if this is a reply
 * 				 (XMZ@sitename, if local).
 * 		Piece 8: Message type (Piece 7 of the message's zero node).
 *  	-1^[error text]
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMRENTNetRequest {

	@XmlElement(required = true)
	private String xmz;

	public XMRENTNetRequest() {
		super();
	}

	public XMRENTNetRequest(String xmDuz, String xmz, String xmk) {
		super();
		this.xmz = xmz;
	}
	/**
	 * @return the xmz
	 */
	public String getXmz() {
		return xmz;
	}

	/**
	 * @param xmz the xmz to set
	 */
	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

}
