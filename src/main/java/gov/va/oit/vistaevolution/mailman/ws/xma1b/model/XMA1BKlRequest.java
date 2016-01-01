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
public class XMA1BKlRequest {
	
	@XmlElement(required = true)
	private String xmduz;
	@XmlElement(required = false)
	private String xmk;
	@XmlElement(required = true)
	private String xmz;
	
	public XMA1BKlRequest() {
		super();
	}
	
	public XMA1BKlRequest(String xmduz, String xmk, String xmz) {
		super();
		this.xmduz = xmduz;
		this.xmk = xmk;
		this.xmz = xmz;
	}
	
	public String getXmduz() {
		return xmduz;
	}
	public void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}
	public String getXmk() {
		return xmk;
	}
	public void setXmk(String xmk) {
		this.xmk = xmk;
	}
	public String getXmz() {
		return xmz;
	}
	public void setXmz(String xmz) {
		this.xmz = xmz;
	}
	
}
