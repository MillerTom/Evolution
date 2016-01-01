/**
 * 
 */
package gov.va.oit.vistaevolution.kernel.ws.xusnpi.model;

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
public class XUSNPINpiResponse {

	@XmlElement(required = true)
	private String response;
	
	public XUSNPINpiResponse() {
		super();
	}

	public XUSNPINpiResponse(String response) {
		super();
		this.response = response;
	}

	public String getResponse() {
		return response;
	}

	public void setResponse(String response) {
		this.response = response;
	}
	
}
