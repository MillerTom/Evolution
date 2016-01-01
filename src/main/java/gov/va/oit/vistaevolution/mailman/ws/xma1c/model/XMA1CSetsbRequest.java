/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1c.model;

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
public class XMA1CSetsbRequest {
	
	@XmlElement(required = true)
	private String xmxx;
	@XmlElement(required = true)
	private String xmz;
	
	public XMA1CSetsbRequest() {
		super();
	}
	
	public XMA1CSetsbRequest(String xmxx, String xmz) {
		super();
		this.xmxx = xmxx;
		this.xmz = xmz;
	}
	
	public String getXmxx() {
		return xmxx;
	}
	public void setXmxx(String xmxx) {
		this.xmxx = xmxx;
	}
	public String getXmz() {
		return xmz;
	}
	public void setXmz(String xmz) {
		this.xmz = xmz;
	}
	
}
