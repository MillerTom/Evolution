/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
@XmlRootElement(name = "XMXUTILTmsgctResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILTmsgctResponse extends AbstractVistaResponse {

	/**
	 * 
	 * totNumOfMsgs :
	 * 
	 * the total number of messages in a user's mailbox
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages
	 */

	@XmlElement(required = false)
	private String totNumOfMsgs;
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTmsgctResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param totNumOfMsgs
	 * @param msgRoot
	 */
	public XMXUTILTmsgctResponse(String totNumOfMsgs, List<String> msgRoot) {
		super();
		this.totNumOfMsgs = totNumOfMsgs;
		this.msgRoot = msgRoot;
	}

	/**
	 * @return the totNumOfMsgs
	 */
	public String getTotNumOfMsgs() {
		return totNumOfMsgs;
	}

	/**
	 * @param totNumOfMsgs
	 *            the totNumOfMsgs to set
	 */
	protected void setTotNumOfMsgs(String totNumOfMsgs) {
		this.totNumOfMsgs = totNumOfMsgs;
	}

	/**
	 * @return the msgRoot
	 */
	public List<String> getMsgRoot() {
		return msgRoot;
	}

	/**
	 * @param msgRoot
	 *            the msgRoot to set
	 */
	protected void setMsgRoot(List<String> msgRoot) {
		this.msgRoot = msgRoot;
	}

}
