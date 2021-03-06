package gov.va.oit.vistaevolution.mailman.ws.xmxutil2.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlType;

@XmlType
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil2ZNodeRequest { 

	public XMXUtil2ZNodeRequest() { 
		super();
	}

	public XMXUtil2ZNodeRequest(String xmz) {
		this.xmz = xmz;
	}

	@XmlElement(name = "xmz", required = true)
	private String xmz;

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
		sb.append("xmz ==> " + this.xmz + "\n");
		return sb.toString();
	}

}
