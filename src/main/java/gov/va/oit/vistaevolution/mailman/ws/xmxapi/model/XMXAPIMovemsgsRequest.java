/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIMovemsgsRequest extends AbstractXMXAPIRequest {

	/**
	 * DUZ :
	 * 
	 * User's DUZ.
	 * 
	 * XMDUZ :
	 * 
	 * The user (DUZ or name) whose messages are to be moved.
	 * 
	 * XMK :
	 * 
	 * Basket (IEN or name) containing the message or messages
	 * 
	 * .XMKZA :
	 * 
	 * Identifies messages
	 * 
	 * XMKTO :
	 * 
	 */
	@XmlElement(required = true)
	private String xmk;
	@XmlElementWrapper(name = "xmkza")
	@XmlElement(name = "entry", required = true)
	private List<XMXAPIArrayEntry> xmkza;
	@XmlElement(required = true)
	private String xmkto;

	/**
	 * No Arguments Constructor.
	 */
	public XMXAPIMovemsgsRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param duz
	 * @param xmDuz
	 * @param xmk
	 * @param xmkza
	 * @param xmkto
	 */
	public XMXAPIMovemsgsRequest(String duz, String xmDuz, String xmk,
			List<XMXAPIArrayEntry> xmkza, String xmkto) {
		super(duz, xmDuz);
		this.xmk = xmk;
		this.xmkza = xmkza;
		this.xmkto = xmkto;
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

	/**
	 * @return the xmkza
	 */
	public List<XMXAPIArrayEntry> getXmkza() {
		return xmkza;
	}

	/**
	 * @param xmkza
	 *            the xmkza to set
	 */
	public void setXmkza(List<XMXAPIArrayEntry> xmkza) {
		this.xmkza = xmkza;
	}

	/**
	 * @return the xmkto
	 */
	public String getXmkto() {
		return xmkto;
	}

	/**
	 * @param xmkto
	 *            the xmkto to set
	 */
	public void setXmkto(String xmkto) {
		this.xmkto = xmkto;
	}

}
