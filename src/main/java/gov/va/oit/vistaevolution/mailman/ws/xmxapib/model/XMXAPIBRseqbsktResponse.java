/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxapib.model;

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
public class XMXAPIBRseqbsktResponse {

	@XmlElement(required = true)
	private String xmmsg;
	
	public XMXAPIBRseqbsktResponse() {
		super();
	}

	public XMXAPIBRseqbsktResponse(String xmmsg) {
		super();
		this.xmmsg = xmmsg;
	}

	public String getXmmsg() {
		return xmmsg;
	}

	public void setXmmsg(String xmmsg) {
		this.xmmsg = xmmsg;
	}
	
}
