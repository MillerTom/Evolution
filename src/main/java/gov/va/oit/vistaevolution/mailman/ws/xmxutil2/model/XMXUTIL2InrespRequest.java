/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

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
public class XMXUTIL2InrespRequest {

	@XmlElement(required = true)
	private String xmduz;
	
	@XmlElement(required = true)
	private String xmz;
	
	@XmlElement(required = true)
	private String xmwhich;
	
	@XmlElement(required = false)
	private String xmflags;
	
	public XMXUTIL2InrespRequest() {
		super();
	}

	public XMXUTIL2InrespRequest(String xmduz, String xmz, String xmwhich) {
		super();
		this.xmduz = xmduz;
		this.xmz = xmz;
		this.xmwhich = xmwhich;
		this.xmflags = "";
	}
	
	public XMXUTIL2InrespRequest(String xmduz, String xmz, String xmwhich, String xmflags) {
		super();
		this.xmduz = xmduz;
		this.xmz = xmz;
		this.xmwhich = xmwhich;
		this.xmflags = xmflags;
	}

	public String getXmduz() {
		return xmduz;
	}

	public void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}

	public String getXmz() {
		return xmz;
	}

	public void setXmz(String xmz) {
		this.xmz = xmz;
	}

	public String getXmwhich() {
		return xmwhich;
	}

	public void setXmwhich(String xmwhich) {
		this.xmwhich = xmwhich;
	}

	public String getXmflags() {
		return xmflags;
	}

	public void setXmflags(String xmflags) {
		this.xmflags = xmflags;
	}

}
