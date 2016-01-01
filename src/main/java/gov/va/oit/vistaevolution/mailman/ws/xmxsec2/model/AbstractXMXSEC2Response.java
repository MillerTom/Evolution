package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AbstractXMXSEC2Response")
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXSEC2Response extends AbstractVistaResponse {

	/**
	 * msgRoot :
	 * 
	 * The array that should receive any error messages.
	 * 
	 */
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;

	public AbstractXMXSEC2Response() {
		super();
		// avoid NPE's, use isEmpty() method to test for no values
		this.msgRoot = new ArrayList<String>();
	}

	public AbstractXMXSEC2Response(List<String> msgRoot2) {
		super();
		this.msgRoot = msgRoot2;
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
