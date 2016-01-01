package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4MADDRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String ien;

	public XUAF4MADDRequest() {
		super();
	}

	public XUAF4MADDRequest(String ien) {
		super();
		this.ien = ien;
	}

	public String getIen() {
		return this.ien;
	}

	public void setIen(String lvIen) {
		this.ien = lvIen;
	}

}