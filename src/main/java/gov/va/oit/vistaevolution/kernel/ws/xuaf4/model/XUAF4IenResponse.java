/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

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
public class XUAF4IenResponse extends AbstractVistaResponse {

	/**
	 * ien :
	 * 
	 * IEN—Internal Entry Number.
	 * 
	 * NULL—Error.
	 * 
	 */
	@XmlElement(required = true)
	private String ien;

	/**
	 * No Arguments Constructor
	 */
	public XUAF4IenResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param ien
	 */
	public XUAF4IenResponse(String ien) {
		super();
		this.ien = ien;
	}

	/**
	 * @return the ien
	 */
	public String getIen() {
		return ien;
	}

	/**
	 * @param ien
	 *            the ien to set
	 */
	public void setIen(String ien) {
		this.ien = ien;
	}

}
