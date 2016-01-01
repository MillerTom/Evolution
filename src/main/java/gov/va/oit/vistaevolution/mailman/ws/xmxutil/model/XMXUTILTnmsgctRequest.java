/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXUTILTnmsgctRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILTnmsgctRequest extends AbstractVistaRequest {

	/**
	 * xmduz :
	 * 
	 * (required) User DUZ.
	 * 
	 */
	@XmlElement(required = true)
	private String xmduz;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTnmsgctRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmduz
	 */
	public XMXUTILTnmsgctRequest(String xmduz) {
		super();
		this.xmduz = xmduz;
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

}
