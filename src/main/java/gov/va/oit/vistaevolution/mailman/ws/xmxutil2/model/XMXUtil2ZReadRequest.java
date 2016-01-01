package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXUtil2ZReadRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2ZReadRequest { 

	public XMXUtil2ZReadRequest(String duz, String xmz) {
		super();
		this.duz = duz;
		this.xmz = xmz;
	}
	public XMXUtil2ZReadRequest() { 
		super();
	}

	@XmlElement(name = "duz", required = true)
	private String duz;
	@XmlElement(name = "xmz", required = true)
	private String xmz;

	public String getDuz() { 
		return this.duz;
	}
	public void setDuz(String lvDuz) { 
		this.duz = lvDuz;
	}
	public String getXmz() { 
		return this.xmz;
	}
	public void setXmz(String lvXmz) { 
		this.xmz = lvXmz;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("duz ==> " + this.duz + "\n");
		sb.append("xmz ==> " + this.xmz + "\n");
		return sb.toString();
	}

}