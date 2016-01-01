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
 *  0-No
 *  1-Yes
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL2NewRequest {

	@XmlElement(required = true)
	private String xmDuz;
	@XmlElement(required = true)
	private String xmk;
	@XmlElement(required = true)
	private String xmz;

	public XMXUTIL2NewRequest() {
		super();
	}

	public XMXUTIL2NewRequest(String xmDuz, String xmz, String xmk) {
		super();
		this.xmDuz = xmDuz;
		this.xmz = xmz;
		this.xmk = xmk;
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
	 * @return the xmk
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
