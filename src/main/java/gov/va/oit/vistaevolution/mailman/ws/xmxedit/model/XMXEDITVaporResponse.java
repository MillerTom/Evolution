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
public class XMXEDITVaporResponse {

	@XmlElement(required = true)
	private String xmmsg;
	
	public XMXEDITVaporResponse() {
		super();
	}

	public XMXEDITVaporResponse(String response) {
		super();
		this.xmmsg = response;
	}

	public String getXmmsg() {
		return xmmsg;
	}

	public void setXmmsg(String xmmsg) {
		this.xmmsg = xmmsg;
	}
	
}
