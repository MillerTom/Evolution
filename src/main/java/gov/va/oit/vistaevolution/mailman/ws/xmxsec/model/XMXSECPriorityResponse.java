/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxsec.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXSECPriorityResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSECPriorityResponse extends AbstractXMXSECResponse {

	/**
	 * 
	 * isPriorityMsg :
	 * 
	 * a value indicating whether a message is "Priority" or not (0 = No; 1 =
	 * Yes).If there's an error, it returns an error message.
	 * 
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages
	 */

	@XmlElement(required = false)
	private String isPriorityMsg;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECPriorityResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param isPriorityMsg
	 * @param msgRoot
	 */
	public XMXSECPriorityResponse(String isPriorityMsg, List<String> msgRoot) {
		super(msgRoot);
		this.isPriorityMsg = isPriorityMsg;
	}

	/**
	 * @return the isPriorityMsg
	 */
	public String getIsPriorityMsg() {
		return isPriorityMsg;
	}

	/**
	 * @param isPriorityMsg
	 *            the isPriorityMsg to set
	 */
	protected void setIsPriorityMsg(String isPriorityMsg) {
		this.isPriorityMsg = isPriorityMsg;
	}

}
