package gov.va.oit.vistaevolution.mailman.ws.xmxsec.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXSECInfoRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSECInfoRequest extends AbstractVistaRequest {

	/**
	 * 
	 * xmz:
	 * 
	 * (required) Message Internal Entry Number (IEN) in the MESSAGE file
	 * (#3.9).
	 */

	@XmlElement(required = true)
	private String xmz;

	/**
	 * Default Empty Constructor
	 * 
	 */
	public XMXSECInfoRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmz
	 */
	public XMXSECInfoRequest(String xmz) {
		this.xmz = xmz;
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
