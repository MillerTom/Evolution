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
@XmlRootElement(name = "XMXUTILTpmsgctResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTILTpmsgctResponse extends AbstractVistaResponse {

	/**
	 * 
	 * totNumOfNewPriorityMsgs :
	 * 
	 * the total number of new priority messages in a user's mailbox.
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages
	 */

	@XmlElement(required = false)
	private String totNumOfNewPriorityMsgs;
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTILTpmsgctResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param totNumOfNewPriorityMsgs
	 * @param msgRoot
	 */
	public XMXUTILTpmsgctResponse(String totNumOfNewPriorityMsgs,
			List<String> msgRoot) {
		super();
		this.totNumOfNewPriorityMsgs = totNumOfNewPriorityMsgs;
		this.msgRoot = msgRoot;
	}

	/**
	 * @return the totNumOfNewPriorityMsgs
	 */
	public String getTotNumOfNewPriorityMsgs() {
		return totNumOfNewPriorityMsgs;
	}

	/**
	 * @param totNumOfNewPriorityMsgs
	 *            the totNumOfNewPriorityMsgs to set
	 */
	protected void setTotNumOfNewPriorityMsgs(String totNumOfNewPriorityMsgs) {
		this.totNumOfNewPriorityMsgs = totNumOfNewPriorityMsgs;
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
