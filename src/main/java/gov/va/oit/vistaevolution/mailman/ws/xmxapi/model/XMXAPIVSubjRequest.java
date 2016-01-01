package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIVSubjRequest extends AbstractVistaRequest {
	@XmlElement(required = true)
	private String subject;
	
	public XMXAPIVSubjRequest() {
		super();
	}
	
	public XMXAPIVSubjRequest(String subject) {
		this.subject = subject;
	}

	public String getSubject() {
		return subject;
	}

	public void setSubject(String subject) {
		this.subject = subject;
	}
	

}
