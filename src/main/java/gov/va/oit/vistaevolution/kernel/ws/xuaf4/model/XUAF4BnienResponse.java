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
public class XUAF4BnienResponse extends AbstractVistaResponse {

	/**
	 * bfName :
	 * 
	 * INSTITUTION file (#4), BILLING FACILITY NAME field (#200)
	 * 
	 */
	@XmlElement(required = false)
	private String bfName;

	/**
	 * No Arguments Constructor
	 */
	public XUAF4BnienResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param bfName
	 */
	public XUAF4BnienResponse(String bfName) {
		super();
		this.bfName = bfName;
	}

	/**
	 * @return the bfName
	 */
	public String getBfName() {
		return bfName;
	}

	/**
	 * @param bfName
	 *            the bfName to set
	 */
	public void setBfName(String bfName) {
		this.bfName = bfName;
	}

}
