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
public class XMXEDITSubjRequest {

	@XmlElement(required = true)
	private String xmz;
	
	@XmlElement(required = true)
	private String xmsubj;
	
	public XMXEDITSubjRequest() {
		super();
	}

	public XMXEDITSubjRequest(String xmz, String xmsubj) {
		super();
		this.xmz = xmz;
		this.xmsubj = xmsubj;
	}

	public String getXmz() {
		return xmz;
	}

	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

	public String getXmsubj() {
		return xmsubj;
	}

	public void setXmsubj(String xmsubj) {
		this.xmsubj = xmsubj;
	}
	
}
