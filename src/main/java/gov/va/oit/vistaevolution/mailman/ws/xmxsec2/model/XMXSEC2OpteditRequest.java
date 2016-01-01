/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXSEC2OpteditRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC2OpteditRequest extends AbstractVistaRequest {

	/**
	 * XMDUZ :
	 * 
	 * (required) User DUZ.
	 * 
	 * XMK :
	 * 
	 * Basket IEN where the message is located.
	 * 
	 * XMZ :
	 * 
	 * Message Internal Entry Number (IEN) in the MESSAGE file (#3.9).
	 * 
	 */

	@XmlElement(name = "XMDUZ", required = true)
	private String xmduz;
	@XmlElement(name = "XMK", required = true)
	private String xmk;
	@XmlElement(name = "XMZ", required = true)
	private String xmz;

	/**
	 * No Arguments Constructor.
	 */
	public XMXSEC2OpteditRequest() {
		super();
	}

	/**
	 * Parameterised Constructor.
	 * 
	 * @param xmduz
	 * @param xmk
	 * @param xmz
	 */
	public XMXSEC2OpteditRequest(String xmduz, String xmk, String xmz) {
		super();
		this.xmduz = xmduz;
		this.xmk = xmk;
		this.xmz = xmz;
	}

	/**
	 * @return the xmduz
	 */
	public String getXmduz() {
		return xmduz;
	}

	/**
	 * @param xmduz
	 *            the xmduz to set
	 */
	protected void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}

	/**
	 * @return the xmk
	 */
	public String getXmk() {
		return xmk;
	}

	/**
	 * @param xmk
	 *            the xmk to set
	 */
	protected void setXmk(String xmk) {
		this.xmk = xmk;
	}

	/**
	 * @return the xmz
	 */
	public String getXmz() {
		return xmz;
	}

	/**
	 * @param xmz
	 *            the xmz to set
	 */
	protected void setXmz(String xmz) {
		this.xmz = xmz;
	}

}
