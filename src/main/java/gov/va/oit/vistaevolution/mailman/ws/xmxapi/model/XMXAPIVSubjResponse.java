package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import java.util.List;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXAPIVSubjResponse extends AbstractVistaResponse {
	@XmlElement(required = true)
	private String result;
	
	public XMXAPIVSubjResponse() {
		super();
	}

	public XMXAPIVSubjResponse(String status, String result) {
		super();
		setStatus(status);
		this.result = result;
	}

	public XMXAPIVSubjResponse(String status, List<String> errors) {
		super(status, errors);
	}

	public String getResult() {
		return result;
	}

	public void setResult(String result) {
		this.result = result;
	}

}
