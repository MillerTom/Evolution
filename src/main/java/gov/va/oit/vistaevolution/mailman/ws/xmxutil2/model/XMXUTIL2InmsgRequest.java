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
public class XMXUTIL2InmsgRequest {

	@XmlElement(required = true)
	private String xmduz;
	
	@XmlElement(required = true)
	private String xmk;
	
	@XmlElement(required = true)
	private String xmz;
	
	@XmlElement(required = false)
	private String xmzrec;
	
	@XmlElement(required = false)
	private String xmflags;
	
	public XMXUTIL2InmsgRequest() {
		super();
	}

	public XMXUTIL2InmsgRequest(String xmduz, String xmk, String xmz) {
		super();
		this.xmduz = xmduz;
		this.xmk = xmk;
		this.xmz = xmz;
		this.xmzrec = "";
		this.xmflags = "";
	}

	public XMXUTIL2InmsgRequest(String xmduz, String xmk, String xmz, String xmzrec, String xmflags) {
		super();
		this.xmduz = xmduz;
		this.xmk = xmk;
		this.xmz = xmz;
		this.xmzrec = xmzrec;
		this.xmflags = xmflags;
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

	public String getXmzrec() {
		return xmzrec;
	}

	public void setXmzrec(String xmzrec) {
		this.xmzrec = xmzrec;
	}

	public String getXmflags() {
		return xmflags;
	}

	public void setXmflags(String xmflags) {
		this.xmflags = xmflags;
	}
	
}
