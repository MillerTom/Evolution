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

@XmlRootElement(name="XMA03RenRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMA03RenRequest {

	@XmlElement(required = true)
	private String xmDuz;
	@XmlElement(required = true)
	private String xmk;

	public XMA03RenRequest() {
		super();
	}

	public XMA03RenRequest(String xmk, String xmDuz) {
		super();
		this.xmk = xmk;
		this.xmDuz = xmDuz;
	}
	/**
	 * @return the xmz
	 */

	public String getXmk() {
		return xmk;
	}

	/**
	 * @param xmz the xmk to set
	 */
	public void setXmk(String xmk) {
		this.xmk = xmk;
	}

	/**
	 * @return the xmDuz
	 */
	public String getXmDuz() {
		return xmDuz;
	}

	/**
	 * @param xmSer the xmSer to set
	 */
	public void setXmDuz(String xmDuz) {
		this.xmDuz = xmDuz;
	}

}
