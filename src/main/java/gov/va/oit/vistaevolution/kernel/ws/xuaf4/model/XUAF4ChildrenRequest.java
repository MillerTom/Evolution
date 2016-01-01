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
public class XUAF4ChildrenRequest extends AbstractVistaRequest {

	/**
	 * 
	 * parent :
	 * 
	 * (Required) Parent (VISN) institution lookup value, any of the following:
	 * 
	 * • Internal Entry Number (IEN), will have the ` in front of it.
	 * 
	 * • Institution Name - (National Parent (VISN) only.)
	 * 
	 */
	@XmlElement(required = true)
	private String parent;

	/**
	 * No Arguments Constructor.
	 */
	public XUAF4ChildrenRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param parent
	 */
	public XUAF4ChildrenRequest(String parent) {
		super();
		this.parent = parent;
	}

	/**
	 * @return the parent
	 */
	public String getParent() {
		return parent;
	}

	/**
	 * @param parent
	 *            the parent to set
	 */
	public void setParent(String parent) {
		this.parent = parent;
	}

}
