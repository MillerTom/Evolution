/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xma1b.model;

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
public class XMA1BS2Response {
	
	@XmlElement(required = true)
	private String response;
	
	public XMA1BS2Response() {
		super();
	}

	public XMA1BS2Response(String response) {
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
