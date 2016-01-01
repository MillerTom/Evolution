package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1CtrlRequest {

	@XmlElement(name = "input", required = true)
	private String input;
	
	public XMXUTIL1CtrlRequest() {
		super();
	}


	public XMXUTIL1CtrlRequest(String input) {
		
		this.input = input;
	}
	public String getInput() {
		return input;
	}
	public void setInput(String input) {
		this.input = input;
	}
}
