/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

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
@XmlRootElement(name = "XMXUTIL1TstampResponse")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1TstampResponse extends AbstractVistaResponse {

	/**
	 * 
	 * currentTimeStamp :
	 * 
	 * the current timestamp (i.e., $H expressed in seconds).
	 * 
	 * msgRoot :
	 * 
	 * Array that should receive any error messages
	 */

	@XmlElement(required = false)
	private String currentTimeStamp;
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;

	/**
	 * Default Empty Constructor
	 */
	public XMXUTIL1TstampResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param currentTimeStamp
	 * @param msgRoot
	 */
	public XMXUTIL1TstampResponse(String currentTimeStamp, List<String> msgRoot) {
		super();
		this.currentTimeStamp = currentTimeStamp;
		this.msgRoot = msgRoot;
	}

	/**
	 * @return the currentTimeStamp
	 */
	public String getCurrentTimeStamp() {
		return currentTimeStamp;
	}

	/**
	 * @param currentTimeStamp
	 *            the currentTimeStamp to set
	 */
	protected void setCurrentTimeStamp(String currentTimeStamp) {
		this.currentTimeStamp = currentTimeStamp;
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
