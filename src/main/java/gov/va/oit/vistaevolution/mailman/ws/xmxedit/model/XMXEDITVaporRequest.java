/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxedit.model;

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
public class XMXEDITVaporRequest {

	@XmlElement(required = true)
	private String xmz;
	
	@XmlElement(required = true)
	private String xmvapor;
	
	public XMXEDITVaporRequest() {
		super();
	}

	public XMXEDITVaporRequest(String xmz, String xmvapor) {
		super();
		this.xmz = xmz;
		this.xmvapor = xmvapor;
	}

	public String getXmz() {
		return xmz;
	}

	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

	public String getXmvapor() {
		return xmvapor;
	}

	public void setXmvapor(String xmvapor) {
		this.xmvapor = xmvapor;
	}
	
}
