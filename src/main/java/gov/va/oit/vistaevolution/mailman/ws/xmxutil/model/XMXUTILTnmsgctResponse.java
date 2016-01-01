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
@XmlRootElement(name = "XMXUTILTnmsgctResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILTnmsgctResponse extends AbstractVistaResponse {

	/**
	 * 
	 * totNumOfNewMsgs :
	 * 
	 * the total number of new messages in a user's mailbox
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages
	 */
	@XmlElement(required = false)
	private String totNumOfNewMsgs;
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTnmsgctResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param totNumOfNewMsgs
	 * @param msgRoot
	 */
	public XMXUTILTnmsgctResponse(String totNumOfNewMsgs, List<String> msgRoot) {
		super();
		this.totNumOfNewMsgs = totNumOfNewMsgs;
		this.msgRoot = msgRoot;
	}

	/**
	 * @return the totNumOfNewMsgs
	 */
	public String getTotNumOfNewMsgs() {
		return totNumOfNewMsgs;
	}

	/**
	 * @param totNumOfNewMsgs
	 *            the totNumOfNewMsgs to set
	 */
	protected void setTotNumOfNewMsgs(String totNumOfNewMsgs) {
		this.totNumOfNewMsgs = totNumOfNewMsgs;
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
