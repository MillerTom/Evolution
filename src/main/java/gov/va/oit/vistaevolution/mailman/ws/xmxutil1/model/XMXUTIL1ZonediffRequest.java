/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

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
public class XMXUTIL1ZonediffRequest {

	/**
	 * XMYT :
	 * 
	 * This is the time zone (3-character or +-hhmm from GMT).
	 * 
	 */
	@XmlElement(required = true)
	private String xmyt;

	/**
	 * No Arguments Constructor.
	 */
	public XMXUTIL1ZonediffRequest() {
	}

	/**
	 * Parameterised Constructor.
	 * 
	 * @param xmyt
	 */
	public XMXUTIL1ZonediffRequest(String xmyt) {
		this.xmyt = xmyt;
	}

	/**
	 * @return the xmyt
	 */
	public String getXmyt() {
		return xmyt;
	}

	/**
	 * @param xmyt
	 *            the xmyt to set
	 */
	public void setXmyt(String xmyt) {
		this.xmyt = xmyt;
	}

	@Override
	public String toString() {
		return "XMXUTIL1ZonediffRequest [xmyt=" + xmyt + "]";
	}

}
