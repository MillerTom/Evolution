
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The request class for the API that sets the division for the current user
 * @author Stephen Combs <Stephen.Combs@synaptekcorp.com>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DivSetXUSRB2Request {
	/**
	 * (required) This is the division to select. If passed with a leading ` an 
	 * Internal Entry Number (IEN) is being passed and will be processed as such.
	 * May only be 12 characters in length.
	 * */
	@XmlElement(required = true)
	private String div;
	
	/**
	 * Default non-arg constructor
	 */
	public DivSetXUSRB2Request() {
		super();
	}
	
	/**
	 * DIV^Set Request Constructor with division argument
	 * @param div division identifier
	 */
	public DivSetXUSRB2Request(String div) {
		super();
		this.div = div;
	}
	
	/**
	 * Returns the division ID that is set for the current user.
	 * @return div
	 */
	public String getDiv() {
		return div;
	}
	
	/**
	 * Sets the division ID for the current user
	 * @param div division identifier
	 */
	public void setDiv(String div) {
		this.div = div;
	}	


}
