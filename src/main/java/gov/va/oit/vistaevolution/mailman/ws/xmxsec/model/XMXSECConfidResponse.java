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
@XmlRootElement(name = "XMXSECConfidResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSECConfidResponse extends AbstractXMXSECResponse {

	/**
	 * msgIsConfidential :
	 * 
	 * a value indicating whether a message is "Confidential" or not (0 = No; 1
	 * = Yes)
	 * 
	 * msgRoot :
	 * 
	 * The array that should receive any error messages.
	 * 
	 */

	@XmlElement(required = false)
	private String msgIsConfidential;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECConfidResponse() {
		super();
	}

	/**
	 * parameterised Constructor
	 * 
	 * @param msgIsConfidential
	 * @param msgRoot
	 */
	public XMXSECConfidResponse(String msgIsConfidential, List<String> msgRoot) {
		super(msgRoot);
		this.msgIsConfidential = msgIsConfidential;
	}

	/**
	 * @return the msgIsConfidential
	 */
	public String getMsgIsConfidential() {
		return msgIsConfidential;
	}

	/**
	 * @param msgIsConfidential
	 *            the msgIsConfidential to set
	 */
	protected void setMsgIsConfidential(String msgIsConfidential) {
		this.msgIsConfidential = msgIsConfidential;
	}

}