package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUAF4BNSTAResponse extends AbstractVistaResponse {

	/**
	 * 
	 * facilityName :
	 * 
	 * String that should receive RPC response
	 * 
	 */

	@XmlElement(required = true)
	private String facilityName;

	/**
	 * No Arguments Constructor
	 */
	public XUAF4BNSTAResponse() {
		super();
	}

	/**
	 * 
	 * Parameterised Constructor
	 * 
	 * @param facilityName
	 */
	public XUAF4BNSTAResponse(String facilityName) {
		super();
		this.facilityName = facilityName;
	}

	// getters and setters
	public String getFacilityName() {
		return this.facilityName;
	}

	public void setFacilityName(String lvFacilityName) {
		this.facilityName = lvFacilityName;
	}

}