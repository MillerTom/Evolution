package gov.va.oit.vistaevolution.mailman.ws.xmxsec.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXSECInfoResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSECInfoResponse extends AbstractXMXSECResponse {

	/**
	 * 
	 * isInfoOnlyMsg :
	 * 
	 * value indicating whether a message is "Information Only" or not (0 = No;
	 * 1 = Yes). If there's an error, it returns an error message.
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages
	 */

	@XmlElement(required = false)
	private String isInfoOnlyMsg;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECInfoResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param isInfoOnlyMsg
	 * @param msgRoot
	 */
	public XMXSECInfoResponse(String isInfoOnlyMsg, List<String> msgRoot) {
		super(msgRoot);
		this.isInfoOnlyMsg = isInfoOnlyMsg;
	}

	/**
	 * @return the isInfoOnlyMsg
	 */
	public String getIsInfoOnlyMsg() {
		return isInfoOnlyMsg;
	}

	/**
	 * @param isInfoOnlyMsg
	 *            the isInfoOnlyMsg to set
	 */
	protected void setIsInfoOnlyMsg(String isInfoOnlyMsg) {
		this.isInfoOnlyMsg = isInfoOnlyMsg;
	}

}
