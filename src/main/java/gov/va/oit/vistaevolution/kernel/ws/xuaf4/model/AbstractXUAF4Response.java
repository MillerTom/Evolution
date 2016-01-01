package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlElementWrapper;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXUAF4Response {

	/**
	 * msgRoot :
	 * 
	 * The array that should receive any error messages.
	 * 
	 */
	@XmlElementWrapper(name = "errors")
	@XmlElement(name = "error", required = false)
	protected List<String> msgRoot;
	
	@XmlElement(name = "rawResponse", required = false)
	protected String rawResponse;

	public AbstractXUAF4Response(String rawResponse) {
		super();
		this.rawResponse = rawResponse;
	}

	public AbstractXUAF4Response() {
		super();
	}

	public AbstractXUAF4Response(List<String> msgRoot) {
		super();
		this.msgRoot = msgRoot;
	}

	public List<String> getMsgRoot() {
		return msgRoot;
	}

	public void setMsgRoot(List<String> msgRoot) {
		this.msgRoot = msgRoot;
	}

	public String getRawResponse() {
		return rawResponse;
	}

	public void setRawResponse(String rawResponse) {
		this.rawResponse = rawResponse;
	}

}
