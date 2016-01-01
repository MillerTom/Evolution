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
public class XMXUTIL2QrespRequest {

	@XmlElement(required = true)
	private String xmz;
	
	@XmlElement(required = false)
	private String xmwhich;

	public XMXUTIL2QrespRequest() {
		super();
	}

	public XMXUTIL2QrespRequest(String xmz) {
		super();
		this.xmz = xmz;
		this.xmwhich = "";
	}

	public XMXUTIL2QrespRequest(String xmz, String xmzrec, String xmwhich) {
		super();
		this.xmz = xmz;
		this.xmwhich = xmwhich;
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

}
