/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xms1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Leisa Martella
 * @author Tom Miller<tom.miller@dbitpro.com>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMS1StatusRequest extends AbstractVistaRequest {

	/**
	 * 
	 * xmz:
	 * 
	 * (required) Message Internal Entry Number (IEN) in the MESSAGE file
	 * (#3.9).
	 * 
	 * xmser:
	 * 
	 * (required) Server name. Must be the full name, starting with "S."
	 * 
	 */
	@XmlElement(required = true)
	private String xmz;
	@XmlElement(required = true)
	private String xmser;

	/**
	 * No Arguments Constructor
	 * 
	 */
	public XMS1StatusRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmz
	 * @param xmser
	 */
	public XMS1StatusRequest(String xmz, String xmser) {
		super();
		this.xmz = xmz;
		this.xmser = xmser;
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
	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

	/**
	 * @return the xmser
	 */
	public String getXmser() {
		return xmser;
	}

	/**
	 * @param xmser
	 *            the xmser to set
	 */
	public void setXmser(String xmser) {
		this.xmser = xmser;
	}

}
