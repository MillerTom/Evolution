package gov.va.oit.vistaevolution.mailman.ws.xmxapi.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

@XmlRootElement( name = "XMXAPIPutServRequest", namespace = "http://vistaevolution.va.gov")
@XmlAccessorType(XmlAccessType.FIELD)
public class XMXAPIPutServRequest extends AbstractVistaRequest {
	
	@XmlElement(required = true)
	private String mkn;
	
	@XmlElement(required = true)
	private String mz;

	public String getMkn() {
		return mkn;
	}

	public void setMkn(String mkn) {
		this.mkn = mkn;
	}

	public String getMz() {
		return mz;
	}

	public void setMz(String mz) {
		this.mz = mz;
	}

}
