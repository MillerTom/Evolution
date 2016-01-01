/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXAPIBNamebsktRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIBNamebsktRequest extends AbstractVistaRequest {

	/**
	 * DUZ :
	 * 
	 * (required) User's DUZ.
	 * 
	 */

	@XmlElement(name = "DUZ", required = true)
	private String duz;

	/**
	 * No Arguments Constructor.
	 */
	public XMXAPIBNamebsktRequest() {
		super();
	}

	/**
	 * Parameterised Constructor.
	 * 
	 * @param duz
	 */
	public XMXAPIBNamebsktRequest(String duz) {
		super();
		this.duz = duz;
	}

	/**
	 * @return the duz
	 */
	public String getDuz() {
		return duz;
	}

	/**
	 * @param duz
	 *            the duz to set
	 */
	protected void setDuz(String duz) {
		this.duz = duz;
	}

}
