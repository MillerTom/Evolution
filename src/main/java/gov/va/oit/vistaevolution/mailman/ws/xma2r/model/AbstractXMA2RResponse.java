package gov.va.oit.vistaevolution.mailman.ws.xma2r.model;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
public abstract class AbstractXMA2RResponse {

	/**
	 * result :
	 * 
	 * IEN ---->If results are okay, this is the responses internal pointer
	 * located in file 3.9
	 * 
	 * 
	 * “E”n Text ---->If bad result, the letter "E" followed by a number,
	 * followed by a space, then a human readable explanation of the error.
	 * 
	 * 
	 * msgRoot :
	 * 
	 * Array that will receive Error Messages
	 */

	@XmlElement(required = false)
	protected String result;
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;

	/**
	 * Default Empty Constructor
	 */
	public AbstractXMA2RResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param result
	 * @param msgRoot
	 */
	public AbstractXMA2RResponse(String result, List<String> msgRoot) {
		super();
		this.result = result;
		this.msgRoot = msgRoot;
	}

	/**
	 * @return the result
	 */
	public String getResult() {
		return result;
	}

	/**
	 * @param result
	 *            the result to set
	 */
	protected void setResult(String result) {
		this.result = result;
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
