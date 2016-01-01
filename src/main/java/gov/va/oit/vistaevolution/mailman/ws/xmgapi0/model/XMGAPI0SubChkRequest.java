/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmgapi0.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement
@XmlAccessorType(XmlAccessType.NONE)
public class XMGAPI0SubChkRequest extends AbstractVistaRequest{

	@XmlElement(name = "xmSub", required = true)
	private String xmSUB;

	/**
	 * Default No-arg constructor
	 */
	public XMGAPI0SubChkRequest() {
		this.setXmSUB(null);
	}

	/**
	 * @param string
	 */
	public XMGAPI0SubChkRequest(String XMZ) {
		this.setXmSUB(XMZ);
	}

	public String getXmSUB() {
		return xmSUB;
	}

	protected void setXmSUB(String xMZ) {
		xmSUB = xMZ;
	}

}
