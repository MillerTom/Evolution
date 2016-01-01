package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1CopyRecpRequest {

	
	public XMXSEC1CopyRecpRequest() { 
		super();
	}

	public XMXSEC1CopyRecpRequest(String xmz) {
		this.xmzMsg = xmz;
	}

	@XmlElement(name = "xmzMsg", required = true)
	private String xmzMsg;

	public String getXmzMsg() { 
		return this.xmzMsg;
	}
	public void setXmzMsg(String lvXmzMsg) { 
		this.xmzMsg = lvXmzMsg;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("xmzMsg ==> " + this.xmzMsg + "\n");
		return sb.toString();
	}

}
