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
public class XMXEDITSubjResponse {

	@XmlElement(required = true)
	private String xmim;
	
	public XMXEDITSubjResponse() {
		super();
	}

	public XMXEDITSubjResponse(String xmim) {
		super();
		this.xmim = xmim;
	}

	public String getXmim() {
		return xmim;
	}

	public void setXmim(String xmim) {
		this.xmim = xmim;
	}
	
}
