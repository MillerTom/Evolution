package gov.va.oit.vistaevolution.mailman.ws.xmxsec1.model;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMXSEC1CopyAmtRequest {

	/* 
	 * string of original message
	 */
	@XmlElement(name = "xmzMsg", required = true)
	private String xmzMsg;
	
	/* 
	 * string of which responses to copy (0=original msg).
       Default = original msg and all responses.
	 */
	@XmlElement(name = "xmWhich", required = true)
	private String xmWhich = "0";

	
	// constructors
	public XMXSEC1CopyAmtRequest() { 
		super();
	}
	
	
	public XMXSEC1CopyAmtRequest(String xmzMsg, String xmWhich) {
		super();
		this.xmzMsg = xmzMsg;
		this.xmWhich = xmWhich;
	}

	// getters and setters
	public String getXmzMsg() { 
		return this.xmzMsg;
	}
	public void setXmzMsg(String lvXmzMsg) { 
		this.xmzMsg = lvXmzMsg;
	}
	public String getXmWhich() { 
		return this.xmWhich;
	}
	public void setXmWhich(String lvXmWhich) { 
		this.xmWhich = lvXmWhich;
	}

	public String toString() { 
		StringBuffer sb = new StringBuffer();
		sb.append("Class = " + this.getClass() + "\n");
		sb.append("===========================================\n");
		sb.append("xmzMsg ==> " + this.xmzMsg + "\n");
		sb.append("xmWhich ==> " + this.xmWhich + "\n");
		return sb.toString();
	}

}
