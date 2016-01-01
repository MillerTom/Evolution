/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christopher Schuck
 *
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XUSNPINpiRequest {

	@XmlElement(required = true)
	private String xusqi;
	
	@XmlElement(required = true)
	private String xusien;
	
	@XmlElement(required = false)
	private String xusdate;
	
	public XUSNPINpiRequest() {
		super();
	}

	public XUSNPINpiRequest(String xusqi, String xusien) {
		super();
		this.xusqi = xusqi;
		this.xusien = xusien;
		this.xusdate = "";
	}

	public XUSNPINpiRequest(String xusqi, String xusien, String xusdate) {
		super();
		this.xusqi = xusqi;
		this.xusien = xusien;
		this.xusdate = xusdate;
	}

	public String getXusqi() {
		return xusqi;
	}

	public void setXusqi(String xusqi) {
		this.xusqi = xusqi;
	}

	public String getXusien() {
		return xusien;
	}

	public void setXusien(String xusien) {
		this.xusien = xusien;
	}

	public String getXusdate() {
		return xusdate;
	}

	public void setXusdate(String xusdate) {
		this.xusdate = xusdate;
	}

}
