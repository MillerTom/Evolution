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
public class XQCSChkRequest extends AbstractVistaRequest {

	/**
	 * XUIEN :
	 * 
	 * (required) DUZ of user.
	 * 
	 * XUOPT :
	 * 
	 * (required) Name or IEN of the option.
	 * 
	 * XURPC :
	 * 
	 * (optional) Name or IEN of the remote procedure. If this variable is null
	 * no check is made to see if a procedure is allowed. That is, we only look
	 * to see if the option is there and if the user has been assigned access to
	 * it.
	 */
	@XmlElement(required = true)
	private String xuien;
	@XmlElement(required = true)
	private String xuopt;
	@XmlElement(required = false)
	private String xurpc;

	/**
	 * No Arguments Constructor
	 */
	public XQCSChkRequest() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param xuien
	 * @param xuopt
	 * @param xurpc
	 * 
	 */
	public XQCSChkRequest(String xuien, String xuopt, String xurpc) {
		super();
		this.xuien = xuien;
		this.xuopt = xuopt;
		this.xurpc = xurpc;
	}

	/**
	 * Mandatory Parameters Constructor
	 * 
	 * @param xuien
	 * @param xuopt
	 * 
	 */
	public XQCSChkRequest(String xuien, String xuopt) {
		super();
		this.xuien = xuien;
		this.xuopt = xuopt;
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

	/**
	 * @return the xurpc
	 */
	public String getXurpc() {
		return xurpc;
	}

	/**
	 * @param xurpc
	 *            the xurpc to set
	 */
	public void setXurpc(String xurpc) {
		this.xurpc = xurpc;
	}

}
