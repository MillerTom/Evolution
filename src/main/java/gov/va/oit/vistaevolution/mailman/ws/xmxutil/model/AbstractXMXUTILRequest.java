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
 * @author Christopher Schuck
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXUTILRequest extends AbstractVistaRequest {

	// User DUZ
	@XmlElement(name = "xmduz", required = true)
	private String xmduz;

	// Basket IEN
	@XmlElement(name = "xmk", required = true)
	private String xmk;

	/**
	 * No Arguments Constructor.
	 */
	public AbstractXMXUTILRequest() {
		super();
	}

	/**
	 * Parameterised Constructor.
	 * 
	 * @param xmduz
	 * @param xmk
	 */
	public AbstractXMXUTILRequest(String xmduz, String xmk) {
		super();
		this.xmduz = xmduz;
		this.xmk = xmk;
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
	public void setXmduz(String xmduz) {
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
	public void setXmk(String xmk) {
		this.xmk = xmk;
	}

}
