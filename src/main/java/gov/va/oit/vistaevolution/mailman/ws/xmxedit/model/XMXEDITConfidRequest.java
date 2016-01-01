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
public class XMXEDITConfidRequest {
	
	@XmlElement(required = true)
	private String xmz;
	
	@XmlElement(required = true)
	private String xminstr;
	
	public XMXEDITConfidRequest() {
		super();
	}

	public XMXEDITConfidRequest(String xmz, String xminstr) {
		super();
		this.xmz = xmz;
		this.xminstr = xminstr;
	}

	public String getXmz() {
		return xmz;
	}

	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

	public String getXminstr() {
		return xminstr;
	}

	public void setXminstr(String xminstr) {
		this.xminstr = xminstr;
	}

}
