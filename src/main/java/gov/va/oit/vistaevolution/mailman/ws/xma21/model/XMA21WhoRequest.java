/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma21.model;

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
public class XMA21WhoRequest {
	
	@XmlElement(required = true)
	private String x;
	@XmlElement(required = false)
	private String xmdf;
	@XmlElement(required = true)
	private String xmduz;
	
	public XMA21WhoRequest() {
		super();
	}
	
	public XMA21WhoRequest(String x, String xmdf, String xmduz) {
		super();
		this.x = x;
		this.xmdf = xmdf;
		this.xmduz = xmduz;
	}

	public String getX() {
		return x;
	}
	public void setX(String x) {
		this.x = x;
	}
	public String getXmdf() {
		return xmdf;
	}
	public void setXmdf(String xmdf) {
		this.xmdf = xmdf;
	}
	public String getXmduz() {
		return xmduz;
	}
	public void setXmduz(String xmduz) {
		this.xmduz = xmduz;
	}
	
}
