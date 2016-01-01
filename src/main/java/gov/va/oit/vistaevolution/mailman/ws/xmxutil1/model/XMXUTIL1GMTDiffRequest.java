package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * 
 * @author bill.blackmon <bill.blackmon@medshphere.comn>
 * 
 */

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUTIL1GMTDiffRequest extends AbstractVistaRequest {

	@XmlElement(required = true)
	private String tz;

	public String getTZ() {
		return tz;
	}

	public void setTZ(String tz) {
		this.tz = tz;
	}

}
