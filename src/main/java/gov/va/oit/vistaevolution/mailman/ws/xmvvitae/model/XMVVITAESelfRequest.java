/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model;

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
public class XMVVITAESelfRequest extends AbstractVistaRequest {

	/**
	 * 
	 * duz:
	 * 
	 * User's DUZ
	 * 
	 */

	@XmlElement(required = true)
	private String duz;

	/**
	 * No Arguments Constructor.
	 */
	public XMVVITAESelfRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param duz
	 */
	public XMVVITAESelfRequest(String duz) {
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
	public void setDuz(String duz) {
		this.duz = duz;
	}

}
