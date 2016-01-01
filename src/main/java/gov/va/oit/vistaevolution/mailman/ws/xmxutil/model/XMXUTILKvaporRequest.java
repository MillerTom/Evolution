/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

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
public class XMXUTILKvaporRequest {
	
	@XmlElement(required = true)
	private String xmduz;
	
	@XmlElement(required = true)
	private String xmk;
	
	@XmlElement(required = true)
	private String xmz;
	
	@XmlElement(required = true)
	private String xmvapor;

	public XMXUTILKvaporRequest() {
		super();
	}

	public XMXUTILKvaporRequest(String xmduz, String xmk, String xmz, String xmvapor) {
		super();
		this.xmduz = xmduz;
		this.xmk = xmk;
		this.xmz = xmz;
		this.xmvapor = xmvapor;
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

	public String getXmvapor() {
		return xmvapor;
	}

	public void setXmvapor(String xmvapor) {
		this.xmvapor = xmvapor;
	}
	
}
