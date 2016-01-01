package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * IEN (The internal entry number for the requested site.
 */
@XmlRootElement()
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4NNTRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String ien;

	/**
	 * Default no arg constructor for JAXB
	 */
	public XUAF4NNTRequest() {
	}

	/**
	 * @param string
	 */
	public XUAF4NNTRequest(String ien) {
		this.setIen(ien);
	}

	public String getIen() {
		return ien;
	}

	protected void setIen(String ien) {
		this.ien = ien;
	}

}
