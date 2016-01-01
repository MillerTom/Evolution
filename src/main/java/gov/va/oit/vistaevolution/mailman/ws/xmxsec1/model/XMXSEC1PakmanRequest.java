/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 *
 */
/**
 * XMWSOA IS MSG PAKMAN
 * 
 * This RPC returns a value indicating whether a message is a PackMan message
 * or not (0 = No; 1 = Yes).  If there's an error, it returns an error
 * message.
 * 
 * Input Parameters:
 * 	 XMZ    (Required) Message Internal Entry Number (IEN) in the MESSAGE file
 * 			(#3.9).
 * 
 * Returns:
 *   0-No, the message is not a PackMan message.
 *   1-Yes, the message is a PackMan message.
 *   
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1PakmanRequest {

	@XmlElement(required = true)
	private String xmDuz;
	@XmlElement(required = true)
	private String xmk;
	@XmlElement(required = true)
	private String xmz;

	public XMXSEC1PakmanRequest() {
		super();
	}

	public XMXSEC1PakmanRequest(String xmDuz, String xmz, String xmk) {
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
