package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement(name = "XMXSEC1ZssPrivRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1ZssPrivRequest { 

	public XMXSEC1ZssPrivRequest() { 
		super();
	}



	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		return sb.toString();
	}

}
