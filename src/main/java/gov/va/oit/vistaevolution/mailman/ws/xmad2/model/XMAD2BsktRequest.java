package gov.va.oit.vistaevolution.mailman.ws.xmad2.model;

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
public class XMAD2BsktRequest extends AbstractVistaRequest {

	/**
	 * xmduz :
	 * 
	 * (required) DUZ of user.
	 * 
	 * xmkn :
	 * 
	 * (required) Basket name.
	 */
	@XmlElement(required = true)
	private String xmduz;
	@XmlElement(required = true)
	private String xmkn;

	/**
	 * No Arguments Constructor
	 */
	public XMAD2BsktRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xmduz
	 * @param xmkn
	 */
	public XMAD2BsktRequest(String xmduz, String xmkn) {
		super();
		this.xmduz = xmduz;
		this.xmkn = xmkn;
	}

	/**
	 * @return the xmduz
	 */
	public String getXmduz() {
		return xmduz;
	}

	/**
	 * @return the xmkn
	 */
	public String getXmkn() {
		return xmkn;
	}

	/**
	 * @param xmduz
	 *            the xmduz to set
	 */
	public void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}

	/**
	 * @param xmkn
	 *            the xmkn to set
	 */
	public void setXmkn(String xmkn) {
		this.xmkn = xmkn;
	}

}
