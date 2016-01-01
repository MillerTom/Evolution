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
@XmlRootElement(name = "XMXSECConfidRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSECConfidRequest extends AbstractVistaRequest {

	/**
	 * xmzrec :
	 * 
	 * (required) Zero node of the message: ^XMB(3.9,XMZ,0).
	 */

	@XmlElement(required = true)
	private String xmzrec;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECConfidRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmzrec
	 */
	public XMXSECConfidRequest(String xmzrec) {
		super();
		this.xmzrec = xmzrec;
	}

	/**
	 * @return the xmzrec
	 */
	public String getXmzrec() {
		return xmzrec;
	}

	/**
	 * @param xmzrec
	 *            the xmzrec to set
	 */
	protected void setXmzrec(String xmzrec) {
		this.xmzrec = xmzrec;
	}

}
