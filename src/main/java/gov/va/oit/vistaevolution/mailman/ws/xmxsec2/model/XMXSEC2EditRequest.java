package gov.va.oit.vistaevolution.mailman.ws.xmxsec2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC2EditRequest {

	public XMXSEC2EditRequest() { 
		super();
	}

	public XMXSEC2EditRequest(String xmDuz, String xmz, String xmzRec) {
		super();
		this.xmDuz = xmDuz;
		this.xmz = xmz;
		this.xmzRec = xmzRec;
	}

	@XmlElement(name = "xmDuz", required = true)
	private String xmDuz;
	@XmlElement(name = "xmz", required = true)
	private String xmz;
	@XmlElement(name = "xmzRec", required = true)
	private String xmzRec;

	public String getXmDuz() { 
		return this.xmDuz;
	}
	public void setXmDuz(String lvXmDuz) { 
		this.xmDuz = lvXmDuz;
	}
	public String getXmz() { 
		return this.xmz;
	}
	public void setXmz(String lvXmz) { 
		this.xmz = lvXmz;
	}
	public String getXmzRec() { 
		return this.xmzRec;
	}
	public void setXmzRec(String lvXmzRec) { 
		this.xmzRec = lvXmzRec;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("xmDuz ==> " + this.xmDuz + "\n");
		sb.append("xmz ==> " + this.xmz + "\n");
		sb.append("xmzRec ==> " + this.xmzRec + "\n");
		return sb.toString();
	}

}
