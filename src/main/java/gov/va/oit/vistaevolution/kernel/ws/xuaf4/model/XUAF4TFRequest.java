/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4TFRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String ien;

	/**
	 * @param ien
	 */
	public XUAF4TFRequest() {
		super();
		this.ien = null;
	}

	/**
	 * @param ien
	 */
	public XUAF4TFRequest(String ien) {
		super();
		this.ien = ien;
	}

	public String getIEN() {
		return ien;
	}

	public void setIEN(String ien) {
		this.ien = ien;
	}

}
