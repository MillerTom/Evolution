package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.List;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXAPITaskBullResponse", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMXAPITaskBullResponse extends AbstractVistaResponse {
	
	@XmlElement(required = false)
	private String result;
	
	public XMXAPITaskBullResponse() {
		super();
	}

	public XMXAPITaskBullResponse(String result) {
		super();
		this.result = result;
	}
	
	public XMXAPITaskBullResponse(String status, List<String> errors) {
		super(status, errors);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}
}
