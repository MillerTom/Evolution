/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmvvitae.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMVVITAERequest extends AbstractVistaRequest {

	/**
	 * DUZ :
	 * 
	 * User's DUZ.
	 * 
	 * XMDUZ :
	 * 
	 * User(default) or Surrogate DUZ.
	 */
	@XmlElement(required = true)
	private String duz;
	@XmlElement(required = true)
	private String xmduz;

	/**
	 * No Arguments Constructor
	 */
	public AbstractXMVVITAERequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param duz
	 * @param xmduz
	 */
	public AbstractXMVVITAERequest(String duz, String xmduz) {
		super();
		this.duz = duz;
		this.xmduz = xmduz;
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

}
