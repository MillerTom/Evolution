/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaResponse;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Christopher Schuck
 *
 */
@XmlRootElement(name = "XMXUTILResponse")
@XmlAccessorType(XmlAccessType.NONE)
public abstract class AbstractXMXUTILResponse extends AbstractVistaResponse {

	// Number of new messages in a user's basket
	@XmlElement(name = "returns", required = true)
	private String returns; 
	
	public AbstractXMXUTILResponse() {
		super();
	}
	
	public AbstractXMXUTILResponse(String returns) {
		super();
		this.returns = returns;
	}

	public String getReturns() {
		return returns;
	}

	public void setReturns(String returns) {
		this.returns = returns;
	}

}
