/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

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
public class XMXUTILKvaporResponse {
	
	@XmlElement(required = true)
	private String xmiu;

	public XMXUTILKvaporResponse() {
		super();
	}

	public XMXUTILKvaporResponse(String xmiu) {
		super();
		this.xmiu = xmiu;
	}

	public String getXmiu() {
		return xmiu;
	}

	public void setXmiu(String xmiu) {
		this.xmiu = xmiu;
	}
	
}
