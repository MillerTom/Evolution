/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1OptgrpRequest extends AbstractVistaRequest {

	/**
	 * XMDUZ :
	 * 
	 * DUZ of the user who is accessing the basket.
	 * 
	 * XMK :
	 * 
	 * Basket IEN.
	 * 
	 */
	@XmlElement(required = true)
	private String xmduz;
	@XmlElement(required = true)
	private String xmk;

	/**
	 * No Arguments Constructor.
	 */
	public XMXSEC1OptgrpRequest() {
		super();
	}

	/**
	 * Parameterised Constructor.
	 * 
	 * @param xmduz
	 * @param xmk
	 */
	public XMXSEC1OptgrpRequest(String xmduz, String xmk) {
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
