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
public class XMXEDITConfidResponse {
	
	@XmlElement(required = true)
	private String xminstr;
	
	@XmlElement(required = true)
	private String xmmsg;

	public XMXEDITConfidResponse() {
		super();
	}

	public XMXEDITConfidResponse(String xmmsg, String xminstr) {
		super();
		this.xminstr = xminstr;
		this.xmmsg = xmmsg;
	}

	public String getXminstr() {
		return xminstr;
	}

	public void setXminstr(String xminstr) {
		this.xminstr = xminstr;
	}

	public String getXmmsg() {
		return xmmsg;
	}

	public void setXmmsg(String xmmsg) {
		this.xmmsg = xmmsg;
	}
	
}
