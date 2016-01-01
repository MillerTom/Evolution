package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4LKUPRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String inst;

	public XUAF4LKUPRequest() {
		super();
	}

	public XUAF4LKUPRequest(String inst) {
		super();
		this.inst = inst;
	}

	// getters and setters
	public String getInst() {
		return this.inst;
	}

	public void setInst(String lvInst) {
		this.inst = lvInst;
	}

}
