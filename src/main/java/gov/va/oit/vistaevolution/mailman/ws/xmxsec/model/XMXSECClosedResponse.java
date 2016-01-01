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
@XmlRootElement(name = "XMXSECClosedResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSECClosedResponse extends AbstractXMXSECResponse {

	/**
	 * msgIsClosed :
	 * 
	 * a value indicating whether a message is "Closed" or not (0 = No; 1 =
	 * Yes).
	 * 
	 * msgRoot:
	 * 
	 * Array that should receive any error messages
	 * 
	 */

	@XmlElement(required = false)
	private String msgIsClosed;

	/**
	 * Default Empty Constructor
	 */
	public XMXSECClosedResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param msgClosed
	 * @param errMsgs
	 */
	public XMXSECClosedResponse(String msgIsClosed, List<String> errMsgs) {
		super(errMsgs);
		this.msgIsClosed = msgIsClosed;
	}

	/**
	 * @return the msgIsClosed
	 */
	public String getMsgIsClosed() {
		return msgIsClosed;
	}

	/**
	 * @param msgIsClosed
	 *            the msgIsClosed to set
	 */
	protected void setMsgIsClosed(String msgIsClosed) {
		this.msgIsClosed = msgIsClosed;
	}

}
