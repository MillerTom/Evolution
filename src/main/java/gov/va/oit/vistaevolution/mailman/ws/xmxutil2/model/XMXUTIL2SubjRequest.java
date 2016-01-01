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
public class XMXUTIL2SubjRequest {

	@XmlElement(required = true)
	private String xmzrec;
	
	public XMXUTIL2SubjRequest() {
		super();
	}

	public XMXUTIL2SubjRequest(String xmzrec) {
		super();
		this.xmzrec = xmzrec;
	}

	public String getXmzrec() {
		return xmzrec;
	}

	public void setXmzrec(String xmzrec) {
		this.xmzrec = xmzrec;
	}
	
}
