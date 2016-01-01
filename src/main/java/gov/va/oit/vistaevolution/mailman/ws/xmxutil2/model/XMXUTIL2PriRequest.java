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
public class XMXUTIL2PriRequest {

	@XmlElement(required = true)
	private String xmz;

	public XMXUTIL2PriRequest() {
		super();
	}

	public XMXUTIL2PriRequest(String xmDuz, String xmz, String xmk) {
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
