/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXUTILNonewRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILNonewRequest extends AbstractXMXUTILRequest {

	/**
	 * XMDUZ :
	 * 
	 * (required) User's DUZ.
	 * 
	 * XMK :
	 * 
	 * (required) Basket IEN.
	 * 
	 * XMZ :
	 * 
	 * (required) Message Internal Entry Number (IEN) in the MESSAGE file
	 * (#3.9).
	 * 
	 * XMLOCKIT :
	 * 
	 * (optional) Should MailMan take care of locking and unlocking the
	 * ^XMB(3.7,XMDUZ global? 0 (default)-No 1-Yes
	 * 
	 */
	@XmlElement(name = "XMZ", required = true)
	private String xmz;
	@XmlElement(name = "XMLOCKIT", required = false)
	private String xmlockit;

	/**
	 * No Arguments Constructor.
	 */
	public XMXUTILNonewRequest() {
		super();
	}

	/**
	 * Parameterised Constructor.
	 * 
	 * @param xmduz
	 * @param xmk
	 * @param xmz
	 * @param xmlockit
	 */
	public XMXUTILNonewRequest(String xmduz, String xmk, String xmz,
			String xmlockit) {
		super(xmduz, xmk);
		this.xmz = xmz;
		this.xmlockit = xmlockit;
	}

	/**
	 * Mandatory Parameters Constructor.
	 * 
	 * @param xmduz
	 * @param xmk
	 * @param xmz
	 */
	public XMXUTILNonewRequest(String xmduz, String xmk, String xmz) {
		super(xmduz, xmk);
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
	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

	/**
	 * @return the xmlockit
	 */
	public String getXmlockit() {
		return xmlockit;
	}

	/**
	 * @param xmlockit
	 *            the xmlockit to set
	 */
	public void setXmlockit(String xmlockit) {
		this.xmlockit = xmlockit;
	}

}
