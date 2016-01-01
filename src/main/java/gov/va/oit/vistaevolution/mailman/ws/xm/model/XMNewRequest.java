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
 *  Returns: 
 *    0^Successful
 *   -1^Error in required input
 *   -1^Mailbox already exists
 *   -1^Failed to create mailbox
 *  
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMNewRequest {

	@XmlElement(required = false)
	private String xmz;
	@XmlElement(required = true)
	private String xmDuz;

	public XMNewRequest() {
		super();
	}

	public XMNewRequest(String xmz, String xmDuz) {
		super();
		this.xmz = xmz;
		this.xmDuz = xmDuz;
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

	/**
	 * @return the xmSer
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

	@Override
	public String toString() {
		return "XMNewRequest [\n toString()=" + super.toString() + "\n [xmz{" + getXmz() + "}], [xmDuz{" + getXmDuz()+"}] \n]";
	}
	

}
