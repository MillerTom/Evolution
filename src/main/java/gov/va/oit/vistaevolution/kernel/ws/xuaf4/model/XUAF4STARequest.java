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
public class XUAF4STARequest extends AbstractVistaRequest{

	@XmlElement(required=true)
	private String ien;

	/**
	 * @param ien
	 */
	public XUAF4STARequest(String ien) {
		super();
		this.ien = ien;
	}

	/**
	 * Default no-arg constructor
	 */
	public XUAF4STARequest() {
		super();
	}

	public String getIen() {
		return ien;
	}

	public void setIen(String ien) {
		this.ien = ien;
	}

	
}