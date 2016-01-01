/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xqcs.model;

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
public class XQCSOptlkRequest extends AbstractVistaRequest {

	/**
	 * xuopt :
	 * 
	 * (Required) The Name of the Option located in the Option file (#19) to
	 * conduct the look up.
	 * 
	 * 
	 */
	@XmlElement(required = true)
	private String xuopt;

	/**
	 * No Arguments Constructor
	 */
	public XQCSOptlkRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xuopt
	 */
	public XQCSOptlkRequest(String xuopt) {
		super();
		this.xuopt = xuopt;
	}

	/**
	 * @return the xuopt
	 */
	public String getXuopt() {
		return xuopt;
	}

	/**
	 * @param xuopt
	 *            the xuopt to set
	 */
	public void setXuopt(String xuopt) {
		this.xuopt = xuopt;
	}

}
