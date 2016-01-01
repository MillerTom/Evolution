package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import java.util.ArrayList;
import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "AbstractXMXSEC1Response")
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXSEC1Response extends AbstractVistaResponse {

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
	 * No Arguments Constructor
	 */
	public AbstractXMXSEC1Response() {
		super();
		this.msgRoot = new ArrayList<String>();
	}

	/**
	 * Parameterised Constructor
	 * 
	 * @param msgRoot2
	 */
	public AbstractXMXSEC1Response(List<String> msgRoot2) {
		this.msgRoot = msgRoot2;
	}

	public List<String> getMsgRoot() {
		return msgRoot;
	}

	public void setMsgRoot(List<String> msgRoot) {
		this.msgRoot = msgRoot;
	}

}
