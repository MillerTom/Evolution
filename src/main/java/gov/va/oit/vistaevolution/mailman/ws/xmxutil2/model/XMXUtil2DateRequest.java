package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType 
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2DateRequest {

	
	
	@XmlElement(name = "xmzRec", required = true)
	private String xmzRec;
	@XmlElement(name = "xmTime", required = true)
	private String xmTime;
	
	
	public XMXUtil2DateRequest() {
		super();
	}
	
	public XMXUtil2DateRequest(String xmz, String xmTime) {
		super();
		this.xmzRec = xmz;
		this.xmTime = xmTime;
	}
	
	
	
	public String getXmzRec() {
		return xmzRec;
	}
	public void setXmzRec(String xmz) {
		this.xmzRec = xmz;
	}
	public String getXmTime() {
		return xmTime;
	}
	public void setXmTime(String xmTime) {
		this.xmTime = xmTime;
	}
	
	
	

}
