/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.model;

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
public class XMA1BS2Request {
	
	@XmlElement(required = true)
	private String xmduz;
	@XmlElement(required = true)
	private String xmkm;
	@XmlElement(required = true)
	private String xmz;
	
	public XMA1BS2Request() {
		super();
	}
	
	public XMA1BS2Request(String xmduz, String xmkm, String xmz) {
		super();
		this.xmduz = xmduz;
		this.xmkm = xmkm;
		this.xmz = xmz;
	}
	
	public String getXmduz() {
		return xmduz;
	}
	public void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}
	public String getXmkm() {
		return xmkm;
	}
	public void setXmkm(String xmkm) {
		this.xmkm = xmkm;
	}
	public String getXmz() {
		return xmz;
	}
	public void setXmz(String xmz) {
		this.xmz = xmz;
	}
	
}
