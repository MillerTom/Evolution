/**
 * 
 */
package gov.va.oit.vistaevolution.mailman.ws.xmxutil1.model;

import gov.va.oit.vistaevolution.ws.model.AbstractVistaRequest;

import javax.xml.bind.annotation.XmlAccessType;
import javax.xml.bind.annotation.XmlAccessorType;
import javax.xml.bind.annotation.XmlElement;
import javax.xml.bind.annotation.XmlRootElement;

/**
 * @author Joshua Zangari <Joshua.Zangari@synaptekcorp.com>
 * 
 */
@XmlRootElement(name = "XMXUtil1INDTRequest")
@XmlAccessorType(XmlAccessType.NONE)
public class XMXUtil1INDTRequest extends AbstractVistaRequest{

	@XmlElement(required = true)
	private String vistaDate;

	/**
	 * @param string
	 */
	public XMXUtil1INDTRequest(String vistaDate) {
		this.setVistaDate(vistaDate);
	}

	/**
	 * 
	 */
	public XMXUtil1INDTRequest() {
		this(null);
	}

	public String getVistaDate() {
		return vistaDate;
	}

	protected void setVistaDate(String vistaDate) {
		this.vistaDate = vistaDate;
	}

}
