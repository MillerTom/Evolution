/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xuskaaj.model;

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
public class XUSKAAJUserinfoRequest {
	
	@XmlElement(required = true)
	private String clientip;
	@XmlElement(required = true)
	private String servernm;
	
	public XUSKAAJUserinfoRequest() {
		super();
	}

	public XUSKAAJUserinfoRequest(String clientip, String servernm) {
		super();
		this.clientip = clientip;
		this.servernm = servernm;
	}

	public String getClientip() {
		return clientip;
	}

	public void setClientip(String clientip) {
		this.clientip = clientip;
	}

	public String getServernm() {
		return servernm;
	}

	public void setServernm(String servernm) {
		this.servernm = servernm;
	}
	
}
