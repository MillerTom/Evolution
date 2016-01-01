/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

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
public class XUAF4BnienRequest extends AbstractVistaRequest {

	/**
	 * XUIEN :
	 * 
	 * (required) INSTITUTION file (#4) internal entry number
	 * 
	 */
	@XmlElement(required = true)
	private String xuien;

	/**
	 * No Arguments Constructor.
	 */
	public XUAF4BnienRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xuien
	 */
	public XUAF4BnienRequest(String xuien) {
		super();
		this.xuien = xuien;
	}

	/**
	 * @return the xuien
	 */
	public String getXuien() {
		return xuien;
	}

	/**
	 * @param xuien
	 *            the xuien to set
	 */
	public void setXuien(String xuien) {
		this.xuien = xuien;
	}

}
