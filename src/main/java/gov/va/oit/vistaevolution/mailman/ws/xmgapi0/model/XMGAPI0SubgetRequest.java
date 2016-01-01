
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
public class XMGAPI0SubgetRequest extends AbstractVistaRequest{

	@XmlElement(name="xmz", required = true)
	private String XMZ;

	/**
	 * Default No-arg constructor
	 */
	public XMGAPI0SubgetRequest() {
		this.setXMZ(null);
	}

	/**
	 * @param string
	 */
	public XMGAPI0SubgetRequest(String XMZ) {
		this.setXMZ(XMZ);
	}

	public String getXMZ() {
		return XMZ;
	}

	protected void setXMZ(String xMZ) {
		XMZ = xMZ;
	}

}