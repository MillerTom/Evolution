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
public class XMXEDITPriorityRequest {
	
	@XmlElement(required = true)
	private String xmz;

	public XMXEDITPriorityRequest() {
		super();
	}

	public XMXEDITPriorityRequest(String xmz) {
		super();
		this.xmz = xmz;
	}

	public String getXmz() {
		return xmz;
	}

	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

}
