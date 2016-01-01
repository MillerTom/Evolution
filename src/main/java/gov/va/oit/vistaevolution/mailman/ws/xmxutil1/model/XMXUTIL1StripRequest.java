/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

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
public class XMXUTIL1StripRequest {

	@XmlElement(required = true)
	private String xmstring;
	
	public XMXUTIL1StripRequest() {
		super();
	}

	public XMXUTIL1StripRequest(String xmstring) {
		super();
		this.xmstring = xmstring;
	}

	public String getXmstring() {
		return xmstring;
	}

	public void setXmstring(String xmstring) {
		this.xmstring = xmstring;
	}
	
}
