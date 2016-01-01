package gov.va.oit.vistaevolution.mailman.ws.xmxsec.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.List;

import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;

/**
 * 
 * @author Tom Miller<tom.miller@dbitpro.com>
 * 
 */
public abstract class AbstractXMXSECResponse extends AbstractVistaResponse {

	/**
	 * msgRoot :
	 * 
	 * The array that should receive any error messages.
	 * 
	 */
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;

	/**
	 * Default Empty Constructor
	 */
	public AbstractXMXSECResponse() {
		super();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param msgRoot
	 */
	public AbstractXMXSECResponse(List<String> msgRoot) {
		super();
		this.msgRoot = msgRoot;
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
