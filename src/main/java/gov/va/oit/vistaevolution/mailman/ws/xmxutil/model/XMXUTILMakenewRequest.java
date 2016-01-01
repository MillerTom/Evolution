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
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILMakenewRequest extends AbstractVistaRequest {

	/**
	 * 
	 * XMDUZ :
	 * 
	 * User's DUZ.
	 * 
	 * XMK :
	 * 
	 * Basket IEN.
	 * 
	 * XMZ :
	 * 
	 * Message Internal Entry Number (IEN) in the MESSAGE file (#3.9).
	 * 
	 * XMLOCKIT :
	 * 
	 * Should MailMan take care of locking and unlocking the ^XMB(3.7,XMDUZ
	 * global? 0 (default)-No 1-Yes
	 * 
	 */

	@XmlElement(required = true)
	private String xmduz;
	@XmlElement(required = true)
	private String xmk;
	@XmlElement(required = true)
	private String xmz;
	@XmlElement(required = false)
	private String xmlockit;

	/**
	 * No Arguments Constructor
	 */
	public XMXUTILMakenewRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmduz
	 * @param xmk
	 * @param xmz
	 * @param xmlockit
	 */
	public XMXUTILMakenewRequest(String xmduz, String xmk, String xmz,
			String xmlockit) {
		super();
		this.xmduz = xmduz;
		this.xmk = xmk;
		this.xmz = xmz;
		this.xmlockit = xmlockit;
	}

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param xmduz
	 * @param xmk
	 * @param xmz
	 */
	public XMXUTILMakenewRequest(String xmduz, String xmk, String xmz) {
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
