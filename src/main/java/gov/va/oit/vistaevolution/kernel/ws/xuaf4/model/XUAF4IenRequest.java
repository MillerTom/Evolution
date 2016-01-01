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
public class XUAF4IenRequest extends AbstractVistaRequest {

	/**
	 * sta :
	 * 
	 * (required) Station Number.
	 * 
	 */

	@XmlElement(required = true)
	private String sta;

	/**
	 * No Arguments Constructor.
	 */
	public XUAF4IenRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param sta
	 */
	public XUAF4IenRequest(String sta) {
		super();
		this.sta = sta;
	}

	/**
	 * @return the sta
	 */
	public String getSta() {
		return sta;
	}

	/**
	 * @param sta
	 *            the sta to set
	 */
	public void setSta(String sta) {
		this.sta = sta;
	}
}
