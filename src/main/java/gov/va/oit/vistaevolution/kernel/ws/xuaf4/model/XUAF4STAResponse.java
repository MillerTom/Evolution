/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuaf4.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

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
public class XUAF4STAResponse extends AbstractVistaResponse {

	@XmlElement(required=true)
	private String stationNumber;

	/**
	 * Default no-arg constructor
	 */
	public XUAF4STAResponse() {
		super();
;
	}

	/**
	 * @param stationNumber
	 */
	public XUAF4STAResponse(String stationNumber) {
		super();
		this.stationNumber = stationNumber;
	}

	public String getStationNumber() {
		return stationNumber;
	}

	protected void setStationNumber(String stationNumber) {
		this.stationNumber = stationNumber;
	}
	
}
