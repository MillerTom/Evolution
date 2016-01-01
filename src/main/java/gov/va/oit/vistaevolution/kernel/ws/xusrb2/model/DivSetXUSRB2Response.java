
package gov.va.oit.vistaevolution.kernel.ws.xusrb2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * The response class for the API that sets the division for the current user
 * @author Stephen Combs <Stephen.Combs@synaptekcorp.com>
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class DivSetXUSRB2Response {
	/**
	 *Returns a Boolean value, represented as a string, in the subscripted output array:
	 *<li>True (non-zero)—Division selection is considered successful.
	 *<li>False (zero)—Division selection failed.
	 **/
	@XmlElement(required = true)
	private String ret;
	
	/**
	 * Default non-arg constructor
	 */
	public DivSetXUSRB2Response() {
		super();
	}
	
	/**
	 * DIV^Set Response Constructor with division argument
	 * @param ret return value
	 */
	public DivSetXUSRB2Response(String ret) {
		super();
		this.ret = ret;
	}
	
	/**
	 * Return object from the DIV^Set RPC
	 * @return ret
	 */
	public String getRet() {
		return ret;
	}
	
	/**
	 * Sets the return value for the DIV^Set response object
	 * @param ret return value
	 */
	public void setRet(String ret) {
		this.ret = ret;
	}	

}
