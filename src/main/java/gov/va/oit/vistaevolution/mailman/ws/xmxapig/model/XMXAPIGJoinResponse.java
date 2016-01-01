/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapig.model;

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
public class XMXAPIGJoinResponse {

	@XmlElement(required = true)
	private String xmtsk;
	
	public XMXAPIGJoinResponse() {
		super();
	}

	public XMXAPIGJoinResponse(String xmtsk) {
		super();
		this.xmtsk = xmtsk;
	}

	public String getXmtsk() {
		return xmtsk;
	}

	public void setXmtsk(String xmtsk) {
		this.xmtsk = xmtsk;
	}
	
}
